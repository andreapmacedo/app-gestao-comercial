/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Settings;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFormattedTextField.AbstractFormatter;

/**
 *
 * @author Andre
 */














public class DateLabelFormatter extends AbstractFormatter {
    
    
    
        public String getDataFormatada_String() {  
            SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");  
            String dataFormat = formatador.format(new Date());  
            return dataFormat;  
        } 
    
    
         public Object getDataFormatada_Date() {  
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");  
            String dataFormat = formatador.format(new Date());  
            return dataFormat;  
        }    
    
    
    
    
    
    
    

    private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }

        return "";
    }




private void insertDateStr(String dataStr) throws ParseException, SQLException {  
        // converter para java.util.Date  
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");  
        java.util.Date dataUtil = df.parse(dataStr);  
          
        insertDate(dataUtil);  
    }  
  
    private void insertDate(java.util.Date dataUtil) throws SQLException {  
        // converter de java.util.Date para java.sql.Date  
        java.sql.Date dataJDBC = new java.sql.Date(dataUtil.getTime());  
          
        // converter java.util.Date para String (formato diferente do acima)  
        // idem para java.sql.Date que é uma subclasse do java.util.Date  
        SimpleDateFormat iso = new SimpleDateFormat("yyyy-MM-dd");  
        String dataISO = iso.format(dataUtil);  

    }  
    
    
      
  


    
}