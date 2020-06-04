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
public class Admin extends Utilisateur{
    public Admin(String inemail, String innom, String inprenom,ArrayList<Seance> inseances,Reporting inreporting) {
        super(inemail, innom, inprenom,inseances,inreporting);
    }
}
