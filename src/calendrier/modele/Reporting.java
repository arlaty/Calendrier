/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.modele;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author cleme
 */
public class Reporting {
    
    Map <String, Integer> info1;
    Map <String, Integer> info2;
    Map <String, Integer> info3;
    
    
    public Reporting() {}
    public Reporting(ArrayList<Seance> seance, Utilisateur user){
        this.info1=infoCours(seance,user);
        this.info2=infoTypeCours(seance,user);
        this.info3= test(seance, user);
        
    }
    
    public Map infoCours(ArrayList<Seance> seance, Utilisateur user){
        Map <String, Integer> cours= new HashMap<>();
        String nomC;
        for (int i = 0; i < seance.size(); i++) {
            
            Seance mesSeances=seance.get(i);
            
        if(user instanceof Admin){
            nomC=mesSeances.getPromo();
            cours.put(nomC, Collections.frequency(seance, mesSeances.getPromo()));
        }
        if(user instanceof Enseignant){
            nomC=mesSeances.getPromo();
            cours.put(nomC, Collections.frequency(seance, mesSeances.getPromo()));
        }    
        if(user instanceof Etudiant){
            nomC=mesSeances.getCours();
            cours.put(nomC, Collections.frequency(seance, mesSeances.getCours()));
        }
        
        }
        return cours;
    }
    
    public Map infoTypeCours(ArrayList<Seance> seance, Utilisateur user){
        Map <String, Integer> T_cours= new HashMap<>();
        String nomTC;
        for (int i = 0; i < seance.size(); i++) {
            Seance mesSeances=seance.get(i); 
            if(user instanceof Admin){
                nomTC=mesSeances.getSites();
                T_cours.put(nomTC, Collections.frequency(seance, mesSeances.getSites()));
            }
            if(user instanceof Enseignant){
                nomTC=mesSeances.getType_cours();
                T_cours.put(nomTC, Collections.frequency(seance, mesSeances.getType_cours()));
            }
            if(user instanceof Etudiant){
                nomTC=mesSeances.getType_cours();
                T_cours.put(nomTC, Collections.frequency(seance, mesSeances.getType_cours()));
            }
        }
        return T_cours;
    }
    
    public Map test(ArrayList<Seance> seance, Utilisateur user){
        Map <String, Integer> Tout_enseignant= new HashMap<>();
        String nomE;
        ArrayList<String> enseignants;
        for (int i = 0; i < seance.size(); i++) {
            Seance mesSeances=seance.get(i); 
            if(user instanceof Admin){
                enseignants=mesSeances.getEnseignants();
                for(int x=0;x<enseignants.size();x++){
                    nomE=enseignants.get(x);
                    Tout_enseignant.put(nomE, Collections.frequency(seance, nomE));
                }
            }
        }
        return Tout_enseignant;
    }
    
    
}
