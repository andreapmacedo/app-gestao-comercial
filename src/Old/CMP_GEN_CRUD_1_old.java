/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Old;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Andre
 */
public class CMP_GEN_CRUD_1_old extends javax.swing.JPanel {

    //public Container contentPane;
    public JButton cmdClean, cmdAdd, cmdEdit, cmdExclude;
    public JTextField txtID, txtIdentification;

    public CMP_GEN_CRUD_1_old() {

        initComponets();
        events();

        configCtrl(0, getComponents());
    }

    private void initComponets() {

        Dimension btmPreferedSize = (new Dimension(123, 63));
        Dimension btmMinimumSize = btmPreferedSize;
        Dimension btmMaximumSize = btmPreferedSize;

        setLayout(new FlowLayout(FlowLayout.CENTER));
        FlowLayout layout = new FlowLayout(1, 20, 10);
        this.setLayout(layout);

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        cmdClean = new javax.swing.JButton();
        cmdClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clean32x32.png"))); // NOI18N
        cmdClean.setText("Limpar");
        //cmdSeach.setMaximumSize(btmMaximumSize);
        //cmdSeach.setMinimumSize(btmMinimumSize);
        cmdClean.setPreferredSize(btmPreferedSize);

        txtIdentification = new javax.swing.JTextField();

        //cmdSeach.requestFocus();
        //   add(cmdSeach);
        add(cmdAdd);
        add(cmdEdit);
        add(cmdExclude);
        add(cmdClean);

    }

    private void configCtrl(int itemSelected, java.awt.Component[] cpcount) {

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

        cmdClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                configCtrl(0, getComponents());
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
