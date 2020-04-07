/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.modeles;

import java.util.EventObject;

/**
 *
 * @author khaml
 */
public class MontantChangedEvent extends EventObject {
    
    private double newMontant;
    
  
    public MontantChangedEvent(Object source, double newMontant) {
        super(source);
        this.newMontant= newMontant;
    }
    
      public double getNewMontant() {
        return newMontant;
    }
    
}
