/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeamento;


import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import mapeamento.ENUNS.Combate;
import mapeamento.beans.strategy.AbstractStrategyCombate;

/**
 *SISTOM-15
 * @author Gus
 */
public class EscolhaCombateDialog extends javax.swing.JDialog {

    /**
     * Creates new form TesteDialog
     * @param parent
     * @param modal
     */
    
    private Combate resultado;
    
    public EscolhaCombateDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
      
        initComponents();
        // System.out.println(tom.getLinha());
        
        this.setSize(450, 200);
        Combate[] combates = Combate.values();
        ComboBoxModel cbModelCombates = new DefaultComboBoxModel(combates);
        this.jComboBoxCombate.setModel(cbModelCombates);
        //Deixa o JDialog no meio da aplicação
        this.setLocationRelativeTo(parent);
        getContentPane().add(this.jPanelComBotaoOk, java.awt.BorderLayout.PAGE_END);
        
    }

  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanelComBotaoOk = new javax.swing.JPanel();
        jButtonOk = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jComboBoxCombate = new javax.swing.JComboBox<>();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelDuracao = new javax.swing.JLabel();
        jTextFieldDuracao = new javax.swing.JTextField();
        jLabelPreco = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();

        jButtonOk.setText("OK");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });
        jPanelComBotaoOk.add(jButtonOk);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(450, 200));

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jComboBoxCombate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCombateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        jPanel1.add(jComboBoxCombate, gridBagConstraints);

        jLabelNome.setText("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jLabelNome, gridBagConstraints);

        jTextFieldNome.setEditable(false);
        jTextFieldNome.setText("---");
        jTextFieldNome.setMinimumSize(new java.awt.Dimension(200, 30));
        jTextFieldNome.setPreferredSize(new java.awt.Dimension(200, 30));
        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel1.add(jTextFieldNome, gridBagConstraints);

        jLabelDuracao.setText("Duração:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jLabelDuracao, gridBagConstraints);

        jTextFieldDuracao.setText("---");
        jTextFieldDuracao.setMinimumSize(new java.awt.Dimension(80, 30));
        jTextFieldDuracao.setPreferredSize(new java.awt.Dimension(80, 30));
        jTextFieldDuracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDuracaoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(jTextFieldDuracao, gridBagConstraints);

        jLabelPreco.setText("Preço:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jLabelPreco, gridBagConstraints);

        jTextFieldPreco.setEditable(false);
        jTextFieldPreco.setText("---");
        jTextFieldPreco.setMinimumSize(new java.awt.Dimension(80, 30));
        jTextFieldPreco.setPreferredSize(new java.awt.Dimension(80, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(jTextFieldPreco, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxCombateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCombateActionPerformed
        // TODO add your handling code here:
        Combate selectedItem = (Combate)this.jComboBoxCombate.getSelectedItem();
        if (!Combate.NENHUM.equals(selectedItem)) {
            AbstractStrategyCombate strategy = selectedItem.getStrategy();
            String nome = strategy.getNome();
            int duracao = strategy.getDuracao();
            Double preco = strategy.getPreco();
            //String infoString = strategy.getInfoString();

            this.jTextFieldNome.setText(nome);

            this.jTextFieldDuracao.setText(Integer.toString(duracao));

            this.jTextFieldPreco.setText(preco.toString());
        }//if
        else{
            this.jTextFieldNome.setText("---");

            this.jTextFieldDuracao.setText("---");

            this.jTextFieldPreco.setText("---");
        }//else
       
      
        
    }//GEN-LAST:event_jComboBoxCombateActionPerformed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jTextFieldDuracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDuracaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDuracaoActionPerformed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        // TODO add your handling code here:
        Combate selectedItem = (Combate)this.jComboBoxCombate.getSelectedItem();
        this.resultado = selectedItem;
        this.setVisible(false);
        //return selectedItem;
    }//GEN-LAST:event_jButtonOkActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EscolhaCombateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EscolhaCombateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EscolhaCombateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EscolhaCombateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EscolhaCombateDialog dialog = new EscolhaCombateDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOk;
    private javax.swing.JComboBox<String> jComboBoxCombate;
    private javax.swing.JLabel jLabelDuracao;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelComBotaoOk;
    private javax.swing.JTextField jTextFieldDuracao;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPreco;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the resultado
     */
    public Combate getResultado() {
        return resultado;
    }
}
