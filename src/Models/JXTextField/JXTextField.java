package br.com.gqferreira.JXTextField;

import java.text.Normalizer;
import javax.swing.JTextField;
import javax.swing.text.Document;

/**
 * @author Gustavo Ferreira - www.gqferreira.com.br
 */
@SuppressWarnings("serial")
public class JXTextField extends JTextField {

    private boolean acentos;

    public JXTextField(int maxlenght) {
        this(null, maxlenght, false);
    }

    public JXTextField(int maxlenght, boolean uperCase) {
        this(null, maxlenght, uperCase, true);
    }

    public JXTextField(boolean uperCase, boolean acentos) {
        this(null, 0, uperCase, acentos);
    }

    public JXTextField(int maxlenght, boolean uperCase, boolean acentos) {
        this(null, maxlenght, uperCase, acentos);
    }

    public JXTextField() {
        this(null, 0, false, true);
    }

    public JXTextField(String text, int maxlenght, boolean uperCase) {
        this(null, 0, uperCase, true);
    }

    public JXTextField(String text, int maxlenght, boolean uperCase, boolean acentos) {
        super();
        this.acentos = acentos;
        setDocument(new TextPlainDocument(maxlenght, uperCase));
        this.setText(text);
        
    }

    @Override
    public String getText() {
        try {
            Document model = this.getDocument();
            String text = model.getText(0, model.getLength()).trim();
            if (acentos) {
                return text;
            } else {
                return Normalizer.normalize(text, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
