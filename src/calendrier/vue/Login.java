/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author alexi
 */
public class Login extends JFrame implements ActionListener {
   private JLabel intituléEmail = new JLabel("Email :");
   private JTextField email = new JTextField("Votre email");
   private JLabel intituléMdp = new JLabel("Mot de passe :");
   private JPasswordField mdp = new JPasswordField("Votre mot de passe");
   private JButton validation = new JButton("Valider");

   public Login() {
      super("Connexion au compte");
      gestionDisposition();
      pack();
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false);
      setVisible(true);
      validation.addActionListener(this);
   }

   private class Saisie extends JTextField {
      public Saisie(String texte) {
         super(texte, 20);
         setFont(new Font("Verdana", Font.BOLD, 12));
         setMargin(new Insets(0, 3, 0, 0));
      }     
   }
   
   private void gestionDisposition() {
      GroupLayout groupe = new GroupLayout(getContentPane());
      getContentPane().setLayout(groupe);
      groupe.setAutoCreateContainerGaps(true);
      groupe.setAutoCreateGaps(true);
      GroupLayout.ParallelGroup horzGroupe = groupe.createParallelGroup();          
      GroupLayout.SequentialGroup vertGroupe = groupe.createSequentialGroup();
      horzGroupe.addComponent(intituléEmail).addComponent(email).addComponent(intituléMdp).addComponent(mdp); 
      horzGroupe.addComponent(validation);
      vertGroupe.addComponent(intituléEmail).addComponent(email).addComponent(intituléMdp).addComponent(mdp); 
      vertGroupe.addComponent(validation);      
      groupe.setHorizontalGroup(horzGroupe);
      groupe.setVerticalGroup(vertGroupe);  
   }

   public void actionPerformed(ActionEvent e) {
   }   
}