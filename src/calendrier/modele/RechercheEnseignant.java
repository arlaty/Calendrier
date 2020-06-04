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
public class RechercheEnseignant{
    ArrayList<String> cours;
    ArrayList<String> promo;
    ArrayList<String> groupe;

    public RechercheEnseignant() {
    }

    public RechercheEnseignant(ArrayList<String> cours, ArrayList<String> promo, ArrayList<String> groupe) {
        this.cours = cours;
        this.promo = promo;
        this.groupe = groupe;
    }

    public ArrayList<String> getCours() {
        return cours;
    }

    public ArrayList<String> getPromo() {
        return promo;
    }

    public ArrayList<String> getGroupe() {
        return groupe;
    }
}
