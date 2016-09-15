package Old;

import Settings.DateLabelFormatter;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javafx.scene.control.DatePicker;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class CMP_EMP_BasicInfo extends JPanel {

    Container pane;

    public JTextField txtRegistros,
            txtID, txtDataRegistro, txtIdentificacao, extra;

    private JLabel lblRegistros,
            lblCod, lblDataRegistro, lblIdentificacao;
    
    final JDatePickerImpl datePicker;

    public CMP_EMP_BasicInfo() throws ParseException {

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

        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        //txtDataRegistro = new JFormattedTextField(new MaskFormatter("##-##-####"));
        pane = new Container();
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;

        lblCod = new JLabel("ID: ");
        pane.add(lblCod, c);

        c.gridx = 1;
        txtID = new JTextField(6);
        pane.add(txtID, c);

        c.insets = new Insets(0, 5, 0, 0);
        c.gridx = 2;
        lblDataRegistro = new JLabel("Data do Registro: ");
        pane.add(lblDataRegistro, c);

        c.insets = new Insets(0, 0, 0, 0);
        c.gridx = 3;
        pane.add(datePicker, c);

        c.insets = new Insets(5, 0, 0, 0);
        c.gridx = 0;
        c.gridy = 1;
        lblIdentificacao = new JLabel("Identificação: ");
        pane.add(lblIdentificacao, c);

        c.gridwidth = 3;
        c.gridx = 1;
        txtIdentificacao = new JTextField(30);
        pane.add(txtIdentificacao, c);

        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(0, 50, 0, 0);
        c.gridwidth = 1;
        c.gridheight = 2;
        c.gridx = 4;
        c.gridy = 0;
        lblRegistros = new JLabel("Registros: ");
        pane.add(lblRegistros, c);

        c.insets = new Insets(0, 0, 0, 0);
        c.gridx = 5;
        txtRegistros = new JTextField(8);
        txtRegistros.setEnabled(false);
        txtRegistros.setFont(new java.awt.Font("Tahoma", 1, 24));
        txtRegistros.setForeground(new java.awt.Color(51, 51, 255));
        txtRegistros.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pane.add(txtRegistros, c);
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
