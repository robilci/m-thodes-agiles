/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.projet;
import gestion.finance.controleurs.CompteControleur;
import gestion.finance.controleurs.PersonneControleur;
import gestion.finance.controleurs.TransactionControleur;
import gestion.finance.modeles.CompteModele;
import gestion.finance.modeles.TransactionModele;
import gestion.finance.utils.Database;
import gestion.finance.vue.Accueil;
import gestion.finance.vue.AjoutMembre;
import java.awt.Dimension;
import javax.swing.JFrame;
/**
 *
 * @author e1503742
 */
public class GestionFinanceProjet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Database("localhost", "3306", "gestion_finances", "root", "");
        /*TransactionModele modele = new TransactionModele();
        TransactionControleur ts = new TransactionControleur(modele);*/
        
        /*CompteControleur compteControleur = new CompteControleur();
        compteControleur.showInscription();*/
        
        PersonneControleur controleur = new PersonneControleur();
        controleur.showAjoutMembre();
    }
    
    
}
