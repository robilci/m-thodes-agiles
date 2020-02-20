/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.controlleurs;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author robin
 */
public class Personne {
    
    private String nom;
    private String prenom;
    private Date date;
    private ArrayList<Transaction> transactions;

    public Personne(String nom, String prenom, Date date) {
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
        this.transactions = new ArrayList<>();
    }
    
    public Personne(String nom, String prenom, Date date, ArrayList<Transaction> transactions){
        this(nom, prenom, date);
        this.transactions = transactions;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
     
}
