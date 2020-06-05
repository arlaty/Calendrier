/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.DAO;

import calendrier.modele.Utilisateur;
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
        conn = DriverManager.getConnection(urlDatabase, "root", "");
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
                System.out.println(user.getEmail());
              System.out.println(user.getPrenom());
              System.out.println(user.getNom());
              System.out.println(user.getNumero());
              System.out.println(user.getTD());
              System.out.println(user.getPromo());
            }
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return user;
    }  
}