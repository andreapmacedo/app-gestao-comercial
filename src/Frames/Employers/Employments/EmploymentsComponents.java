package Frames.Employers.Employments;

import Components.Registers.DefaultComponentsParameters;
import Components.Registers.SetComponents;
import Settings.SET_TextField_Date_2;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;


public abstract class EmploymentsComponents extends DefaultComponentsParameters {

    String[] lblItens = {"Data Inicial:", "Data Final:","Stituação:"};
    String[] txfItens = {"Data Inicial", "Data Final"};
    String[] cmbItens = {"Situação"};
    //String[] chbItens = {"Ativo"};

    ArrayList<JLabel> lbl; //serão declarados publicos na hora de serem instanciados no setcomp
    ArrayList<JTextField> txf;
    ArrayList<JComboBox> cmb;
    ArrayList<JCheckBox> chb;


    public EmploymentsComponents() {
        setComponents();
    }
    

    private void setComponents() {

        SetComponents comp = new SetComponents();
        lbl = comp.lblList(lblItens);
        txf = comp.txfList(txfItens, 20, 20);
        cmb = comp.cmbList(cmbItens);
       // chb = comp.chbList(chbItens);

        setEpecificFeatures();
       // loadcmb;
        // setitens;
    }

    private void setEpecificFeatures() {

        txf.get(0).setDocument(new SET_TextField_Date_2());
        txf.get(1).setDocument(new SET_TextField_Date_2());
        
        txf.get(0).setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txf.get(1).setHorizontalAlignment(javax.swing.JTextField.CENTER);
       
        cmb.get(0).setRenderer(UIResource);
        cmb.get(0).addItem("TODOS");
        cmb.get(0).addItem("ATIVOS");
        cmb.get(0).addItem("INATIVOS");
        cmb.get(0).setPreferredSize(cmbPreferedSize); //new Dimension(150, 20)
        
    }


    abstract void setSubEpecificFeatures();

    abstract void buildPanel();

    abstract void setDefault();

    abstract void loadCmbs();

    abstract void events();

    abstract void configPanel();

}
