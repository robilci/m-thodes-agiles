/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.controleurs;

import gestion.finance.modeles.CompteModele;
import gestion.finance.modeles.TransactionListener;
import gestion.finance.vue.Connexion;
import gestion.finance.vue.Inscription;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author robin
 */
public class CompteControleur {

    private Inscription inscriptionView;
    private Connexion connexionView;

    private CompteModele compteModele;

    public CompteControleur() {
        this.compteModele = new CompteModele();
        this.inscriptionView = new Inscription(this);
        this.connexionView = new Connexion(this);
        compteModele.addCompteListener(this.inscriptionView);
        compteModele.addCompteListener(this.connexionView);
    }

    public void showInscription() {
        this.inscriptionView.setVisible(true);
    }

    public void closeInscription() {
        this.inscriptionView.setVisible(false);
    }

    public void showConnexion() {
        this.connexionView.setVisible(true);
    }

    public void closeConnexion() {
        this.connexionView.setVisible(false);
    }

    public void createAccount(String pseudo, String password) {
        compteModele.createAccount(pseudo, md5(password));
    }

    public void auth(String pseudo, String password) {
        compteModele.auth(pseudo, md5(password));
    }

    private String md5(String message) {
        
        String digest = null;
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                sb.append(String.format("%02x", b & 0xff));
            }
            
            digest = sb.toString();

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CompteControleur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CompteControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return digest;
    }

}
