/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author lizziedelaisser
 */
public class Recherche extends JPanel{
    
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
    
    private JComboBox recherche_semaine = new JComboBox();
    private JLabel semaine = new JLabel("Semaine");
    
    
    /**
     * Constructeur du "menu" ou "form" de recherche et qui return le panel de recherche
     *  
     * 
     */
    public Recherche(){
        System.out.println("Page Recherche");
        

        setBackground(Color.white);
        setLayout(new BorderLayout());

        Font police = new Font("Arial", Font.BOLD, 14);

        //boucle pour entrer les cours depuis la bdd etc
        recherche_cours.addItem("ALL");
        recherche_cours.addItem("1");

        recherche_promo.addItem("ALL");
        recherche_groupe.addItem("ALL");
        recherche_utilisateur.addItem("ALL");
        recherche_semaine.addItem("ALL");

        etudiants.setSelected(true);
        //etudiants.addActionListener(new StateListener());
        //enseignants.addActionListener(new StateListener());
        type_utilisateur.add(etudiants);
        type_utilisateur.add(enseignants);


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
        pan_bis.add(semaine);
        pan_bis.add(recherche_semaine);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(pan);
        add(pan_bis);
    }
  
}