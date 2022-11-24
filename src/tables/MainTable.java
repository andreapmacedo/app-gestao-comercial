package tables;

import entities.Employees;

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

import dao.EmployerDAO;

public class MainTable {

    private Employees item = new Employees();
    public JTable table;
    public DefaultTableModel model;
    private EmployerDAO itemDAO;
    private String[] columnNames;
    private List<Employees> list;

    public MainTable(JTable table, int status) throws SQLException {

        this.table = table;
        loadTable(status);

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
            columnModel.getColumn(1).setMaxWidth(150);
            columnModel.getColumn(1).setMinWidth(150);
            columnModel.getColumn(1).setCellRenderer(rendererCentro);
        }
    }

    public void loadTable(int status) throws SQLException {

        itemDAO = new EmployerDAO();
        columnNames = itemDAO.columnNames;

        loadLists(status);

        table.setModel(model);
        configRenderers(table);

    }

    public void loadLists(int status) throws SQLException {

        if (status == 0) {
            list = new ArrayList(itemDAO.get_All_Entity_StatusFilter(1));
        } else if (status == 1) {
            list = new ArrayList(itemDAO.get_All_Entity_StatusFilter(0));
        }

        model = new DefaultTableModel(itemDAO.preencherTabela(list), columnNames);

    }

    public void reloadTable(int status, final JTextField contItens, ArrayList attr, ArrayList fieldsFilter) throws SQLException {

        list = new ArrayList(itemDAO.get_All_Entity_FullFilter(status, attr, fieldsFilter));

        model = new DefaultTableModel(itemDAO.preencherTabela(list), columnNames);

        table.setModel(model);
        configRenderers(table);
        contItens.setText(String.valueOf(Integer.valueOf(table.getRowCount())));
    }

}
