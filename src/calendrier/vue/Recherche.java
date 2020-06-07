/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.vue;

import calendrier.modele.Enseignant;
import calendrier.modele.Etudiant;
import calendrier.modele.Utilisateur;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    public Recherche(String titre_page, Utilisateur user){
        
        //setBackground(Color.white);
        setLayout(new GridLayout(2, 1));
        titre = new JLabel(titre_page);
        
        pan_espacement.setLayout(new BoxLayout(pan_espacement, BoxLayout.LINE_AXIS));
        pan_espacement.add(espacement);
        pan_titre.setLayout(new BoxLayout(pan_titre, BoxLayout.LINE_AXIS));
        pan_titre.add(titre);

        pan.setLayout(new BoxLayout(pan, BoxLayout.LINE_AXIS));
        pan_bis.setLayout(new BoxLayout(pan_bis, BoxLayout.LINE_AXIS));
        //rehcerche par COURS dispo pour tous
        //boucle pour entrer les cours depuis la bdd etc
        for (String cour: user.getRecherche().getCours()){
            recherche_cours.addItem(cour);
        }
        recherche_cours.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //si on sélectionne une autre valeur on l'affiche
                user.getRecherche().setCoursSelectionne((String)recherche_cours.getSelectedItem());
            }
        });
        pan.add(cours);
        pan.add(recherche_cours);
        for (Integer semaine: user.getRecherche().getSemaine()){
            recherche_semaine.addItem(semaine);
        }
        recherche_semaine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //si on sélectionne une autre valeur on l'affiche
                user.getRecherche().setSemaineSelectionne((Integer)recherche_semaine.getSelectedItem());
            }
        });
        pan_bis.add(semaine);
        pan_bis.add(recherche_semaine);
        //recherche par ... non dispo pour ETUDIANT
        if (!(user instanceof Etudiant)){
            for (String promos: user.getRecherche().getPromo()){
                recherche_promo.addItem(promos);
            }
            pan.add(promo);
            pan.add(recherche_promo);
            for (String groupes: user.getRecherche().getGroupe()){
                recherche_groupe.addItem(groupes);
            }
            pan.add(groupe);
            pan.add(recherche_groupe);
            recherche_utilisateur.addItem("ALL");
            pan.add(utilisateur);
            pan.add(recherche_utilisateur);
            if(titre_page != "Récapitulatif des cours"){
                recherche_année.addItem("ALL");
                pan_bis.add(année);
                pan_bis.add(recherche_année);
                pan_bis.add(mois);
            }

            //recherche par ... non dispo pour ETUDIANT, ENSEIGNANT
            if (!(user instanceof Enseignant)){
                etudiants.setSelected(true);
                //etudiants.addActionListener(new StateListener());
                //enseignants.addActionListener(new StateListener());
                type_utilisateur.add(etudiants);
                pan.add(etudiants);
                type_utilisateur.add(enseignants);
                pan.add(enseignants);
            }
        }

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(pan_espacement);
        this.add(pan_titre);
        add(pan);
        add(pan_bis);
    }  
}
