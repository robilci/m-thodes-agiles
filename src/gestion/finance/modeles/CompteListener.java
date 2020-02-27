/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.modeles;

import java.util.EventListener;

/**
 *
 * @author robin
 */
public interface CompteListener extends EventListener{
     public void compteChanged(CompteChangedEvent event);
}
