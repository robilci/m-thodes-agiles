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
import java.sql.ResultSet;
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
      
      
      
    
}
