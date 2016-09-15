/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Old;

import Settings.DateLabelFormatter;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Andre
 */
public class EMP_Basic_Info extends JPanel{
    
        Container pane;

    public JTextField txtRegistros,
            txtID, txtDataRegistro, txtIdentificacao;

    private JLabel lblRegistros,
            lblCod, lblDataRegistro, lblIdentificacao;
    
    final JDatePickerImpl datePicker;

    public EMP_Basic_Info() throws ParseException {

        UtilDateModel model = new UtilDateModel();
        Properties pp = new Properties();

        pp.put("text.today", "Hoje");
        pp.put("text.month", "Mês");
        pp.put("text.year", "Ano");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, pp);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        initComponents();
        events();

    }

    private void initComponents() throws ParseException {

//        setLayout(new FlowLayout(FlowLayout.LEFT));
//        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        //txtDataRegistro = new JFormattedTextField(new MaskFormatter("##-##-####"));
        pane = new Container();
        pane.setLayout(new FlowLayout(FlowLayout.LEFT));
         
        lblCod = new JLabel("ID: ");
        pane.add(lblCod);

        txtID = new JTextField(6);
        pane.add(txtID);

        lblDataRegistro = new JLabel("Data do Registro: ");
        pane.add(lblDataRegistro);

        pane.add(datePicker);
        
        lblIdentificacao = new JLabel("Identificação: ");
        pane.add(lblIdentificacao);

        txtIdentificacao = new JTextField(30);
        pane.add(txtIdentificacao);

        lblRegistros = new JLabel("Registros: ");
        pane.add(lblRegistros);


//        txtRegistros = new JTextField(8);
//        txtRegistros.setEnabled(false);
//        txtRegistros.setFont(new java.awt.Font("Tahoma", 1, 24));
//        txtRegistros.setForeground(new java.awt.Color(51, 51, 255));
//        txtRegistros.setHorizontalAlignment(javax.swing.JTextField.CENTER);
//        pane.add(txtRegistros);
        add(pane);

    }

    private void events() {
        datePicker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Date c = (Date) datePicker.getModel().getValue();
                SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
                String a = s.format(c);
                txtDataRegistro.setText(a);
                System.out.println("data = " + a);

                //txtDataRegistro.setText(formatador.format((Date) datePicker.getModel().getValue())); 
            }
        });
    }
    
    
}
