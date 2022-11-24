package frames.employee;

import dao.EmployerPhoneDAO;
import entities.EmployeesPhone;
import settings.ID_Find;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import components.cmd.CMP_BasicCRUD;

public class EmployeeAddPhone extends JFrame {

    public EmployeePhoneItens cmpItens;
    public EmployeesPhone item = new EmployeesPhone();
    public EmployerPhoneDAO itemDAO = new EmployerPhoneDAO();
    private JTable table;
    private String txtId, txtIdentify;
    private int formFrom;

    EmployeePhone frmPhone;
    EmployeeAllPhone frmAllPhone;

    public CMP_BasicCRUD cmpCrud;
    public int switchComand = 0;

    public EmployeeAddPhone(EmployeePhone frmPhone,int switchComand ) throws SQLException, ParseException {

        this.frmPhone = frmPhone;
        this.switchComand = switchComand;
        formFrom = frmPhone.frmFrom;
        table = frmPhone.table;

        configShow();
        initComps();
        event();


    }

    public EmployeeAddPhone(EmployeeAllPhone frmAllPhone,int switchComand ) throws SQLException, ParseException {

        this.frmAllPhone = frmAllPhone;
        this.switchComand = switchComand;
        formFrom = frmAllPhone.frmFrom;
        table = frmAllPhone.table;
        

        configShow();
        initComps();
        event();

    }

    public void initComps() throws SQLException, ParseException {

        
        
        cmpItens = new EmployeePhoneItens();
        cmpCrud = new CMP_BasicCRUD();
        
        setDefault();
        

        add(cmpItens, BorderLayout.NORTH);
        add(cmpCrud, BorderLayout.SOUTH);

    }

    public void setDefault() throws SQLException {

        cmpCrud.removeAll();
        cmpCrud.add(cmpCrud.cmdConfirm);
        cmpCrud.cmdConfirm.setEnabled(false);
        cmpCrud.add(cmpCrud.cmdClean);
        cmpCrud.add(cmpCrud.cmdCancel);
        
        cmpItens.setDefault();
        
        cmpItens.setBorder(null);
        
       
        

    }

    private void event() {

        cmpCrud.cmdConfirm.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    item.setIdFK_Employer(EmployeeInfo.idEmployer);
                    item.setIdPk(new ID_Find().ID_PK(table));
                    item.setNumero(cmpItens.txtNumero.getText().toUpperCase());
                    item.setTipo(cmpItens.cmbType.getSelectedItem().toString().toUpperCase());
                    item.setOperadora(cmpItens.cmbCarrier.getSelectedItem().toString().toUpperCase());

                    if (switchComand == 0) {
                        itemDAO.add_Entity(item);
                    } else if (switchComand == 1) {
                        itemDAO.update_Entity(item);
                    }
                    cmpItens.setDefault();

                    if (formFrom == 0) {

                        frmPhone.reloadTable();

                    } else if (formFrom == 1) {

                        frmAllPhone.reloadTable();

                    }
                    
                    dispose();

                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeAddMain.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        cmpCrud.cmdCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                dispose();
            }

        });

        cmpCrud.cmdClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmpItens.setDefault();
            }

        });

        cmpItens.txtNumero.getDocument().addDocumentListener(new DocumentListener() {

            public void changedUpdate(DocumentEvent e) {
                if (cmpItens.txtNumero.getText().length() > 10) {
                    cmpCrud.cmdConfirm.setEnabled(true);
                } else {
                    cmpCrud.cmdConfirm.setEnabled(false);
                }

            }

            public void insertUpdate(DocumentEvent e) {
                if (cmpItens.txtNumero.getText().length() > 10) {
                    cmpCrud.cmdConfirm.setEnabled(true);
                }else {
                    cmpCrud.cmdConfirm.setEnabled(false);
                }
            }

            public void removeUpdate(DocumentEvent e) {

                if (cmpItens.txtNumero.getText().length() > 10) {
                    cmpCrud.cmdConfirm.setEnabled(true);
                }else {
                    cmpCrud.cmdConfirm.setEnabled(false);
                }
            }

        });

    }

    private void configShow() {

        setMinimumSize(new Dimension(980, 180));
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
        setTitle("Colaboradores");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Images/work4.png"));
        this.setIconImage(imagemTitulo);
    }

}
