/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.vue;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lizziedelaisser
 */
public class EDT extends JPanel{
   
    JPanel plus;
    JTable tab;
    Zoom zoom_page;
    
    /**
     * Constructeur qui instancie l'objet EDT qui correspond au contenu de l'emploi du temps
     *  
     *
     */
    public EDT(){
        
        //new GridLayout( nbligne, nbcolonne) --> nb ligne en fonction du nombre de jour où il y a cours au max 5 par semaine
        this.setLayout(new GridLayout(5,2));
        
        ajout_jour("lundi");
        ajout_jour("mardi");
        ajout_jour("mercredi");
        ajout_jour("jeudi");
        ajout_jour("vendredi");
        
    }
    
    /**
     * méthode qui crée et rempli un tableau de l'emploi du temps d'une journée
     * et prend en paramètre une chaine de charactère qui correspond au jour de la semaine
     *
     */
    private void ajout_jour(String jour){
        
        
        plus = new JPanel();
        plus.setBackground(Color.WHITE);
        
        //Les données du tableau qui seront à chercher depuis la BDD
        Object[][] data = {
            {"Horaires", "Cours", "Enseignant(s)", "Promo Groupe", "Site Salle(s) (CAPACITE)",  "Type de Cours"},
            {"Horaires", "Cours", "Enseignant1, Enseignant2", "Promo Groupe", "Site Salle(s) (CAPACITE)",  "Type de Cours"},
            {"Horaires", "Cours", "Enseignant(s)", "Promo Groupe", "Site Salle(s) (CAPACITE)",  "Type de Cours"}
        };
        
        //Les titres des colonnes
        String  title[] = {jour, "XX/XX/XXXX", " ", " ", " ", " "};
        
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
                    zoom_page = new Zoom();
        
		}
            }
 
	});
        
        //Nous ajoutons notre tableau à notre contentPane dans un scroll
        //Sinon les titres des colonnes ne s'afficheront pas !
        this.add(new JScrollPane(tab));
        this.add(plus);
    
    }
  
}
