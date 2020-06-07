/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.DAO;

import calendrier.modele.Referent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alexi
 */
public class ReferentDAO extends DAO<Referent>{

    public ReferentDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Referent obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Referent obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Referent obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Referent find(int id) {
        Referent user= null;
        try{
            ResultSet result = DAOFactory.conn.createStatement(
             ResultSet.TYPE_SCROLL_INSENSITIVE,
             ResultSet.CONCUR_READ_ONLY)
             .executeQuery("SELECT * FROM utilisateur WHERE id="+id);
            if(result.first()){
                user=new Referent(
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
