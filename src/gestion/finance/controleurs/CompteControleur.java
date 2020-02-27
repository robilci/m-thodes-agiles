/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.controleurs;

import gestion.finance.modeles.CompteModele;
import gestion.finance.modeles.TransactionListener;
import gestion.finance.vue.Inscription;

/**
 *
 * @author robin
 */
public class CompteControleur {
    
    private Inscription inscriptionView;
    
    private CompteModele compteModele;
    
    public CompteControleur(){
        this.compteModele = new CompteModele();
        this.inscriptionView = new Inscription(this, this.compteModele);
        compteModele.addTransactionListener(this.inscriptionView);
    }
    
    public void showInscription(){
        this.inscriptionView.setVisible(true);
    }
    
    public void closeInscription(){
        this.inscriptionView.setVisible(false);
    }
    
    public void notifyConfirmed(String pseudo, String password){
        compteModele.createAccount(pseudo, password);
    }
    
}
