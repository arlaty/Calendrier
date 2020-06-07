/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.modele;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Alexis
 */
public class RechercheUser {
    ArrayList<Integer> semaine;
    ArrayList<String> cours;
    int semaineSelectionne;
    String coursSelectionne="ALL";

    public RechercheUser(Utilisateur user) {
        ArrayList<Seance> seances = user.getSeances();
        semaine=new ArrayList<>();
        cours=new ArrayList<>();
        boolean find;
        SimpleDateFormat formater = new SimpleDateFormat("w");
        semaineSelectionne= Integer.parseInt(formater.format(new Date()));
        semaine.add(semaineSelectionne);
        cours.add(coursSelectionne);
        for(Seance seance: seances){
            find=false;
            for(int semain: semaine){
                if (semain==seance.getSemaine()){
                    find=true;
                }
            }
            if(!find){
                semaine.add(seance.getSemaine());
            }
            find=false;
            for(String cour: cours){
                if (cour.equals(seance.getCours())){
                    find=true;
                }
            }
            if(!find){
                cours.add(seance.getCours());
            }
        }
    }

    public void setCoursSelectionne(String coursSelectionne) {
        this.coursSelectionne = coursSelectionne;
    }

    public ArrayList<String> getCours() {
        return cours;
    }

    public String getCoursSelectionne() {
        return coursSelectionne;
    }

    public ArrayList<Integer> getSemaine() {
        return semaine;
    }

    public int getSemaineSelectionne() {
        return semaineSelectionne;
    }

    public void setSemaineSelectionne(int semaineSelectionne) {
        this.semaineSelectionne = semaineSelectionne;
    }

    public ArrayList<String> getPromo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<String> getGroupe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Iterable<String> getEnseignant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPromoSelectionne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
