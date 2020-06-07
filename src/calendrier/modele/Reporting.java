/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.modele;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author clement
 */
public class Reporting {
    
    Map <String, Integer> info1;
    Map <String, Integer> info2;
    Map <String, Integer> info3;
    Map <String, Integer> info4;
    
    /**
     * Constructeur qui instancie l'objet Reporting qui correspond au contenu que l'on souhaite afficher dans Vue.reporting
     *  
     *
     * @param user
     */
    public Reporting() {}
    public Reporting(Utilisateur user){ 
        info1=I1(user);
        try {
            info2=I2(user);
        } catch(Exception e){
            e.printStackTrace();
        }
        info3= I3(user);
        info4=I4(user);
        
    }
     /**
     * Methode get qui recupère une map info1  une Map(String,Integer) pour pouvoir la reutiliser
     *  
     *
     * 
     * @return 
     */
    public Map<String, Integer> getInfo1(){
        return info1;
    }
    /**
     * Methode get qui recupère une map info2 pour pouvoir la reutiliser
     *  
     *
     * 
     * @return 
     */
    public Map<String, Integer> getInfo2(){
        return info2;
    }
    /**
     * Methode get qui recupère une map info3 pour pouvoir la reutiliser
     *  
     *
     * 
     * @return 
     */
    public Map<String, Integer> getInfo3(){
        return info3;
    }
    
    /**
     * Methode get qui recupère une map info4 pour pouvoir la reutiliser
     *  
     *
     * 
     * @return 
     */
    public Map<String, Integer> getInfo4(){
        return info4;
    }
    /**
     * Methode qui permet d'initialiser info1  grace à l'utilisateur
     *  
     *
     *  @param user
     * @return 
     */
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
    
    /**
     * Methode qui permet d'initialiser info2 une Map(String,Integer) grace à l'utilisateur
     *  
     *
     *  @param user
     * @return 
     */
    public Map I2(Utilisateur user) throws ClassNotFoundException, SQLException{
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
            
                Class.forName("com.mysql.jdbc.Driver");
                String urlDatabase = "jdbc:mysql://localhost/calendrier";
                Connection connect = DriverManager.getConnection(urlDatabase, "root", "");
                ResultSet result4 = connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM salle");
                while (result4.next()){
                    result4.getString("nom");
                    result4.getInt("capacite");
                    Info2.put(result4.getString("nom"),result4.getInt("capacite"));
                    }
            }
        }
        if((user instanceof Etudiant)||(user instanceof Enseignant)){
        for (int i = 0; i < seance.size(); i++) {
            String mesTypeSeances=C.get(i);
            nomTC=mesTypeSeances;
            Info2.put(nomTC, Collections.frequency(C, nomTC));
        }
        }
        return Info2;
    }
    
    /**
     * Methode qui permet d'initialiser info3 une Map(String,Integer) grace à l'utilisateur
     *  
     *
     *  @param user
     * @return 
     */
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
                    test.add(mesSeances.cours);
                }
        }for (int i = 0; i < test.size(); i++) {
            nomE=test.get(i);
            Tout_enseignant.put(nomE, Collections.frequency(test, nomE));
        }
        return Tout_enseignant;
    }
    
    /**
     * Methode qui permet d'initialiser info4 une Map(String,Integer)grace à l'utilisateur
     *  
     *
     *  @param user
     * @return 
     */
    public Map I4( Utilisateur user){
        ArrayList<Seance> seance=user.getSeances();
        Map <String, Integer> Tout_enseignant= new HashMap<>();
        String nomE;
        ArrayList<String> enseignants;
        ArrayList<String> test= new ArrayList<String>();
        for (int i = 0; i < seance.size(); i++) {
            Seance mesSeances=seance.get(i);
                if((user instanceof Admin)||(user instanceof Referent)||(user instanceof Enseignant)){
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