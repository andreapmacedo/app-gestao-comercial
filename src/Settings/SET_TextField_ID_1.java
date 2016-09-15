/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Settings;

import Old.OLD_CMP_EMP_BasicInfo_1;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Andre
 */
public class SET_TextField_ID_1 {

    JTextField tst;

    public SET_TextField_ID_1(JTextField tst) {
        this.tst = tst;
        event();

    }

    void event() {

        tst.addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent ev) {

                String caracteres = "0987654321";

                if (!caracteres.contains(ev.getKeyChar() + "")) {

                    ev.consume();

                }

            }

        });

    }

}
