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
 * @author lizziedelaisser
 */


public class Login extends JFrame implements ActionListener {
   private JLabel intituléEmail = new JLabel("Email :");
   private JTextField email = new JTextField("Votre email");
   private JLabel intituléMdp = new JLabel("Mot de passe :");
   private JPasswordField mdp = new JPasswordField("Votre mot de passe");
   private JButton validation = new JButton("Valider");
   private JLabel résultat = new JLabel(" ");
   public boolean OK= false;

   /**
     * Constructeur de la boite de dialogue de connexion à l'ouverture de l'application
     *  
     *
     * 
     */
   public Login() {
       
      super("Connexion au compte");
      
      System.out.println("Page Login");
      this.setPreferredSize(new Dimension(300, 200));
      //this.setLocationRelativeTo(null);
      this.gestionDisposition();
      this.pack();
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setResizable(false);
      this.setVisible(true);
      validation.addActionListener(this);
   }

   /**
     * Constructeur de la classe Saisie héritant de JTextField
     *  
     *
     * 
     */
   private class Saisie extends JTextField {
      public Saisie(String texte) {
         super(texte, 20);
         setFont(new Font("Verdana", Font.BOLD, 12));
         setMargin(new Insets(0, 3, 0, 0));
      }     
   }
   
   /**
     * Fonction qui affiche le contenu de la boite de dialogue et gère les intéractions avec le boutton de validation
     *  
     *
     * 
     */
   private void gestionDisposition() {
      GroupLayout groupe = new GroupLayout(getContentPane());
      getContentPane().setLayout(groupe);
      groupe.setAutoCreateContainerGaps(true);
      groupe.setAutoCreateGaps(true);
      GroupLayout.ParallelGroup horzGroupe = groupe.createParallelGroup();          
      GroupLayout.SequentialGroup vertGroupe = groupe.createSequentialGroup();
      horzGroupe.addComponent(intituléEmail).addComponent(email).addComponent(intituléMdp).addComponent(mdp); 
      horzGroupe.addComponent(validation).addComponent(résultat);
      vertGroupe.addComponent(intituléEmail).addComponent(email).addComponent(intituléMdp).addComponent(mdp); 
      vertGroupe.addComponent(validation).addComponent(résultat);      
      groupe.setHorizontalGroup(horzGroupe);
      groupe.setVerticalGroup(vertGroupe);  
   }

   /**
     * Fonction qui s'occupe de la vérification des données de connexion via la BDD
     *  
     *
     * 
     */
   @Override
   public void actionPerformed(ActionEvent e) {
       
       /*if(verification(email, mdp)!=true) {
           //On test dans la bdd email
           //si email trouvé on test mdp
           //si tout est bon
           OK=true;
           dispose();
       } else {
           //si email pas trouvé ou si mdp pas valide pour email trouvé alors message d'erreur
           résultat.setText("Email ou mot de passe invalide");
       }*/
       OK=true;
       résultat.setText("Email ou mot de passe invalide");
       dispose();
       
   }    
}