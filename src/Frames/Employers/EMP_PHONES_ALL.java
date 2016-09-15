package Frames.Employers;

import Components.CMD.CMP_TBL_ConfigFilter;
import Components.Tables.CMP_TBL_EVOTable;
import Tables.EMP_PHONEall_Table;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;

public class EMP_PHONES_ALL extends JFrame {

    private EMP_PHONES_ITENS cmpItens;
    private CMP_TBL_EVOTable gneTable;
    public EMP_PHONEall_Table setTable;
  //  private EmployerPhoneDAO itemDAO;
    public JTable table;
    //private DefaultTableModel model;
  //  private List<EmployersPhone> list;

    public String txtId, txtIdentify;
    public int frmFrom = 1;

    CMP_TBL_ConfigFilter configFilter;

    public EMP_PHONES_ALL() throws SQLException, ParseException {

        configShow();
        initComps();
        event();
    }

    private void initComps() throws SQLException, ParseException {

        table = new JTable();
        setTable = new EMP_PHONEall_Table(table);
        cmpItens = new EMP_PHONES_ITENS();
        gneTable = new CMP_TBL_EVOTable(table, 1);

      //  itemDAO = new EmployerPhoneDAO();

        reloadTable();
        setDefault();



        add(BorderLayout.NORTH, cmpItens);
        add(BorderLayout.CENTER, gneTable);
    }

    private void setDefault() {

//        cmpItens.txtEmployer.setFont(new java.awt.Font("Tahoma", 0, 11));
//        cmpItens.txtEmployer.setBackground(new java.awt.Color(255, 255, 255));
//        cmpItens.txtEmployer.setForeground(new java.awt.Color(0, 0, 0));
//        cmpItens.txtEmployer.setEditable(true);
//        cmpItens.txtEmployer.setText(null);

        cmpItens.add(cmpItens.statusEmployer);

        //  gneTable.remove(gneTable.pnlFooter);
        // gneTable.cmpCrud.remove(gneTable.cmpCrud.cmdInformations);
        //gneTable.cmpCrud.removeAll(gneTable.cmpCrud.cmdAll);
        gneTable.cmpCrud.removeAll();
    }

    private void event() {

        gneTable.cmpConfigFilter.cmdClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cmpItens.setDefault();
                setDefault();

                try {
                    reloadTable();
                } catch (SQLException ex) {
                    Logger.getLogger(EMP_PHONES_ALL.class.getName()).log(Level.SEVERE, null, ex);
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

        cmpItens.statusEmployer.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {

                try {
                    reloadTable();
                } catch (SQLException ex) {
                    Logger.getLogger(EMP_PHONES_ALL.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

    public void reloadTable() throws SQLException {

        ArrayList<String> fieldsFilter = new ArrayList<String>();

        fieldsFilter.add(cmpItens.txtNumero.getText());
       // fieldsFilter.add(cmpItens.txtEmployer.getText());
        fieldsFilter.add(cmpItens.cmbType.getSelectedItem().toString());
        fieldsFilter.add(cmpItens.cmbCarrier.getSelectedItem().toString());

        ArrayList<String> attr = new ArrayList<String>();

        attr.add("EFN_NUMERO");
      //  attr.add("EMP_IDENTIFICACAO");
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

        setTable.reloadTable(cmpItens.statusEmployer.isSelected(), gneTable.cmpSelectedIten.txtRegistros, attr, fieldsFilter);
    }

    private void configShow() {


        setLayout(new BorderLayout());
        //  setLayout(new GridLayout(2, 1,0,50));
        setMinimumSize(new Dimension(1024, 768));
        setLocationRelativeTo(null);
        setTitle("Colaboradores");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Images/work4.png"));
        this.setIconImage(imagemTitulo);

    }

}


