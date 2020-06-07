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
    Map <String, Integer> info4;
    
    
    public Reporting() {}
    public Reporting(Utilisateur user){ 
        info1=I1(user);
        info2=I2(user);
        info3= I3(user);
        info4=I4(user);
        
    }
    public Map<String, Integer> getInfo1(){
        return info1;
    }
    public Map<String, Integer> getInfo2(){
        return info2;
    }
    public Map<String, Integer> getInfo3(){
        return info3;
    }
    public Map<String, Integer> getInfo4(){
        return info4;
    }
    
    public Map I1(Utilisateur user){
        //Recupère les séances de l'utilisateur
        ArrayList<Seance> seance=user.getSeances();
        //Création d'une map pour stock le nom du cour et le nbr d'heure qui lui est associé
        Map <String, Integer> Info= new HashMap<>();
        //List des différent cours
        ArrayList<String>C=new ArrayList<String>();
        String nomC;
        //Boucle qui
        for (int i = 0; i < seance.size(); i++) {
            Seance S=seance.get(i);
            
            if(user instanceof Etudiant){
            C.add(S.getCours());
            }else if(user instanceof Enseignant){
                C.add(S.getType_cours());
            }else if((user instanceof Admin)||(user instanceof Referent)){
                C.add(S.getPromo());
            }
        }
        for (int i = 0; i < C.size(); i++) {
            String mesSeances=C.get(i);
            nomC=mesSeances;
            Info.put(nomC, Collections.frequency(C,nomC ));
        }
        return Info;
    }
    
    public Map I2(Utilisateur user){
        ArrayList<Seance> seance=user.getSeances();
        Map <String, Integer> Info2= new HashMap<>();
        //List des différent cours
        ArrayList<String>C=new ArrayList<String>();
        String nomTC;
        for (int i = 0; i < seance.size(); i++) {
            Seance S=seance.get(i);
            if(user instanceof Etudiant){
            C.add(S.getType_cours());
            }else if(user instanceof Enseignant){
            C.add(S.getPromo());
            }
            else if((user instanceof Admin)||(user instanceof Referent)){
            C.add(S.getSite());
            }
        }
        for (int i = 0; i < seance.size(); i++) {
            String mesTypeSeances=C.get(i);
            nomTC=mesTypeSeances;
            Info2.put(nomTC, Collections.frequency(C, nomTC));
            
        }
        return Info2;
    }
    
    public Map I3( Utilisateur user){
        ArrayList<Seance> seance=user.getSeances();
        Map <String, Integer> Tout_enseignant= new HashMap<>();
        String nomE;
        ArrayList<String> enseignants;
        ArrayList<String> test= new ArrayList<String>();
        for (int i = 0; i < seance.size(); i++) {
            Seance mesSeances=seance.get(i);
                if((user instanceof Admin)||(user instanceof Referent)||(user instanceof Etudiant)){
                    enseignants=mesSeances.getEnseignants();
                    for(int x=0;x<enseignants.size();x++){
                        test.add(enseignants.get(x));
                    }
                }else{
                    test.add(mesSeances.etat);
                }
        }for (int i = 0; i < test.size(); i++) {
            nomE=test.get(i);
            Tout_enseignant.put(nomE, Collections.frequency(test, nomE));
        }
        return Tout_enseignant;
    }
    
    public Map I4( Utilisateur user){
        ArrayList<Seance> seance=user.getSeances();
        Map <String, Integer> Tout_enseignant= new HashMap<>();
        String nomE;
        ArrayList<String> enseignants;
        ArrayList<String> test= new ArrayList<String>();
        for (int i = 0; i < seance.size(); i++) {
            Seance mesSeances=seance.get(i);
                if((user instanceof Admin)||(user instanceof Referent)){
                    enseignants=mesSeances.getSalles();
                    for(int x=0;x<enseignants.size();x++){
                        test.add(enseignants.get(x));
                    }
                }else{
                    test.add(mesSeances.etat);
                }
        }for (int i = 0; i < test.size(); i++) {
            nomE=test.get(i);
            Tout_enseignant.put(nomE, Collections.frequency(test, nomE));
        }
        return Tout_enseignant;
    }
    
    
}