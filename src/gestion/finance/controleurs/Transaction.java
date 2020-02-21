/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.controleurs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author robin
 */
abstract class Transaction {

    private Date dateTransaction;
    private double montant;

    public void importer(String url) {
        
        try {
            InputStream flux = new FileInputStream(url);
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            String ligne;
            
            while((ligne = buff.readLine()) != null){
                System.out.println(ligne); // Lignes à traiter
            }
            
            // TODO : implémenter le code de traitement des données
            // TODO : implémenter le code de sauvegarde des nouvelles opérations dans la base de données
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Fichier non trouvé \n");
        } catch (IOException ex) {
            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erreur dans l'importation de données \n");
        }
    }

    @Override
    public String toString() {
        return "Montant : " + this.montant;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
     
}
