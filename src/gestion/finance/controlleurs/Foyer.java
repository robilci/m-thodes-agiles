/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.controlleurs;

import gestion.finance.exceptions.AucunePersonneException;
import java.util.ArrayList;

/**
 *
 * @author robin
 */
public class Foyer {
    
    private String adresse;
    private ArrayList<Personne> personnes;
    
    public void Foyer(String adresse, Personne personne){
        this.adresse = adresse;
        this.personnes = new ArrayList<>();
        this.personnes.add(personne);
    }
    
    public void Foyer(String adresse, ArrayList<Personne> personnes) throws AucunePersonneException{
        if(this.personnes.size() < 1)
            throw new AucunePersonneException();
        
        this.adresse = adresse;
        this.personnes = personnes;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
}
