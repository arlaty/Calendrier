/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.modele;


import calendrier.controleur.Connexion;
import java.sql.*;

/**
 *
 * @author alexi
 */
public class SeanceDAO extends DAO<Seance> {

    public SeanceDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Seance obj) {
        return false;
    }

    @Override
    public boolean delete(Seance obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Seance obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seance find(int id) {
        Seance seance = new Seance();  

      
    try {
         ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM eleve WHERE elv_id = " + id);
      if(result.first())
        seance = new Seance(
          id,
          result.getString("elv_nom"),
          result.getString("elv_prenom"
        ));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance;
    }
    
}
