/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.Employers.Agreement;

import Models.JDoubleField.JDoubleField2;
import Settings.JMoneyField;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 *
 * @author Andre
 */
public class RegisterAgreementEmployer extends JPanel {

    public JTextField txtEmployer, txtReference, txtSalary, txtDeduction, txtQuantity;
    private JLabel lblDescription, lblReference, lblSalary, lblDeduction, lblQuantity;
    public JComboBox cmbDescription;
    public JButton btmAddDescription;
    public JCheckBox statusEmployer;
    public JPanel pnlContainer;

    GridBagConstraints c = new GridBagConstraints(); //Restriçoes

    public RegisterAgreementEmployer() throws ParseException, SQLException {
        configShow();
        initComps();
        setDefault();
        //  event();
    }

    private void initComps() throws SQLException {

        BasicComboBoxRenderer.UIResource UIResource = new BasicComboBoxRenderer.UIResource();
        UIResource.setHorizontalAlignment(SwingConstants.CENTER);

        pnlContainer = new JPanel();
        pnlContainer.setLayout(new GridBagLayout());

        c.insets = new Insets(4, 4, 4, 4);

        lblDescription = new JLabel("Descrição:");
        c.gridy = 0;
        c.gridx = 0;

        c.anchor = GridBagConstraints.EAST;
        pnlContainer.add(lblDescription, c);

        cmbDescription = new JComboBox();
        cmbDescription.setFont(new Font("Tahoma", Font.PLAIN, 11));
        cmbDescription.setPreferredSize(new Dimension(315, 20));
        cmbDescription.setRenderer(UIResource);
        //  loadCmbDescription();
        cmbDescription.setSelectedIndex(-1);
        c.gridwidth = 4;
        c.gridx = 1;
        c.anchor = GridBagConstraints.WEST;
        pnlContainer.add(cmbDescription, c);

        btmAddDescription = new JButton("Add");
        c.gridwidth = 1;
        c.gridx = 5;
        c.anchor = GridBagConstraints.WEST;
        pnlContainer.add(btmAddDescription, c);

        lblReference = new JLabel("Referência:");
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.EAST;
        pnlContainer.add(lblReference, c);

        c.gridwidth = 2;
        txtReference = new JTextField(12);
        txtReference.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtReference.setEditable(false);
        c.gridx = 1;
        c.anchor = GridBagConstraints.WEST;
        pnlContainer.add(txtReference, c);

        c.gridwidth = 1;
        lblQuantity = new JLabel("Vr. Referência:");
        c.gridx = 3;
        c.anchor = GridBagConstraints.EAST;
        pnlContainer.add(lblQuantity, c);

        txtQuantity = new JDoubleField2();
        txtQuantity.setPreferredSize(new Dimension(80, 20));
        txtQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        c.gridx = 4;
        c.anchor = GridBagConstraints.WEST;
        pnlContainer.add(txtQuantity, c);

        lblSalary = new JLabel("Rendimento:");
        c.gridy = 2;
        c.gridx = 0;
        c.anchor = GridBagConstraints.NORTHEAST;
        pnlContainer.add(lblSalary, c);

        txtSalary = new JMoneyField();
        txtSalary.setPreferredSize(new Dimension(136, 20));
        txtSalary.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        c.gridwidth = 2;
        c.gridx = 1;
        c.anchor = GridBagConstraints.WEST;
        pnlContainer.add(txtSalary, c);

        lblDeduction = new JLabel("Dedução:");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.NORTHEAST;
        pnlContainer.add(lblDeduction, c);

        txtDeduction = new JMoneyField();
        txtDeduction.setPreferredSize(new Dimension(136, 20));
        txtDeduction.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        c.gridwidth = 2;
        c.gridx = 1;
        c.anchor = GridBagConstraints.WEST;
        pnlContainer.add(txtDeduction, c);

        add(pnlContainer);

    }

    public void setDefault() {

        txtSalary.setText(null);
        txtDeduction.setText(null);
        txtQuantity.setText(null);
        txtReference.setText(null);
        txtSalary.setEnabled(false);
        txtDeduction.setEnabled(false);
        cmbDescription.setSelectedIndex(-1);// não posso utilizar cmbDescription.setSelectedItem("") porque não existe esse valor no banco de dados

    }

    //tem que levar esse cara daqui?
//    public void loadCmbDescription() throws SQLException {
//
//        HoleriteDescriptionDAO hdDAO = new HoleriteDescriptionDAO();
//
//        Vector<HoleriteDescription> list = new Vector(hdDAO.get_All_Entity_OrderByItemName());
//        for (HoleriteDescription iten : list) {
//            cmbDescription.addItem(iten.getDescription());
//        }
//        System.out.println("NO HOLERITE ITENS !!!");
//
//    }
//    private void loadCmbReference(int idFk) throws SQLException {
//
//        HoleriteReferenceDAO itemDAO = new HoleriteReferenceDAO();
//
//        cmbReference.removeAllItems();
//
//        Vector<HoleriteReference> list = new Vector(itemDAO.get_JustFk_Entity_OrderByItemName(idFk));
//
//        if (cmbDescription.getSelectedIndex() > -1) {
//            for (HoleriteReference iten : list) {
//                cmbReference.addItem(iten.getReference());
//
//            }
//        }
//    }
//    private void event() {
//
//        //mandei lá pra o form chamador para poder passar parámetros dele para o proximo form
////        btmAddDescription.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////
////                try {
////                    EMP_HOL_DESCRIPTION dialog = new EMP_HOL_DESCRIPTION();
////                    dialog.setVisible(true);
////                } catch (SQLException ex) {
////                    Logger.getLogger(EMP_HOLERITE_ITENS.class.getName()).log(Level.SEVERE, null, ex);
////                } catch (ParseException ex) {
////                    Logger.getLogger(EMP_HOLERITE_ITENS.class.getName()).log(Level.SEVERE, null, ex);
////                }
////
////            }
////        });
//        cmbDescription.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                HoleriteDescriptionDAO itenDAO = new HoleriteDescriptionDAO();
//
//                int idFk = itenDAO.get_Id_Entity((String) cmbDescription.getSelectedItem());
//
//                if (cmbDescription.getSelectedIndex() != -1) {
//
//                    HoleriteDescription iten;
//
//                    try {
//
////                        iten = itenDAO.get_Iten_Entity_1(idFk);
////                        String temp = iten.getReferenceType();
////                        System.out.println("temp " + temp);
//                        int type = itenDAO.get_Iten_Entity_1(idFk).getType();
//                        if (type == 0) {
//                            txtSalary.setEnabled(true);
//                            txtDeduction.setEnabled(false);
//                        } else {
//                            txtSalary.setEnabled(false);
//                            txtDeduction.setEnabled(true);
//                        }
//
//                        txtReference.setText(itenDAO.get_Iten_Entity_1(idFk).getReferenceType());
//                        txtQuantity.setText(itenDAO.get_Iten_Entity_1(idFk).getReferenceValue().toString());
//
//                    } catch (SQLException ex) {
//                        Logger.getLogger(EMP_HOLERITE_ITENS.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//
//                } else {
//                    setDefault();
//                }
//
//            }
//        });
//    }
    private void configShow() {

        setLayout(new FlowLayout((FlowLayout.LEFT), 10, 10));
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setBorder(BorderFactory.createTitledBorder("Pesquisa"));

    }

}
