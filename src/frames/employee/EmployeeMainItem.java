package frames.employee;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import settings.SET_TextField_Date_2;
import settings.SET_TextField_ID_1;

public class EmployeeMainItem extends JPanel {
    
    public JTextField txtID, txtDataRegistro, txtIdentificacao;    
    public JLabel lblCod, lblDataRegistro, lblIdentificacao, lblStatus;
    public JComboBox cmbStatus;
    
    public EmployeeMainItem() throws ParseException {
        
        configShow();
        initComps();
        
        event();
        
    }
    
    private void initComps() throws ParseException {
        
        BasicComboBoxRenderer.UIResource UIResource = new BasicComboBoxRenderer.UIResource();        
        UIResource.setHorizontalAlignment(SwingConstants.CENTER);        
        
        lblCod = new JLabel("ID:");
        
        txtID = new JTextField(6);
        SET_TextField_ID_1 setConf_ID_1 = new SET_TextField_ID_1(txtID);
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        
        lblDataRegistro = new JLabel("  Data do Registro:");
        txtDataRegistro = new JTextField(12);
        txtDataRegistro.setDocument(new SET_TextField_Date_2());
        txtDataRegistro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        
        lblIdentificacao = new JLabel("  Identificação:");
        txtIdentificacao = new JTextField(30);
        
        lblStatus = new JLabel("  Situação:");
        cmbStatus = new JComboBox();
        cmbStatus.setFont(new Font("Tahoma", Font.PLAIN, 11));
        
        cmbStatus.addItem("INATIVO");
        cmbStatus.addItem("ATIVO");
        cmbStatus.setRenderer(UIResource);
        cmbStatus.setSelectedIndex(1);
        
        add(lblCod);
        add(txtID);
        add(lblDataRegistro);
        add(txtDataRegistro);
        add(lblIdentificacao);
        add(txtIdentificacao);
        
        add(lblStatus);
        add(cmbStatus);
        
       setDefault();
        
    }
    
    public void setDefault() {
        
        txtIdentificacao.setText(null);
        
        
    }
    
    private void event() {
        
    }
    
    private void textFieldsClean(java.awt.Component[] cpcount) {

//        for (int i = 0; i < cpcount.length; i++) {
//            if (cpcount[i] instanceof JTextField) {
//                JTextField field = (JTextField) cpcount[i];
//                field.setText(null);
//            }
//        }
    }
    
    private void configShow() {
        
        setLayout(new FlowLayout(FlowLayout.LEFT));
        // setLayout(new BorderLayout());
        //setBorder(javax.swing.BorderFactory.createEtchedBorder(1));
        setBorder(BorderFactory.createTitledBorder("Pesquisa"));


    }
}
