/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.DAO;

import calendrier.modele.Admin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alexi
 */
public class AdminDAO extends DAO<Admin>{
    
    /**
     * 
     * @param conn 
     */
    public AdminDAO(Connection conn) {
        super(conn);
    }
    /**
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean create(Admin obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean delete(Admin obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean update(Admin obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * 
     * @param id
     * @return 
     */
    @Override
    public Admin find(int id) {
        Admin user= null;
        try{
            ResultSet result = connect.createStatement(
             ResultSet.TYPE_SCROLL_INSENSITIVE,
             ResultSet.CONCUR_READ_ONLY)
             .executeQuery("SELECT * FROM utilisateur WHERE id="+id);
            if(result.first()){
                user=new Admin(
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
