/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Andre
 */
public class GNE_TABLE_1 extends JPanel {

    public JTable tableBasicInfo;
    public JScrollPane scrollPane1;
    public JPanel pnlTable1;
    public JLabel lblRegistros;
    public JTextField txtRegistros;

    private JTable table;
    private DefaultTableModel model;
    private int filterType;
    private int[] jumpColumn;
    private JTextField[] textFields;

    public GNE_TABLE_1(final JTable table, TableModel model, int filterType, final int[] jumpColumn, final JTextField... textFields) throws SQLException {

        this.table = table;
        this.model = (DefaultTableModel) model;
        this.filterType = filterType;
        this.jumpColumn = jumpColumn;
        this.textFields = new JTextField[textFields.length];

        for (int i = 0; i < textFields.length; i++) {
            this.textFields[i] = textFields[i];
        }

        initComponents();

    }

    private void initComponents() throws SQLException {

        setLayout(new BorderLayout());
        setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        loadTable(1, table, model, filterType, jumpColumn, txtRegistros, textFields);
        
        scrollPane1 = new JScrollPane();
        scrollPane1.setViewportView(table);
        pnlTable1 = new JPanel(new GridLayout(2, 1));
        pnlTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlTable1.add(scrollPane1);
        pnlTable1.add(intPanel1);
        add(pnlTable1);
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
        TableColumnModel modeloDaColuna = table.getColumnModel();

        for (int i = 0; i < table.getColumnCount(); i++) {

            if (table.getColumnName(i).equals("ID")) {
                modeloDaColuna.getColumn(i).setMaxWidth(100);
            } else {
                modeloDaColuna.getColumn(i).setCellRenderer(rendererEsquerda);
            }
        }

    }

    public void loadTableGeneric_AUTO(final JTable table, TableModel model, final int index_Filter_FullPart, final int[] jumpColumn, final JTextField contItens, final JTextField x[]) {

        System.out.println("loadtable_AUTO");

        table.setModel(model);

        configRenderers(table);

        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);

        contItens.setText(String.valueOf(Integer.valueOf(table.getRowCount())));

        for (int i = 0; i < x.length; i++) {

            x[i].getDocument().addDocumentListener(new DocumentListener() {

                public void changedUpdate(DocumentEvent e) {

                    setItens(sorter, table, jumpColumn, index_Filter_FullPart, contItens, x);
                }

                public void insertUpdate(DocumentEvent e) {

                    setItens(sorter, table, jumpColumn, index_Filter_FullPart, contItens, x);
                }

                public void removeUpdate(DocumentEvent e) {

                    setItens(sorter, table, jumpColumn, index_Filter_FullPart, contItens, x);
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

    public void loadTable(int index_Filter_AutoMan, JTable table, DefaultTableModel model, int index_Filter_FullPart, int[] jumpColumn, final JTextField contItens, final JTextField... textFields) {

        if (index_Filter_AutoMan == 0) {

            loadTableGeneric_AUTO(table, model, index_Filter_FullPart, jumpColumn, contItens, textFields);
        } else {

            loadTableGeneric_AUTO(table, model, index_Filter_FullPart, jumpColumn, contItens, textFields);
            //loadTableGeneric_MANUAL(table, model, index_Filter_FullPart, jumpColumn, contItens, textFields);
        }

    }

//    public void reloadTable(int loadType, JTable table, DefaultTableModel model, int filterType, int[] jumpColumn, JTextField... textFields) {
//
//        loadTable(loadType, table, model, filterType, jumpColumn, txtRegistros, textFields);
//        
//        
//        
//
//    }
}
