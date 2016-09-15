package Frames.Employers;

import Components.Tables.CMP_TBL_EVOTable;
import DAO.EmployerPhoneDAO;
import Settings.ID_Find;
import Tables.EMP_PHONE_Table;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTable;

public class EMP_PHONES extends JPanel {

    private EMP_PHONES_ITENS cmpItens;
    private CMP_TBL_EVOTable gneTable;
    private EMP_PHONES_ADD frmAdd;
    public EmployerPhoneDAO itemDAO;
    public EMP_PHONE_Table setTable;
    public JTable table;

    public int frmFrom = 0;


    public EMP_PHONES() throws SQLException, ParseException {

        configShow();
        initComps();
        event();
    }

    private void initComps() throws SQLException, ParseException {

        table = new JTable();
        setTable = new EMP_PHONE_Table(table);
        itemDAO = new EmployerPhoneDAO();

        cmpItens = new EMP_PHONES_ITENS();
        gneTable = new CMP_TBL_EVOTable(table, 1);

        reloadTable();

        setDefault();

        add(cmpItens, BorderLayout.NORTH);
        add(gneTable, BorderLayout.CENTER);

    }

    public void setDefault() {

        gneTable.cmpCrud.remove(gneTable.cmpCrud.cmdInformations);

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
                    reloadTable();
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

        gneTable.cmpCrud.cmdEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int row = table.getSelectedRow();
                if (row != -1) {

                    try {
                        callAdd(1);
                    } catch (SQLException ex) {
                        Logger.getLogger(EMP_PHONES.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(EMP_PHONES.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    frmAdd.cmpItens.txtNumero.setText(((String) table.getValueAt(row, 1)).replaceAll("\\(", ""));
                    frmAdd.cmpItens.cmbType.setSelectedItem((String) table.getValueAt(row, 2));
                    frmAdd.cmpItens.cmbCarrier.setSelectedItem((String) table.getValueAt(row, 3));

                }
            }

        });

        gneTable.cmpConfigFilter.cmdClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cmpItens.setDefault();
                try {
                    reloadTable();
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
                    reloadTable();
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
                    reloadTable();
                } catch (SQLException ex) {
                    Logger.getLogger(EMP_PHONES.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

    }

    private void callAdd(int callType) throws SQLException, ParseException {

        frmAdd = new EMP_PHONES_ADD(this, callType);
        frmAdd.setVisible(true);

    }

    public void reloadTable() throws SQLException {

        ArrayList<String> fieldsFilter = new ArrayList<String>();

        fieldsFilter.add(cmpItens.txtNumero.getText());
        fieldsFilter.add(cmpItens.cmbType.getSelectedItem().toString());
        fieldsFilter.add(cmpItens.cmbCarrier.getSelectedItem().toString());

        ArrayList<String> attr = new ArrayList<String>();

        attr.add("EFN_NUMERO");
        attr.add("EFN_TIPO");
        attr.add("EFN_OPERADORA");

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
        
        

        setTable.reloadTable(gneTable.cmpSelectedIten.txtRegistros, attr, fieldsFilter);
    }

    private void configShow() {

        setLayout(new BorderLayout());

    }

}
