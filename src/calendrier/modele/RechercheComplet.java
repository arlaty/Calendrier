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
public class RechercheComplet extends RechercheEnseignant{
    ArrayList<String> etudiant;
    ArrayList<String> enseignant;
    ArrayList<String> salle;

    public RechercheComplet() {}

    public RechercheComplet(ArrayList<String> etudiant, ArrayList<String> enseignant, ArrayList<String> salle, ArrayList<String> cours, ArrayList<String> promo, ArrayList<String> groupe) {
        super(cours, promo, groupe);
        this.etudiant = etudiant;
        this.enseignant = enseignant;
        this.salle = salle;
    }

    public ArrayList<String> getEtudiant() {
        return etudiant;
    }

    public ArrayList<String> getEnseignant() {
        return enseignant;
    }

    public ArrayList<String> getSalle() {
        return salle;
    }    
}