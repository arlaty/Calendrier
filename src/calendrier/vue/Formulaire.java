/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.vue;

import calendrier.modele.Utilisateur;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 *
 * @author lizziedelaisser
 */
public class Formulaire extends JPanel{
   
    private JPanel pan_espacement = new JPanel();
        private JLabel espacement = new JLabel(" ");
        
    private JPanel pan_titre = new JPanel();
        private JLabel titre = new JLabel("Formulaire d'ajout d'une séance");
        
    private JPanel pan_date = new JPanel();
        private JLabel date = new JLabel("Date : ", JLabel.RIGHT);
        private JComboBox saisie_année = new JComboBox();
        private JLabel année = new JLabel("Année", JLabel.RIGHT);
        private JComboBox saisie_mois = new JComboBox();
        private JLabel mois = new JLabel("Mois", JLabel.RIGHT);
        private JComboBox saisie_jour = new JComboBox();
        private JLabel jour = new JLabel("jour", JLabel.RIGHT);
    
    private JPanel pan_horaires = new JPanel();
        private JLabel horaires = new JLabel("Horaires : ", JLabel.RIGHT);
        private JComboBox saisie_heure_début = new JComboBox();
        private JLabel heure_début = new JLabel("Heure début", JLabel.RIGHT);
        private JComboBox saisie_heure_fin = new JComboBox();
        private JLabel heure_fin = new JLabel("Heure Fébut", JLabel.RIGHT);
    
    private JPanel pan_état = new JPanel();
        private JComboBox saisie_état = new JComboBox();
        private JLabel état = new JLabel("Etat", JLabel.RIGHT);
   
    private JPanel pan_cours = new JPanel();
        private JComboBox saisie_cours = new JComboBox();
        private JLabel cours = new JLabel("Cours");
        private JComboBox saisie_type_cours = new JComboBox();
        private JLabel type_cours = new JLabel("Type de cours");
    
    private JPanel pan_groupe= new JPanel();
        private JComboBox saisie_promo = new JComboBox();
        private JLabel promo = new JLabel("Promo");
        //chargé suivant les groupes existants
        //private ArrayList <JCheckBox> list_groupe;
    
    private JPanel pan_enseignant= new JPanel();
        //chargé suivant les enseignants qui s'occupent du cours sélectionnés plus haut
        //private ArrayList <JCheckBox> list_enseignant;
        private JCheckBox enseignant1 = new JCheckBox("Enseignant1");
        private JCheckBox enseignant2 = new JCheckBox("Enseignant2");
        private JLabel enseignants = new JLabel("Enseignant(s) ");
    
    private JPanel pan_site = new JPanel();
        private JComboBox saisie_site = new JComboBox();
        private JLabel site = new JLabel("Site");
        //chargé suivant le site sélectionné
        //private ArrayList <JCheckBox> list_salles;
        private JCheckBox salle1 = new JCheckBox("Salle1");
        private JCheckBox salle2 = new JCheckBox("Salle2");
        private JCheckBox salle3 = new JCheckBox("Salle3");
    
    private JPanel pan_btn = new JPanel();
        private JButton btn_ajouter = new JButton("Ajouter");
    
    /**
     * Constrcuteur du content formulaire, qui prend en paramètre une fen^re de type JFrame
     * Initialise et affiche le form à remplir
     *  
     *
     * 
     * @param user 
     */
    public  Formulaire(Utilisateur user){
        //setBackground(Color.white);
        setLayout(new BorderLayout());

        //Font police = new Font("Arial", Font.BOLD, 14);
        pan_espacement.setLayout(new BoxLayout(pan_espacement, BoxLayout.LINE_AXIS));
        pan_espacement.add(espacement);
        pan_titre.setLayout(new BoxLayout(pan_titre, BoxLayout.LINE_AXIS));
        pan_titre.add(titre);
        
        année.setLabelFor(saisie_année);
        mois.setLabelFor(saisie_mois);
        jour.setLabelFor(saisie_jour);
        saisie_année.addItem("2020");
        saisie_année.addItem("2019");
        saisieMois(saisie_mois);    
        for(int i=0; i<31; ++i){
            saisie_jour.addItem(i+1);
        }
        
        pan_date.setLayout(new BoxLayout(pan_date, BoxLayout.LINE_AXIS));
        pan_date.add(date);
        pan_date.add(année);
        pan_date.add(saisie_année);
        pan_date.add(mois);
        pan_date.add(saisie_mois);
        pan_date.add(jour);
        pan_date.add(saisie_jour);
   
        
        heure_début.setLabelFor(saisie_heure_début);
        saisie_heure_début.addItem("8h30");
        saisie_heure_début.addItem("10h15");
        saisie_heure_début.addItem("12h");
        saisie_heure_début.addItem("13h45");
        saisie_heure_début.addItem("15h30");
        saisie_heure_début.addItem("17h15");
        saisie_heure_début.addItem("19h");
        pan_horaires.setLayout(new BoxLayout(pan_horaires, BoxLayout.LINE_AXIS));
        pan_horaires.add(horaires);
        pan_horaires.add(heure_début);
        pan_horaires.add(saisie_heure_début);
        
        état.setLabelFor(saisie_état);
        saisie_état.addItem("Validé");
        saisie_état.addItem("En cours de Validation");
        saisie_état.addItem("Annulé");   
        pan_état.setLayout(new BoxLayout(pan_état, BoxLayout.LINE_AXIS));
        pan_état.add(état);
        pan_état.add(saisie_état);
           
        saisie_type_cours.addItem("CM");
        saisie_type_cours.addItem("TD");
        saisie_type_cours.addItem("TP");  
        saisie_type_cours.addItem("Projet");  
        saisie_type_cours.addItem("Soutien");
        pan_cours.setLayout(new BoxLayout(pan_cours, BoxLayout.LINE_AXIS));
        for (String cours : user.getRecherche().getCours()){
            if (!cours.equals("ALL"))saisie_cours.addItem(cours);
        }
        pan_cours.add(cours);
        pan_cours.add(saisie_cours);
        pan_cours.add(type_cours);
        pan_cours.add(saisie_type_cours);
        
        for (String promos: user.getRecherche().getPromo()){
            if (!promos.equals("ALL"))saisie_promo.addItem(promos);
        }
        pan_groupe.setLayout(new BoxLayout(pan_groupe, BoxLayout.LINE_AXIS));
        pan_groupe.add(promo);
        pan_groupe.add(saisie_promo);
        for (String cours: user.getRecherche().getGroupe()){
            if (!cours.equals("ALL"))pan_groupe.add(new JCheckBox(cours));
        }
        
        pan_enseignant.setLayout(new BoxLayout(pan_enseignant, BoxLayout.LINE_AXIS));
        pan_enseignant.add(enseignants);
        for (String cours: user.getRecherche().getEnseignant()){
            if (!cours.equals("ALL"))pan_enseignant.add(new JCheckBox(cours));
        }

        pan_btn.add(btn_ajouter);
        
        btn_ajouter.addActionListener((ActionEvent arg0) -> { 
            
        });
      
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(pan_espacement);
        this.add(pan_titre);
        this.add(pan_date);
        this.add(pan_horaires);
        this.add(pan_état);
        this.add(pan_cours);
        this.add(pan_groupe);
        this.add(pan_enseignant);
        this.add(pan_site);
        this.add(pan_btn);
    }
   
    /**
     * Fonction qui rempli un menu déroulant ici appelé combo avec les différents mois de l'année 
     * et qui prend en paramètre une JComboBox (le dit menu déroulant)
     *  
     *
     * @param combo
     */
    private void saisieMois(JComboBox combo) {
        combo.addItem("Janvier");
        combo.addItem("Février");
        combo.addItem("Mars");
        combo.addItem("Avril");
        combo.addItem("Mai");
        combo.addItem("Juin");
        combo.addItem("Juillet");
        combo.addItem("Aout");
        combo.addItem("Septembre");
        combo.addItem("Octobre");
        combo.addItem("Novembre");
        combo.addItem("Décembre");
    }
}
