
package Components.CMD;


import java.awt.Dimension;
import javax.swing.JButton;



public class CMP_CMD_MasterCrud extends javax.swing.JPanel {


    public JButton cmdConfirm, cmdCancel;
    
    //Dimension defaultDim = new Dimension(24, 155);

    public CMP_CMD_MasterCrud() {

        initComponets();

    }

    private void initComponets() {

        Dimension btmPreferedSize = (new Dimension(123, 63));
        Dimension btmMinimumSize = btmPreferedSize;
        Dimension btmMaximumSize = btmPreferedSize;

//        setLayout(new FlowLayout(FlowLayout.LEFT));
//        FlowLayout layout = new FlowLayout(1, 20, 10);
//        this.setLayout(layout);

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cmdConfirm = new JButton();
        cmdConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add32x32G.png"))); // NOI18N
        cmdConfirm.setText("Confirmar");
        //cmdSeach.setMaximumSize(btmMaximumSize);
        //cmdSeach.setMinimumSize(btmMinimumSize);
        cmdConfirm.setPreferredSize(btmPreferedSize);

        cmdCancel = new JButton();
        cmdCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icn_C_Cancel_32x32.png"))); // NOI18N
        cmdCancel.setText("Cancelar");
        //cmdAdd.setMaximumSize(btmMaximumSize);
        //cmdAdd.setMinimumSize(btmMinimumSize);
        cmdCancel.setPreferredSize(btmPreferedSize);

        //cmdSeach.requestFocus();
        add(cmdConfirm);
        add(cmdCancel);

    }

}
