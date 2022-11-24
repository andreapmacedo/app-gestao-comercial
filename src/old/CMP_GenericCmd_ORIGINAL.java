/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Andre
 */
public class CMP_GenericCmd_ORIGINAL extends javax.swing.JPanel {

    //public Container contentPane;
    private JButton cmdSeach, cmdAdd, cmdEdit, cmdExclude;

    public CMP_GenericCmd_ORIGINAL() {

        initComponets();
        events();

        configCtrl(0, getComponents());
    }

    private void initComponets() {

        Dimension btmPreferedSize = (new Dimension(123, 63));
        Dimension btmMinimumSize = btmPreferedSize;
        Dimension btmMaximumSize = btmPreferedSize;

        //contentPane = getContentPane(); só pra jframe... panel não serve
        setLayout(new FlowLayout(FlowLayout.CENTER));
        FlowLayout layout = new FlowLayout(1, 20, 10);
        this.setLayout(layout);

        //setSize(800, 600);
        //setMaximumSize(new java.awt.Dimension(618, 96));
        //setExtendedState(JFrame.MAXIMIZED_BOTH); // Tela Cheia
        //setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cmdSeach = new javax.swing.JButton();
        cmdSeach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icnSerch_32x32.png"))); // NOI18N
        cmdSeach.setText("Pesquisar");
        //cmdSeach.setMaximumSize(btmMaximumSize);
        //cmdSeach.setMinimumSize(btmMinimumSize);
        cmdSeach.setPreferredSize(btmPreferedSize);

        cmdAdd = new javax.swing.JButton();
        cmdAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icnAdd_32x32.png"))); // NOI18N
        cmdAdd.setText("Adicionar");
        //cmdAdd.setMaximumSize(btmMaximumSize);
        //cmdAdd.setMinimumSize(btmMinimumSize);
        cmdAdd.setPreferredSize(btmPreferedSize);

        cmdEdit = new javax.swing.JButton();
        cmdEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icnEdit_32x32.png"))); // NOI18N
        cmdEdit.setText("Editar");
        //cmdEdit.setMaximumSize(btmMaximumSize);
        //cmdEdit.setMinimumSize(btmMinimumSize);
        cmdEdit.setPreferredSize(btmPreferedSize);

        cmdExclude = new javax.swing.JButton();
        cmdExclude.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icnRemove_32x32.png"))); // NOI18N
        cmdExclude.setText("Excluir");
        //cmdExclude.setMaximumSize(btmMaximumSize);
        //cmdExclude.setMinimumSize(btmMinimumSize);
        cmdExclude.setPreferredSize(btmPreferedSize);

        //cmdSeach.requestFocus();
        add(cmdSeach);
        add(cmdAdd);
        add(cmdEdit);
        add(cmdExclude);

    }

    private void configCtrl(int itemSelected, java.awt.Component[] cpcount) {

        System.out.println("componente " + cpcount.length);

        for (int i = 0; i < cpcount.length; i++) {

            if (cpcount[i] instanceof JButton) {

                if (i == itemSelected) {
                    cpcount[i].setBackground(new Color(204, 255, 255));

                } else {

                    cpcount[i].setBackground(new Color(240, 240, 240));
                }

            }

        }

        switch (itemSelected) {

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

    public void events() {

        cmdSeach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                configCtrl(0, getComponents());
            }
        });

        cmdAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                configCtrl(1, getComponents());
            }
        });
        
        cmdEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                configCtrl(2, getComponents());
            }
        });
        
        cmdExclude.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                configCtrl(3, getComponents());
            }
        });

    }

}
