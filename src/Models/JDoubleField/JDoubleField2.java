package Models.JDoubleField;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JTextField;

/**
 * @author Gustavo Ferreira - www.gqferreira.com.br
 */
@SuppressWarnings("serial")
public class JDoubleField2 extends JTextField {

    public JDoubleField2(int maxlenght) {
        this(null, maxlenght);
    }

    public JDoubleField2() {
        this(null, 0);
    }

    public JDoubleField2(Double value, int maxlenght) {
        super();
        setDocument(new DoublePlainDocument(maxlenght));
        if (value != null) {
            this.setText(String.valueOf(value.doubleValue()));
        }
    }

    public void setDouble(double value){
        this.setText(String.valueOf(value));    
    }
    
    public double getDouble() {
        if (this.getText().length() == 1 && this.getText().indexOf("-") >= 0) {
            return 0;
        }
        final char decimalSeparator = (((DecimalFormat) NumberFormat.getCurrencyInstance(Locale.getDefault())).getDecimalFormatSymbols()).getDecimalSeparator();
        if (decimalSeparator == ',') {
            return this.getText().isEmpty() ? 0 : Double.parseDouble(this.getText().replace(".", "").replace(",", "."));
        } else {
            return this.getText().isEmpty() ? 0 : Double.parseDouble(this.getText().replace(",", ""));
        }
    }
}
