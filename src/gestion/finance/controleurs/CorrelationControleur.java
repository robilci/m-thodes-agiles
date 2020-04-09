/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.controleurs;
import gestion.finance.vue.Accueil;
import gestion.finance.modeles.CorrelationModele;
import java.sql.SQLException;
/**
 *
 * @author victo
 */
public class CorrelationControleur {
     private Accueil accueilView;
    
    private CorrelationModele model;

    public CorrelationControleur(int id) {
        this.model = new CorrelationModele(id);
    }
    
    public double getCorrelation(){
        return model.getCorrelation();
    }
    
    
}
