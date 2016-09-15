package Old;

import Components.CMD.CMP_TBL_ConfigFilter;
import Settings.SET_TextField_ID_1;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class OLD_CMP_EMP_BasicInfo_1 extends JPanel {

    //Container pane, pane2;
    private JPanel panel1, panel2;
    
    public JTextField txtID, txtDataRegistro, txtIdentificacao; //tem que ser publuco
    private JLabel lblCod, lblDataRegistro, lblIdentificacao;
    public CMP_TBL_ConfigFilter configFilter;
    private SET_TextField_ID_1 tst;
    public int filterType;
    public int loadType;

    public OLD_CMP_EMP_BasicInfo_1() throws ParseException {

        initComponents();
        event();

    }

    private void initComponents() throws ParseException {

        
        setLayout(new BorderLayout());

        setBorder(javax.swing.BorderFactory.createEtchedBorder());


        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.LEADING));
        
        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));

        lblCod = new JLabel("ID: ");
        panel1.add(lblCod);

        txtID = new JTextField(6);
        panel1.add(txtID);

        lblDataRegistro = new JLabel("Data do Registro: ");
        panel1.add(lblDataRegistro);

        txtDataRegistro = new JTextField(12);
        tst = new SET_TextField_ID_1(txtDataRegistro);
        panel1.add(txtDataRegistro);

        lblIdentificacao = new JLabel("Identificação: ");
        panel1.add(lblIdentificacao);

        txtIdentificacao = new JTextField(30);
        panel1.add(txtIdentificacao);

        configFilter = new CMP_TBL_ConfigFilter();
        panel2.add(configFilter);

        
        add("West", panel1);
        add("East", panel2);
    }

    private void event() {
        
        configFilter.cmdClean.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldsClean(panel1.getComponents());
            }
        });

    }

    private void textFieldsClean(java.awt.Component[] cpcount) {

        for (int i = 0; i < cpcount.length; i++) {
            if (cpcount[i] instanceof JTextField) {
                JTextField field = (JTextField) cpcount[i];
                field.setText(null);
            }
        }
    }

}
