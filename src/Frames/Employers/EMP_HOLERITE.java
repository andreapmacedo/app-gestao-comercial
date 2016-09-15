package Frames.Employers;

import Components.Tables.CMP_TBL_EVOTable;
import DAO.HoleriteDAO;
import Entidades.Holerite;
import Settings.ID_Find;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class EMP_HOLERITE extends JPanel {

    private EMP_HOLERITE_ITENS cmpItens;
    private CMP_TBL_EVOTable gneTable;
    private EMP_HOLERITE_ADD frmAdd;

    public HoleriteDAO itemDAO;
    public JTable table;
    public DefaultTableModel model;
    final String[] columnNames = {"COD", "DESCRIÇÃO", "Vr. REF.", "REF.", "RENDIMENTO", "DEDUÇÃO", "INCIDÊNCIA"};

    public int frmFrom = 0;

    public EMP_HOLERITE() throws SQLException, ParseException {


        configShow();
        initComps();
        event();
    }

    private void initComps() throws SQLException, ParseException {

        table = new JTable();

        itemDAO = new HoleriteDAO();

        cmpItens = new EMP_HOLERITE_ITENS();
        gneTable = new CMP_TBL_EVOTable(table, 1); // int referente a coluna selecionada da tabela

        loadTable(); //não desabilitar o load automatico da tabela pois pretendemos excluir a pesquisa desse form

        setDefault();

        //add(cmpItens, BorderLayout.NORTH);
        //vamos criar o painel de controle financeiro inclusive com botão de demostrativo detalhado sobre o custo do servidor
        add(gneTable, BorderLayout.CENTER);

    }

    public void setDefault() {

//        cmpItens.txtEmployer.setText(fkIdentify);
        gneTable.cmpCrud.remove(gneTable.cmpCrud.cmdInformations);
        gneTable.remove(gneTable.pnlHeader);

    }

    private void event() {

        gneTable.cmpCrud.cmdAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    callAdd(0);
                } catch (SQLException ex) {
                    Logger.getLogger(EMP_PHONES.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(EMP_PHONES.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        gneTable.cmpCrud.cmdExclude.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    itemDAO.remove_Entity(new ID_Find().ID_PK(table));
                    loadTable();
                } catch (SQLException ex) {
                    Logger.getLogger(FrontEmployer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        gneTable.cmpCrud.cmdAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    EMP_PHONES_ALL dialog = new EMP_PHONES_ALL();
                    dialog.setVisible(true);

                } catch (SQLException ex) {
                    Logger.getLogger(FrontEmployer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(EMP_PHONES.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

//        gneTable.cmpCrud.cmdEdit.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                int row = table.getSelectedRow();
//                if (row != -1) {
//
//                    try {
//                        callAdd(1);
//                    } catch (SQLException ex) {
//                        Logger.getLogger(EMP_PHONES.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (ParseException ex) {
//                        Logger.getLogger(EMP_PHONES.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//
//                    frmAdd.cmpItens.txtNumero.setText(((String) table.getValueAt(row, 1)).replaceAll("\\(", ""));
//                    frmAdd.cmpItens.cmbType.setSelectedItem((String) table.getValueAt(row, 2));
//                    frmAdd.cmpItens.cmbCarrier.setSelectedItem((String) table.getValueAt(row, 3));
//
//                }
//            }
//
//        });
        gneTable.cmpConfigFilter.cmdClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cmpItens.setDefault();
                try {
                    loadTable();
                } catch (SQLException ex) {
                    Logger.getLogger(EMP_PHONES.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        gneTable.cmpConfigFilter.cmbFilter_FullPart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gneTable.cmpConfigFilter.index_Filter_FullPart = gneTable.cmpConfigFilter.cmbFilter_FullPart.getSelectedIndex();
                try {
                    loadTable();
                } catch (SQLException ex) {
                    Logger.getLogger(EMP_PHONES.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        gneTable.cmpConfigFilter.cmdSerch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gneTable.cmpConfigFilter.index_Filter_FullPart = gneTable.cmpConfigFilter.cmbFilter_FullPart.getSelectedIndex();
                gneTable.cmpConfigFilter.index_Filter_AutoMan = gneTable.cmpConfigFilter.cmbFilter_AutoMan.getSelectedIndex();
                try {
                    loadTable();
                } catch (SQLException ex) {
                    Logger.getLogger(EMP_PHONES.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

    }

    private void callAdd(int callType) throws SQLException, ParseException {

        frmAdd = new EMP_HOLERITE_ADD(this, callType);
        frmAdd.setVisible(true);

    }

    public void loadTable() throws SQLException {

        ArrayList<String> fieldsFilter = new ArrayList<String>();

//                fieldsFilter.add(cmpItens.txtNumero.getText());
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

        if (gneTable.cmpConfigFilter.index_Filter_FullPart == 0) {
            for (int i = 0; i < fieldsFilter.size(); i++) {
                fieldsFilter.set(i, "'%" + fieldsFilter.get(i) + "%'");
            }
        } else {
            for (int i = 0; i < fieldsFilter.size(); i++) {
                fieldsFilter.set(i, "'" + fieldsFilter.get(i) + "%'");
            }
        }

        itemDAO = new HoleriteDAO();

        List<Holerite> list;
//        list = new ArrayList(itemDAO.select_InnerFilter((EMP_INFO.idEmployer), attr, fieldsFilter));
 //       model = new DefaultTableModel(itemDAO.populateTable_2(list), columnNames);
//        table.setModel(model);
 //       configRenderers(table);
        gneTable.cmpSelectedIten.txtRegistros.setText(String.valueOf(Integer.valueOf(table.getRowCount())));

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
        for (int i = 0; i < table.getColumnCount(); i++) {

//            if (table.getColumnName(i).equals("ID")) {
//                columnModel.getColumn(i).setMaxWidth(120);
//                columnModel.getColumn(1).setMinWidth(120);
//            } else {
//                columnModel.getColumn(i).setCellRenderer(left);
//
//            }
            //columnModel.getColumn(0).setMinWidth(150);
            columnModel.getColumn(0).setMaxWidth(70);
            columnModel.getColumn(0).setCellRenderer(center);
            //columnModel.getColumn(1).setMaxWidth(150);
            columnModel.getColumn(1).setMinWidth(150);
            columnModel.getColumn(1).setCellRenderer(left);
            columnModel.getColumn(2).setMaxWidth(150);
            columnModel.getColumn(2).setMinWidth(70);
            columnModel.getColumn(2).setCellRenderer(center);
            columnModel.getColumn(3).setMaxWidth(150);
            columnModel.getColumn(3).setMinWidth(70);
            columnModel.getColumn(3).setCellRenderer(center);
            columnModel.getColumn(4).setMaxWidth(150);
            columnModel.getColumn(4).setMinWidth(150);
            columnModel.getColumn(4).setCellRenderer(left);
            columnModel.getColumn(5).setMaxWidth(150);
            columnModel.getColumn(5).setMinWidth(150);
            columnModel.getColumn(5).setCellRenderer(left);
            columnModel.getColumn(6).setMaxWidth(150);
            columnModel.getColumn(6).setMinWidth(150);
            columnModel.getColumn(6).setCellRenderer(center);

        }
    }

    private void configShow() {

        setLayout(new BorderLayout());

    }

}
