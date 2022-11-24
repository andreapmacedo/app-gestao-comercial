package old;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EMP_GNE_PNL_SelectedIten extends JPanel {

    public JButton cmdInformations;
    public JTextField txtID, txtIdentify;

    public EMP_GNE_PNL_SelectedIten() {

        configShow();
        initComps();

    }

    private void initComps() {

        cmdInformations = new javax.swing.JButton();
        cmdInformations.setText("Informações");
        cmdInformations.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/info31.png")));
        
        txtIdentify = new JTextField(35);
        txtIdentify.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdentify.setFont(new java.awt.Font("Tahoma", 1, 16));
        txtIdentify.setForeground(new java.awt.Color(150, 150, 150));
        txtIdentify.setEditable(false);

        txtID = new JTextField(8);
        txtID.setFont(new java.awt.Font("Tahoma", 1, 16));
        //txtID.setBackground(new java.awt.Color(255, 255, 239));
        txtID.setForeground(new java.awt.Color(150, 150, 150));
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtID.setEditable(false);

        cmdInformations.setVisible(false);

        add(txtID);
        add(txtIdentify);
        add(cmdInformations);

    }

    private void configShow() {
        

        setLayout( new FlowLayout(0, 20, 10));
        //setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setBorder(BorderFactory.createTitledBorder("Colaborador"));
        
    }

}
