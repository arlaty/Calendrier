/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.vue;

import calendrier.modele.Admin;
import calendrier.modele.Seance;
import calendrier.modele.Utilisateur;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;


/**
 *
 * @author lizziedelaisser
 */
public class Zoom extends JFrame{

    JPanel pan;
    JTable tab;
    private JPanel pan_date = new JPanel();
        private JLabel date = new JLabel("Date :    ", JLabel.RIGHT);
        private JLabel seance_date;
    
    private JPanel pan_horaires = new JPanel();
        private JLabel horaires = new JLabel("Horaires :    de ", JLabel.RIGHT);
        private JLabel intermédiaire = new JLabel("  à   ");
        private JLabel seance_heure_début, seance_heure_fin;
    
    private JPanel pan_état = new JPanel();
        private JLabel état = new JLabel("Etat :    ", JLabel.RIGHT);
        private JLabel seance_état;
   
    private JPanel pan_cours = new JPanel();
        private JLabel cours = new JLabel("Cours :    ");
        private JLabel type_cours = new JLabel("    Type de cours :    ");
        private JLabel seance_cours, seance_type_cours;
    
    private JPanel pan_groupe= new JPanel();
        private JLabel promo = new JLabel("Promo :    ");
        private JLabel groupe = new JLabel("    Groupe(s) :    ");
        private JLabel seance_promo, seance_groupe;
        //chargé suivant les groupes existants
        //private ArrayList <JLabel> seance_groupe;
    
    private JPanel pan_enseignant= new JPanel();
        //chargé suivant les enseignants qui s'occupent du cours sélectionnés plus haut
        //private ArrayList <JLabel> seance_enseignant;
        private JLabel enseignant = new JLabel("Enseignant(s) :    ");
        private JLabel seance_enseignant;
    
    private JPanel pan_site = new JPanel();
        private JLabel site = new JLabel("Site :    ");
        private JLabel salle = new JLabel("     Salle(s) :    ");
        private JLabel seance_site, seance_salle;
        //private ArrayList <JLabel> seance_salle;     //chargé suivant le site sélectionné
    
    private JPanel pan_btn = new JPanel();
        private JButton btn_modifier = new JButton("Modifier");
        private JButton btn_supprimer = new JButton("Supprimer");
    
    /**
     * Constructeur qui instancie l'objet Zoom qui correspond à la fenêtre qui détaille le contenu d'une séance 
     * 
     *  
     *
     */
    public Zoom(Seance seance,Utilisateur user){
        super("Zoom sur une séance");
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true); 
        
        pan = new JPanel();
        
        ArrayList<String> enseignants= seance.getEnseignants();
        String listenseignants="";
        for (String enseignant:enseignants){
            listenseignants+=enseignant+" ";
        }
        String listgroupes="";
        ArrayList<String> groupes= seance.getGroupes();
        for (String groupe:groupes){
            listgroupes+=groupe+" ";
        }
        String listsalles="";
        ArrayList<String> salles= seance.getSalles();
        for (String salle:salles){
            listsalles+=salle+" ";
        }
        //données à charger depuis la table séance
        seance_date= new JLabel(seance.getDate().toString());
        seance_heure_début = new JLabel(seance.getHeure_debut().toString());
        seance_heure_fin  = new JLabel(seance.getHeure_fin().toString());
        seance_état = new JLabel(seance.getEtat());
        seance_cours = new JLabel(seance.getCours());
        seance_type_cours = new JLabel(seance.getType_cours());
        seance_promo = new JLabel(seance.getPromo());
        seance_groupe = new JLabel(listgroupes);
        seance_enseignant = new JLabel(listenseignants);
        seance_site = new JLabel(seance.getSite());
        seance_salle= new JLabel(listsalles);
        
        
        pan_date.setLayout(new BoxLayout(pan_date, BoxLayout.LINE_AXIS));
        pan_date.add(date);
        pan_date.add(seance_date);
   
        pan_horaires.setLayout(new BoxLayout(pan_horaires, BoxLayout.LINE_AXIS));
        pan_horaires.add(horaires);
        pan_horaires.add(seance_heure_début);
        pan_horaires.add(intermédiaire);
        pan_horaires.add(seance_heure_fin);
    
        pan_état.setLayout(new BoxLayout(pan_état, BoxLayout.LINE_AXIS));
        pan_état.add(état);
        pan_état.add(seance_état);
           
        //à remplir
        pan_cours.setLayout(new BoxLayout(pan_cours, BoxLayout.LINE_AXIS));        
        pan_cours.add(cours);
        pan_cours.add(seance_cours);
        pan_cours.add(type_cours);
        pan_cours.add(seance_type_cours);
        
        pan_groupe.setLayout(new BoxLayout(pan_groupe, BoxLayout.LINE_AXIS));
        pan_groupe.add(promo);
        pan_groupe.add(seance_promo);
        pan_groupe.add(groupe);
        pan_groupe.add(seance_groupe);

        
        pan_enseignant.setLayout(new BoxLayout(pan_enseignant, BoxLayout.LINE_AXIS));
        pan_enseignant.add(enseignant);
        pan_enseignant.add(seance_enseignant);

        
        pan_site.setLayout(new BoxLayout(pan_site, BoxLayout.LINE_AXIS));
        pan_site.add(site);
        pan_site.add(seance_site);
        pan_site.add(salle);
        pan_site.add(seance_salle);
        
        if (user instanceof Admin){
            pan_btn.add(btn_modifier);
            pan_btn.add(btn_supprimer);
        }
        
        btn_modifier.addActionListener((ActionEvent arg0) -> { 
            //content formulaire prerempli avec les données de la séance 
            //nouveau programme ou class avec copie-coller formulaire ajout séance chargé les données de la bdd puis pré sélectionnés  les données de la séance
        });
        btn_supprimer.addActionListener((ActionEvent arg0) -> { 
            //suppression de la séance dans la bdd 
       
        });
        
        pan.setLayout(new BoxLayout(pan, BoxLayout.PAGE_AXIS));
        pan.add(pan_date);
        pan.add(pan_horaires);
        pan.add(pan_état);
        pan.add(pan_cours);
        pan.add(pan_groupe);
        pan.add(pan_enseignant);
        pan.add(pan_site);
        pan.add(pan_btn);
        this.setContentPane(pan);
        this.pack();
        this.setVisible(true);
        System.out.println("sort zoom");
    }
}
