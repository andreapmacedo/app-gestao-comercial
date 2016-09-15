package Components.CMD;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CMP_TBL_SelectedIten extends JPanel {

    public JLabel lblRegistros, lblSelectedIten;
    public JTextField txtRegistros, txtSelectedItem;
    public String idSelectedRow;

    public CMP_TBL_SelectedIten() {

        configShow();
        initComps();
    }

    private void initComps() {
        lblRegistros = new JLabel("Total de Registros: ");
        txtRegistros = new JTextField(6);
        txtRegistros.setEditable(false);
        txtRegistros.setFont(new java.awt.Font("Tahoma", 1, 12));
        txtRegistros.setForeground(new java.awt.Color(150, 150, 150));
        txtRegistros.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblSelectedIten = new JLabel("Item Selecionado: ");
        txtSelectedItem = new JTextField(35);
        txtSelectedItem.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtSelectedItem.setFont(new java.awt.Font("Tahoma", 1, 12));
        txtSelectedItem.setBackground(new java.awt.Color(221, 241, 255));
        txtSelectedItem.setForeground(new java.awt.Color(0, 0, 200));

        txtSelectedItem.setEditable(false);

        add(lblRegistros);
        add(txtRegistros);
        add(lblSelectedIten);
        add(txtSelectedItem);

    }

    private void configShow() {

        setLayout(new FlowLayout(FlowLayout.LEFT, 8, 8));

    }

}
