package frames.employee;

import dao.PayStubDAO;
import dao.PayStubDescriptionDAO;
import entities.PayStub;
import entities.PayStubDescription;
import settings.ID_Find;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;

import components.cmd.CMP_BasicCRUD;

public class EmployeeAddPayStub extends JFrame {

    public EmployeePayStubItem cmpItens;
    public PayStub iten = new PayStub();
    public PayStubDAO itemDAO = new PayStubDAO();
    private JTable table;
    public int formFrom;
    public final int ADD = 0;
    public final int UPDATE = 1;

    PayStubDescriptionDAO itenDescriptionDAO = new PayStubDescriptionDAO();

    EmployeePayStub frmHolerite;

    public CMP_BasicCRUD cmpCrud;
    public int switchComand = 0;

    public EmployeeAddPayStub(EmployeePayStub frmHolerite, int switchComand) throws SQLException, ParseException {

        this.frmHolerite = frmHolerite;
        this.switchComand = switchComand;
        formFrom = frmHolerite.frmFrom;
        table = frmHolerite.table;

        configShow();
        initComps();
        event();

    }

//    public EMP_HOLERITE_ADD(EMP_PHONES_ALL frmAllPhone,int switchComand ) throws SQLException, ParseException {
//
//        this.frmAllPhone = frmAllPhone;
//        this.switchComand = switchComand;
//        formFrom = frmAllPhone.frmFrom;
//        idFk = frmAllPhone.idFk;
//        txtIdentify = frmAllPhone.txtIdentify;
//        table = frmAllPhone.table;
//        
//
//        configShow();
//        initComps();
//        event();
//
//    }
    public void initComps() throws SQLException, ParseException {

        cmpItens = new EmployeePayStubItem();
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

    
    
        public void loadCmbDescription() throws SQLException {

        PayStubDescriptionDAO hdDAO = new PayStubDescriptionDAO();

        cmpItens.cmbDescription.removeAllItems();
        
        
        Vector<PayStubDescription> list = new Vector(hdDAO.get_All_Entity_OrderByItemName());
        for (PayStubDescription iten : list) {
            cmpItens.cmbDescription.addItem(iten.getDescription());
        }
        System.out.println(" NO HOLERITE ADD !!!");

    }
    
    
    
    
    private void event() {

        cmpCrud.cmdConfirm.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    iten.setIdPk(new ID_Find().ID_PK(table));
                    iten.setIdFk_Employer(EmployeeInfo.idEmployer);

                    iten.setQuantity(new BigDecimal(getDouble(cmpItens.txtQuantity)));
                    iten.setSalary(new BigDecimal(getDouble(cmpItens.txtSalary)));
                    iten.setDeduction(new BigDecimal(getDouble(cmpItens.txtDeduction)));
                    int pkDescription = itenDescriptionDAO.get_Id_Entity((String) cmpItens.cmbDescription.getSelectedItem());

                    iten.setIdFk_Description(pkDescription);

                    System.out.println("idfkdescription: " + pkDescription);

                    if (switchComand == ADD) {
                        itemDAO.add_Entity(iten);
                    } else if (switchComand == UPDATE) {
                        itemDAO.update_Entity(iten);
                    }

                    cmpItens.setDefault();

                    if (formFrom == ADD) {

                        frmHolerite.loadTable();

                    } else if (formFrom == UPDATE) {

                        // frmAllPhone.loadTable();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeAddPayStub.class.getName()).log(Level.SEVERE, null, ex);
                }
                dispose();

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

        cmpItens.cmbDescription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmpItens.cmbDescription.getSelectedIndex() != -1) {
                    cmpCrud.cmdConfirm.setEnabled(true);
                } else {
                    cmpCrud.cmdConfirm.setEnabled(false);
                }
            }

        });

        cmpItens.btmAddDescription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    callAdd(0);
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeAddPayStub.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(EmployeeAddPayStub.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

    private void callAdd(int callType) throws SQLException, ParseException {

        EmployeeAddPayStubDescription frmAdd = new EmployeeAddPayStubDescription(this, callType);
        frmAdd.setVisible(true);
    }

    public double getDouble(JTextField textField) {
        if (textField.getText().length() == 1 && textField.getText().indexOf("-") >= 0) {
            return 0;
        }
        final char decimalSeparator = (((DecimalFormat) NumberFormat.getCurrencyInstance(Locale.getDefault())).getDecimalFormatSymbols()).getDecimalSeparator();
        if (decimalSeparator == ',') {
            return textField.getText().isEmpty() ? 0 : Double.parseDouble(textField.getText().replace(".", "").replace(",", "."));
        } else {
            return textField.getText().isEmpty() ? 0 : Double.parseDouble(textField.getText().replace(",", ""));
        }
    }

    private void configShow() {

        setMinimumSize(new Dimension(500, 400));
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
        setTitle("Colaboradores");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Images/work4.png"));
        this.setIconImage(imagemTitulo);
    }

}
