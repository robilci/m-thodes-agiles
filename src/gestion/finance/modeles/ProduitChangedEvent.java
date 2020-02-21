/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.modeles;
import java.util.EventObject;
/**
 *
 * @author victo
 */
public class ProduitChangedEvent extends EventObject{
    private int nouveauProduit;
 
	public ProduitChangedEvent(Object source, int nouveauProduit){
		super(source);
 
		this.nouveauProduit = nouveauProduit;
	}
 
	public int getNouveauProduit(){
		return nouveauProduit;
	}
}
