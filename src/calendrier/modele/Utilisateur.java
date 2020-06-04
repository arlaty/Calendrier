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
public abstract class Utilisateur {
    String email;
    String nom;
    String prenom;
    ArrayList<Seance> seances;
    Reporting reporting;

    public Utilisateur() {}

    public Utilisateur(String email, String nom, String prenom, ArrayList<Seance> seances, Reporting reporting) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.seances = seances;
        this.reporting = reporting;
    }

    public String getEmail() {
        return email;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public ArrayList<Seance> getSeances() {
        return seances;
    }

    public Reporting getReporting() {
        return reporting;
    }
}
