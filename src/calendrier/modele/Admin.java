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
    
    /**
     *
     */
    public Admin() {}

    /**
     *
     * @param email
     * @param nom
     * @param prenom
     */
    public Admin(String email, String nom, String prenom) {
        super(email, nom, prenom);
        this.champs = null;
    }

    /**
     *
     * @return
     */
    public RechercheComplet getChamps() {
        return champs;
    }

    /**
     *
     * @param champs
     */
    public void setChamps(RechercheComplet champs) {
        this.champs = champs;
    }

    /**
     *
     * @return
     */
    @Override
    public int getNumero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPromo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createReporting() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
