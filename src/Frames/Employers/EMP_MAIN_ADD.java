package Frames.Employers;

import Components.CMD.CMP_BasicCRUD;
import DAO.EmployerDAO;
import Entidades.Employers;
import Settings.ID_Find;
import Settings.SET_TextField_ID_1;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class EMP_MAIN_ADD extends JFrame {

    public CMP_BasicCRUD cmpCrud;
    public EMP_MAIN_ITENS cmpItens;
    private EmployerDAO itemDAO = new EmployerDAO();
    private Employers item = new Employers();
    public FrontEmployer frmMain;
    private JTable table;
    public int switchComand = 0;
    private SET_TextField_ID_1 setConf_ID_1;
    DateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");

    public EMP_MAIN_ADD(FrontEmployer frmMain, int switchComand) throws SQLException, ParseException {

        this.frmMain = frmMain;
        this.table = frmMain.table;
        this.switchComand = switchComand;
        configShow();
        initComps();
        event();

    }

    public void initComps() throws SQLException, ParseException {

        cmpItens = new EMP_MAIN_ITENS();
        cmpCrud = new CMP_BasicCRUD();
        itemDAO = new EmployerDAO();
        setDefault();

        add(cmpItens, BorderLayout.NORTH);
        add(cmpCrud, BorderLayout.SOUTH);

    }

    public void setDefault() throws SQLException {

        cmpItens.txtID.setText(itemDAO.get_AutoIncremente());
        cmpItens.txtDataRegistro.setText(formatador.format(new Date()));
        cmpItens.txtIdentificacao.setText(null);
        cmpItens.setBorder(null);
        
        cmpItens.txtID.setEnabled(false);
        cmpItens.txtDataRegistro.setEnabled(false);

        if (switchComand == 0) {
            cmpItens.remove(cmpItens.cmbStatus);
            cmpItens.remove(cmpItens.lblStatus);
        }

        cmpCrud.removeAll();
        cmpCrud.add(cmpCrud.cmdConfirm);
        cmpCrud.cmdConfirm.setEnabled(false);
        cmpCrud.add(cmpCrud.cmdClean);
        cmpCrud.add(cmpCrud.cmdCancel);

    }

    private void event() {

        cmpCrud.cmdConfirm.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (switchComand == 0) {
                        item.setIdEmployer(new ID_Find().ID_PK(table));
                        item.setDataRegistroEmployer(new java.sql.Date(new java.util.Date().getTime()));
                        item.setIdentificacaoEmployer(cmpItens.txtIdentificacao.getText().toUpperCase());

                        itemDAO.add_Entity(item);

                    } else if (switchComand == 1) {

                        item.setIdEmployer(Integer.parseInt(cmpItens.txtID.getText()));
                        item.setIdentificacaoEmployer(cmpItens.txtIdentificacao.getText().toUpperCase());

                        if (cmpItens.cmbStatus.getSelectedIndex() == 1) {
                            item.setStatus(1);
                        } else if (cmpItens.cmbStatus.getSelectedIndex() == 0) {
                            item.setStatus(0);
                        }

                        itemDAO.update_Entity(item);
                    }

                    setDefault();
                    frmMain.reloadTable(frmMain.status);
                    dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(EMP_MAIN_ADD.class.getName()).log(Level.SEVERE, null, ex);
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

        cmpItens.txtIdentificacao.getDocument().addDocumentListener(new DocumentListener() {

            public void changedUpdate(DocumentEvent e) {
                if (cmpItens.txtIdentificacao.getText().length() > 1) {
                    cmpCrud.cmdConfirm.setEnabled(true);
                } else {
                    cmpCrud.cmdConfirm.setEnabled(false);
                }
            }

            public void insertUpdate(DocumentEvent e) {
                if (cmpItens.txtIdentificacao.getText().length() > 1) {
                    cmpCrud.cmdConfirm.setEnabled(true);
                } else {
                    cmpCrud.cmdConfirm.setEnabled(false);
                }
            }

            public void removeUpdate(DocumentEvent e) {

                if (cmpItens.txtIdentificacao.getText().length() > 1) {
                    cmpCrud.cmdConfirm.setEnabled(true);
                } else {
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
