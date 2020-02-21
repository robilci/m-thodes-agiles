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
public class TransactionChangedEvent extends EventObject{
     private int nouvelleTransaction;
 
	public TransactionChangedEvent(Object source, int nouvelleTransaction){
		super(source);
 
		this.nouvelleTransaction = nouvelleTransaction;
	}
 
	public int getNouvelleCategoriet(){
		return nouvelleTransaction;
	}
}
