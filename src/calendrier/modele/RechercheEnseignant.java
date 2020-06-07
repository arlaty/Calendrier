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
public class RechercheEnseignant extends RechercheUser{
    ArrayList<String> promo;
    ArrayList<String> groupe;

    public RechercheEnseignant(Utilisateur user) {
        super(user);
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
