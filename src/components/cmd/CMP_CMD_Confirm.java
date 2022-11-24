
package components.cmd;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;


public class CMP_CMD_Confirm extends JPanel {

    public JButton cmdEdit, cmdClean, cmdCancel, cmdConfirm;
    
    Dimension defaultDim = new Dimension(120, 25);

    public CMP_CMD_Confirm() {

        configShow();
        initComps();
        setDefault();
        event();

    }

    private void initComps() {

        cmdEdit = new JButton();
        cmdEdit.setText("Editar");

        cmdClean = new JButton();
        cmdClean.setText("Limpar");

        cmdCancel = new JButton();
        cmdCancel.setText("Cacelar");

        cmdConfirm = new JButton();
        cmdConfirm.setText("Confirmar");

    }

    public void setDefault() {

        removeAll();
        add(cmdEdit);
        this.setVisible(false);
        this.setVisible(true);
        setDefaultDimension(this.getComponents());

    }

    public void editConfig() {

        removeAll();

        add(cmdConfirm);
        add(cmdClean);
        add(cmdCancel);
        this.setVisible(false);
        this.setVisible(true);
        setDefaultDimension(this.getComponents());

    }
    
        private void setDefaultDimension(java.awt.Component[] cpcount) {

        for (int i = 0; i < cpcount.length; i++) {
            if (cpcount[i] instanceof JButton) {
                cpcount[i].setPreferredSize(defaultDim);
            }

        }

    }

    private void event() {

        cmdEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editConfig();
            }
        });

        cmdConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDefault();
            }
        });
//        cmdClean.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setDefault();
//            }
//        });
        cmdCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDefault();
            }
        });

    }

    private void configShow() {

        setLayout(new FlowLayout(FlowLayout.LEFT));

    }

}
