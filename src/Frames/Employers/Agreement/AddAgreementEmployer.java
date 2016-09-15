package Frames.Employers.Agreement;

import Components.CMD.CMP_BasicCRUD;
import DAO.HoleriteDescriptionDAO;
import Entidades.HoleriteDescription;
import Frames.Employers.EMP_HOL_DESCRIPTION_ADD;
import Frames.Employers.EMP_INFO;
import Settings.ID_Find;
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
import javax.swing.JTextField;

public class AddAgreementEmployer extends JFrame {

//    
//    ///remains
//    public RegisterAgreementEmployer register;
//    public CMP_BasicCRUD command;
//    
//    
//    
//    //change
////    public Holerite iten = new Holerite();
////    public HoleriteDAO itemDAO = new HoleriteDAO();
////    private JTable table;
////    public int formFrom;
////    public final int ADD = 0;
////    public final int UPDATE = 1;
////
////    HoleriteDescriptionDAO itenDescriptionDAO = new HoleriteDescriptionDAO();
////
////    EMP_HOLERITE frmHolerite;
////
////    public int switchComand = 0;
//
//    //vamos mandar não o form
//    
//    //jogar uma variavel global para o id do iten
//    
//    public AddAgreementEmployer(boolean add) throws SQLException, ParseException {
//
//
//        configShow();
//        initComps();
//        event();
//
//    }
//
//    AddAgreementEmployer(boolean add) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
////    public EMP_HOLERITE_ADD(EMP_PHONES_ALL frmAllPhone,int switchComand ) throws SQLException, ParseException {
////
////        this.frmAllPhone = frmAllPhone;
////        this.switchComand = switchComand;
////        formFrom = frmAllPhone.frmFrom;
////        idFk = frmAllPhone.idFk;
////        txtIdentify = frmAllPhone.txtIdentify;
////        table = frmAllPhone.table;
////        
////
////        configShow();
////        initComps();
////        event();
////
////    }
//    public void initComps() throws SQLException, ParseException {
//
//        register = new RegisterAgreementEmployer();
//        command = new CMP_BasicCRUD();
//
//        setDefault();
//
//        add(register, BorderLayout.NORTH);
//        add(command, BorderLayout.SOUTH);
//
//    }
//
//    public void setDefault() throws SQLException {
//
//        command.removeAll();
//        command.add(command.cmdConfirm);
//        command.cmdConfirm.setEnabled(false);
//        command.add(command.cmdClean);
//        command.add(command.cmdCancel);
//
//        
//        register.setDefault();
//        register.setBorder(null);
//
//    }
//
//    // ok permanece
//    public void loadCmbDescription() throws SQLException {
//
//        HoleriteDescriptionDAO hdDAO = new HoleriteDescriptionDAO();
//
//        register.cmbDescription.removeAllItems();
//
//        Vector<HoleriteDescription> list = new Vector(hdDAO.get_All_Entity_OrderByItemName());
//        for (HoleriteDescription iten : list) {
//            register.cmbDescription.addItem(iten.getDescription());
//        }
//
//
//    }
//
//    private void event() {
//
//        command.cmdConfirm.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                
//                
//
//        //vai lá pro crud
//                try {
//
//                    iten.setIdPk(new ID_Find().ID_PK(table));// pegar o id na variavel global
//                    iten.setIdFk_Employer(EMP_INFO.idEmployer);
//
//                    iten.setQuantity(new BigDecimal(getDouble(register.txtQuantity)));
//                    iten.setSalary(new BigDecimal(getDouble(register.txtSalary)));
//                    iten.setDeduction(new BigDecimal(getDouble(register.txtDeduction)));
//                    int pkDescription = itenDescriptionDAO.get_Id_Entity((String) register.cmbDescription.getSelectedItem());
//
//                    iten.setIdFk_Description(pkDescription);
//
//                    System.out.println("idfkdescription: " + pkDescription);
//
//                    if (switchComand == ADD) {
//                        itemDAO.add_Entity(iten);
//                    } else if (switchComand == UPDATE) {
//                        itemDAO.update_Entity(iten);
//                    }
//
//                    register.setDefault();
//
//                    if (formFrom == ADD) {
//
//                        frmHolerite.loadTable();
//
//                    } else if (formFrom == UPDATE) {
//
//                        // frmAllPhone.loadTable();
//                    }
//
//                } catch (SQLException ex) {
//                    Logger.getLogger(EMP_HOLERITE_ADD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                dispose();
//
//            }
//
//        });
//
//        command.cmdCancel.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                dispose();
//            }
//
//        });
//
//        command.cmdClean.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                register.setDefault();
//            }
//
//        });
//
//        register.cmbDescription.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (register.cmbDescription.getSelectedIndex() != -1) {
//                    command.cmdConfirm.setEnabled(true);
//                } else {
//                    command.cmdConfirm.setEnabled(false);
//                }
//            }
//
//        });
//
//        register.btmAddDescription.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//              
//                    callAdd(0);
//
//
//            }
//        });
//
//    }
//
//    private void callAdd(int callType) throws SQLException, ParseException {
//
//        EMP_HOL_DESCRIPTION_ADD frmAdd = new EMP_HOL_DESCRIPTION_ADD(callType);
//        frmAdd.setVisible(true);
//    }
//
//    public double getDouble(JTextField textField) {
//        if (textField.getText().length() == 1 && textField.getText().indexOf("-") >= 0) {
//            return 0;
//        }
//        final char decimalSeparator = (((DecimalFormat) NumberFormat.getCurrencyInstance(Locale.getDefault())).getDecimalFormatSymbols()).getDecimalSeparator();
//        if (decimalSeparator == ',') {
//            return textField.getText().isEmpty() ? 0 : Double.parseDouble(textField.getText().replace(".", "").replace(",", "."));
//        } else {
//            return textField.getText().isEmpty() ? 0 : Double.parseDouble(textField.getText().replace(",", ""));
//        }
//    }
//
//    private void configShow() {
//
//        setMinimumSize(new Dimension(500, 400));
//        setLocationRelativeTo(null);
//        setResizable(false);
//        setLayout(new BorderLayout());
//        setTitle("Colaboradores");
//        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Images/work4.png"));
//        this.setIconImage(imagemTitulo);
//    }

}
