/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.modeles;

import gestion.finance.utils.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.EventListenerList;

/**
 *
 * @author victo
 */
public class CategorieModele {

    private int id;
    private String Libelle;

    private EventListenerList listeners;


    public CategorieModele(int id,String libelle) {
        super();

        this.id = id;
        this.Libelle = libelle;

        listeners = new EventListenerList();
    }

    public CategorieModele getCategorie(int id_transaction) throws SQLException {
        PreparedStatement ps;
        ResultSet retour = null;
        try {
            ps = Database.getConnection().prepareStatement("SELECT c.ID_Categorie ID ,c.Nom Nom FROM categorie c JOIN transactions t on t.ID_Categorie = c.ID_Categorie WHERE t.ID_Categorie = " + id_transaction);
            retour = ps.executeQuery();        
            

        } catch (SQLException ex) {

            Logger.getLogger(SoldeModele.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new CategorieModele(retour.getInt("ID"), retour.getString("Nom"));
    }

    /*public void setCategorie(int categorie) {
		this.categorie = categorie;
 
		fireCategorieChanged();
	}*/
    public void addCategorieListener(CategorieListener listener) {
        listeners.add(CategorieListener.class, listener);
    }

    public void removeCategorieListener(CategorieListener l) {
        listeners.remove(CategorieListener.class, l);
    }

    /*public void fireCategorieChanged() {
        CategorieListener[] listenerList = (CategorieListener[]) listeners.getListeners(CategorieListener.class);

        for (CategorieListener listener : listenerList) {
            listener.categorieChanged(new CategorieChangedEvent(this, getCategorie()));
        }
    }*/
}
