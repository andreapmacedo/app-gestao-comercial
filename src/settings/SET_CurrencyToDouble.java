/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Andre
 */
public class  SET_CurrencyToDouble {

    String valor;
    
    
    
    public SET_CurrencyToDouble(String valor) {
    
        this.valor = valor;
    
    }
    
    
    
    
//    
//    
//        public double getDouble() {
//        if (this.length() == 1 && this.getText().indexOf("-") >= 0) {
//            return 0;
//        }
//        final char decimalSeparator = (((DecimalFormat) NumberFormat.getCurrencyInstance(Locale.getDefault())).getDecimalFormatSymbols()).getDecimalSeparator();
//        if (decimalSeparator == ',') {
//            return this.getText().isEmpty() ? 0 : Double.parseDouble(this.getText().replace(".", "").replace(",", "."));
//        } else {
//            return this.getText().isEmpty() ? 0 : Double.parseDouble(this.getText().replace(",", ""));
//        }
//    }
    
    
}
