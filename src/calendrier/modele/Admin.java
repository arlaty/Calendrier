/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.modele;

import java.util.ArrayList;

/**
 *
 * @author alexi
 */
public class Admin extends Utilisateur{
    RechercheComplet champs;
<<<<<<< HEAD
    /**
     * 
     */
    public Admin() {}
    /**
     * 
     * @param email
     * @param nom
     * @param prenom 
=======
    
    /**
     *
     */
    public Admin() {}

    /**
     *
     * @param email
     * @param nom
     * @param prenom
>>>>>>> 7e2efa00787d94df9577376218efa1286f40f9a2
     */
    public Admin(String email, String nom, String prenom) {
        super(email, nom, prenom);
        this.champs = null;
    }
<<<<<<< HEAD
    /**
     * 
     * @return 
=======

    /**
     *
     * @return
>>>>>>> 7e2efa00787d94df9577376218efa1286f40f9a2
     */
    public RechercheComplet getChamps() {
        return champs;
    }
<<<<<<< HEAD
    /**
     * 
     * @param champs 
=======

    /**
     *
     * @param champs
>>>>>>> 7e2efa00787d94df9577376218efa1286f40f9a2
     */
    public void setChamps(RechercheComplet champs) {
        this.champs = champs;
    }
<<<<<<< HEAD
    /**
     * 
     * @return 
=======

    /**
     *
     * @return
>>>>>>> 7e2efa00787d94df9577376218efa1286f40f9a2
     */
    @Override
    public int getNumero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * 
     * @return 
     */
    @Override
    public String getTD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * 
     * @return 
     */
    @Override
    public String getPromo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * 
     */
    @Override
    public void createReporting() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
