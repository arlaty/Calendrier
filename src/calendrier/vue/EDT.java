/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.vue;

import calendrier.modele.Seance;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import calendrier.modele.Utilisateur;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
    public EDT(Utilisateur user){
        //new GridLayout( nbligne, nbcolonne) --> nb ligne en fonction du nombre de jour où il y a cours au max 5 par semaine
        this.setLayout(new GridLayout(5,2));
        
        Calendar calendar = Calendar.getInstance();
        Date currentDate=new Date();
        SimpleDateFormat formater= new SimpleDateFormat("E");
        if (formater.format(currentDate).equals("sam.")){
            calendar.add(calendar.DATE, -5);
            ajout_jour(user,calendar.getTime());
            calendar = Calendar.getInstance();
            calendar.add(calendar.DATE, -4);
            ajout_jour(user,calendar.getTime());
            calendar = Calendar.getInstance();
            calendar.add(calendar.DATE, -3);
            ajout_jour(user,calendar.getTime());
            calendar = Calendar.getInstance();
            calendar.add(calendar.DATE, -2);
            ajout_jour(user,calendar.getTime());
            calendar = Calendar.getInstance();
            calendar.add(calendar.DATE, -1);
            ajout_jour(user,calendar.getTime());
            calendar = Calendar.getInstance();
            //ajout_jour(user,currentDate);
            calendar.add(calendar.DATE, 1);
            //ajout_jour(user,calendar.getTime());
        }
    }
    
    /**
     * méthode qui crée et rempli un tableau de l'emploi du temps d'une journée
     * et prend en paramètre une chaine de charactère qui correspond au jour de la semaine
     *
     */
    private void ajout_jour(Utilisateur user,Date date){
        
        plus = new JPanel();
        plus.setBackground(Color.WHITE);
        //Les données du tableau qui seront à chercher depuis la BDD
        SimpleDateFormat formater = new SimpleDateFormat("ddMMyy");
        ArrayList<Seance> seances= user.getSeances();
        int i=0;
        for(Seance seance: seances){
            if (formater.format(date).equals(formater.format(seance.getDate()))){
                i++;
            }
        }
        Object[][] data = new Object[i][6];
        i=0;
        for(Seance seance: seances){
            if (formater.format(date).equals(formater.format(seance.getDate()))){
                data[i][0]=seance.getHeure_debut().toString()+"-"+seance.getHeure_fin().toString();
                data[i][1]=seance.getCours();
                ArrayList<String> enseignants= seance.getEnseignants();
                data[i][2]="";
                for (String enseignant:enseignants){
                    data[i][2]+=enseignant+" ";
                }
                data[i][3]=seance.getPromo()+" ";
                ArrayList<String> groupes= seance.getGroupes();
                for (String groupe:groupes){
                    data[i][3]+=groupe+" ";
                }
                data[i][4]=seance.getSite()+" ";
                ArrayList<String> salles= seance.getSalles();
                for (String salle:salles){
                    data[i][4]+=salle+" ";
                }
                data[i][4]+="("+String.valueOf(seance.getCapacite())+")";
                data[i][5]=seance.getType_cours();
                i++;
            }
        }
        formater= new SimpleDateFormat("EEEEEEEE");
        SimpleDateFormat formater2= new SimpleDateFormat("dd MMMMMMM");
        //Les titres des colonnes
        String  title[] = {formater.format(date),formater2.format(date), " ", " ", " ", " "};
        
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
                    System.out.print(tab.getSelectedRow());
                    System.out.print(tab.getSelectedColumn());
                    zoom_page = new Zoom(seances.get(0));
                    ArrayList<Seance> seances= user.getSeances();
                    for(Seance seance: seances){
                        if (seance.getDate().equals(String.valueOf(tab.getValueAt(selectedRow,4)))){
                            zoom_page = new Zoom(seance);
                        }
                    }
                    
		}
            }
	});
        
        //Nous ajoutons notre tableau à notre contentPane dans un scroll
        //Sinon les titres des colonnes ne s'afficheront pas !
        this.add(new JScrollPane(tab));
        this.add(plus);
    
    }
  
}
