/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.modeles;

import gestion.finance.utils.Database;
import gestion.finance.utils.Session;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.event.EventListenerList;

/**
 *
 * @author victo
 */
public class TransactionModele {

    private EventListenerList listeners;
    private String membreId = "0";
    private DefaultListModel<String> listModel;
    private String dateDebut;
    private String dateFin;

    public TransactionModele() {
        listeners = new EventListenerList();
    }

    public void addTransactionListener(TransactionListener listener) {
        listeners.add(TransactionListener.class, listener);
    }

    public void removeTransactionListener(CategorieListener l) {
        listeners.remove(CategorieListener.class, l);
    }

    public void fireTransactionChanged() {
        TransactionListener[] listenerList = (TransactionListener[]) listeners.getListeners(TransactionListener.class);
        for (TransactionListener listener : listenerList) {
            listener.transactionChanged(new TransactionChangedEvent(this, listModel));
        }
    }

    public DefaultListModel<String> updateModel() {
        listModel = new DefaultListModel<String>();
        try {
            PreparedStatement statement = Database.getConnection().prepareStatement("SELECT * FROM transactions");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                listModel.addElement(rs.getString("Type") + " - " + rs.getString("Montant") + " - " + rs.getString("Libelle"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransactionModele.class.getName()).log(Level.SEVERE, null, ex);
        }
        fireTransactionChanged();
        return listModel;
    }

    private void updateModelFromMembre() {
        listModel = new DefaultListModel<String>();

        try {
            PreparedStatement statement = Database.getConnection().prepareStatement("SELECT * FROM transactions WHERE ID_Personne=" + membreId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                listModel.addElement(rs.getString("Type") + " - " + rs.getString("Montant") + " - " + rs.getString("Libelle"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransactionModele.class.getName()).log(Level.SEVERE, null, ex);
        }

        fireTransactionChanged();

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
            while (rs.next()) 
                listMembre[++i] = rs.getString("Nom") + " - " + rs.getString("Prenom");
            
        } catch (SQLException ex) {
            Logger.getLogger(TransactionModele.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMembre;
    }
    
    public void updateModelFromDates(){
        listModel = new DefaultListModel<String>();
      
        try {
            PreparedStatement statement = Database.getConnection().prepareStatement("SELECT * FROM transactions WHERE ID_Personne=" + membreId + " AND DateTransact BETWEEN '" + dateDebut + "' AND '" + dateFin + "'");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                listModel.addElement(rs.getString("Type") + " - " + rs.getString("Montant") + " - " + rs.getString("Libelle"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransactionModele.class.getName()).log(Level.SEVERE, null, ex);
        }

        fireTransactionChanged();
    }

    public void setMembreId(String id) {
        this.membreId = id;
        
        if(id.equals("0"))
            updateModel();
        else 
            updateModelFromMembre();
    }
    
    public void setDates(String dateDebut, String dateFin){
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        
        if(membreId.equals("0"))
            membreId = "1";
        updateModelFromDates();
    }
}
