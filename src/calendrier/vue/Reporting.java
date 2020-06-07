/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author lizziedelaisser
 */
public class Reporting extends JPanel{
    JPanel panel;
   
    public Reporting(){
        System.out.println("Page Reporting");
        panel = new JPanel(new GridLayout(2, 2));
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Section 1", 23.3);
        dataset.setValue("Section 2", 56.5);
        dataset.setValue("Section 3", 43.3);
        dataset.setValue("Section 4", 11.1);
        
        JFreeChart chart1 = ChartFactory.createPieChart("Chart 1", dataset, false, false, false);
        JFreeChart chart2 = ChartFactory.createPieChart("Chart 2", dataset, false, false, false);
        PiePlot plot2 = (PiePlot) chart2.getPlot();
        panel.add(new ChartPanel(chart1));
        panel.add(new ChartPanel(chart2));
        panel.setPreferredSize(new Dimension(800, 600));
        this.add(panel);
        
    }
}