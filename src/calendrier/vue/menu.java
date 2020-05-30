/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.vue;

/**
 *
 * @author cleme
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class menu extends JFrame{
    
    private JMenuBar menuBar = new JMenuBar();
  private JMenu test1 = new JMenu("Cours");
  private JMenu test2 = new JMenu("Reporting");
  private JMenu test3 = new JMenu("Salles");
  private JMenu test4 = new JMenu("Deconnexion");

  private JMenuItem item1 = new JMenuItem("Emploi du temps");
  private JMenuItem item2 = new JMenuItem("Récapitulatif des cours");
  private JMenuItem item3 = new JMenuItem("Ajouter une séance");
  private JMenuItem item4 = new JMenuItem("Deconnexion");
  private  JButton deco= new JButton(new ImageIcon("icon/test.png"));
  
  

  public menu(int droit){
    this.setSize(400, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);

    //On initialise nos menus
    
    this.test1.add(item1);  
    this.test1.add(item2);
    this.test1.add(item3);
    this.test4.add(deco);
    deco.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        System.exit(0);
      }        
    });
    

    //L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de gauche à droite
    //Le premier ajouté sera tout à gauche de la barre de menu et inversement pour le dernier
    this.menuBar.add(test1);
    this.menuBar.add(test2);
    if(droit==1)
    this.menuBar.add(test3);
    this.menuBar.add(Box.createHorizontalGlue());
    this.menuBar.add(test4);
    this.setJMenuBar(menuBar);
    this.setVisible(true);
  }
}
