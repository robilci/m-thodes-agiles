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

/**
 *
 * @author e1503742
 */
public class SoldeModele {

    private EventListenerList listeners;
    private int soldeID;
    private String dateSolde;
    private double soldeActuel = 0;
    private boolean result;

    public SoldeModele(EventListenerList listeners, int soldeID, String dateSolde) {
        this.listeners = listeners;
        this.soldeID = soldeID;
        this.dateSolde = dateSolde;
        this.soldeActuel = getSoldeActuel();
    }


    public void addSoldeListener(CompteListener listener) {
        listeners.add(CompteListener.class, listener);
    }

    public void removeSoldeListener(CategorieListener l) {
        listeners.remove(CategorieListener.class, l);
    }

    public double getSoldeActuel() {
        PreparedStatement ps;

        try {
            ps = Database.getConnection().prepareStatement("SELECT * FROM solde ORDER BY ID_Solde DESC LIMIT 1");
            ResultSet retour = ps.executeQuery();
            if (!retour.next()) {

                return soldeActuel;
            } else {
                this.soldeActuel = retour.getDouble("SoldeActuel");
                fireSoldeChanged();
                return soldeActuel;
                
            }

        } catch (SQLException ex) {

            Logger.getLogger(SoldeModele.class.getName()).log(Level.SEVERE, null, ex);
        }
        return soldeActuel;
    }

    public void fireSoldeChanged() {
        SoldeListener[] listenerList = (SoldeListener[]) listeners.getListeners(SoldeListener.class);
        for (SoldeListener listener : listenerList) {
            listener.soldeChanged(new SoldeChangedEvent(this, this.soldeActuel));
        }
    }

  

  
  

}
