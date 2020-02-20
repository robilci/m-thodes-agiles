/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.controlleurs;

import gestion.finance.exceptions.AucunProduitException;
import java.util.ArrayList;

/**
 *
 * @author robin
 */
public class Depense extends Transaction{
    
    private ArrayList<Produit> produits;

    public Depense(ArrayList<Produit> prouits) throws AucunProduitException {
        if(produits.size() < 1)
            throw new AucunProduitException();

        this.produits = produits;     
    }
    
    public Depense(Produit produit) {
        this.produits = new ArrayList<>();
        this.produits.add(produit);
    }

    public ArrayList<Produit> getProduits() {
        return produits;
    }

    public void setProduits(ArrayList<Produit> produits) {
        this.produits = produits;
    }
    
    public void addProduit(Produit produit){
        produits.add(produit);
    }
  
}
