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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private JTable tab,tab2;
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
        
        try {
            ajout_cours();
        } catch (SQLException ex) {
            Logger.getLogger(Récap.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tab.setAutoCreateRowSorter(true);
        //Nous ajoutons notre tableau à notre contentPane dans un scroll
        //Sinon les titres des colonnes ne s'afficheront pas !
        this.add(new JScrollPane(tab));
        this.add(plus);
        
        tab.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	tab.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tab.getSelectedRow(); 
                    try {
                        affichageDetails(String.valueOf(tab.getValueAt(selectedRow,0)));
                    } catch (SQLException ex) {
                        Logger.getLogger(Récap.class.getName()).log(Level.SEVERE, null, ex);
                    }
		}
            }
	});	
        this.user=user;
    }
    
    private void ajout_cours() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Récap.class.getName()).log(Level.SEVERE, null, ex);
        }
        String urlDatabase = "jdbc:mysql://localhost/calendrier";
        Connection connect=null;
        try {
            connect = DriverManager.getConnection(urlDatabase, "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(Récap.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet result = connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY)
        .executeQuery("SELECT * FROM groupe INNER JOIN promotion ON groupe.Id_promotion=promotion.id");
        int rowcount =0;
        if (result.last()) {
            rowcount = result.getRow();
            result.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
        }
        Object[][] data = new Object[15][5];
        int i=0;
        while (result.next()){
            ResultSet result2 = connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY)
            .executeQuery("SELECT * FROM seance_groupes INNER JOIN seance ON seance.id=seance_groupes.Id_seance WHERE Id_groupe="+result.getString("groupe.id")+" ORDER BY date and heure_debut");
            while(result2.next()){
                ResultSet result3 = connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY)
                .executeQuery("SELECT * FROM cours WHERE id="+result2.getString("Id_cours"));
                result3.first();
                data[i][0]=result3.getString("nom")+" -"+result.getString("groupe.nom")+" "+result.getString("promotion.nom");
            }
            result2.first();
            data[i][1]=result2.getString("date")+" de "+result2.getString("heure_debut")+" à "+result2.getString("heure_fin");
            result2.last();
            data[i][2]=result2.getString("date")+" de "+result2.getString("heure_debut")+" à "+result2.getString("heure_fin");
            data[i][3]=result2.getRow()*1.5;
            data[i][4]=result2.getRow();
            i++;
        }
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
    
    void affichageDetails(String cell) throws SQLException{
        details_page = new JFrame("Détails des séances");
        details_page.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        details_page.setLocationRelativeTo(null);
        details_page.setAlwaysOnTop(true); 
        
        details_pan = new JPanel();
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Récap.class.getName()).log(Level.SEVERE, null, ex);
        }
        String urlDatabase = "jdbc:mysql://localhost/calendrier";
        Connection connect=null;
        try {
            connect = DriverManager.getConnection(urlDatabase, "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(Récap.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] split= cell.split("-");//sdhfzavyefv-efe zefe
        String td= split[1].split(" ")[0];//efe
        String promo=split[1].split(" ")[1];//zefe
        ResultSet result = connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY)
        .executeQuery("SELECT * FROM groupe INNER JOIN promotion ON groupe.Id_promotion=promotion.id WHERE groupe.nom='"+td+"' and promotion.nom='"+promo+"'");
        result.first();
        ResultSet result2 = connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY)
        .executeQuery("SELECT * FROM seance_groupes INNER JOIN seance ON seance.id=seance_groupes.Id_seance WHERE Id_groupe="+result.getString("id")+" ORDER BY date and heure_debut");
        int rowcount =0;
        if (result2.last()) {
            rowcount = result2.getRow();
            result2.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
        }
        Object[][] data = new Object[rowcount][4];
        int i=0;
        while(result2.next()){
            data[i][0]=result2.getString("date");
            data[i][1]=result2.getString("heure_debut")+" "+result2.getString("heure_fin");
            data[i][2]="";
            ResultSet result3 = connect.createStatement(
             ResultSet.TYPE_SCROLL_INSENSITIVE,
             ResultSet.CONCUR_READ_ONLY)
             .executeQuery("SELECT * FROM seance_enseignants JOIN utilisateur WHERE Id_seance="+result2.getInt("id")+" and Id_enseignant=id");
            while(result3.next()){
                data[i][2]+=result3.getString("nom")+" "+result3.getString("prenom")+" ";
            }
            int capacite=0;
            ResultSet result4 = connect.createStatement(
             ResultSet.TYPE_SCROLL_INSENSITIVE,
             ResultSet.CONCUR_READ_ONLY)
             .executeQuery("SELECT * FROM seance_salles JOIN salle WHERE Id_seance="+result2.getInt("id")+" and Id_salles=id");
            result4.first();
            ResultSet result5 = connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY)
            .executeQuery("SELECT * FROM site WHERE id="+result4.getInt("Id_site"));
            result5.first();
            data[i][3]=result5.getString("nom")+" ";
            result4.beforeFirst();
            while(result4.next()){
                data[i][3]+=result4.getString("nom")+" ";
                capacite+=result4.getInt("capacite");
            }
            data[i][3]+=" ("+capacite+")";
            i++;
        }
        
        //Les titres des colonnes
        String  title[] = {" ", " ", " ", " "};
        
        tab2 = new JTable(data, title);
        //instance table model
        DefaultTableModel tableModel = new DefaultTableModel(data, title) {

            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            }
        };
        tab2.setModel(tableModel);
        tab2.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	tab2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
 
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if ( !e.getValueIsAdjusting() ) {
                    int selectedRow = tab2.getSelectedRow();
                    
                    try {
                        recupInfos(tab2, selectedRow);
                    } catch (ParseException ex) {
                        Logger.getLogger(Récap.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
		}
            }
	});
        
        //Nous ajoutons notre tableau à notre contentPane dans un scroll
        //Sinon les titres des colonnes ne s'afficheront pas !

        details_page.add(tab2);
        
        details_page.pack();
        details_page.setVisible(true);
    }
    /** Fontion qui récupère les infos de la ligne du table des séances pour afficher la fenêtre de zoom
     * qui prend en paramètre la table en question et l'index du row selected
     * 
     * @param table
     * @param selectedRow 
     */
    public void recupInfos(JTable table, int selectedRow) throws ParseException {
	if ( selectedRow>=0 ) {
            
            for(int i=0; i<table.getColumnCount(); i++) {
                int column = table.convertColumnIndexToView(i); 
                System.out.println(String.valueOf(table.getValueAt(selectedRow,column)));
            }
            
            ArrayList <Seance> seances = user.getSeances();
            for(Seance seance: seances){
                String[] split = String.valueOf(table.getValueAt(selectedRow,1)).split(" ");
                String date = String.valueOf(table.getValueAt(selectedRow,0));
                String pattern = "yyyy-MM-dd";
                DateFormat df = new SimpleDateFormat(pattern);
                String reportDate = df.format(seance.getDate());
                String pattern2 = "hh:mm:ss";
                DateFormat df2 = new SimpleDateFormat(pattern2);
                String reportTime = df2.format(seance.getHeure_debut());
                if ((reportDate.equals(date))&&(reportTime.equals(split[0]))){
  
                    zoom_page = new Zoom(seance,user);
             
                }
                
            }
	}
        
    }
}
