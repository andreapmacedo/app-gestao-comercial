package Tables;

import DAO.EmployerPhoneDAO;
import Entidades.Employers;
import Entidades.EmployersPhone;
import Frames.Employers.EMP_INFO;
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

public class EMP_PHONE_Table {

    private Employers item = new Employers();
    public JTable table;
    public DefaultTableModel model;
    private EmployerPhoneDAO itemDAO;
    private String[] columnNames = {"ID", "NUMERO", "TIPO", "OPERADORA"};
    private List<EmployersPhone> list;

    public EMP_PHONE_Table(JTable table) throws SQLException {

        this.table = table;

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

    public void loadTable() throws SQLException {

        itemDAO = new EmployerPhoneDAO();

        list = new ArrayList(itemDAO.Select_idFK(EMP_INFO.idEmployer));
        model = new DefaultTableModel(itemDAO.populateTable_2(list), columnNames);

        table.setModel(model);
        configRenderers(table);

    }

    public void reloadTable(final JTextField contItens, ArrayList attr, ArrayList fieldsFilter) throws SQLException {

        System.out.println("dentro do reload o idfk: " + EMP_INFO.idEmployer);

   //     list = new ArrayList(itemDAO.(EMP_INFO.idEmployer, attr, fieldsFilter));
        
        
//                for (int i = 0; i < fieldsFilter.size(); i++) {
//                    System.out.println(""+attr.get(i));
//                    System.out.println(""+fieldsFilter.get(i));
//        }
        
                itemDAO = new EmployerPhoneDAO();
        
       list = new ArrayList(itemDAO.select_Filter(EMP_INFO.idEmployer, attr, fieldsFilter));
       

        model = new DefaultTableModel(itemDAO.populateTable_2(list), columnNames);

        table.setModel(model);
        configRenderers(table);
        contItens.setText(String.valueOf(Integer.valueOf(table.getRowCount())));
    }

}
