/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.DAO;

import calendrier.modele.Enseignant;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alexi
 */
public class EnseignantDAO extends DAO<Enseignant>{

    public EnseignantDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Enseignant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Enseignant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Enseignant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Enseignant find(int id) {
        Enseignant user= null;
        try{
            ResultSet result = DAOFactory.conn.createStatement(
             ResultSet.TYPE_SCROLL_INSENSITIVE,
             ResultSet.CONCUR_READ_ONLY)
             .executeQuery("SELECT * FROM utilisateur WHERE id="+id);
            if(result.first()){
                user=new Enseignant(
                result.getString("email"),
                result.getString("nom"),
                result.getString("prenom")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
