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
    ArrayList<String> enseignant;
    ArrayList<String> salle;
<<<<<<< HEAD
    
    /**
     * 
     * @param user 
     */
=======
    String enseignantSelectionne="ALL";
    String salleSelectionne="ALL";

>>>>>>> 7e2efa00787d94df9577376218efa1286f40f9a2
    public RechercheComplet(Utilisateur user) {
        super(user);
        ArrayList<Seance> seances = user.getSeances();
        enseignant=new ArrayList<>();
        salle=new ArrayList<>();
        boolean find;
        enseignant.add(enseignantSelectionne);
        salle.add(salleSelectionne);
        for(Seance seance: seances){
            for(String enseignants: seance.getEnseignants()){
                find=false;
                for(String enseignant: enseignant){
                    if (enseignant.equals(enseignants)){
                        find=true;
                    }
                }
                if(!find){
                    enseignant.add(enseignants);
                }
            }
            for(String salles: seance.getSalles()){
                find=false;
                for(String sal: salle){
                    if (sal.equals(salles)){
                        find=true;
                    }
                }
                if(!find){
                    groupe.add(salles);
                }
            }
        }
    }
<<<<<<< HEAD
    /**
     * 
     * @return 
     */
    public ArrayList<String> getEtudiant() {
        return etudiant;
    }
    /**
     * 
     * @return 
     */
=======

    @Override
>>>>>>> 7e2efa00787d94df9577376218efa1286f40f9a2
    public ArrayList<String> getEnseignant() {
        return enseignant;
    }
    /**
     * 
     * @return 
     */
    public ArrayList<String> getSalle() {
        return salle;
    }    

    public void setEnseignantSelectionne(String enseignantSelectionne) {
        this.enseignantSelectionne = enseignantSelectionne;
    }

    public void setSalleSelectionne(String salleSelectionne) {
        this.salleSelectionne = salleSelectionne;
    }
}