/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.tables;

import entities.Employees;
import settings.SET_Table_5;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.EmployerDAO;


/**
 *
 * @author Andre
 */
public class CMP_GEN_Table_1 extends JPanel {

    public JTable tableBasicInfo;

    public JScrollPane scrollPane1;

    public JPanel pnlTable1;

    public JLabel lblRegistros;

    public JTextField txtRegistros;
    
    private boolean stype;

    private EmployerDAO employerDAO;

    private JTextField[] jtfSerchItens;

    public CMP_GEN_Table_1(final boolean switchType, final JTextField... jtsSerchItens) throws SQLException {

        this.stype = switchType;
        
        jtfSerchItens = new JTextField[jtsSerchItens.length];

        for (int i = 0; i < jtsSerchItens.length; i++) {

            jtfSerchItens[i] = jtsSerchItens[i];

        }

        initComponents();
    }

    private void initComponents() throws SQLException {

        setLayout(new BorderLayout());
        //setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblRegistros = new JLabel("Registros: ");

        txtRegistros = new JTextField(8);
        txtRegistros.setEnabled(false);
        txtRegistros.setFont(new java.awt.Font("Tahoma", 1, 24));
        txtRegistros.setForeground(new java.awt.Color(51, 51, 255));
        txtRegistros.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        JPanel intPanel1;

        intPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        intPanel1.add(lblRegistros);
        intPanel1.add(txtRegistros);

        loadTableBasicInfo();
        scrollPane1 = new JScrollPane();
        scrollPane1.setViewportView(tableBasicInfo);
        pnlTable1 = new JPanel(new GridLayout(2, 1));
        pnlTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlTable1.add(scrollPane1);
        pnlTable1.add(intPanel1);
        add(pnlTable1);

    }
    
    
    

    private void loadTableBasicInfo() throws SQLException {

        employerDAO = new EmployerDAO();
        List<Employees> list = new ArrayList(employerDAO.get_All_Entity_OrderByItemName());
        int[] jumpColumn = new int[0]; //n colunas q vai pular  
        String[] columnNames = employerDAO.columnNames;
        DefaultTableModel model = new DefaultTableModel(EmployerDAO.preencherTabela(list), columnNames);

        tableBasicInfo = new JTable(model);

        SET_Table_5 configT = new SET_Table_5();

        configT.loadTableGeneric(tableBasicInfo, model, jumpColumn, stype , this.txtRegistros, jtfSerchItens);

    }

    
}
