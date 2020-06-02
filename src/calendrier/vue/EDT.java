/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lizziedelaisser
 */
public class EDT extends JTabbedPane{
   
    public EDT(){
        System.out.println("Page EDT");
        
        //Les données du tableau qui seront à chercher depuis la BDD
        Object[][] data = {
            {"Horaires", "Cours", "Enseignant(s)", "Promo Groupe", "Site Salle(s) (CAPACITE)",  "Type de Cours"},
            {"Horaires", "Cours", "Enseignant1, Enseignant2", "Promo Groupe", "Site Salle(s) (CAPACITE)",  "Type de Cours"},
            {"Horaires", "Cours", "Enseignant(s)", "Promo Groupe", "Site Salle(s) (CAPACITE)",  "Type de Cours"}
        };

        //Les titres des colonnes
        String  title[] = {"Jour XX/XX/XXXX", " ", " ", " ", " ", " "};
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
    }
  
}
