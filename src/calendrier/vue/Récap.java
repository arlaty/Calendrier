/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.vue;
import calendrier.modele.Seance;
import calendrier.modele.Utilisateur;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lizziedelaisser
 */
public class Récap extends JTabbedPane{
    
    private JPanel plus, details_pan;
    private JTable tab;
    private JFrame details_page;
    private Zoom zoom_page;
    private Utilisateur user;
    
    /**
     * Constructeur qui instancie l'objet Récap qui correspond au content du récapitulatif des cours.
     *  
     *
     * @param user
     */
    public Récap(Utilisateur user){
        //new GridLayout( nbligne, nbcolonne) --> nb ligne en fonction du nombre de jour où il y a cours au max 5 par semaine
        this.setLayout(new GridLayout(2,1));
        
        plus = new JPanel();
        plus.setBackground(Color.WHITE);
        
        ajout_cours();
        
        tab.setAutoCreateRowSorter(true);
        //Nous ajoutons notre tableau à notre contentPane dans un scroll
        //Sinon les titres des colonnes ne s'afficheront pas !
        this.add(new JScrollPane(tab));
        this.add(plus);
        
        tab.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	tab.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
 
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if ( !e.getValueIsAdjusting() ) {
                    int selectedRow = tab.getSelectedRow(); 
                    System.out.print("affiche int selectedRow dans recap " + selectedRow);
                    affichageDetails();
		}
            }
	});	
        this.user=user;
    }
    
    private void ajout_cours(){
        
        //Les données du tableau qui seront à chercher depuis la BDD
        Object[][] data = {
            {"Maths -ING1 TD1", "lundi XX/XX/XXXX de XXhXX à XX/XX", "vendredi XX/XX/XXXX de XXhXX à XX/XX", "XXhXX", "XX"},
            {"Maths -ING1 TD2", "lundi XX/XX/XXXX de XXhXX à XX/XX", "jeudi XX/XX/XXXX de XXhXX à XX/XX", "XXhXX", "XX"},
            {"Java POO -ING3 TD1", "mardi XX/XX/XXXX de XXhXX à XX/XX", "mardi XX/XX/XXXX de XXhXX à XX/XX", "XXhXX", "XX"}
        };
        
        //Les titres des colonnes
        String  title[] = {"Matière -Groupe", "Première séance", "Dernière séance", "Nombre total d'heure", "Nombre de séance"};
        
        tab = new JTable(data, title);
        //instance table model
        DefaultTableModel tableModel = new DefaultTableModel(data, title) {

            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            }
        };
        tab.setModel(tableModel);
    
    }
    
    void affichageDetails(){
        details_page = new JFrame("Détails des séances");
        details_page.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        details_page.setLocationRelativeTo(null);
        details_page.setAlwaysOnTop(true); 
        
        details_pan = new JPanel();
       
        //Les données du tableau qui seront à chercher depuis la BDD
        Object[][] data = {
            {"Jour XX/XX/XXXX", "Horaires", "Enseignant(s)", "Site Salle(s) (CAPACITE)"},
            {"Jour XX/XX/XXXX", "Horaires", "Enseignant(s)", "Site Salle(s) (CAPACITE)"},
            {"Jour XX/XX/XXXX", "Horaires", "Enseignant(s)", "Site Salle(s) (CAPACITE)"}
        };
        
        //Les titres des colonnes
        String  title[] = {" ", " ", " ", " ", " "};
        
        tab = new JTable(data, title);
        //instance table model
        DefaultTableModel tableModel = new DefaultTableModel(data, title) {

            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            }
        };
        tab.setModel(tableModel);
        tab.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	tab.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
 
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if ( !e.getValueIsAdjusting() ) {
                    int selectedRow = tab.getSelectedRow();
                    System.out.print("test affiche " +tab.getSelectedRow());
                    System.out.print(tab.getSelectedColumn());
                    ArrayList<Seance> seances= user.getSeances();
                    /*for(Seance seance: seances){
                        if (seance.getDate().equals(String.valueOf(tab.getValueAt(selectedRow,4)))){
                            zoom_page = new Zoom(seance,user);
                        }
                    }*/
		}
            }
 
	});
        
        //Nous ajoutons notre tableau à notre contentPane dans un scroll
        //Sinon les titres des colonnes ne s'afficheront pas !
        details_page.add(new JScrollPane(tab));
        
        
        details_page.pack();
        details_page.setVisible(true);
    
    }
    
     //Création de plusieurs Panneau
    /*Panneau[] tPan = {   new Panneau(Color.RED), new Panneau(Color.GREEN), new Panneau(Color.BLUE)};
      
    //Création de notre conteneur d'onglets
    public Récap(){
        
        System.out.println("Page Recap");
        int i = 0;
        for(Panneau pan : tPan){
          //Méthode d'ajout d'onglet
          add("Onglet n° "+(++i), pan);
          //Vous pouvez aussi utiliser la méthode addTab
          //onglet.addTab("Onglet n° "+(++i), pan);

        }
    }*/
    
}
