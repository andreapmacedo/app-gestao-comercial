
package components.tables;

import settings.ID_Find;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import components.cmd.CMP_BasicCRUD;
import components.cmd.CMP_TBL_ConfigFilter;
import components.cmd.CMP_TBL_SelectedIten;



public class GenericTableModel1 extends JPanel{
    public JTable tableBasicInfo;
    public JScrollPane scrollPaneTable;
    public JPanel pnlHeader, pnlFooter, pnlCenter;
    public CMP_TBL_SelectedIten cmpSelectedIten;
    public CMP_BasicCRUD cmpCrud;
    public CMP_TBL_ConfigFilter cmpConfigFilter;
    public int columnSelectedIten;
    public JTable table;
    public DefaultTableModel model;
    

    public GenericTableModel1() throws SQLException, ParseException {
        
//        this.table = table;
//        this.columnSelectedIten = columnSelectedIten;

        configPanel();
        initComps();
        event();
    }

    private void initComps() throws SQLException {

        
        table = new JTable();
        cmpCrud = new CMP_BasicCRUD();
        cmpConfigFilter = new CMP_TBL_ConfigFilter();
        cmpSelectedIten = new CMP_TBL_SelectedIten();
        
 
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//não sabemos porque não funciona
 

        pnlFooter = new JPanel(new BorderLayout());
        pnlFooter.add(cmpSelectedIten, BorderLayout.NORTH);
        pnlFooter.add(cmpCrud, BorderLayout.SOUTH);

        pnlHeader = new JPanel(new BorderLayout());
        pnlHeader.add(cmpConfigFilter, BorderLayout.WEST);

        scrollPaneTable = new JScrollPane();
        scrollPaneTable.setViewportView(table);
        pnlCenter = new JPanel(new GridLayout());
        pnlCenter.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlCenter.add(scrollPaneTable);

//        add(pnlHeader, BorderLayout.NORTH);
//        add(pnlFooter, BorderLayout.SOUTH);
//        add(pnlCenter, BorderLayout.CENTER);

    }

    public void event() {//vou ter que enviar esse evente para uma classe externa chamando pela subclasse

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                int row = table.getSelectedRow();
                if (row != -1) {

                    cmpSelectedIten.txtSelectedItem.setText((String) table.getValueAt(row, columnSelectedIten));
                    cmpSelectedIten.idSelectedRow = Integer.toString(new ID_Find().ID_PK(table));
                    cmpCrud.cmdInformations.setVisible(true);
                    cmpCrud.cmdEdit.setEnabled(true);
                    cmpCrud.cmdExclude.setEnabled(true);

                } else {

                    cmpSelectedIten.txtSelectedItem.setText(null);
                    cmpSelectedIten.idSelectedRow = null;
                    cmpCrud.cmdInformations.setVisible(false);
                    cmpCrud.cmdEdit.setEnabled(false);
                    cmpCrud.cmdExclude.setEnabled(false);

                }

            }

        });

    }

    private void configPanel() {

        setLayout(new BorderLayout());

    }

}
