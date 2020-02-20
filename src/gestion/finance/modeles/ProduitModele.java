/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.modeles;

import javax.swing.event.EventListenerList;

/**
 *
 * @author victo
 */
public class ProduitModele {
    private int produit;
 
	private EventListenerList listeners;
 
	public ProduitModele(){
		this(0);
	}
 
	public ProduitModele(int produit){
		super();
 
		this.produit = produit;
 
		listeners = new EventListenerList();
	}
 
	public int getProduit() {
		return produit;
	}
 
	public void setProduit(int produit) {
		this.produit = produit;
 
		fireProduitChanged();
	}
 
	public void addProduitListener(ProduitListener listener){
		listeners.add(ProduitListener.class, listener);
	}
 
	public void removeProduitListener(ProduitListener l){
		 listeners.remove(ProduitListener.class, l);
	}
 
	public void fireProduitChanged(){
		ProduitListener[] listenerList = (ProduitListener[])listeners.getListeners(ProduitListener.class);
 
		for(ProduitListener listener : listenerList){
			listener.produitChanged(new ProduitChangedEvent(this, getProduit()));
		}
	}
}
