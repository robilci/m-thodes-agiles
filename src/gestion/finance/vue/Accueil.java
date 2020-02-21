/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.vue;

import gestion.finance.controleurs.TransactionControleur;
import gestion.finance.modeles.TransactionChangedEvent;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import gestion.finance.modeles.TransactionListener;
import gestion.finance.modeles.TransactionModele;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author lauri
 */
public class Accueil extends javax.swing.JFrame implements TransactionListener {
    
    private TransactionModele modele;
    private TransactionControleur controleur;

    /**
     * Creates new form Accueil
     */
    public Accueil(TransactionModele modele, TransactionControleur controleur) {
        this.modele = modele;
        this.controleur = controleur;
        
        initComponents();
        initActionListener();
        setPreferredSize(new Dimension(250, 150));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {
        
        jSeparator1 = new javax.swing.JSeparator();
        bImport = new javax.swing.JButton();
        bAnalyse = new javax.swing.JButton();
        bAjoutMembre = new javax.swing.JButton();
        bGraphique = new javax.swing.JButton();
        bPrediction = new javax.swing.JButton();
        listMembre = new javax.swing.JComboBox<>();
        labelDebut = new javax.swing.JLabel();
        dateDebut = new javax.swing.JTextField();
        labelFin = new javax.swing.JLabel();
        dateFin = new javax.swing.JTextField();
        bAppliquer = new javax.swing.JButton();
        bEnlever = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTransaction = new javax.swing.JList<>();
        
        listTransaction.setModel(modele.updateModel());
        listMembre.setModel(new DefaultComboBoxModel(modele.getMembres(1)));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Accueil");
        
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        
        bImport.setText("Importer des données");
        bImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bImportActionPerformed(evt);
            }
        });
        
        bAnalyse.setText("Analyse des données sélecionner");
        
        bAjoutMembre.setText("Ajouter membre à la famille");
        
        bGraphique.setText("Voir graphique des gains/dépenses");
        
        bPrediction.setText("Prédiction dépense globale");
        
        labelDebut.setText("Date début");
        
        dateDebut.setText("Format : AAAA-MM-JJ");
        
        labelFin.setText("Date fin");
        
        dateFin.setText("Format : AAAA-MM-JJ");
        
        bAppliquer.setText("Appliquer filtre de date");
        
        bEnlever.setText("Enlever filtre de date");
        
        jScrollPane1.setViewportView(listTransaction);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(listMembre, 0, 603, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelDebut)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(dateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labelFin)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(dateFin, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(bAppliquer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bEnlever, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator2)
                                        .addComponent(jScrollPane1))
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(bImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bAnalyse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bAjoutMembre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bGraphique, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                                        .addComponent(bPrediction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(235, 235, 235)
                                                .addComponent(bImport)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(bAnalyse)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(bAjoutMembre)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(bGraphique)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(bPrediction)
                                                .addGap(0, 275, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSeparator1)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(listMembre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(labelDebut)
                                                                        .addComponent(dateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(labelFin)
                                                                        .addComponent(dateFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(bAppliquer)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(bEnlever)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane1)))))
                                .addContainerGap())
        );
        
        pack();
    }
    
    private void initActionListener() {
        bAppliquer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.notifyDatesChanged(dateDebut.getText().toString(), dateFin.getText().toString());
            }
        });
           
        listMembre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listMembre.getSelectedItem() != null) {
                    controleur.notifyMembreChanged(String.valueOf(listMembre.getSelectedIndex()));
                }
            }
        });
        
        bEnlever.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listMembre.setSelectedIndex(0);
            }
        });
        
        
        
        
        
    }
    
    private void bImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bImportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bImportActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAjoutMembre;
    private javax.swing.JButton bAnalyse;
    private javax.swing.JButton bAppliquer;
    private javax.swing.JButton bEnlever;
    private javax.swing.JButton bGraphique;
    private javax.swing.JButton bImport;
    private javax.swing.JButton bPrediction;
    private javax.swing.JTextField dateDebut;
    private javax.swing.JTextField dateFin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelDebut;
    private javax.swing.JLabel labelFin;
    private javax.swing.JComboBox<String> listMembre;
    private javax.swing.JList<String> listTransaction;
    // End of variables declaration//GEN-END:variables

    @Override
    public void transactionChanged(TransactionChangedEvent event) {
        listTransaction.setModel(event.getNouveauModele());
    }
}
