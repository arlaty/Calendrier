/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author alexi
 */
public class Fenetre extends JFrame implements ActionListener, ItemListener{
    private Connexion maconnexion;
    
    public Fenetre() {
        // creation par heritage de la fenetre
        super("Calendrier");
        
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
        
        Login test= new Login();
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
