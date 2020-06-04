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
public class Etudiant extends Utilisateur{
    int numero;
    int TD;
    String Promo;
    public Etudiant (String inemail,String innom,String inprenom,int innumero,int inTD,String inpromo,ArrayList<Seance> inseances,Reporting inreporting){
        super(inemail,innom,inprenom,inseances,inreporting);
        numero=innumero;
        TD=inTD;
        Promo=inpromo;
    }
}
