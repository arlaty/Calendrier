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
    RechercheUser recherche;

    public Utilisateur() {}

    public Utilisateur(String email, String nom, String prenom) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.seances = null;
        this.reporting = null;
        this.recherche = null;
    }

    public void setRecherche(RechercheUser recherche) {
        this.recherche = recherche;
    }
    
    

    public void setSeances(ArrayList<Seance> seances) {
        this.seances = seances;
    }
    public void setReporting(Reporting r) {
        this.reporting = r;
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

    public RechercheUser getRecherche() {
        return recherche;
    }
    
    public abstract void createReporting();
    public abstract int getNumero();
    public abstract String getTD();
    public abstract String getPromo();
}
