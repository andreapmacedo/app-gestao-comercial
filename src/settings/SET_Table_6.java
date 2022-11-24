package settings;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
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

/**
 *
 * @author Andre
 */
public class SET_Table_6 {

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
        TableColumnModel modeloDaColuna = table.getColumnModel();

        for (int i = 0; i < table.getColumnCount(); i++) {

            if (table.getColumnName(i).equals("ID")) {
                modeloDaColuna.getColumn(i).setMaxWidth(100);
            } else {
                modeloDaColuna.getColumn(i).setCellRenderer(rendererEsquerda);
            }
        }
    }

    public void loadTableGeneric_AUTO(final JTable table, TableModel model, final int filterType, final int[] jumpColumn, final JTextField contItens, final JTextField x[]) {

        table.setModel(model);

        configRenderers(table);

        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);

        contItens.setText(String.valueOf(Integer.valueOf(table.getRowCount())));

        for (int i = 0; i < x.length; i++) {

            x[i].getDocument().addDocumentListener(new DocumentListener() {

                public void changedUpdate(DocumentEvent e) {

                    setItens(sorter, table, jumpColumn, filterType, contItens, x);
                }

                public void insertUpdate(DocumentEvent e) {

                    setItens(sorter, table, jumpColumn, filterType, contItens, x);
                }

                public void removeUpdate(DocumentEvent e) {

                    setItens(sorter, table, jumpColumn, filterType, contItens, x);
                }

            });

        }

    }

    public void loadTableGeneric_MANUAL(final JTable table, TableModel model, final int filterType, final int[] jumpColumn, final JTextField contItens, final JTextField x[]) {

        table.setModel(model);

        configRenderers(table);

        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);

        contItens.setText(String.valueOf(Integer.valueOf(table.getRowCount())));

        setItens(sorter, table, jumpColumn, filterType, contItens, x);
        
//        for (int i = 0; i < x.length; i++) {
//
//            
//            
//        }
    

}

public void setItens(TableRowSorter<TableModel> sorter, JTable table, final int[] jumpColumn, int filterType, final JTextField z, final JTextField x[]) {

        String[] text = new String[x.length];

        for (int y = 0; y < text.length; y++) {

            text[y] = x[y].getText().toUpperCase();

        }

        multiFilterGeneric(sorter, jumpColumn, filterType, text);

        z.setText(String.valueOf(Integer.valueOf(table.getRowCount())));

    }

    static void multiFilterGeneric(TableRowSorter<TableModel> sorter, final int[] jumpColumn, int filterType, String... texto) {

        RowFilter<TableModel, Object> firstFiler = null;
        List<RowFilter<TableModel, Object>> filters = new ArrayList<RowFilter<TableModel, Object>>();

        RowFilter<TableModel, Object> compoundRowFilter = null;

        int iColumn = -1;

        for (int i = 0; i < texto.length; i++) {
            try {

                iColumn++;

                for (int y = 0; y < jumpColumn.length; y++) {

                    if (jumpColumn[y] == i) {

                        iColumn++;

                    }

                }

                if (filterType == 0) {
                    firstFiler = RowFilter.regexFilter(texto[i], iColumn);
                } else {
                    firstFiler = RowFilter.regexFilter("^" + texto[i], iColumn);
                }

                filters.add(firstFiler);
                compoundRowFilter = RowFilter.andFilter(filters); // you may also choose the OR filter

            } catch (java.util.regex.PatternSyntaxException e) {
                return;
            }
            sorter.setRowFilter(compoundRowFilter);

        }

    }

}
