package settings;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class SET_TextField_Phone extends PlainDocument {

           @Override
           public void insertString(int off, String string, AttributeSet attr)
                throws BadLocationException {

//            if (off < 15) {
//                if (!Character.isDigit(string.charAt(string.length() - 1))) {
//                    return;
//                } else {
//                    if (off == 0) {
//                        string = "(".concat(string);
//                    }
//                    if (off == 2) {
//                        string = string.concat(")  ");
//                    }
//                    if (off == 4) {
//                        string = string.concat(".");
//                    }
////                     if (off == 5) {
////                        string = string.concat(".");
////                    }
////                     if (off == 7) {
////                        string = string.concat("-");
////                    }
//
//                    super.insertString(off, string, attr);
//                }
//            }
        
                       if (off < 12) {
                if (!Character.isDigit(string.charAt(string.length() - 1))) {
                    return;
                } else {
                    if (off == 2) {
                        string = "-".concat(string);
                    }
//                    if (off == 2) {
//                        string = string.concat(")  ");
//                    }
//                    if (off == 4) {
//                        string = string.concat(".");
//                    }
//                     if (off == 5) {
//                        string = string.concat(".");
//                    }
//                     if (off == 7) {
//                        string = string.concat("-");
//                    }

                    super.insertString(off, string, attr);
                }
            }
           
           }
    }
    

