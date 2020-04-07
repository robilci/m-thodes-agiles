/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.controleurs;

import gestion.finance.modeles.PersonneModele;
import gestion.finance.modeles.ImportationModel;

import gestion.finance.vue.AjoutMembre;
import gestion.finance.vue.vueImportDonnee;




/**
 *
 * @author khaml
 */
public class ImportationControleur {
    private vueImportDonnee vueImportDonnee;
    private ImportationModel model; 
            
    private AjoutMembre ajoutMembreView;
    private PersonneModele modele;
    
    
     public ImportationControleur(){
        this.model = new ImportationModel();
        this.vueImportDonnee = new vueImportDonnee(model,this);
        this.model.addMontantListener(vueImportDonnee);
        this.showAjoutDonnee();
    }
    
    
 
    
    public void showAjoutDonnee(){
        this.vueImportDonnee.setVisible(true);
    }
    
    public void closeAjoutDonnee(){
        this.vueImportDonnee.setVisible(false);
    }
    
    // c'est plutot ajouteDonne et la fonction du model qui fera sa sera ajoutFile la ou il y'aura persistance avec la DB.
    
    public void ajouterMembre(String nom, String prenom){
        modele.addPersonne(nom, prenom);
    }
}
