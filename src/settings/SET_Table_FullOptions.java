package settings;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class SET_Table_FullOptions {

    String stringField = null;

    int iTemp = 0;
    int column = 0;

        

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
                columnModel.getColumn(i).setMaxWidth(100);
            } else {
                columnModel.getColumn(i).setCellRenderer(rendererEsquerda);

            }
        }
    }

    public void loadTableGeneric(final JTable table, TableModel model, final int index_Filter_AutoMan, final int index_Filter_FullPart, final int[] jumpColumn,
            final JComboBox cmbAutoMan, final JComboBox cmbFullPart, JButton cmdSearch, final JTextField contItens, final JTextField... fieldsItems) {

        System.out.println("loadTableGeneric");

        //Limpando os Listners
        for (ActionListener listener : cmdSearch.getActionListeners()) {
            cmdSearch.removeActionListener(listener);

        }
        
//        for (int i = 0; i < fieldsItems.length; i++) {
//
//            
//            DocumentListener els[] = fieldsItems[i].getListeners(DocumentListener.class);
//                
//            System.out.println("dl"+fieldsItems[i].getListeners(EventListener.class).getClass());
//            
//            
//            for (int y = 0; y < els.length; y++) {
//                System.out.println("achei esse aqui: "+y);
//                fieldsItems[i].getDocument().removeDocumentListener(els[y]);
//            }
//        }

        table.setModel(model);
        configRenderers(table);

        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);

        contItens.setText(String.valueOf(Integer.valueOf(table.getRowCount())));

        if (index_Filter_AutoMan == 0) {

            for (int i = 0; i < fieldsItems.length; i++) {

                fieldsItems[i].getDocument().addDocumentListener(new DocumentListener() {

                    public void changedUpdate(DocumentEvent e) {

                        setItems(sorter, table, jumpColumn, index_Filter_FullPart, contItens, fieldsItems);
                    }

                    public void insertUpdate(DocumentEvent e) {

                        setItems(sorter, table, jumpColumn, index_Filter_FullPart, contItens, fieldsItems);
                    }

                    public void removeUpdate(DocumentEvent e) {

                        setItems(sorter, table, jumpColumn, index_Filter_FullPart, contItens, fieldsItems);

                    }

                });

            }

        } else if (index_Filter_AutoMan == 1) {

            cmdSearch.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    System.out.println("fielditens: " + fieldsItems.length);
                    setItems(sorter, table, jumpColumn, index_Filter_FullPart, contItens, fieldsItems);
                }
            });
        }
        
//     
        table.changeSelection(table.getRowCount() - 1, table.getColumnCount() - 1, true, true);
        
    }

    public void setItems(TableRowSorter<TableModel> sorter, JTable table, final int[] jumpColumn, int index_Filter_FullPart, final JTextField contItems, final JTextField[] fieldsItems) {

        String[] ColunmItens = new String[fieldsItems.length];

        for (int y = 0; y < ColunmItens.length; y++) {
            ColunmItens[y] = fieldsItems[y].getText().toUpperCase();
        }

        multiFilterGeneric(sorter, table, jumpColumn, index_Filter_FullPart, ColunmItens);
        contItems.setText(String.valueOf(Integer.valueOf(table.getRowCount())));

    }

    static void multiFilterGeneric(TableRowSorter<TableModel> sorter, JTable table, final int[] jumpColumn, int index_Filter_FullPart, String... ColumSearch) {

        RowFilter<TableModel, Object> firstFiler = null;
        List<RowFilter<TableModel, Object>> filters = new ArrayList<RowFilter<TableModel, Object>>();

        RowFilter<TableModel, Object> compoundRowFilter = null;
        int iColumn = -1;
        for (int i = 0; i < ColumSearch.length; i++) {
            try {

                iColumn++;

                for (int y = 0; y < jumpColumn.length; y++) {

                    if (jumpColumn[y] == iColumn) {
                        iColumn++;

                    }
                }
                if (index_Filter_FullPart == 0) {
                    firstFiler = RowFilter.regexFilter(ColumSearch[i], iColumn);
                } else {
                    firstFiler = RowFilter.regexFilter("^" + ColumSearch[i], iColumn);
                }

                filters.add(firstFiler);
                compoundRowFilter = RowFilter.andFilter(filters);

            } catch (java.util.regex.PatternSyntaxException e) {
                return;
            }
            sorter.setRowFilter(compoundRowFilter);
            
            System.out.println("readTableItens");

        }

    }

}
