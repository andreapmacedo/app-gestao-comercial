
package tables;

import entities.Employees;
import entities.EmployeesPhone;

import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import dao.EmployerPhoneDAO;


public class DateTable {
     private Employees item = new Employees();
    public JTable table;
    public DefaultTableModel model;
    private EmployerPhoneDAO itemDAO;
    private String[] columnNames = {"ID", "NUMERO", "TIPO", "OPERADORA"};
    private List<EmployeesPhone> list;

    public DateTable(JTable table, String idFk) throws SQLException {

        this.table = table;
        loadTable(idFk);

    }

    public void configRenderers(JTable table) {

        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);

        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);

        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);

        JTableHeader header = table.getTableHeader();
        header.setPreferredSize(new Dimension(0, 30)); //tamanho da barra de titulo

        header.setAlignmentY(SwingConstants.CENTER);
        TableColumnModel columnModel = table.getColumnModel();

        for (int i = 0; i < table.getColumnCount(); i++) {

            if (table.getColumnName(i).equals("ID")) {
                columnModel.getColumn(i).setMaxWidth(120);
                columnModel.getColumn(1).setMinWidth(120);
            } else {
                columnModel.getColumn(i).setCellRenderer(rendererEsquerda);

            }
            columnModel.getColumn(0).setCellRenderer(rendererCentro);
            // columnModel.getColumn(1).setMaxWidth(150);
            columnModel.getColumn(1).setMinWidth(150);
            columnModel.getColumn(1).setCellRenderer(rendererCentro);
            columnModel.getColumn(2).setMaxWidth(150);
            columnModel.getColumn(2).setMinWidth(150);
            columnModel.getColumn(2).setCellRenderer(rendererCentro);
            columnModel.getColumn(3).setMaxWidth(150);
            columnModel.getColumn(3).setMinWidth(150);
            columnModel.getColumn(3).setCellRenderer(rendererCentro);

        }
    }

    public void loadTable(String idFk) throws SQLException {

        itemDAO = new EmployerPhoneDAO();

        list = new ArrayList(itemDAO.Select_idFK(Integer.parseInt(idFk)));
        model = new DefaultTableModel(itemDAO.populateTable_2(list), columnNames);

        table.setModel(model);
        configRenderers(table);

    }

    public void reloadTable(int idFk, final JTextField contItens, ArrayList attr, ArrayList fieldsFilter) throws SQLException {

        list = new ArrayList(itemDAO.select_Filter(idFk, attr, fieldsFilter));

        model = new DefaultTableModel(itemDAO.populateTable_2(list), columnNames);

        table.setModel(model);
        configRenderers(table);
        contItens.setText(String.valueOf(Integer.valueOf(table.getRowCount())));
    }

}

