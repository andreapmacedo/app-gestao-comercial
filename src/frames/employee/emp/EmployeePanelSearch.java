package frames.employee.emp;

import java.awt.FlowLayout;
import javax.swing.BorderFactory;

public class EmployeePanelSearch extends EmployeeComponents {

    public EmployeePanelSearch() {
        configPanel();
        buildPanel();
    }

    @Override
    void setSubEpecificFeatures() {

    }

    @Override
    void buildPanel() {

        add(lbl.get(0), c);
        add(txf.get(0), c);
        c.gridy = 1;
        add(lbl.get(1), c);
        add(txf.get(1), c);
        c.gridy = 2;
        add(lbl.get(2), c);
        //  c.gridwidth = 2;
        add(cmb.get(0), c);

        // add(p);
    }

    @Override
    void setDefault() {
    }

    @Override
    void loadCmbs() {
    }

    @Override
    void events() {
    }

    @Override
    void configPanel() {

//        setLayout(new GridBagLayout());
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
//        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setBorder(BorderFactory.createTitledBorder("Pesquisar"));
    }

}
