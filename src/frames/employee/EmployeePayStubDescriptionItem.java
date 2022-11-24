package frames.employee;

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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import ex.JDoubleField.JDoubleField2;

public class EmployeePayStubDescriptionItem extends JPanel {

    public JTextField txtDescription, txtReferenceValue;
    private JLabel lblDescription, lblType, lblIncidence, lblReferenceType, lblReferenceValue, lblOBS;
    public JComboBox cmbType, cmbReferenceType, cmbIncidence;
    public JCheckBox cbxInss, cbxFgts, cbxIr;
    public JPanel pnlContainer;

    GridBagConstraints gbl = new GridBagConstraints(); //Restriçoes

    public EmployeePayStubDescriptionItem() throws ParseException, SQLException {
        configShow();
        initComps();
        event();
    }

    private void initComps() throws SQLException {

        BasicComboBoxRenderer.UIResource UIResource = new BasicComboBoxRenderer.UIResource();
        UIResource.setHorizontalAlignment(SwingConstants.CENTER);

        pnlContainer = new JPanel();
        pnlContainer.setLayout(new GridBagLayout());

        gbl.insets = new Insets(4, 4, 4, 4);

        lblDescription = new JLabel("*Descrição:");
        gbl.gridy = 0;
        gbl.gridx = 0;

        gbl.anchor = GridBagConstraints.EAST;
        pnlContainer.add(lblDescription, gbl);

        txtDescription = new JTextField(34);
        txtDescription.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        gbl.gridwidth = 3;
        gbl.gridx = 1;
        gbl.anchor = GridBagConstraints.WEST;
        pnlContainer.add(txtDescription, gbl);

        lblType = new JLabel("*Tipo:");
        gbl.gridwidth = 1;
        gbl.gridy = 1;
        gbl.gridx = 0;
        gbl.anchor = GridBagConstraints.EAST;
        pnlContainer.add(lblType, gbl);

        cmbType = new JComboBox();
        cmbType.setFont(new Font("Tahoma", Font.PLAIN, 11));
        cmbType.setSelectedIndex(-1);
        cmbType.setPreferredSize(new Dimension(100, 20));
        cmbType.setRenderer(UIResource);
        cmbType.addItem("RENDIMENTO");
        cmbType.addItem("DEDUÇÃO");
        cmbType.setSelectedIndex(-1);
        gbl.gridx = 1;
        gbl.anchor = GridBagConstraints.WEST;
        pnlContainer.add(cmbType, gbl);

        lblReferenceType = new JLabel("*Referência:");
        gbl.gridx = 0;
        gbl.gridy = 2;
        gbl.anchor = GridBagConstraints.EAST;
        pnlContainer.add(lblReferenceType, gbl);

        cmbReferenceType = new JComboBox();
        cmbReferenceType.setFont(new Font("Tahoma", Font.PLAIN, 11));
        cmbReferenceType.setPreferredSize(new Dimension(100, 20));
        cmbReferenceType.setRenderer(UIResource);
        cmbReferenceType.addItem("%");
        cmbReferenceType.addItem("DIAS");
        cmbReferenceType.addItem("QTD");
        cmbReferenceType.setSelectedIndex(-1);
        gbl.gridx = 1;
        gbl.anchor = GridBagConstraints.WEST;
        pnlContainer.add(cmbReferenceType, gbl);

        lblReferenceValue = new JLabel("**Vr. Referência:");
        gbl.gridx = 2;
        gbl.anchor = GridBagConstraints.EAST;
        pnlContainer.add(lblReferenceValue, gbl);

        txtReferenceValue = new JDoubleField2();
        txtReferenceValue.setPreferredSize(new Dimension(50, 20));
        txtReferenceValue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gbl.gridx = 3;
        gbl.anchor = GridBagConstraints.WEST;
        pnlContainer.add(txtReferenceValue, gbl);

        lblIncidence = new JLabel("*Incidência:");
        gbl.gridx = 0;
        gbl.gridy = 3;
        gbl.anchor = GridBagConstraints.EAST;
        pnlContainer.add(lblIncidence, gbl);

        cmbIncidence = new JComboBox();
        cmbIncidence.setFont(new Font("Tahoma", Font.PLAIN, 11));
        cmbIncidence.setPreferredSize(new Dimension(100, 20));
        cmbIncidence.setRenderer(UIResource);
        cmbIncidence.addItem("OCASIONAL");
        cmbIncidence.addItem("DIÁRIA");
        cmbIncidence.addItem("SEMANAL");
        cmbIncidence.addItem("MENSAL");
        cmbIncidence.addItem("SEMESTRAL");
        cmbIncidence.addItem("ANUAL");
        cmbIncidence.setSelectedIndex(-1);
        gbl.gridx = 1;
        gbl.anchor = GridBagConstraints.WEST;
        pnlContainer.add(cmbIncidence, gbl);

        gbl.gridwidth = 2;

        cbxInss = new JCheckBox("Incide INSS");
        gbl.gridy = 4;
        gbl.gridx = 0;
        gbl.anchor = GridBagConstraints.WEST;
        pnlContainer.add(cbxInss, gbl);

        cbxFgts = new JCheckBox("Incide FGTS");
        gbl.gridy = 5;
        gbl.anchor = GridBagConstraints.WEST;
        pnlContainer.add(cbxFgts, gbl);

        cbxIr = new JCheckBox("Incide IR");
        gbl.gridy = 6;
        gbl.anchor = GridBagConstraints.WEST;
        pnlContainer.add(cbxIr, gbl);

        gbl.gridwidth = 5;

        lblOBS = new JLabel("(*) Preenchimento obrigatório");
        gbl.gridy = 7;
        gbl.gridx = 0;
        pnlContainer.add(lblOBS, gbl);

        lblOBS = new JLabel("(**) Valor padrão do item, preenchimento não obrigatório");
        //gbl.gridy = 7;
        gbl.gridy = 8;
        pnlContainer.add(lblOBS, gbl);

        add(pnlContainer);
        setDefault();

    }

    public void setDefault() {

        txtDescription.setText("");
        cmbIncidence.setSelectedIndex(-1);
        cmbReferenceType.setSelectedIndex(-1);
        cmbType.setSelectedIndex(-1);

        //cbxInss.
//        txtSalary.setText("");
//        txtDeduction.setText("");
//        txtQuantity.setText("");
//        cmbDescription.setSelectedIndex(-1);// não posso utilizar cmbDescription.setSelectedItem("") porque não existe esse valor no banco de dados
//        cmbReference.setSelectedIndex(-1);
    }

//    private void loadCmbDescription() throws SQLException {
//
//        HoleriteDescriptionDAO itemDAO = new HoleriteDescriptionDAO();
//
//        Vector<HoleriteDescription> list = new Vector(itemDAO.get_All_Entity_OrderByItemName());
//        for (HoleriteDescription iten : list) {
//            cmbDescription.addItem(iten.getDescription());
//        }
//
//    }
//
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
    private void event() {

//        cmbDescription.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                HoleriteDescriptionDAO itemDAO = new HoleriteDescriptionDAO();
//
//                int idFk = itemDAO.get_Id_Entity((String) cmbDescription.getSelectedItem());
//
//                try {
//
//                    loadCmbReference(idFk);
//                } catch (SQLException ex) {
//                    Logger.getLogger(EMP_DATA_ITENS.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
    }

    private void configShow() {

        setLayout(new FlowLayout((FlowLayout.LEFT), 10, 10));
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setBorder(BorderFactory.createTitledBorder("Pesquisa"));

    }

}
