/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.controleurs;

import gestion.finance.modeles.GraphModele;
import gestion.finance.vue.AjoutMembre;
import gestion.finance.vue.Graph;
import java.io.IOException;



public class GraphControleur {
    private Graph GraphView;
    private GraphModele model;
    
    public GraphControleur() throws IOException {
        this.model = new GraphModele();
        model.getelement();
        
        this.GraphView = new Graph();
        this.showGraphView();
        
    }
    
      public void showGraphView(){
        this.GraphView.setVisible(true);
    }
    
}
