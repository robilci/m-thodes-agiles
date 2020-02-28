/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.modeles;

import gestion.finance.utils.Database;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.EventListenerList;

/**
 *
 * @author robin
 */
public class PersonneModele {
    
    private EventListenerList listeners;
    
    private boolean result;

    public PersonneModele() {
        this.listeners = new EventListenerList();
    } 
    
    public void addTransactionListener(PersonneListener listener) {
        listeners.add(PersonneListener.class, listener);
    }
    
     public void removeTransactionListener(CategorieListener l) {
        listeners.remove(CategorieListener.class, l);
    }
     
    public void fireTransactionChanged() {
        PersonneListener[] listenerList = (PersonneListener[]) listeners.getListeners(PersonneListener.class);
        for (PersonneListener listener : listenerList) {
            listener.PersonneChanged(this.result);
        }
    }
    
    public void addPersonne(String nom, String prenom){
         PreparedStatement ps;
        try {
            ps = Database.getConnection().prepareStatement("INSERT INTO Personne (Nom, Prenom, ID_Compte) VALUES (?, ?, ?)");
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, "1");
            int retour = ps.executeUpdate();
            result = true;
        } catch (SQLException ex) {
            result = false;
            Logger.getLogger(CompteModele.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        fireTransactionChanged();
    }
}
