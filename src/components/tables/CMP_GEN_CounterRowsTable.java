package components.tables;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import settings.ID_Find;

public class CMP_GEN_CounterRowsTable extends JPanel {

    public JTable tableBasicInfo;
    public JScrollPane scrollPaneTable;
    public JPanel pnlHeader, pnlFooter;
    public JLabel lblRegistros, lblSelectedIten;
    public JTextField txtRegistros, txtSelectedItem;
    public JButton cmdInformations;
    public String idSelectedRow;

    private JTable table;

    public CMP_GEN_CounterRowsTable(JTable table) throws SQLException {

        this.table = table;
        configShow();
        initComps();
        event();
    }

    private void initComps() throws SQLException {

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        lblRegistros = new JLabel("Registros: ");
        txtRegistros = new JTextField(6);
        txtRegistros.setEditable(false);
        txtRegistros.setFont(new java.awt.Font("Tahoma", 1, 16));
        // txtRegistros.setBackground(new java.awt.Color(200, 220, 240));
        txtRegistros.setForeground(new java.awt.Color(150, 150, 150));
        txtRegistros.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblSelectedIten = new JLabel("Item Selecionado: ");
        txtSelectedItem = new JTextField(35);
        txtSelectedItem.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtSelectedItem.setFont(new java.awt.Font("Tahoma", 1, 16));
        //txtSelectedItem.setBackground(new java.awt.Color(200, 220, 240));
        txtSelectedItem.setForeground(new java.awt.Color(150, 150, 150));
        txtSelectedItem.setEditable(false);

        cmdInformations = new javax.swing.JButton();
        cmdInformations.setText("Informações");
        cmdInformations.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/info31.png")));
        cmdInformations.setVisible(false);

        pnlFooter = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlFooter.add(lblRegistros);
        pnlFooter.add(txtRegistros);
        // pnlFooter.add(lblSelectedIten);
        pnlFooter.add(txtSelectedItem);
        pnlFooter.add(cmdInformations);

        scrollPaneTable = new JScrollPane();
        scrollPaneTable.setViewportView(table);

        pnlHeader = new JPanel(new GridLayout());
        pnlHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlHeader.add(scrollPaneTable);

        add(pnlHeader, BorderLayout.NORTH);
        add(pnlFooter, BorderLayout.CENTER);

    }

    private void event() {
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {

                int row = table.getSelectedRow();
                if (row != -1) {

                    txtSelectedItem.setText((String) table.getValueAt(row, 2));
                    idSelectedRow = Integer.toString(new ID_Find().ID_PK(table));
                    cmdInformations.setVisible(true);
                

                } else {

                    txtSelectedItem.setText(null);
                    idSelectedRow = null;
                    cmdInformations.setVisible(false);

                }

            }

        });

    }

    private void configShow() {

        setLayout(new BorderLayout());

    }

}
