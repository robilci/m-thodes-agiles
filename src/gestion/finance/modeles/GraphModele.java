/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.modeles;

import gestion.finance.utils.Database;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.event.EventListenerList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;


/**
 *
 * @author Abed
 */
public class GraphModele {
    private EventListenerList listeners;
    private final String membreId = "0";
    private DefaultListModel<String> listModel;
   
    
    
        public void getelement() throws IOException {
        listModel = new DefaultListModel<String>();
        try {
            PreparedStatement statement = Database.getConnection().prepareStatement("SELECT * FROM transactions");
            ResultSet rs = statement.executeQuery();
            DefaultPieDataset dataset = new DefaultPieDataset();
            while(rs.next())
            {
                dataset.setValue(rs.getString("Libelle"),Double.parseDouble(rs.getString("Montant")));
            }
           JFreeChart chart = ChartFactory.createPieChart("grafique ", dataset,true,true,false);
           
           int lg = 400;
           int la = 500;
           File f = new File("g.jpg");
           ChartUtils.saveChartAsPNG(f,chart,lg,la);
           
          
        } catch (SQLException ex) {
            Logger.getLogger(TransactionModele.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        }

    
    
}
