/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.modeles;

import java.util.EventObject;

/**
 *
 * @author robin
 */
public class CompteChangedEvent extends EventObject{
    
    private boolean result;
    
    public CompteChangedEvent(Object source, boolean result){
		super(source);
                this.result = result;
    }
    
    public boolean getResult(){
        return this.result;
    }
    
}
