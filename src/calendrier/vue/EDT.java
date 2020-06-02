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
import java.awt.GridLayout;
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
public class EDT extends JPanel{
   
    JPanel plus1, plus2, plus3, plus4, plus5;
    
    public EDT(){
        System.out.println("Page EDT");
        //new GridLayout( nbligne, nbcolonne) --> nb ligne en fonction du nombre de jour où il y a cours au max 5 par semaine
        this.setLayout(new GridLayout(5,2));
        
        plus1 = new JPanel();
        plus2 = new JPanel();
        plus3 = new JPanel();
        plus4 = new JPanel();
        plus5 = new JPanel();
        plus1.setBackground(Color.MAGENTA);
        plus2.setBackground(Color.MAGENTA);
        plus3.setBackground(Color.MAGENTA);
        plus4.setBackground(Color.MAGENTA);
        plus5.setBackground(Color.MAGENTA);
        
        //Les données du tableau qui seront à chercher depuis la BDD
        Object[][] data = {
            {"Horaires", "Cours", "Enseignant(s)", "Promo Groupe", "Site Salle(s) (CAPACITE)",  "Type de Cours"},
            {"Horaires", "Cours", "Enseignant1, Enseignant2", "Promo Groupe", "Site Salle(s) (CAPACITE)",  "Type de Cours"},
            {"Horaires", "Cours", "Enseignant(s)", "Promo Groupe", "Site Salle(s) (CAPACITE)",  "Type de Cours"}
        };

        //Les titres des colonnes
        String  title[] = {"Jour XX/XX/XXXX", " ", " ", " ", " ", " "};
        JTable tableau1 = new JTable(data, title);
        JTable tableau2 = new JTable(data, title);
        JTable tableau3 = new JTable(data, title);
        JTable tableau4 = new JTable(data, title);
        JTable tableau5 = new JTable(data, title);
        //instance table model
        DefaultTableModel tableModel = new DefaultTableModel(data, title) {

            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            }
        };
        tableau1.setModel(tableModel);
        tableau2.setModel(tableModel);
        tableau3.setModel(tableModel);
        tableau4.setModel(tableModel);
        tableau5.setModel(tableModel);
        //Nous ajoutons notre tableau à notre contentPane dans un scroll
        //Sinon les titres des colonnes ne s'afficheront pas !
        this.add(new JScrollPane(tableau1));
        this.add(plus1);
        this.add(new JScrollPane(tableau2));
        this.add(plus2);
        this.add(new JScrollPane(tableau3));
        this.add(plus3);
        this.add(new JScrollPane(tableau4));
        this.add(plus4);
        this.add(new JScrollPane(tableau5));
        this.add(plus5);
    }
  
}
