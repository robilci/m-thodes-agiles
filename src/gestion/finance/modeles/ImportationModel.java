/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.modeles;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import gestion.finance.utils.Database;
import gestion.finance.utils.Session;
import java.sql.ResultSet;
import javax.swing.event.EventListenerList;


import gestion.finance.utils.Database;
import gestion.finance.utils.Session;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
/**
 *
 * @author khaml
 */
public class ImportationModel {
    private EventListenerList listeners;
    private String date;
    private String libele;
    private String categorie;
    private double montant;

      public ImportationModel() {
        this.listeners = new EventListenerList();
    }
        
      public ImportationModel( String date, String libele, String categorie, double montant) {
          super();
          
        this.date = date;
        this.libele = libele;
        this.categorie = categorie;
        
        listeners = new EventListenerList();

    }

    public String getDate() {
        return date;
    }

    public String getLibele() {
        return libele;
    }

    public String getCategorie() {
        return categorie;
    }

    public double getMontant() {
        return montant;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setMontant(double montant) {
        this.montant = montant;
        fireMontantChanged();
    }
      
    	public void addMontantListener(ImportationListener listener){
		listeners.add(ImportationListener.class, listener);
	}
 
	public void removeMontantListener(ImportationListener l){
		 listeners.remove(ImportationListener.class, l);
	}
 
	public void fireMontantChanged(){
		ImportationListener[] listenerList = (ImportationListener[])listeners.getListeners(ImportationListener.class);
 
		for(ImportationListener listener : listenerList){
			listener.montantChanged(new MontantChangedEvent(this, getMontant()));
		}
	}
        
        
         public String[] getMembres() {
        String[] listMembre = null;
        try {
            PreparedStatement statement = Database.getConnection().prepareStatement("SELECT * FROM personne WHERE ID_Compte = " + Session.getIdCompte());
            System.out.println("SELECT * FROM personne WHERE ID_Compte = " + Session.getIdCompte());
            ResultSet rs = statement.executeQuery();
            rs.last();
            listMembre = new String[rs.getRow() + 1];
            rs.beforeFirst();
            int i = 0;
            listMembre[i] = "Tous les membres";
            while (rs.next()) {
                listMembre[++i] = rs.getString("Nom") + " - " + rs.getString("Prenom");
            }

        } catch (SQLException ex) {
            Logger.getLogger(TransactionModele.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMembre;
    }
         public void remplirDB(String csvFilePath) throws SQLException, FileNotFoundException, IOException, ParseException
         {
             int batchSize = 100;
 
         
         try{
         
           PreparedStatement  statement = Database.getConnection().prepareStatement("INSERT INTO transactions (Type, DateTransact, Montant,Libelle,ID_Personne,ID_Categorie) VALUES (?, ?, ?,?,?,?)");
           
                 try (BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath))) {
                     String lineText = null;
                     int count = 0;
                     
                     while ((lineText = lineReader.readLine()) != null) {
                         String[] data = lineText.split(",");
                         String Type = data[0];
                         String DateTransact = data[1];
                         String Montant = data[2];
                         String Libelle = data[3];
                         String ID_Personne = data[4];
                         String ID_Categorie = data[5];
                         
                         statement.setString(1, Type);
                         
                         
                        Timestamp sqlTimestamp = Timestamp.valueOf(DateTransact);
                        statement.setTimestamp(2, sqlTimestamp);
                         
                         Float fMontant = Float.parseFloat(Montant);
                         statement.setFloat(3, fMontant);
                         statement.setString(4, Libelle);
                         
                         int per=Integer.parseInt(ID_Personne);
                         statement.setInt(5, per);
                         
                         
                         int cat=Integer.parseInt(ID_Categorie);
                         statement.setInt(6, per);
                         
                         statement.addBatch();
                         
                         if (count % batchSize == 0)
                         {
                             statement.executeBatch();
                         }
                         
                         
                     }       }
 
            // execute the remaining queries
            statement.executeBatch();
 
         
             
         }    
             
             catch (IOException ex) {
            Logger.getLogger(ImportationModel.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
      
         }
}