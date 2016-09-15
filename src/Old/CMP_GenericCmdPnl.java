/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Old;

import java.awt.Color;
import java.awt.Point;
import javax.swing.JButton;

/**
 *
 * @author Andre
 */

public class CMP_GenericCmdPnl extends javax.swing.JPanel {

    public CMP_GenericCmdPnl() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdSeach_A1 = new javax.swing.JButton();
        cmdAdd_A1 = new javax.swing.JButton();
        cmdEdit_A1 = new javax.swing.JButton();
        cmdExclude_A1 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMaximumSize(new java.awt.Dimension(618, 96));

        cmdSeach_A1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icnSerch_32x32.png"))); // NOI18N
        cmdSeach_A1.setText("Pesquisar");
        cmdSeach_A1.setMaximumSize(new java.awt.Dimension(113, 43));
        cmdSeach_A1.setMinimumSize(new java.awt.Dimension(113, 43));
        cmdSeach_A1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSeach_A1ActionPerformed(evt);
            }
        });

        cmdAdd_A1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icnAdd_32x32.png"))); // NOI18N
        cmdAdd_A1.setText("Adicionar");
        cmdAdd_A1.setMaximumSize(new java.awt.Dimension(113, 43));
        cmdAdd_A1.setMinimumSize(new java.awt.Dimension(113, 43));
        cmdAdd_A1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAdd_A1ActionPerformed(evt);
            }
        });

        cmdEdit_A1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icnEdit_32x32.png"))); // NOI18N
        cmdEdit_A1.setText("Editar");
        cmdEdit_A1.setMaximumSize(new java.awt.Dimension(113, 43));
        cmdEdit_A1.setMinimumSize(new java.awt.Dimension(113, 43));
        cmdEdit_A1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEdit_A1ActionPerformed(evt);
            }
        });

        cmdExclude_A1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icnRemove_32x32.png"))); // NOI18N
        cmdExclude_A1.setText("Excluir");
        cmdExclude_A1.setMaximumSize(new java.awt.Dimension(113, 43));
        cmdExclude_A1.setMinimumSize(new java.awt.Dimension(113, 43));
        cmdExclude_A1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdExclude_A1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdSeach_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdAdd_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdEdit_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdExclude_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdAdd_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdEdit_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdSeach_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdExclude_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAdd_A1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAdd_A1ActionPerformed
        configCtrl(1, getComponents());
    }//GEN-LAST:event_cmdAdd_A1ActionPerformed

    private void cmdEdit_A1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEdit_A1ActionPerformed
        configCtrl(2, getComponents());
    }//GEN-LAST:event_cmdEdit_A1ActionPerformed

    private void cmdSeach_A1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSeach_A1ActionPerformed
        configCtrl(0, getComponents());
    }//GEN-LAST:event_cmdSeach_A1ActionPerformed

    private void cmdExclude_A1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdExclude_A1ActionPerformed
        configCtrl(3, getComponents());
    }//GEN-LAST:event_cmdExclude_A1ActionPerformed

    private void configCtrl(int itemGhost, java.awt.Component[] cpcount) {
   
        for (int i = 0; i < cpcount.length; i++) {


            if (cpcount[i] instanceof JButton) {

                if (i == itemGhost) {
                    cpcount[i].setBackground(new Color(204, 255, 255));

                } else {

                    cpcount[i].setBackground(new Color(240, 240, 240));
                }

            }

        }

        //Tela cheia.
        //int width = dimension.width - (in.left + in.top);
        //int height = dimension.height - (in.top + in.bottom);
        //setSize(width, height);
        //setLocation(in.left, in.top);
        //Point position = pnlCmdExecute_A1.getPopupLocation(null);
        // itemGhost++;
        switch (itemGhost) {

            case 0:

                break;

            case 1:

                break;
            case 2:

                break;
            case 3:

                break;

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAdd_A1;
    private javax.swing.JButton cmdEdit_A1;
    private javax.swing.JButton cmdExclude_A1;
    private javax.swing.JButton cmdSeach_A1;
    // End of variables declaration//GEN-END:variables


}
