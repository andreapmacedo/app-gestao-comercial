/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class SET_Table_3 {

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

    public void loadTableGeneric(final JTable table, TableModel model, final int jumpC[],final JTextField... x) {

        table.setModel(model);

        configRenderers(table);

 
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);

        x[0].setText(String.valueOf(Integer.valueOf(table.getRowCount()))); // esse é por definção o textf do número de itens

        for (int i = 0; i < x.length - 1; i++) {

            x[i + 1].getDocument().addDocumentListener(new DocumentListener() {

                public void changedUpdate(DocumentEvent e) {

                    String[] a = new String[x.length - 1];

                    for (int y = 0; y < a.length; y++) {

                        a[y] = x[y + 1].getText().toUpperCase();

                    }

                    multiFilterGeneric(sorter, jumpC, a);

                    x[0].setText(String.valueOf(Integer.valueOf(table.getRowCount())));

                }

                public void insertUpdate(DocumentEvent e) {

                    String[] a = new String[x.length - 1];

                    for (int y = 0; y < a.length; y++) {

                        a[y] = x[y + 1].getText().toUpperCase();

                    }

                    multiFilterGeneric(sorter, jumpC, a);

                    x[0].setText(String.valueOf(Integer.valueOf(table.getRowCount())));
                }

                public void removeUpdate(DocumentEvent e) {

                    String[] a = new String[x.length - 1];

                    for (int y = 0; y < a.length; y++) {

                        a[y] = x[y + 1].getText().toUpperCase();

                    }
                    multiFilterGeneric(sorter, jumpC, a);

                    x[0].setText(String.valueOf(Integer.valueOf(table.getRowCount())));
                }

            });

        }

    }

    static void multiFilterGeneric(TableRowSorter<TableModel> sorter, final int[] jumpColumn, String... texto) {

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

                firstFiler = RowFilter.regexFilter(texto[i], iColumn);
                filters.add(firstFiler);
                compoundRowFilter = RowFilter.andFilter(filters); // you may also choose the OR filter
            } catch (java.util.regex.PatternSyntaxException e) {
                return;
            }
            sorter.setRowFilter(compoundRowFilter);

        }

    }

    

    static void multiFilter(int colunaA, int colunaB, String textoA, String textoB, TableRowSorter<TableModel> sorter) {

        RowFilter<TableModel, Object> firstFiler = null;
        RowFilter<TableModel, Object> secondFilter = null;
        List<RowFilter<TableModel, Object>> filters = new ArrayList<RowFilter<TableModel, Object>>();
        RowFilter<TableModel, Object> compoundRowFilter = null;
        try {
            firstFiler = RowFilter.regexFilter(textoA, colunaA);
            secondFilter = RowFilter.regexFilter(textoB, colunaB);
            filters.add(firstFiler);
            filters.add(secondFilter);
            compoundRowFilter = RowFilter.andFilter(filters); // you may also choose the OR filter
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(compoundRowFilter);

    }
}
