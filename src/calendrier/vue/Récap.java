/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.vue;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

/**
 *
 * @author lizziedelaisser
 */
public class Récap extends JTabbedPane{
    
     //Création de plusieurs Panneau
    Panneau[] tPan = {   new Panneau(Color.RED), new Panneau(Color.GREEN), new Panneau(Color.BLUE)};
      
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
    }
    
}
