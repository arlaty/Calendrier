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
 * @author alexi
 */
public class RechercheEnseignant extends RechercheUser{
    ArrayList<String> promo;
    String promoSelectionne="ALL";
    ArrayList<String> groupe;
    String groupeSelectionne="ALL";
    public RechercheEnseignant(Utilisateur user) {
        super(user);
        ArrayList<Seance> seances = user.getSeances();
        promo=new ArrayList<>();
        groupe=new ArrayList<>();
        boolean find;
        boolean findg;
        promo.add(promoSelectionne);
        groupe.add(groupeSelectionne);
        for(Seance seance: seances){
            find=false;
            for(String promo1: promo){
                if (promo1.equals(seance.getPromo())){
                    find=true;
                }
            }
            for(String td: seance.getGroupes()){
                findg=false;
                for(String td1: groupe){
                    if (td1.equals(td)){
                        findg=true;
                    }
                }
                if(!findg){
                    groupe.add(td);
                }
            }
            if(!find){
                promo.add(seance.getPromo());
            }
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String getPromoSelectionne() {
        return promoSelectionne;
    }
    
    /**
     *
     * @return
     */
    public String getGroupeSelectionne() {
        return groupeSelectionne;
    }
    
    /**
     *
     * @return
     */
    @Override
    public ArrayList<String> getPromo() {
        return promo;
    }

    /**
     *
     * @return
     */
    @Override
    public ArrayList<String> getGroupe() {
        return groupe;
    }

    /**
     *
     * @param promoSelectionne
     */
    public void setPromoSelectionne(String promoSelectionne) {
        this.promoSelectionne = promoSelectionne;
    }

    /**
     *
     * @param groupeSelectionne
     */
    public void setGroupeSelectionne(String groupeSelectionne) {
        this.groupeSelectionne = groupeSelectionne;
    }
}
