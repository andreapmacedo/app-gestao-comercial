package Frames.Employers;

import Components.Tables.CMP_TBL_EVOTable;
import DAO.EmployerDAO;
import Settings.ID_Find;
import Tables.EMP_MAIN_Table;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;

public class FrontEmployer extends JFrame {


    

    private EMP_MAIN_ITENS cmpItens;
    private CMP_TBL_EVOTable gneTable;
    private EMP_MAIN_ADD frmAdd;
    private EmployerDAO itemDAO;
    private EMP_MAIN_Table setTable;
    public JTable table;
    public int status = 1;

    public FrontEmployer() throws SQLException, ParseException {

        configShow();
        initComps();
        event();

    }

    private void initComps() throws SQLException, ParseException {

        cmpItens = new EMP_MAIN_ITENS();
        table = new JTable();
        setTable = new EMP_MAIN_Table(table, status);
        gneTable = new CMP_TBL_EVOTable(table, 2);
        itemDAO = new EmployerDAO();

        reloadTable(status);

        setDefault();

                
        add(BorderLayout.NORTH, cmpItens);
        add(BorderLayout.CENTER, gneTable);

    }

    public void setDefault() {

        gneTable.cmpCrud.remove(gneTable.cmpCrud.cmdAll);
        cmpItens.txtID.setText(null);
        cmpItens.txtDataRegistro.setText(null);
        cmpItens.txtIdentificacao.setText(null);

    }

    private void event() {

        gneTable.cmpCrud.cmdAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    callAdd(0);
                } catch (SQLException ex) {
                    Logger.getLogger(FrontEmployer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(FrontEmployer.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        gneTable.cmpCrud.cmdExclude.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    itemDAO.remove_Entity(new ID_Find().ID_PK(table));

                    reloadTable(status);
                } catch (SQLException ex) {
                    Logger.getLogger(FrontEmployer.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(FrontEmployer.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(FrontEmployer.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    frmAdd.cmpItens.txtIdentificacao.setText(((String) table.getValueAt(row, 2))/*.replaceAll("\\(", "")*/);
                    frmAdd.cmpItens.txtDataRegistro.setText((String) table.getValueAt(row, 1));
                    frmAdd.cmpItens.txtID.setText(Integer.toString(new ID_Find().ID_PK(table)));
                    frmAdd.cmpItens.cmbStatus.setSelectedIndex(cmpItens.cmbStatus.getSelectedIndex());

                }
            }
        });

        for (ActionListener listener : gneTable.cmpConfigFilter.cmdClean.getActionListeners()) {
            gneTable.cmpConfigFilter.cmdClean.removeActionListener(listener);
        }

        gneTable.cmpConfigFilter.cmdClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setDefault();
                try {
                    reloadTable(status);
                } catch (SQLException ex) {
                    Logger.getLogger(EMP_PHONES.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        for (ActionListener listener : gneTable.cmpConfigFilter.cmbFilter_FullPart.getActionListeners()) {
            gneTable.cmpConfigFilter.cmbFilter_FullPart.removeActionListener(listener);
        }

        gneTable.cmpConfigFilter.cmbFilter_FullPart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gneTable.cmpConfigFilter.index_Filter_FullPart = gneTable.cmpConfigFilter.cmbFilter_FullPart.getSelectedIndex();
                try {
                    reloadTable(status);
                } catch (SQLException ex) {
                    Logger.getLogger(EMP_PHONES.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        for (ActionListener listener : gneTable.cmpConfigFilter.cmdSerch.getActionListeners()) {
            gneTable.cmpConfigFilter.cmdSerch.removeActionListener(listener);
        }

        gneTable.cmpConfigFilter.cmdSerch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gneTable.cmpConfigFilter.index_Filter_FullPart = gneTable.cmpConfigFilter.cmbFilter_FullPart.getSelectedIndex();
                // gneTable.cmpConfigFilter.index_Filter_AutoMan = gneTable.cmpConfigFilter.cmbFilter_AutoMan.getSelectedIndex();
                try {
                    reloadTable(status);
                } catch (SQLException ex) {
                    Logger.getLogger(EMP_PHONES.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        gneTable.cmpCrud.cmdInformations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    System.out.println("valor encontrado: " + Integer.parseInt(gneTable.cmpSelectedIten.idSelectedRow));
                    EMP_INFO dialog = new EMP_INFO(Integer.parseInt(gneTable.cmpSelectedIten.idSelectedRow), gneTable.cmpSelectedIten.txtSelectedItem.getText());
                    dialog.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrontEmployer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(FrontEmployer.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        cmpItens.cmbStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                status = cmpItens.cmbStatus.getSelectedIndex();

                try {
                    reloadTable(status);
                } catch (SQLException ex) {
                    Logger.getLogger(EMP_PHONES.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

    private void callAdd(int callType) throws SQLException, ParseException {

        frmAdd = new EMP_MAIN_ADD(this, callType);
        frmAdd.setVisible(true);

    }

    public void reloadTable(int status) throws SQLException {

        ArrayList<String> fieldsFilter = new ArrayList<String>();
        fieldsFilter.add(cmpItens.txtID.getText());
        // Date dateteste = null;
        fieldsFilter.add(cmpItens.txtDataRegistro.getText());
        fieldsFilter.add(cmpItens.txtIdentificacao.getText());

        ArrayList<String> attr = new ArrayList<String>();
        attr.add("EMP_ID");
        attr.add("EMP_DATA_REGISTRO");
        attr.add("EMP_IDENTIFICACAO");

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

        setTable.reloadTable(status, gneTable.cmpSelectedIten.txtRegistros, attr, fieldsFilter);
    }

    private void configShow() {

        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(1024, 768));

        setLocationRelativeTo(null);
        setTitle("Colaboradores");

        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Images/work4.png"));
        this.setIconImage(imagemTitulo);

    }

}
