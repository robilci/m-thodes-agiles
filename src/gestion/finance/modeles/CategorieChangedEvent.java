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
public class CategorieChangedEvent extends EventObject{
      private int nouvelleCategorie;
 
	public CategorieChangedEvent(Object source, int nouvelleCategorie){
		super(source);
 
		this.nouvelleCategorie = nouvelleCategorie;
	}
 
	public int getNouvelleCategoriet(){
		return nouvelleCategorie;
	}
}
