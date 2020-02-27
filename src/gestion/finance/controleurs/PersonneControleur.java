/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.controleurs;

import gestion.finance.modeles.PersonneModele;
import gestion.finance.vue.AjoutMembre;

/**
 *
 * @author robin
 */
public class PersonneControleur {
    
    private AjoutMembre ajoutMembreView;
    private PersonneModele modele;
    
    public PersonneControleur(){
        this.modele = new PersonneModele();
        this.ajoutMembreView = new AjoutMembre(this, modele);
        this.modele.addTransactionListener(ajoutMembreView);
        this.showAjoutMembre();
    }
    
    public void showAjoutMembre(){
        this.ajoutMembreView.setVisible(true);
    }
    
    public void closeAjoutMembre(){
        this.ajoutMembreView.setVisible(false);
    }
    
    public void ajouterMembre(String nom, String prenom){
        modele.addPersonne(nom, prenom);
    }
    
}
