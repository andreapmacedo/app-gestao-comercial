/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;



import GNF.GNF_Estados;
import java.awt.Dimension;
import java.util.List;
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
public class SET_Table_1 {

  //  private final EstadosDAO itemDAO = new EstadosDAO();

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

    public void loadTable(final JTable table, final JTextField pesquisa, final JTextField registros,List list,String columnNames[],Object gnf) {

        //final String itemCadastro = pesquisa.getText().toUpperCase();

        
            String columns[] = columnNames;
            
                //PreencherTabela(list)

            //TableModel model = new DefaultTableModel(list, columns) {

                TableModel model = new DefaultTableModel(GNF_Estados.preencherTabela(list), columns) {
//                public Class getColumnClass(int column) {
//                    Class returnValue;
//                    if ((column >= 0) && (column < getColumnCount())) {
//                        returnValue = getValueAt(0, column).getClass();
//                        
//                    } else {
//                        returnValue = Object.class;
//                        
//                    }
//                    return returnValue;
//                }
            };

            table.setModel(model);

            configRenderers(table);

            final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
            table.setRowSorter(sorter);

            registros.setText(String.valueOf(Integer.valueOf(table.getRowCount())));

            pesquisa.getDocument().addDocumentListener(new DocumentListener() {

                public void changedUpdate(DocumentEvent e) {
                    String text = pesquisa.getText().toUpperCase();//itemCadastro;
                    if (text.length() == 0) {
                        sorter.setRowFilter(null);
                    } else {
                        sorter.setRowFilter(RowFilter.regexFilter(text));
                    }
                    //qtdLinhas = Integer.valueOf(table.getRowCount());
                    registros.setText(String.valueOf(Integer.valueOf(table.getRowCount())));
                }

                public void insertUpdate(DocumentEvent e) {
                    String text = pesquisa.getText().toUpperCase();
                    if (text.length() == 0) {
                        sorter.setRowFilter(null);
                    } else {
                        sorter.setRowFilter(RowFilter.regexFilter(text));
                    }
                    //qtdLinhas = Integer.valueOf(table.getRowCount());
                    registros.setText(String.valueOf(Integer.valueOf(table.getRowCount())));
                }

                public void removeUpdate(DocumentEvent e) {
                    String text = pesquisa.getText().toUpperCase();
                    if (text.length() == 0) {
                        sorter.setRowFilter(null);
                    } else {
                        sorter.setRowFilter(RowFilter.regexFilter(text));
                    }
                    //qtdLinhas = Integer.valueOf(table.getRowCount());
                    registros.setText(String.valueOf(Integer.valueOf(table.getRowCount())));
                }
            });

    }

//    static Object[][] PreencherTabela(List<Estados> lista) {
//
//        Object[][] resposta = new Object[lista.size()][2];
//
//        for (int i = 0; i < resposta.length; i++) {
//            Estados orc = lista.get(i);
//            // resposta[i][2] = orc.setIdCidade();
//            resposta[i][0] = orc.getIdEstado();
//            resposta[i][1] = orc.getNomeEstado();
//            qtdLinhas++;
//        }
//
//        return resposta;
//    }
//    
    

}
