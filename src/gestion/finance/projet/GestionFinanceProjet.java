/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.projet;
import gestion.finance.modeles.CompteModele;
import gestion.finance.utils.Database;
/**
 *
 * @author e1503742
 */
public class GestionFinanceProjet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Database("localhost", "3307", "gestion_finances", "root", "");
        CompteModele cm = new CompteModele();
        cm.createAccount();
    }
    
}
