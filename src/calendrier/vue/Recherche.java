/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.vue;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author lizziedelaisser
 */
public class Recherche extends JPanel{
    
    private JPanel pan_espacement = new JPanel();
        private JLabel espacement = new JLabel(" ");    
    private JPanel pan_titre = new JPanel();
        private JLabel titre;
    
    private JPanel pan = new JPanel();
    private JPanel pan_bis = new JPanel();
   
    private JComboBox recherche_cours = new JComboBox();
    private JLabel cours = new JLabel("Cours");
    
    private JComboBox recherche_promo = new JComboBox();
    private JLabel promo = new JLabel("Promo");
    
    private JComboBox recherche_groupe = new JComboBox();
    private JLabel groupe = new JLabel("Groupe");
    
    private ButtonGroup type_utilisateur = new ButtonGroup();
    private JRadioButton etudiants = new JRadioButton("     Etudiants");
    private JRadioButton enseignants = new JRadioButton("Enseignants");
    
    private JComboBox recherche_utilisateur = new JComboBox();
    private JLabel utilisateur = new JLabel("   Utilisateur");
    
    private JComboBox recherche_année = new JComboBox();
    private JLabel année = new JLabel("Année");
    private JComboBox recherche_semaine = new JComboBox();
    private JLabel semaine = new JLabel("Semaine");
    private JLabel mois = new JLabel("Indique le mois correspondant ou bien le lundi correspondant");
    
    
    /**
     * Constructeur du "menu" ou "form" de recherche et qui return le panel de recherche
     *  
     * 
     */
    public Recherche(String titre_page){
        
        //setBackground(Color.white);
        setLayout(new GridLayout(2, 1));
        titre = new JLabel(titre_page);

        //rehcerche par COURS dispo pour tous
        //boucle pour entrer les cours depuis la bdd etc
        recherche_cours.addItem("ALL");
        recherche_cours.addItem("1");

        //recherche par ... non dispo pour ETUDIANT
        recherche_promo.addItem("ALL");
        recherche_groupe.addItem("ALL");
        recherche_utilisateur.addItem("ALL");
        recherche_année.addItem("ALL");
        recherche_semaine.addItem("ALL");

        //recherche par ... non dispo pour ETUDIANT, ENSEIGNANT
        etudiants.setSelected(true);
        //etudiants.addActionListener(new StateListener());
        //enseignants.addActionListener(new StateListener());
        type_utilisateur.add(etudiants);
        type_utilisateur.add(enseignants);
        
        pan_espacement.setLayout(new BoxLayout(pan_espacement, BoxLayout.LINE_AXIS));
        pan_espacement.add(espacement);
        pan_titre.setLayout(new BoxLayout(pan_titre, BoxLayout.LINE_AXIS));
        pan_titre.add(titre);

        pan.setLayout(new BoxLayout(pan, BoxLayout.LINE_AXIS));
        pan_bis.setLayout(new BoxLayout(pan_bis, BoxLayout.LINE_AXIS));
        pan.add(cours);
        pan.add(recherche_cours);
        pan.add(promo);
        pan.add(recherche_promo);
        pan.add(groupe);
        pan.add(recherche_groupe);
        pan.add(enseignants);
        pan.add(etudiants);
        pan.add(utilisateur);
        pan.add(recherche_utilisateur);
        if(titre_page != "Récapitulatif des cours"){
            pan_bis.add(année);
            pan_bis.add(recherche_année);
            pan_bis.add(semaine);
            pan_bis.add(recherche_semaine);
            pan_bis.add(mois);
        }

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(pan_espacement);
        this.add(pan_titre);
        add(pan);
        add(pan_bis);
    }
  
}