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
public class Etudiant extends Utilisateur{
    int numero;
    String TD;
    String Promo;

    public Etudiant() {}
    
    public Etudiant(String email, String nom, String prenom,int numero, String TD, String Promo) {
        super(email, nom, prenom);
        this.numero = numero;
        this.TD = TD;
        this.Promo = Promo;
    }

    public int getNumero() {
        return numero;
    }

    public String getTD() {
        return TD;
    }

    public String getPromo() {
        return Promo;
    }   

    @Override
    public void createReporting() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
