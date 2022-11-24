package frames.employee;

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
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import components.cmd.CMP_BasicCRUD;

public class EmployeeAddPayStubDescription extends JFrame {

    public EmployeePayStubDescriptionItem cmpItens;
    public PayStubDescription iten = new PayStubDescription();
    public PayStubDescriptionDAO itenDAO = new PayStubDescriptionDAO();
//    private JTable table;
    private String idFk, txtIdentify;
    private int formFrom;
    private final int ADD = 0;
    private final int UPDATE = 1;
    EmployeePayStubItem itenHoleriteItens;
//
//    HoleriteDescriptionDAO itenDescriptionDAO = new HoleriteDescriptionDAO();
//    HoleriteReferenceDAO itenReferenceDAO = new HoleriteReferenceDAO();
//
    EmployeeAddPayStub formHoleriteAdd;

    public CMP_BasicCRUD cmpCrud;
    public int callType = 0;

    public EmployeeAddPayStubDescription(EmployeeAddPayStub formHoleriteAdd, int callType) throws SQLException, ParseException {

        this.formHoleriteAdd = formHoleriteAdd;
        this.callType = callType;
        formFrom = formHoleriteAdd.formFrom;


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

        cmpItens = new EmployeePayStubDescriptionItem();
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

//precisamos do idpk para caso de update
                //  iten.setIdPk(new ID_Find().ID_PK(table));
                //iten.setIdFk_Employer(Integer.parseInt(idFk));
                iten.setDescription(cmpItens.txtDescription.getText().toUpperCase());
                iten.setType(cmpItens.cmbType.getSelectedIndex());
                iten.setReferenceType(cmpItens.cmbReferenceType.getSelectedItem().toString());

                if (!cmpItens.txtReferenceValue.getText().equals("")) {
                    iten.setReferenceValue(new BigDecimal(cmpItens.txtReferenceValue.getText().replace(',', '.')));
                } else {
                    iten.setReferenceValue(new BigDecimal(1));
                }

                iten.setIncidence(cmpItens.cmbIncidence.getSelectedItem().toString());

                if (cmpItens.cbxInss.isSelected()) {
                    iten.setInssFocus(1);
                } else {
                    iten.setInssFocus(0);
                }

                if (cmpItens.cbxFgts.isSelected()) {
                    iten.setFgtsFocus(1);
                } else {
                    iten.setFgtsFocus(0);
                }

                if (cmpItens.cbxIr.isSelected()) {
                    iten.setIrFocus(1);
                } else {
                    iten.setIrFocus(0);
                }

                try {
                    if (callType == 0) {
                        itenDAO.add_Entity(iten);
                    } else if (callType == 1) {
                        itenDAO.update_Entity(iten);
                    }

                    cmpItens.setDefault();

                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeAddPayStubDescription.class.getName()).log(Level.SEVERE, null, ex);
                }
                dispose();

                try {

                    if (formFrom == ADD) {
                       //itenHoleriteItens = new EMP_HOLERITE_ITENS();

                        formHoleriteAdd.loadCmbDescription();
                      //  itenHoleriteItens.loadCmbDescription();
                        System.out.println("entrou no load");

                    } else if (formFrom == UPDATE) {

                        // frmAllPhone.lloadTable();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeAddPayStubDescription.class.getName()).log(Level.SEVERE, null, ex);
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

        cmpItens.cmbType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkConfirm();
            }

        });

        cmpItens.cmbReferenceType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkConfirm();
            }

        });

        cmpItens.cmbIncidence.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkConfirm();
            }

        });

        cmpItens.txtDescription.getDocument().addDocumentListener(new DocumentListener() {

            public void changedUpdate(DocumentEvent e) {
                checkConfirm();
            }

            public void insertUpdate(DocumentEvent e) {
                checkConfirm();
            }

            public void removeUpdate(DocumentEvent e) {
                checkConfirm();
            }

        });

    }

    private void checkConfirm() {

        if (cmpItens.txtDescription.getText().length() > 1) {
            if (cmpItens.cmbIncidence.getSelectedIndex() != -1 && cmpItens.cmbType.getSelectedIndex() != -1 && cmpItens.cmbReferenceType.getSelectedIndex() != -1) {
                cmpCrud.cmdConfirm.setEnabled(true);
            }
        } else {
            cmpCrud.cmdConfirm.setEnabled(false);
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
