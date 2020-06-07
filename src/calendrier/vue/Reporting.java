/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.vue;

import calendrier.modele.Admin;
import calendrier.modele.Enseignant;
import calendrier.modele.Etudiant;
import calendrier.modele.Referent;
import calendrier.modele.Utilisateur;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author clement
 */
public class Reporting extends JPanel{
    JPanel panel;
   /**
     * Constructeur de Reporting  qui configure le panel permettant l'affichage les diagrammes d'info de l'utilisateur
     *  @param user 
     */
    public Reporting(Utilisateur user){
        calendrier.modele.Reporting repo=user.getReporting();
        Map<String, Integer> dia1=repo.getInfo1();
        Map<String, Integer> dia2=repo.getInfo2();
        Map<String, Integer> dia3=repo.getInfo3();
        Map<String, Integer> dia4=repo.getInfo4();
        int t;
        panel = new JPanel(new GridLayout(2, 2));
        PieDataset data1=createData(dia1,user,1);
        PieDataset data2=createData(dia2,user,2);
        PieDataset data3=createData(dia3,user,1);
        PieDataset data4=createData(dia4,user,0);
        JFreeChart chart1 = null;
        JFreeChart chart2 = null;
        JFreeChart chart3 = null; 
        JFreeChart chart4 = null;
        if((user instanceof Admin)||(user instanceof Referent))
        {
            chart1 = ChartFactory.createPieChart("Nombre d'heures par promotion", data1, false, false, false);
            chart2 = ChartFactory.createPieChart("Nombre d’heures par enseignant", data3, false, false, false);
            chart3 = ChartFactory.createPieChart("Taux d'occupation des salles", data4 , false, false, false);
            chart4 = ChartFactory.createPieChart("Capacité de chaque salle",data2 , false, false, false);
        }else if((user instanceof Enseignant))
        {
            chart1 = ChartFactory.createPieChart("Nombre d'heures de cours par promotion",data2 , false, false, false);
            chart2 = ChartFactory.createPieChart("Nombre d'heures enseignées par cours ",data3 , false, false, false);
            chart3 = ChartFactory.createPieChart("Nombre d'heures enseignées par type de cours", data1, false, false, false);
            chart4 = ChartFactory.createPieChart("Nombre d'heures enseignées par salle", data4, false, false, false);
        }
        else if (user instanceof Etudiant)
        {
            chart1 = ChartFactory.createPieChart("Nombre d'heures par cours", data1, false, false, false);
            chart2 = ChartFactory.createPieChart("Nombre d'heures par type de cours", data2, false, false, false);
            chart3 = ChartFactory.createPieChart("Nombre d'heures par enseignant", data3, false, false, false);
            chart4 = null;
        }
        panel.add(new ChartPanel(chart1));
        panel.add(new ChartPanel(chart2));
        panel.add(new ChartPanel(chart3));
        panel.add(new ChartPanel(chart4));
        panel.setPreferredSize(new Dimension(800, 600));
        this.add(panel);
        
    }
    
    /**
     * Methode qui configure les données du diagramme
     * @param t
     * @param user 
     * @param v 
     * @return PieDataset  
     *  
     */
    public PieDataset createData(Map<String, Integer> t,Utilisateur user, int v){
        DefaultPieDataset dataset = new DefaultPieDataset();
        // Afficher le contenu du MAP
    		Set listKeys=t.keySet();  // Obtenir la liste des clés
    		Iterator iterateur=listKeys.iterator();
    		// Parcourir les clés et afficher les entrées de chaque clé;
                
    		while(iterateur.hasNext())
    		{
    			Object key= iterateur.next();
                        if((((user instanceof Admin)||(user instanceof Referent)||(user instanceof Enseignant))&&(v==0))||((((user instanceof Admin)||(user instanceof Referent)))&&(v==2)))
                        {
                            dataset.setValue((Comparable) key, (t.get(key)));
                        }else dataset.setValue((Comparable) key, (t.get(key))*1.5);
    		}
        return dataset;
    }
}