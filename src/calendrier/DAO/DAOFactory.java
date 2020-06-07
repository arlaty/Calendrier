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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
      return user;
    }  
}