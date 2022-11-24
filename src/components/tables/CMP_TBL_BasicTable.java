/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.tables;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.ListSelectionModel;

/**
 *
 * @author Andre
 */
public class CMP_TBL_BasicTable extends JPanel {

    public JTable tableBasicInfo;
    public JScrollPane scrollPane1;
    public JPanel pnlHeader, pnlFooter;
    public JButton cmdAll;

    private JTable table;

    public CMP_TBL_BasicTable(JTable table) throws SQLException {

        this.table = table;
        configShow();
        initComps();

    }

    private void initComps() {

        cmdAll = new JButton("Exibir Todos");
        pnlFooter = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlFooter.add(cmdAll);

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        scrollPane1 = new JScrollPane();
        scrollPane1.setViewportView(table);

        pnlHeader = new JPanel(new GridLayout());
        pnlHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlHeader.add(scrollPane1);

        add(pnlHeader, BorderLayout.NORTH);
        add(pnlFooter, BorderLayout.CENTER);

    }

    private void configShow() {

        setLayout(new BorderLayout());

    }

}
