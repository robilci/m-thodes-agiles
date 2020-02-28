/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.modeles;
import java.util.EventObject;
import javax.swing.DefaultListModel;
/**
 *
 * @author victo
 */
public class TransactionChangedEvent extends EventObject{
     private DefaultListModel<String> nouveauModele;
 
	public TransactionChangedEvent(Object source, DefaultListModel<String> modele){
		super(source);
                this.nouveauModele = modele;
	}
 
	public DefaultListModel<String> getNouveauModele(){
		return nouveauModele;
	}
}
