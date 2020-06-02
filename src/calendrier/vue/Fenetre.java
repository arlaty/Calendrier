/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.vue;

import calendrier.controleur.Connexion;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
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

/**
 *
 * @author lizziedelaisser
 */
public class Fenetre extends JFrame implements ActionListener, ItemListener{
    private Connexion maconnexion;
    private JMenuBar navigation;
    private Formulaire ajout_seance;
    private EDT edt_content;
    private Récap recap_content;
    private Recherche recherche_form;
    //private Nav navigation;
    
    
    /**
     * Constructeur qui instancie l'objet en attribut de la classe Connexion.
     *  
     *
     */
    public Fenetre() {
  
        // creation par heritage de la fenetre
        super("Calendrier");
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(false);
        
        try {
            try {
                maconnexion = new Connexion();
            } catch (ClassNotFoundException cnfe) {
                System.out.println("Connexion echouee : probleme de classe");
                cnfe.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Connexion echouee : probleme SQL");
            e.printStackTrace();
        }
        
        Login page0 = new Login();
        //si connection
        
        ouverture(page0);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Fonction qui ouvre la fenêtre principale après que la connexion ait été vérifiée
     *  
     *
     * @param page
     */
    public void ouverture (Login page){
        System.out.println("av");
        while (page.OK==false) {
            //this.setVisible(false);
            //attention il faut mettre au moins une ligne de code pour que la boucle soit valide
            System.out.println("1");
            //tant que le login n'est pas valider on affiche pas la fenêtre
        }
         System.out.println("ap");
         
         
        //ajout de la barre d'infos et du menu principal
        barre();
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
        
        BoxLayout    bl=new BoxLayout(pan,BoxLayout.Y_AXIS);   //layoutManager
        pan.setLayout(bl);                      //attache le layoutManager au panel           

        JLabel  lab=new JLabel("Planning 2019-2020  -Nom Prénom (type d'utilisateur)");  //créé un label
        pan.add(lab);           //l'ajoute au panel
        
        //configuration du menu selon le droit de l'utilisateur connecté
        Nav(1);
        pan.add(navigation, BorderLayout.SOUTH);    
        
        this.setContentPane(pan);
    }
    
    /**
     * Fonction qui affiche les salles dont dispose l'organisme de l'edt
     *  
     *
     */
    public void affichageSalles(){
        //Les données du tableau qui seront à chercher depuis la BDD
        Object[][] data = {
            {"E1", "EM009"},
            {"E2", "P445"},
            {"E3", "C102"}
        };

        //Les titres des colonnes
        String  title[] = {"Site", "Salle"};
        JTable tableau = new JTable(data, title);
        //Nous ajoutons notre tableau à notre contentPane dans un scroll
        //Sinon les titres des colonnes ne s'afficheront pas !
        this.getContentPane().add(new JScrollPane(tableau));

    }
    
    /**
     * fonction qui initialise le menu de navigation principal et qui prend en paramètre le droit de l'utlisateur afin d'initialiser les bons onglets
     *  
     *
     * @param droit
     */
    public void Nav(int droit){
        JMenu cours, reporting, salles, logout;
        JMenuItem edt, recap, ajout;
        JButton deco;
    
        cours = new JMenu("Cours");
        reporting = new JMenu("Reporting");
        salles = new JMenu("Salles");
        logout = new JMenu("Deconnexion");

        edt = new JMenuItem("Emploi du temps");
        recap = new JMenuItem("Récapitulatif des cours");
        ajout = new JMenuItem("Ajouter une séance");
        deco= new JButton(new ImageIcon("icon/test.png"));

        //On initialise nos menus
        cours.add(edt);  
        cours.add(recap);
        if(droit==1) //seul l'admin a accès à l'ajout d'une séance
            cours.add(ajout);

        logout.add(deco);

        edt.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //affichage de l'edt
                recherche_form = new Recherche(this);
                edt_content = new EDT();
            }
        });
        
        recap.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //affichage du récapitulatif des cours
                recherche_form = new Recherche(this);
                recap_content = new Récap();
            }
        });
        
        ajout.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //affichage du formulaire d'ajout d'une séance
                ajout_seance = new Formulaire();
            }
        });
        
        reporting.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //affichage du reporting
            }
        });
        
        salles.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //affichage des salles
                affichageSalles();
        
            }
        });
        
        deco.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });

        //L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de gauche à droite
        //Le premier ajouté sera tout à gauche de la barre de menu et inversement pour le dernier
        navigation.add(cours);
        navigation.add(reporting);
        if(droit==1) //seul l'admin a accès aux Salles
            navigation.add(salles);

        navigation.add(Box.createHorizontalGlue());
        navigation.add(logout);
    
    }

}
