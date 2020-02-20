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
public class CategorieModele {
      private int categorie;
 
	private EventListenerList listeners;
 
	public CategorieModele(){
		this(0);
	}
 
	public CategorieModele(int categorie){
		super();
 
		this.categorie = categorie;
 
		listeners = new EventListenerList();
	}
 
	public int getCategorie() {
		return categorie;
	}
 
	public void setCategorie(int categorie) {
		this.categorie = categorie;
 
		fireCategorieChanged();
	}
 
	public void addCategorieListener(CategorieListener listener){
		listeners.add(CategorieListener.class, listener);
	}
 
	public void removeCategorieListener(CategorieListener l){
		 listeners.remove(CategorieListener.class, l);
	}
 
	public void fireCategorieChanged(){
		CategorieListener[] listenerList = (CategorieListener[])listeners.getListeners(CategorieListener.class);
 
		for(CategorieListener listener : listenerList){
			listener.categorieChanged(new CategorieChangedEvent(this, getCategorie()));
		}
	}
}
