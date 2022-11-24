package components.registers;

import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SetComponents {


    public ArrayList<JLabel> lblList(String[] itens) {

        ArrayList<JLabel> label = new ArrayList<JLabel>();
        for (String iten : itens) {
            label.add(new JLabel(iten));
            //System.out.println("iten "+iten);
        }
        return label;

    }

    public ArrayList<JTextField> txfList(String[] itens) {

        ArrayList<JTextField> txf = new ArrayList<JTextField>();
        for (String iten : itens) {
            txf.add(new JTextField(iten));
        }
        return txf;

    }

    public ArrayList<JTextField> txfList(String[] itens, int... width) {

        ArrayList<JTextField> txf = new ArrayList<JTextField>();

        for (int i = 0; i < itens.length; i++) {
            txf.add(new JTextField(itens[i], width[i]));
            //  txf[i].setName(("txf" + itens[i]).replace(":", "").replace(" ", ""));
        }
        return txf;

    }

    public ArrayList<JComboBox> cmbList(String[] itens) {

        ArrayList<JComboBox> cmb = new ArrayList<JComboBox>();
        for (String iten : itens) {
            cmb.add(new JComboBox());
        }
        return cmb;

    }

    public ArrayList<JCheckBox> chbList(String[] itens) {

        ArrayList<JCheckBox> chb = new ArrayList<JCheckBox>();
        for (String iten : itens) {
            chb.add(new JCheckBox(iten));
        }
        return chb;

    }



}
