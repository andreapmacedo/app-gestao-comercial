package Frames.Employers;

import Settings.SET_TextField_Phone;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EMP_PHONES_ITENS extends JPanel {

    public JTextField txtEmployer, txtNumero;
    private JLabel lblEmployer, lblType, lblCarrier, lblNumber;
    public JComboBox cmbType, cmbCarrier;
    public JCheckBox statusEmployer;

    public EMP_PHONES_ITENS() throws ParseException {

        configShow();
        initComps();
        event();

    }

    private void initComps() {

        lblNumber = new JLabel("  Número:");
        add(lblNumber);

        txtNumero = new JTextField(10);
        txtNumero.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumero.setDocument(new SET_TextField_Phone());
        add(txtNumero);

        add(txtNumero);

        cmbType = new JComboBox();
        cmbType.setFont(new Font("Tahoma", Font.PLAIN, 11));
        cmbType.addItem("");
        cmbType.addItem("CELULAR");
        cmbType.addItem("FIXO");
        cmbType.addItem("WHATSAPP");
        lblType = new JLabel("  Tipo:");
        add(lblType);

        add(cmbType);

        cmbCarrier = new JComboBox();
        cmbCarrier.setFont(new Font("Tahoma", Font.PLAIN, 11));
        cmbCarrier.addItem("");
        cmbCarrier.addItem("TIM");
        cmbCarrier.addItem("OI");
        cmbCarrier.addItem("CLARO");
        cmbCarrier.addItem("VIVO");
        cmbCarrier.addItem("OUTRA");
        lblCarrier = new JLabel("  Operadora:");
        add(lblCarrier);
        add(cmbCarrier);

        statusEmployer = new JCheckBox(" Incluir Colaborador inativo");
        //add(statusEmployer);

    }

    public void setDefault() {

        txtNumero.setText("");
        cmbType.setSelectedItem("");
        cmbCarrier.setSelectedItem("");

    }

    private void event() {

//        cmbType.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                if (cmbType.getSelectedItem().toString() == "CELULAR") {
//                    cmbCarrier.setEnabled(true);
//                } else {
//                    cmbCarrier.setEnabled(false);
//                    cmbCarrier.setSelectedItem("");
//
//                }
//            }
//        });
    }

    private void configShow() {

        setLayout(new FlowLayout((FlowLayout.LEFT), 10, 10));
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setMaximumSize(new Dimension(300, 100));

        setSize(300, 75);
        setVisible(true);

        //setLayout(new BorderLayout());
        //setBorder(javax.swing.BorderFactory.createEtchedBorder(1));
        setBorder(BorderFactory.createTitledBorder("Pesquisa"));

    }

}
