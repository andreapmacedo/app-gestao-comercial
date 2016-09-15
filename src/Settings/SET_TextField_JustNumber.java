package Settings;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


public class SET_TextField_JustNumber extends PlainDocument {

    

    @Override
public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
    if (str == null)
        return;
    
    try {
        Integer.parseInt(str);
    } catch (Exception e) {
        return;
    }
    
    super.insertString(offset, str, attr);
}
}

    
    
