/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.modele;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author alexi
 */
public class Seance {
    int ID;
    int semaine;
    Date date;
    Time heure_debut;
    Time heure_fin;
    String Etat;
    ArrayList<String> Enseignants;
    String type_cours;
    String cours;
    ArrayList<String> salles;
    String sites;
    int capacite;
    ArrayList<String> groupes;
    String Promo;

    public Seance() {}

    public Seance(int ID, int semaine,Date date, Time heure_debut, Time heure_fin, String Etat, ArrayList<String> Enseignants, String type_cours, String cours, ArrayList<String> salles,String sites, int capacite, ArrayList<String> groupes, String Promo) {
        this.ID = ID;
        this.semaine = semaine;
        this.date= date;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.Etat = Etat;
        this.Enseignants = Enseignants;
        this.type_cours = type_cours;
        this.cours = cours;
        this.salles = salles;
        this.sites = sites;
        this.capacite = capacite;
        this.groupes = groupes;
        this.Promo = Promo;
    }

    public int getID() {
        return ID;
    }

    public int getSemaine() {
        return semaine;
    }

    public Date getDate() {
        return date;
    }

    public Time getHeure_debut() {
        return heure_debut;
    }

    public Time getHeure_fin() {
        return heure_fin;
    }

    public String getEtat() {
        return Etat;
    }

    public ArrayList<String> getEnseignants() {
        return Enseignants;
    }

    public String getType_cours() {
        return type_cours;
    }

    public String getCours() {
        return cours;
    }

    public ArrayList<String> getSalles() {
        return salles;
    }

    public String getSites() {
        return sites;
    }

    public int getCapacite() {
        return capacite;
    }

    public ArrayList<String> getGroupes() {
        return groupes;
    }

    public String getPromo() {
        return Promo;
    }
}
