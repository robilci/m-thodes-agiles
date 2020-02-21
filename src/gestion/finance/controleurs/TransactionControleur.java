/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.controleurs;

import gestion.finance.vue.Accueil;
import gestion.finance.modeles.TransactionModele;



/**
 *
 * @author e1503742
 */
public class TransactionControleur {
    
    private Accueil accueilView;
    
    private TransactionModele model;
    
    public TransactionControleur(TransactionModele model){
        this.model = model;
        accueilView = new Accueil(this.model, this);
        this.model.addTransactionListener(accueilView);
    }
    
    public void notifyMembreChanged(String id){
        model.setMembreId(id);
    }
    
    public void notifyDatesChanged(String dateDebut, String dateFin){
        model.setDates(dateDebut, dateFin);
    }
   
}
