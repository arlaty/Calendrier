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
public class Enseignant extends Utilisateur{
    RechercheEnseignant champ;
    /**
     * 
     */
    public Enseignant() {}
    /**
     * 
     * @param email
     * @param nom
     * @param prenom 
     */
    public Enseignant(String email, String nom, String prenom) {
        super(email, nom, prenom);
        this.champ = null;
    }
    /**
     * 
     * @param champ 
     */
    public void setChamp(RechercheEnseignant champ) {
        this.champ = champ;
    }
    /**
     * 
     * @return 
     */
    public RechercheEnseignant getChamp() {
        return champ;
    }
    
    /**
     * 
     * @return 
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
