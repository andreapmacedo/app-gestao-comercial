/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Andre
 */
public class SET_TextField_Date_2 extends PlainDocument {

    public void insertString(int off, String string, AttributeSet attr)  throws BadLocationException {
           

        if (off < 10) {
            if (!Character.isDigit(string.charAt(string.length() - 1))) {
                return;
            } else {
                if (off == 2) {
                    string = "-".concat(string);
                }
                if (off == 4) {
                    string = string.concat("-");
                }
                super.insertString(off, string, attr);
            }
        }
    }
}
