/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.controleurs;

/**
 *
 * @author robin
 */
public class Revenu extends Transaction{
    
    private String type;

    public Revenu(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Revenu --> " + super.toString() + " - Type : " + this.type;
    }
    
}
