/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.modeles;

import gestion.finance.utils.Database;
import static java.lang.Math.sqrt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author lauri
 */
public class CorrelationModele {
    
    private int idPersonne;
    private ArrayList<Double> revenue;
    private ArrayList<Double> depense;
    
    /**
     * prend en paramètre l'id de la personne dont les transactions sont à étudier, mettre 0 si toutes sont séméectionnées
    */
    public CorrelationModele(int id){
        idPersonne = id;
        revenue = new ArrayList<Double>();
        depense = new ArrayList<Double>();
    }
    
    public double moyenne(ArrayList<Double> m){
        double moy = 0;
        
        for(int i = 0; i < m.size(); i++){
            moy += m.get(i);
        }
        moy = moy/(double)m.size();
        return moy;
    }
    
    public double ecartType(ArrayList<Double> m, double moy){
        double ecart = 0;
        ecart = 1.0/((double)m.size() - 1.0);
        double somme = 0;
        
        for(int i = 0; i < m.size(); i++){
            somme += (m.get(i) - moy)*(m.get(i) - moy);
        }
        
        ecart = ecart * somme;
        ecart = sqrt(ecart);
        
        return ecart;
    }
    
    public double calculCorrelation(){
        double n = revenue.size();
        
        double mr = 0;
        double md = 0;
        double er = 0;
        double ed = 0;
        
        double rho = 0;
        
        double somme = 0;
        double sr = 0;
        double sd = 0;
        
        if(n < depense.size()){
            ArrayList<Double> dep = new ArrayList<>();
            ArrayList<Double> copie = new ArrayList<>();
            Random r = new Random();
            int d = 0;
            double moy = 0;
            for(int i = 0; i < 50; i++){
                copie = (ArrayList<Double>) depense.clone();
                for(int j = 0; j < n; j++){
                    d = r.nextInt(copie.size());
                    dep.add(copie.get(d));
                    copie.remove(d);
                }
                mr = moyenne(revenue);
                md = moyenne(dep);
                er = ecartType(revenue, mr);
                ed = ecartType(dep, md);
                
                double rhoM = 1.0/(n - 1.0);

                for (int k = 0; k < n; k++){
                    sr = (revenue.get(k) - mr)/er;
                    sd = (dep.get(k) - md)/ed;

                    somme += (sr * sd);
                }

                rhoM = rhoM * somme;
                
                rho += rhoM;
            }
            rho = rho/n;
        }
        else if(n > depense.size()){
            n = depense.size();
            ArrayList<Double> rev = new ArrayList<>();
            ArrayList<Double> copie = new ArrayList<>();
            Random r = new Random();
            int d = 0;
            double moy = 0;
            for(int i = 0; i < 50; i++){
                copie = (ArrayList<Double>) revenue.clone();
                for(int j = 0; j < n; j++){
                    d = r.nextInt(copie.size());
                    rev.add(copie.get(d));
                    copie.remove(d);
                }
                mr = moyenne(rev);
                md = moyenne(depense);
                er = ecartType(rev, mr);
                ed = ecartType(depense, md);
                
                double rhoM = 1.0/(n - 1.0);

                for (int k = 0; k < n; k++){
                    sr = (rev.get(k) - mr)/er;
                    sd = (depense.get(k) - md)/ed;

                    somme += (sr * sd);
                }

                rhoM = rhoM * somme;
                
                rho += rhoM;
            }
            rho = rho/n;
        }
        else {
            mr = moyenne(revenue);
            md = moyenne(depense);
            er = ecartType(revenue, mr);
            ed = ecartType(depense, md);
            
            rho = 1.0/(n - 1.0);

            for (int i = 0; i < n; i++){
                sr = (revenue.get(i) - mr)/er;
                sd = (depense.get(i) - md)/ed;

                somme += (sr * sd);
            }

            rho = rho * somme;
        }
        
        return rho;
        
    }
    
    public void getCorrelation(){
        PreparedStatement ps;
        try {
            PreparedStatement statement;
            if(idPersonne == 0){
                statement = Database.getConnection().prepareStatement("SELECT * FROM transactions");
            } else {
                statement = Database.getConnection().prepareStatement("SELECT * FROM transactions WHERE ID_Personne=" + idPersonne);
            }
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                if("Revenue".equals(rs.getString("Type")))
                    revenue.add(Double.parseDouble(rs.getString("Montant")));
                else
                    depense.add(Double.parseDouble(rs.getString("Montant")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CorrelationModele.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(calculCorrelation());
        
    }
    
}
