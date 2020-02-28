/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.utils;

/**
 *
 * @author robin
 */
public class Session {
    
    private static String pseudo;
    private static String idCompte;

    public Session(String pseudo, String idCompte) {
        this.pseudo = pseudo;
        this.idCompte = idCompte;
    }

    public static String getPseudo() {
        return pseudo;
    }

    public static String getIdCompte() {
        return idCompte;
    }
    
    public static void destroy(){
        pseudo = "";
        idCompte = "";
    }

    @Override
    public String toString() {
        return "Session : " + getIdCompte() + " - " + getPseudo();
    }
    
    
}
