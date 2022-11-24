package frames.employee.emp;

import components.tables.GenericTableModel1;
import frames.employee.EmployeeInfo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class EmployeeTable extends GenericTableModel1 {

    EmployeeDAO itemDAO;
    final String[] columnNames = {"COD", "INÍCIO", "TERMINO", "SITUAÇÃO"};


    public EmployeeTable() throws SQLException, ParseException {

        
        initComps();
        setDefault();
        loadTable();

    }

    private void initComps() throws SQLException, ParseException {

        add(pnlHeader, BorderLayout.NORTH);
        add(pnlFooter, BorderLayout.SOUTH);
        add(pnlCenter, BorderLayout.CENTER);
    }

    private void setDefault() {

        cmpCrud.remove(cmpCrud.cmdInformations);
        //genTable.remove(genTable.pnlHeader);
    }

    public void loadTable() throws SQLException {

        ArrayList<String> fieldsFilter = new ArrayList<String>();

//        fieldsFilter.add(cmpItens.txtNumero.getText());
//        fieldsFilter.add(cmpItens.cmbType.getSelectedItem().toString());
//        fieldsFilter.add(cmpItens.cmbCarrier.getSelectedItem().toString());
        //      System.out.println("texto: "+cmpItens.cmbDescription.getSelectedItem());
//        
//        fieldsFilter.add(cmpItens.cmbDescription.getSelectedItem().toString()); //não pode dar null tem q setar nas configurações ""
//        fieldsFilter.add(cmpItens.cmbReference.getSelectedItem().toString());
        // fieldsFilter.add(String.valueOf(Double.parseDouble(cmpItens.txtSalary.getText().replace(',','.'))));
        ArrayList<String> attr = new ArrayList<String>();

//           attr.add("HLD_DESCRIPTION");
//         attr.add("HLR_REFERENCE");
        // attr.add("HOL_VENCIMENTO");
        for (int i = 0; i < fieldsFilter.size(); i++) {
            if (fieldsFilter.get(i).isEmpty()) {
                fieldsFilter.remove(i);
                attr.remove(i);
                i--;
            }
        }

        if (cmpConfigFilter.index_Filter_FullPart == 0) {
            for (int i = 0; i < fieldsFilter.size(); i++) {
                fieldsFilter.set(i, "'%" + fieldsFilter.get(i) + "%'");
            }
        } else {
            for (int i = 0; i < fieldsFilter.size(); i++) {
                fieldsFilter.set(i, "'" + fieldsFilter.get(i) + "%'");
            }
        }

        itemDAO = new EmployeeDAO();

        List<Employee> list;
        list = new ArrayList(itemDAO.select_Filter((EmployeeInfo.idEmployer), attr, fieldsFilter));
        model = new DefaultTableModel(itemDAO.populateTable(list, 1), columnNames);
        table.setModel(model);
        configRenderers(table);

        cmpSelectedIten.txtRegistros.setText(String.valueOf(Integer.valueOf(table.getRowCount())));
    }

    public void configRenderers(JTable table) {

        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);

        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);

        DefaultTableCellRenderer left = new DefaultTableCellRenderer();
        left.setHorizontalAlignment(SwingConstants.LEFT);

        JTableHeader header = table.getTableHeader();
        header.setPreferredSize(new Dimension(0, 30)); //tamanho da barra de titulo

        header.setAlignmentY(SwingConstants.CENTER);
        TableColumnModel columnModel = table.getColumnModel();

//        final int[] columnMinWidth = {150,150,150,150 };
//        final int[] columnMaxWidth = {1,};
//        final DefaultTableCellRenderer[] columnMinWidt = {center, };
//       for (int i = 0; i < table.getColumnCount(); i++) {
//
//            if (table.getColumnName(i).equals("ID")) {
//                columnModel.getColumn(i).setMaxWidth(120);
//                columnModel.getColumn(1).setMinWidth(120);
//            } else {
//                columnModel.getColumn(i).setCellRenderer(left);
//
//            }
//        
//        
//    }
        //Manual
        columnModel.getColumn(0).setMinWidth(30);
        columnModel.getColumn(0).setMaxWidth(70);
        columnModel.getColumn(0).setCellRenderer(center);
        columnModel.getColumn(1).setMaxWidth(150);
        columnModel.getColumn(1).setMinWidth(70);
        columnModel.getColumn(1).setCellRenderer(center);
        columnModel.getColumn(2).setMaxWidth(150);
        columnModel.getColumn(2).setMinWidth(70);
        columnModel.getColumn(2).setCellRenderer(center);
        columnModel.getColumn(3).setMaxWidth(150);
        columnModel.getColumn(3).setMinWidth(70);
        columnModel.getColumn(3).setCellRenderer(center);

    }

}
