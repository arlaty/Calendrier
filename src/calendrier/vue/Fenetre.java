/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.vue;

import calendrier.modele.Utilisateur;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lizziedelaisser
 */
public class Fenetre extends JFrame implements ActionListener, ItemListener{ 
    
    private JMenuBar navigation;
    private JMenu cours, reporting, salles, logout;
    private JMenuItem edt, recap, ajout, liste_salles;
    private JButton deco, reporting_chart;
    private Formulaire ajout_seance;
    private EDT edt_content;
    private Récap recap_content;
    private Recherche recherche_form;
    private Reporting reporting_content;
    private Utilisateur user;
    
    /**
     * Constructeur de la fenêtre principale de l'application
     * qui instancie l'objet en attribut de la classe Connexion.
     *  
     *
     */
    public Fenetre() {
  
        // creation par heritage de la fenetre
        super("Calendrier");
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(false);
        
        Login page0 = new Login();
        //si connection
        
        ouverture(page0);
        
    }

    /**
     * Fonction qui ouvre la fenêtre principale après que la connexion ait été vérifiée
     *  prend en paramètre la page de login pour vérifier la connexion
     *
     * @param page
     */
    public void ouverture (Login page){
        while (page.OK==false) {
            this.setVisible(false);
            //attention il faut mettre au moins une ligne de code pour que la boucle soit valide
            //System.out.println("1");
            //tant que le login n'est pas valider on affiche pas la fenêtre
        }
        
        barre();
        user=page.getUser();
        recherche_form = new Recherche("Emploi du temps",user);
        edt_content = new EDT(user);
        this.add(recherche_form);
        this.add(edt_content);
        this.pack();
        this.setVisible(true);
    }
    /**
     * Fonction qui crée l'entête constituée d'une barre d'infos et du menu principal
     *  
     *
     */
    public void barre(){
       
        JPanel pan=new JPanel();            //panel
        
        pan.setBackground(new Color(113, 171, 219));
        BoxLayout    bl=new BoxLayout(pan,BoxLayout.Y_AXIS);   //layoutManager
        pan.setLayout(bl);                      //attache le layoutManager au panel           

        JLabel  lab=new JLabel("Planning 2019-2020  -Nom Prénom (type d'utilisateur)", JLabel.RIGHT);  //créé un label
        lab.setForeground(Color.white);
        
        pan.add(lab); //l'ajoute au panel
        
        
        //configuration du menu selon le droit de l'utilisateur connecté
        Nav(1);
        setJMenuBar(navigation);
        
        this.setContentPane(pan);
    }
    
    /**
     * Fonction qui affiche les salles dont dispose l'organisme de l'edt
     *  
     *
     */
    public void affichageSalles(){
        System.out.println("Page Salles IN");
        //Les données du tableau qui seront à chercher depuis la BDD
        Object[][] data = {
            {"E1", "EM009"},
            {"E2", "P445"},
            {"E3", "C102"}
        };

        //Les titres des colonnes
        Object  title[] = {"Site", "Salle"};
        JTable tableau = new JTable(data, title);
        //instance table model
        DefaultTableModel tableModel = new DefaultTableModel(data, title) {

            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            }
        };
        tableau.setModel(tableModel);
        //Nous ajoutons notre tableau à notre contentPane dans un scroll
        //Sinon les titres des colonnes ne s'afficheront pas !
        this.add(new JScrollPane(tableau));
        System.out.println("Page Salles OUT");

    }
    
    /**
     * fonction qui initialise le menu de navigation principal et qui prend en paramètre le droit de l'utlisateur afin d'initialiser les bons onglets
     *  
     *
     * @param droit
     */
    public void Nav(int droit){
       
        navigation = new JMenuBar();
        
        cours = new JMenu("Cours");
        reporting = new JMenu("Reporting");
        salles = new JMenu("Salles");
        logout = new JMenu("Deconnexion");

        edt = new JMenuItem("Emploi du temps");
        recap = new JMenuItem("Récapitulatif des cours");
        ajout = new JMenuItem("Ajouter une séance");
        reporting_chart = new JButton(new ImageIcon("icon/reporting.png"));
        liste_salles = new JMenuItem("Liste des salles");
        deco= new JButton(new ImageIcon("icon/deco.png"));

        //On initialise nos menus
        cours.add(edt);  
        
        cours.add(recap);
        if(droit==1) //seul l'admin a accès à l'ajout d'une séance
            cours.add(ajout);

        reporting.add(reporting_chart);
        salles.add(liste_salles);
        logout.add(deco);
        
        //L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de gauche à droite
        //Le premier ajouté sera tout à gauche de la barre de menu et inversement pour le dernier
        navigation.add(cours);
        navigation.add(reporting);
        if(droit==1) //seul l'admin a accès aux Salles
            navigation.add(salles);

        navigation.add(Box.createHorizontalGlue());
        navigation.add(logout);

        edt.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //affichage de l'edt
                actualiser(0);
            }
        });
        
        recap.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //affichage du récapitulatif des cours
                actualiser(1);
            }
        });
        
        ajout.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //affichage du formulaire d'ajout d'une séance
                actualiser(2);
            }
        });
        
        reporting_chart.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //affichage du reporting
                actualiser(3);
            }
        });
        
        liste_salles.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //affichage des salles
                actualiser(4);
            }
        });
        
        deco.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Demande de sortie");
                System.exit(0);
            }
        });
    }
    
    /**
     * fonction qui actualise la fenêtre dès qu'on clique sur un onglet du menu
     * et qui prend en paramètre l'index de l'onglet 
     *  
     *
     * @param content
     */
    public void actualiser(int content){
        
        barre();
        switch(content){
            case 0: //affichage page EDT
                recherche_form = new Recherche("Emploi du temps",user);
                edt_content = new EDT(user);
                this.add("North", recherche_form);
                this.add(edt_content);
                break;
            case 1: //affichage page recap cours
                recherche_form = new Recherche("Récapitulatif des cours",user);
                recap_content = new Récap(user);
                this.add("North", recherche_form);
                this.add(recap_content);
                break;
            case 2: //affichage page ajout séance
                ajout_seance = new Formulaire();
                this.add(ajout_seance);
                break;   
            case 3: //affichage page reporting
                System.out.println("Demande reporting");
                reporting_content = new Reporting();
                this.add(reporting);
                break;
            case 4: //affichage page salles
                System.out.println("Demande affichage salles");
                affichageSalles();
                break;
        }
        
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
