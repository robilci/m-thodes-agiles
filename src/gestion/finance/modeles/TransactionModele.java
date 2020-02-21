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
public class TransactionModele {
      private int transaction;
 
	private EventListenerList listeners;
 
	public TransactionModele(){
		this(0);
	}
 
	public TransactionModele(int transaction){
		super();
 
		this.transaction = transaction;
 
		listeners = new EventListenerList();
	}
 
	public int getTransaction() {
		return transaction;
	}
 
	public void setTransaction(int transaction) {
		this.transaction = transaction;
 
		fireTransactionChanged();
	}
 
	public void addTransactionListener(TransactionListener listener){
		listeners.add(TransactionListener.class, listener);
	}
 
	public void removeTransactionListener(CategorieListener l){
		 listeners.remove(CategorieListener.class, l);
	}
 
	public void fireTransactionChanged(){
		TransactionListener[] listenerList = (TransactionListener[])listeners.getListeners(TransactionListener.class);
 
		for(TransactionListener listener : listenerList){
			listener.transactionChanged(new TransactionChangedEvent(this, getTransaction()));
		}
	}
}
