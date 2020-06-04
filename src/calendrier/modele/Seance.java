/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.modele;

import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author alexi
 */
public class Seance {
    int ID;
    int semaine;
    Time heure_debut;
    Time heure_fin;
    String Etat;
    ArrayList<String> Enseignants;
    String type_cours;
    String cours;
    ArrayList<String> salles;
    ArrayList<String> sites;
    int capacite;
    ArrayList<String> groupes;
    String Promo;

    public Seance(int ID, int semaine, Time heure_debut, Time heure_fin, String Etat, ArrayList<String> Enseignants, String type_cours, String cours, ArrayList<String> salles, ArrayList<String> sites, int capacite, ArrayList<String> groupes, String Promo) {
        this.ID = ID;
        this.semaine = semaine;
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
}
