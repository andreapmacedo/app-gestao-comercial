
package old;

import components.cmd.CMP_CMD_MasterCrud;
import components.tables.CMP_GEN_Table_1;
import dao.EmployerDAO;
import entities.Employees;
import settings.SET_Table_3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Andre
 */
public class OLD_FRM_EMP_MAIN extends JFrame {

    private CMP_GEN_CRUD_1_old Gcrud_2, Gcrud_3, Gcrud_4, Gcrud_5;

    private CMP_CMD_MasterCrud Gcmd_1, Gcmd_2, Gcmd_3, Gcmd_4, Gcmd_5;

    private JPanel pnlMain,
            pnlBasicData,
            pnlPersonalInfo, pnlPersonalAddress, pnlContacts,
            pnlProfessionalContract, pnProfessionallLink, pnlProfessionalSkill,
            pnlPayAgreement, pnlPayPaycheck, pnlPayPayments, pnlPayCET, pnlPayBLC,
            pnlNoteobservation, pnlNotePerformance, pnlNoteEvaluation, pnlNotelHistorical, pnlNoteReference, pnlNoteEPI,
            pnlTable1;

    private JTabbedPane tpnBasicData, tpnPersonal, tpnProfessional, tpnPayment, tpnNote;

    private JTable tableBasicInfo;

    private JScrollPane scrollPane1;

//    private oldPNL_EMP_BasicInf_1 pnlBI;

    private OLD_CMP_EMP_BasicInfo_1 EMP_BasicInf;
    
    
    private CMP_GEN_Table_1 G_BasicTable;

    private JTextField txtRegistros = new JTextField(8);

    //private JDesktopPane deskPanel = new JDesktopPane();
    public OLD_FRM_EMP_MAIN() throws SQLException, ParseException {
        this.EMP_BasicInf = new OLD_CMP_EMP_BasicInfo_1();

        initComponents();
        events();

    }

    public void initComponents() throws SQLException, ParseException {

        setLayout(new GridLayout(1, 1));

        setMinimumSize(new Dimension(1280, 800));
        setLocationRelativeTo(null); // centralizar form
        setTitle("Servidores"); // Nome do form

        //INTANCIANDO COMPONENTES
        
        Gcrud_2 = new CMP_GEN_CRUD_1_old();
        Gcrud_3 = new CMP_GEN_CRUD_1_old();
        Gcrud_4 = new CMP_GEN_CRUD_1_old();
        Gcrud_5 = new CMP_GEN_CRUD_1_old();
        Gcmd_1 = new CMP_CMD_MasterCrud();

        //INTÂNCIANDO OS PANELS
        pnlBasicData = new JPanel(new BorderLayout(0, 0));
        pnlNoteEPI = new JPanel(new BorderLayout(0, 0));
        pnlPersonalInfo = new JPanel(new BorderLayout(0, 0));
        pnlPersonalAddress = new JPanel(new BorderLayout(0, 0));
        pnlContacts = new JPanel(new BorderLayout(0, 0));

        //INSTÂNCIANDO OS TABBEDPANELS. 
        tpnBasicData = new JTabbedPane();
        tpnPersonal = new JTabbedPane();
        tpnProfessional = new JTabbedPane();
        tpnPayment = new JTabbedPane();
        tpnNote = new JTabbedPane();

        //ADICIONANDO OS PANELS AOS TABBEDPANELS. 
        //MAIN TABBED
        tpnBasicData.addTab("Cadastro básico", pnlBasicData);
        tpnBasicData.addTab("Pessoal", tpnPersonal);
        tpnBasicData.addTab("Profissional", tpnProfessional);
        tpnBasicData.addTab("Remunerações", tpnPayment);
        tpnBasicData.addTab("Anotações", tpnNote);
        //SUB TABBED
        tpnPersonal.addTab("Informações Pessoais", pnlPersonalInfo);
        tpnPersonal.addTab("Endereços", pnlPersonalAddress);
        tpnPersonal.addTab("Contatos", pnlContacts);
        //SUB TABBED
        tpnProfessional.addTab("Contrato", pnlProfessionalContract); // folha
        // ta faltando adicionar lotacão, setor etc.
        tpnProfessional.addTab("Referencias", pnProfessionallLink);
        tpnProfessional.addTab("Habilidades", pnlProfessionalSkill); //funçaao que desempenha função atual
        //SUB TABBED
        tpnPayment.addTab("Remunerações", pnlPayAgreement);
        tpnPayment.addTab("Contracheque", pnlPayPaycheck);
        tpnPayment.addTab("Pagamentos", pnlPayPayments); // saldo trabalhado, gerar pagamento individualizado,
        tpnPayment.addTab("CET", pnlPayCET);
        tpnPayment.addTab("BLC", pnlPayBLC);
        //SUB TABBED
        tpnNote.addTab("Observações", pnlNoteobservation);
        tpnNote.addTab("Performance", pnlNotePerformance);
        tpnNote.addTab("Avaliação", pnlNoteEvaluation);
        tpnNote.addTab("Histórico", pnlNotelHistorical);
        tpnNote.addTab("Referência", pnlNoteReference);
        tpnNote.addTab("EPI", pnlNoteEPI);

        //ADICIONANDO OS COMPONENTES AOS PANELS
        //loadFrame2();
//        pnlBI = new oldPNL_EMP_BasicInf_1();
//        pnlBasicData.add("North", pnlBI);

        pnlPersonalInfo.add(Gcrud_2, "North");
        pnlPersonalAddress.add(Gcrud_3, "North");

        pnlContacts.add(Gcrud_4, "North");

        //DEFININDO CONFIGURAÇÕES GERAIS DO 
        //PREENCHIMENTO COM TAMANHO DEFINIDO PELOS COMPONENTES
        //pnlMain = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //TELA CHEIA
        pnlMain = new JPanel(new BorderLayout());
        pnlMain.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        add(pnlMain);
        pnlMain.add(tpnBasicData, "North");

    }

    private void loadFrame1() throws SQLException {

//        JLabel lblRegistros;
//        lblRegistros = new JLabel("Registros: ");
//
//        EMP_BasicInf.txtID.setEditable(true);
//        txtRegistros.setEnabled(false);
//        txtRegistros.setFont(new java.awt.Font("Tahoma", 1, 24));
//        txtRegistros.setForeground(new java.awt.Color(51, 51, 255));
//        txtRegistros.setHorizontalAlignment(javax.swing.JTextField.CENTER);
//
//        JPanel intPanel1;
//
//        intPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        intPanel1.add(lblRegistros);
//        intPanel1.add(txtRegistros);
//
//        loadTableBasicInfo();
//        scrollPane1 = new JScrollPane();
//        scrollPane1.setViewportView(tableBasicInfo);
//        pnlTable1 = new JPanel(new GridLayout(2, 1));
//        pnlTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
//        pnlTable1.add(scrollPane1);
//        pnlTable1.add(intPanel1);
//
//        pnlBasicData.add("North", Gcrud_1);
//        pnlBasicData.add("Center", EMP_BasicInf);
//        pnlBasicData.add("South", pnlTable1);

    }

    private void loadFrame2() throws SQLException {

        
//        
//        G_BasicTable = new CMP_GEN_Table_1(EMP_BasicInf.txtID, EMP_BasicInf.txtDataRegistro, EMP_BasicInf.txtIdentificacao);
//
//        EMP_BasicInf.txtID.setEditable(true);
//
//        pnlBasicData.add("North", Gcrud_1);
//        pnlBasicData.add("Center", EMP_BasicInf);
//        pnlBasicData.add("South", G_BasicTable);

    }

    private void events() {

//        Gcrud_1.cmdAdd.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                pnlTable1.setVisible(false);
//                pnlBasicData.remove(pnlTable1);
//                EMP_BasicInf.txtID.setEditable(false);
//                pnlBasicData.add("South", Gcmd_1);
//
//            }
//        });
//
//        Gcmd_1.cmdCancel.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                Gcrud_1.cmdSeach.doClick();
//
//            }
//        });
//
//        Gcrud_1.cmdSeach.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                pnlBasicData.setVisible(false);
//                pnlBasicData.removeAll();
//
//                try {
//                    loadFrame2();
//                } catch (SQLException ex) {
//                    Logger.getLogger(OLD_FRM_EMP_MAIN.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            }
//        });

    }

//    private void loadTableBasicInfo() throws SQLException {
//
//        employerDAO = new EmployerDAO();
//        List<Employers> list = new ArrayList(employerDAO.get_All_Entity_OrderByItemName());
//        int[] jumpColumn = new int[0]; //n colunas q vai pular  
//        String[] columnNames = employerDAO.columnNames;
//        DefaultTableModel model = new DefaultTableModel(EmployerDAO.preencherTabela(list), columnNames);
//
//        tableBasicInfo = new JTable(model);
//
//        SET_Table_3 configT = new SET_Table_3();
//
//        //configT.loadTableGeneric(tableBasicInfo, model, jumpColumn, this.txtRegistros, EMP_BasicInf.txtID, EMP_BasicInf.txtIdentificacao);
//
//    }

}
