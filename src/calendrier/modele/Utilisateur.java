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
public class Utilisateur {
    String email;
    String nom;
    String prenom;
    ArrayList<Seance> seances;
    Reporting reporting;
    
    public Utilisateur(String inemail,String innom,String inprenom,ArrayList<Seance> inseances,Reporting inreporting){
        email=inemail;
        nom=innom;
        prenom=inprenom;
        seances=inseances;
        reporting=inreporting;
    }
}
