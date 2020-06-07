/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.DAO;

import calendrier.modele.RechercheComplet;
import calendrier.modele.RechercheEnseignant;
import calendrier.modele.RechercheUser;
import calendrier.modele.Utilisateur;
import calendrier.vue.Recherche;
import calendrier.modele.Reporting;
import calendrier.modele.Seance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Alexis
 */
public class DAOFactory {
  protected static Connection conn ;   

    public DAOFactory() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
        String urlDatabase = "jdbc:mysql://localhost/calendrier";
       // String urlDatabase = "jdbc:mysql://localhost:3308/jps?characterEncoding=latin1";
        //création d'une connexion JDBC à la base 
        conn = DriverManager.getConnection(urlDatabase, "root", "root");
    }
   
    /**
    * Retourne un objet Classe interagissant avec la BDD
       * @param email
       * @param password
    * @return DAO
    */
    public static Utilisateur DAOUtilisateur(String email,String password){
      Utilisateur user=null;
      try { 
        ResultSet result = conn.createStatement(
          ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY)
        .executeQuery("SELECT id,droit FROM utilisateur WHERE email = '" + email+"' AND password='"+password+"'");
        if(result.first()){
            if (result.getInt("droit")==4){
                EtudiantDAO etudiantDAO = new EtudiantDAO(conn);
                user=etudiantDAO.find(result.getInt("id"));
            }
            else if (result.getInt("droit")==3){
                EnseignantDAO enseignantDAO = new EnseignantDAO(conn);
                user=enseignantDAO.find(result.getInt("id"));
            }
            else if (result.getInt("droit")==2){
                ReferentDAO referentDAO = new ReferentDAO(conn);
                user=referentDAO.find(result.getInt("id"));
            }
            else if (result.getInt("droit")==1){
                AdminDAO adminDAO = new AdminDAO(conn);
                user=adminDAO.find(result.getInt("id"));
            }
            SeanceDAO seanceDAO= new SeanceDAO(conn);
            user.setSeances(seanceDAO.findAll(result.getInt("id"), result.getInt("droit")));
            if (result.getInt("droit")==4){
                user.setRecherche(new RechercheUser(user));
            }
            else if (result.getInt("droit")==3){
                user.setRecherche(new RechercheEnseignant(user));
            }
            else{
                user.setRecherche(new RechercheComplet(user));
            }
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
      Reporting t=new Reporting(user);
      user.setReporting(t);
      //Printf pour verifier implementatation de l'utilisateur et plus particulierement du reporting
      System.out.println(user.getNom());
      System.out.println(user.getPrenom());
      System.out.println(user.getEmail());
      
      ArrayList<Seance>s=user.getSeances();
      for(int i=0; i<s.size();i++)
      {
          Seance sa=s.get(i);
          System.out.println(sa.getCours());
      }
      Reporting r=user.getReporting();
      Map<String, Integer> m=r.getInfo1();
      Map<String, Integer> y=r.getInfo3();
      // Afficher le contenu du MAP
    		Set listKeys=m.keySet();  // Obtenir la liste des clés
    		Iterator iterateur=listKeys.iterator();
    		// Parcourir les clés et afficher les entrées de chaque clé;
    		while(iterateur.hasNext())
    		{
    			Object key= iterateur.next();
    			System.out.println (key+"=>"+m.get(key));
                     
    		}
                Set listKeyss=y.keySet();  // Obtenir la liste des clés
    		Iterator Iterateur=listKeyss.iterator();
    		// Parcourir les clés et afficher les entrées de chaque clé;
    		while(Iterateur.hasNext())
    		{
    			Object key= Iterateur.next();
    			System.out.println (key+"=>"+y.get(key));
                     
    		}
      return user;
    }  
}