package br.com.gqferreira.JXTextField;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * @author Gustavo Ferreira - www.gqferreira.com.br
 */
@SuppressWarnings("serial")
class TextPlainDocument extends PlainDocument {

    private int maxSize;
    private boolean uperCase;

    public TextPlainDocument(int limit, boolean uperCase) {
        this.maxSize = limit;
        this.uperCase = uperCase;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException, java.lang.NumberFormatException {
        if (((getLength() + str.length()) <= this.maxSize) || this.maxSize == 0) {
            super.insertString(offs, this.uperCase ? str.toUpperCase() : str, a);
        }
    }
}
