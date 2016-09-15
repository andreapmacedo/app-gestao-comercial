/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Andre
 */
public class DatePicker {

    final JDatePickerImpl datePicker;

    private JTextField tst;

    public DatePicker(JTextField tst) {

        this.tst = tst;

        UtilDateModel model = new UtilDateModel();
        Properties pp = new Properties();

        pp.put("text.today", "Hoje");
        pp.put("text.month", "Mês");
        pp.put("text.year", "Ano");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, pp);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        events();
    }

    private void events() {

        datePicker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Date c = (Date) datePicker.getModel().getValue();
                SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
                String a = s.format(c);
                tst.setText(a);
                System.out.println("data = " + a);

                //txtDataRegistro.setText(formatador.format((Date) datePicker.getModel().getValue())); 
            }
        }
        );
    }

}
