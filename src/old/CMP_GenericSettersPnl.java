/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

/**
 *
 * @author Andre
 */
public class CMP_GenericSettersPnl extends javax.swing.JPanel {

    /**
     * Creates new form GenericSettersPnl
     */
    public CMP_GenericSettersPnl() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        txtPesquisaPorNome = new javax.swing.JTextField();
        txtRegistros = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPesquisaPorID = new javax.swing.JTextField();
        lblRegistros = new javax.swing.JLabel();
        cmbVinculoPesquisa = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        btmClean = new javax.swing.JButton();

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Identificação:");

        txtRegistros.setEditable(false);
        txtRegistros.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtRegistros.setForeground(new java.awt.Color(51, 51, 255));
        txtRegistros.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRegistros.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Registros");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("ID");

        txtPesquisaPorID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesquisaPorIDKeyTyped(evt);
            }
        });

        cmbVinculoPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbVinculoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVinculoPesquisaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Vínculo");

        btmClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clean32x32.png"))); // NOI18N
        btmClean.setText("Limpar");
        btmClean.setMaximumSize(new java.awt.Dimension(113, 43));
        btmClean.setMinimumSize(new java.awt.Dimension(113, 43));
        btmClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmCleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 903, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtPesquisaPorID, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbVinculoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtPesquisaPorNome, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(326, 326, 326)
                            .addComponent(lblRegistros))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(btmClean, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel5)))
                    .addGap(25, 25, 25)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtPesquisaPorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbVinculoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtPesquisaPorNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btmClean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRegistros)
                            .addComponent(jLabel5)))
                    .addGap(18, 18, 18)
                    .addComponent(lblRegistros)
                    .addGap(35, 35, 35)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaPorIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaPorIDKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPesquisaPorIDKeyTyped

    private void cmbVinculoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVinculoPesquisaActionPerformed

//        System.out.println("cmbVinculoPesquisarActionPerformed -> " + depure++);
//
//        cmbBondIndex = cmbVinculoPesquisa.getSelectedIndex();
//
//        if (cmbVinculoPesquisa.getItemCount() > 0 && cmbBondIndex != -1) {//
//            String item = cmbVinculoPesquisa.getSelectedItem().toString();
//            correspIdItem = estadosDAO.get_Id_Entity(item);
//
//            if (oldCmbIndex != cmbBondIndex) {
//
//                try {
//                    loadTable1();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Form_Employers.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//
//        } else {
//
//            try {
//                loadCmbBond();
//            } catch (SQLException ex) {
//                Logger.getLogger(Form_Employers.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//        oldCmbIndex = cmbBondIndex;
    }//GEN-LAST:event_cmbVinculoPesquisaActionPerformed

    private void btmCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmCleanActionPerformed

//        txtPesquisaPorNome.setText(null);
//        txtPesquisaPorID.setText(null);
//
//        if (bond == true) {
//            cmbVinculoPesquisa.setSelectedIndex(-1);
//        } else {
//            try {
//                loadTable1();
//            } catch (SQLException ex) {
//                Logger.getLogger(Form_Employers.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }

    }//GEN-LAST:event_btmCleanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmClean;
    private javax.swing.JComboBox cmbVinculoPesquisa;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JTextField txtPesquisaPorID;
    private javax.swing.JTextField txtPesquisaPorNome;
    private javax.swing.JTextField txtRegistros;
    // End of variables declaration//GEN-END:variables
}
