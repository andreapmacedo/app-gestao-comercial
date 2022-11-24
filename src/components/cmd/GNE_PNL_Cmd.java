/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.cmd;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;

/**
 *
 * @author Andre
 */
public class GNE_PNL_Cmd extends javax.swing.JPanel {

    public JButton cmdClose, cmdAdd, cmdEdit, cmdRefresh, cmdExclude;
    Dimension btmMinimumSize, btmMaximumSize, btmPreferedSize;

    public GNE_PNL_Cmd() {

        configShow();
        initComps();

    }

    private void initComps() {

        btmPreferedSize = (new Dimension(143, 63));
        btmMinimumSize = btmPreferedSize;
        btmMaximumSize = btmPreferedSize;

        cmdAdd = new javax.swing.JButton();
        cmdAdd.setText("Adicionar");
        cmdAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icnAdd_32x32.png")));
        // cmdAdd.setBackground(new java.awt.Color(215, 255, 215));
        cmdAdd.setPreferredSize(btmPreferedSize);

        cmdEdit = new javax.swing.JButton();
        cmdEdit.setText("Editar");
        cmdEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icnEdit_32x32.png")));

        //  cmdEdit.setBackground(new java.awt.Color(215, 255, 255));
        cmdEdit.setPreferredSize(btmPreferedSize);
        cmdEdit.setEnabled(false);

        cmdRefresh = new javax.swing.JButton();
        cmdRefresh.setText("Atualizar");
        //   cmdRefresh.setBackground(new java.awt.Color(215, 255, 255));
        cmdRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icnEdit_32x32.png")));
        cmdRefresh.setPreferredSize(btmPreferedSize);

        cmdExclude = new javax.swing.JButton();
        cmdExclude.setText("Excluir");
        cmdExclude.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icnRemove_32x32.png")));
        //   cmdExclude.setBackground(new java.awt.Color(255, 215, 215));
        cmdExclude.setPreferredSize(btmPreferedSize);
        cmdExclude.setEnabled(false);

        cmdClose = new javax.swing.JButton();
        cmdClose.setText("Fechar");
        cmdClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancel45(1).png")));
        //   cmdClose.setBackground(new java.awt.Color(200, 200, 200));
        cmdClose.setPreferredSize(btmPreferedSize);

        add(cmdAdd);
        add(cmdEdit);
        add(cmdExclude);
        add(cmdClose);

    }
    
//        private void setDefaultDimension(java.awt.Component[] cpcount) {
//
//        for (int i = 0; i < cpcount.length; i++) {
//            System.out.println("oiiiiiiiiiiiiiii");
//
//            if (cpcount[i] instanceof JButton) {
//
//                cpcount[i].setPreferredSize(defaultDim);
//            }
//
//        }
//
//    }
        
        
    private void configShow() {

        //setBackground(new java.awt.Color(150, 150, 150));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        FlowLayout layout = new FlowLayout(1, 20, 10);
        this.setLayout(layout);

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }

}
