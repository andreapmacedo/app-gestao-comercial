package components.cmd;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CMP_BasicCRUD extends JPanel {

    public JButton cmdEdit, cmdExclude, cmdAll, cmdInformations, cmdAdd, cmdClean, cmdCancel, cmdConfirm;

    Dimension defaultDim = new Dimension(130, 25);

    public CMP_BasicCRUD() {

        configShow();
        initComps();

    }

    private void initComps() {

        cmdEdit = new JButton();
        cmdEdit.setText("Editar");
        cmdEdit.setEnabled(false);
        cmdEdit.setPreferredSize(defaultDim);

        cmdExclude = new JButton();
        cmdExclude.setText("Excluir");
        cmdExclude.setEnabled(false);
        cmdExclude.setPreferredSize(defaultDim);

        cmdAll = new JButton();
        cmdAll.setText("Exibir Todos");
        cmdAll.setPreferredSize(defaultDim);

        cmdAdd = new JButton();
        cmdAdd.setText("Adicionar");
        cmdAdd.setPreferredSize(defaultDim);

        cmdClean = new JButton();
        cmdClean.setText("Limpar");
        cmdClean.setPreferredSize(defaultDim);

        cmdCancel = new JButton();
        cmdCancel.setText("Cacelar");
        cmdCancel.setPreferredSize(defaultDim);

        cmdConfirm = new JButton();
        cmdConfirm.setText("Confirmar");
        cmdConfirm.setPreferredSize(defaultDim);

        cmdInformations = new JButton();
        cmdInformations.setText("Informações");
        cmdInformations.setPreferredSize(defaultDim);
        cmdInformations.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/info31.png")));
        cmdInformations.setVisible(false);

       // setDefaultDimension(this.getComponents());

        add(cmdAdd);
        add(cmdEdit);
        add(cmdExclude);
        add(cmdAll);
        add(cmdInformations);

    }

    private void setDefaultDimension(java.awt.Component[] cpcount) {

        for (int i = 0; i < cpcount.length; i++) {
            System.out.println("oiiiiiiiiiiiiiii");

            if (cpcount[i] instanceof JButton) {

                cpcount[i].setPreferredSize(defaultDim);
            }

        }

    }

    private void configShow() {

        //setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setLayout(new FlowLayout(FlowLayout.LEFT));

    }

}
