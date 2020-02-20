/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.modeles;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import gestion.finance.utils.Database;

/**
 *
 * @author e1503742
 */
public class CompteModele {
    

    
    public CompteModele(){

    }
    
    public void createAccount(){
        PreparedStatement ps;
        try {
            ps = Database.getConnection().prepareStatement("INSERT INTO compte (Pseudo, Password) VALUES (?, ?)");
            ps.setString(1, "Robin");
            ps.setString(2, "45587888888");
            int retour = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompteModele.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
