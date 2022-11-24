package components.cmd;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 *
 * @author Andre
 */
public class CMP_TBL_ConfigFilter extends JPanel {

    public JButton cmdClean, cmdSerch;
    public JComboBox cmbFilter_FullPart, cmbFilter_AutoMan;

    public int index_Filter_FullPart = 0;
    public int index_Filter_AutoMan = 0;

    Dimension defaultDim = new Dimension(100, 25);
    
    public CMP_TBL_ConfigFilter() {

        configShow();
        initComps();
        event();

    }

    private void initComps() {

        cmdClean = new JButton();
        cmdClean.setText("Limpar");
        cmdClean.setPreferredSize(defaultDim);
        cmdSerch = new JButton();
        cmdSerch.setText("Pesquisar");
        cmdSerch.setPreferredSize(defaultDim);

        BasicComboBoxRenderer.UIResource UIResource = new BasicComboBoxRenderer.UIResource();
        UIResource.setHorizontalAlignment(SwingConstants.CENTER);

        cmbFilter_FullPart = new JComboBox();
        cmbFilter_FullPart.setFont(new Font("Tahoma", Font.PLAIN, 13));
        cmbFilter_FullPart.setRenderer(UIResource);
        cmbFilter_FullPart.addItem("Contendo");
        cmbFilter_FullPart.addItem("Começando");

        cmbFilter_AutoMan = new JComboBox();
        cmbFilter_AutoMan.setFont(new Font("Tahoma", Font.PLAIN, 13));
        cmbFilter_AutoMan.setRenderer(UIResource);
        cmbFilter_AutoMan.addItem("Atualização Automática");
        cmbFilter_AutoMan.addItem("Atualização Manual");

        //cmdSerch.setEnabled(false);
     
       // setDefaultDimension(this.getComponents());
        add(cmbFilter_FullPart);
        //add(cmbFilter_AutoMan);
        add(cmdSerch);
        add(cmdClean);

    }
    
        private void setDefaultDimension(java.awt.Component[] cpcount) {

        for (int i = 0; i < cpcount.length; i++) {

            if (cpcount[i] instanceof JButton) {

                cpcount[i].setPreferredSize(defaultDim);
            }

        }

    }

    private void event() {

//        cmbFilter_FullPart.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                index_Filter_FullPart = cmbFilter_FullPart.getSelectedIndex();
//
//            }
//        });
//        cmbFilter_AutoMan.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                index_Filter_AutoMan = cmbFilter_AutoMan.getSelectedIndex();
//
//                
//                if (index_Filter_AutoMan == 0) {
//                    cmdSerch.setEnabled(false);
//                } else {
//                    cmdSerch.setEnabled(true);
//                    cmdSerch.doClick();
//                }
//            }
//        });
//        cmdSerch.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                index_Filter_FullPart = cmbFilter_FullPart.getSelectedIndex();
//                index_Filter_AutoMan = cmbFilter_AutoMan.getSelectedIndex();
//            }
//        });
    }

    private void configShow() {

        setLayout(new FlowLayout(FlowLayout.LEFT));
        //setBorder(javax.swing.BorderFactory.createEtchedBorder(1));
        // setBorder(BorderFactory.createTitledBorder("Pesquisa"));

    }

}
