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
public class SoldeChangedEvent extends EventObject{
      private double nouveauSolde;
 
	public SoldeChangedEvent(Object source, double nouveauSolde){
		super(source);
 
		this.nouveauSolde = nouveauSolde;
	}
 
	public double getNouveauSolde(){
		return nouveauSolde;
	}
}
