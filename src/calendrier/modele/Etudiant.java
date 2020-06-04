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
    int TD;
    String Promo;

    public Etudiant() {}
    
    public Etudiant(int numero, int TD, String Promo, String email, String nom, String prenom, ArrayList<Seance> seances, Reporting reporting) {
        super(email, nom, prenom, seances, reporting);
        this.numero = numero;
        this.TD = TD;
        this.Promo = Promo;
    }

    public int getNumero() {
        return numero;
    }

    public int getTD() {
        return TD;
    }

    public String getPromo() {
        return Promo;
    }   
}
