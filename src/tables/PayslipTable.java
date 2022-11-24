package tables;

import entities.PayStub;

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

import dao.PayStubDAO;

public class PayslipTable {

    private PayStub iten = new PayStub();
    public JTable table;
    public DefaultTableModel model;
    private PayStubDAO itemDAO;
    private final String[] columnNames = {"COD", "DESCRIÇÃO", "Vr. REF.", "REFERÊNCIA", "VENCIMENTO", "DESCONTO", "INCIDÊNCIA"};
    private List<PayStub> list;

    public PayslipTable(JTable table, String idFk) throws SQLException {

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

            //columnModel.getColumn(0).setMinWidth(150);
            columnModel.getColumn(0).setMaxWidth(70);
            columnModel.getColumn(0).setCellRenderer(rendererCentro);
            //columnModel.getColumn(1).setMaxWidth(150);
            columnModel.getColumn(1).setMinWidth(150);
            columnModel.getColumn(1).setCellRenderer(rendererEsquerda);
            columnModel.getColumn(2).setMaxWidth(150);
            columnModel.getColumn(2).setMinWidth(70);
            columnModel.getColumn(2).setCellRenderer(rendererCentro);
            columnModel.getColumn(3).setMaxWidth(150);
            columnModel.getColumn(3).setMinWidth(150);
            columnModel.getColumn(3).setCellRenderer(rendererCentro);
            columnModel.getColumn(4).setMaxWidth(150);
            columnModel.getColumn(4).setMinWidth(150);
            columnModel.getColumn(4).setCellRenderer(rendererCentro);
            columnModel.getColumn(5).setMaxWidth(150);
            columnModel.getColumn(5).setMinWidth(150);
            columnModel.getColumn(5).setCellRenderer(rendererCentro);
            columnModel.getColumn(6).setMaxWidth(150);
            columnModel.getColumn(6).setMinWidth(150);
            columnModel.getColumn(6).setCellRenderer(rendererCentro);

        }
    }

//    public void loadTable() throws SQLException {
//
//        itemDAO = new HoleriteDAO();
//
//        list = new ArrayList(itemDAO.select_Inner());
//        model = new DefaultTableModel(itemDAO.populateTable_2(list), columnNames);
//
//        table.setModel(model);
//        configRenderers(table);
//
//    }
//
//    public void reloadTable(boolean statusEmp, final JTextField contItens, ArrayList attr, ArrayList fieldsFilter) throws SQLException {
//
//        
//        
//        list = new ArrayList(itemDAO.select_InnerFilter(statusEmp, attr, fieldsFilter));
//
//        model = new DefaultTableModel(itemDAO.populateTable_1(list), columnNames);
//
//        table.setModel(model);
//        configRenderers(table);
//        contItens.setText(String.valueOf(Integer.valueOf(table.getRowCount())));
//    }
    public void loadTable(String idFk) throws SQLException {

        itemDAO = new PayStubDAO();

        list = new ArrayList(itemDAO.Select_By_idFK(Integer.parseInt(idFk)));
        model = new DefaultTableModel(itemDAO.populateTable_1(list), columnNames);

        table.setModel(model);
        configRenderers(table);

    }

    // 
    public void reloadTable(int idFk, final JTextField contItens, ArrayList attr, ArrayList fieldsFilter) throws SQLException {

        list = new ArrayList(itemDAO.select_InnerFilter(idFk, attr, fieldsFilter));

        model = new DefaultTableModel(itemDAO.populateTable_2(list), columnNames);

        table.setModel(model);
        configRenderers(table);
        contItens.setText(String.valueOf(Integer.valueOf(table.getRowCount())));
    }

}
