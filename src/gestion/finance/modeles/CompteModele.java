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
import javax.swing.event.EventListenerList;

/**
 *
 * @author e1503742
 */
public class CompteModele {
    
    private EventListenerList listeners;
    private boolean result;
    
    public CompteModele(){
        listeners = new EventListenerList();
        result = false;
    }
    
    public void addTransactionListener(CompteListener listener) {
        listeners.add(CompteListener.class, listener);
    }

    public void removeTransactionListener(CategorieListener l) {
        listeners.remove(CategorieListener.class, l);
    }

    public void fireTransactionChanged() {
        CompteListener[] listenerList = (CompteListener[]) listeners.getListeners(CompteListener.class);
        for (CompteListener listener : listenerList) {
            listener.compteChanged(new CompteChangedEvent(this, this.result));
        }
    }
    
    public void createAccount(String pseudo, String password){
        PreparedStatement ps;
        try {
            ps = Database.getConnection().prepareStatement("INSERT INTO compte (Pseudo, Password) VALUES (?, ?)");
            ps.setString(1, pseudo);
            ps.setString(2, password);
            int retour = ps.executeUpdate();
            result = true;
        } catch (SQLException ex) {
            result = false;
            Logger.getLogger(CompteModele.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        fireTransactionChanged();
    }
    
    public void auth(String pseudo, String password){
        PreparedStatement ps;
        try {
            ps = Database.getConnection().prepareStatement("SELECT Pseudo FROM compte WHERE Pseudo = '" + pseudo + "' AND Password = '" + password + "'");
            int retour = ps.executeUpdate();
            System.out.println(retour + " RETOURRR");
        } catch (SQLException ex) {
            result = false;
            Logger.getLogger(CompteModele.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
