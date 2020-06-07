/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.DAO;

import calendrier.modele.Etudiant;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author alexi
 */
public class EtudiantDAO extends DAO<Etudiant>{
    
    public EtudiantDAO(Connection cnctn) {
        super(cnctn);
    }
    @Override
    public boolean create(Etudiant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Etudiant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Etudiant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Etudiant find(int id) {
        Etudiant user= null;
        try{
            ResultSet result = connect.createStatement(
             ResultSet.TYPE_SCROLL_INSENSITIVE,
             ResultSet.CONCUR_READ_ONLY)
             .executeQuery("SELECT * FROM utilisateur JOIN etudiant WHERE id="+id+" and Id_utilisateur=id");
            if(result.first()){
                ResultSet result2 = connect.createStatement(
                 ResultSet.TYPE_SCROLL_INSENSITIVE,
                 ResultSet.CONCUR_READ_ONLY)
                 .executeQuery("SELECT * FROM groupe WHERE id="+result.getInt("Id_groupe"));
                if(result2.first()){
                    ResultSet result3 = connect.createStatement(
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_READ_ONLY)
                     .executeQuery("SELECT * FROM promotion WHERE id="+result2.getInt("Id_promotion"));
                    if(result3.first()){
                        user=new Etudiant(
                        result.getString("email"),
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getInt("numero"),
                        result2.getString("nom"),
                        result3.getString("nom")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    
}
