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
public class Referent extends Utilisateur{
    RechercheComplet champs;
    public Referent() {}

    public Referent(RechercheComplet champs, String email, String nom, String prenom, ArrayList<Seance> seances, Reporting reporting) {
        super(email, nom, prenom, seances, reporting);
        this.champs = champs;
    }

    public RechercheComplet getChamps() {
        return champs;
    }
}
