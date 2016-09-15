package Frames.Employers;

import Components.CMD.GNE_PNL_Cmd;
import Components.Tables.CMP_TBL_BasicTable;
import Frames.Employers.Employments.EmploymentsPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class EMP_INFO extends JFrame {
    
    
    //variáveis globais
    public static int idEmployer;
    public static String identifyEmployer;  
    public static boolean activedEmployer = true;

    
    public GNE_PNL_Cmd pnlCmds;
    public EMP_MAIN_ITENS pnlFields;
    // public EMP_GNE_PNL_SelectedIten pnlSelectedItens;
    private JPanel pnlPersonalInfo, x1, x2, x3, x4, x5, y1, y2, y3, pnlHead;
   // private String idFk, fkIdentify;
    private JTabbedPane tbnMain, tbnPersonal, tbnProfessional, tbnFinancial;
    JTextField txtEmployer;

    CMP_TBL_BasicTable gneTable;

    DateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");

    public EMP_INFO(int idMain, String identifyMain) throws SQLException, ParseException {

        EMP_INFO.idEmployer = idMain;
        EMP_INFO.identifyEmployer = identifyMain;
        
        
        

        configShow();
        initComps();
        event();

    }

    public void initComps() throws SQLException, ParseException {

        pnlFields = new EMP_MAIN_ITENS();
        pnlCmds = new GNE_PNL_Cmd();
      //  pnlSelectedItens = new EMP_GNE_PNL_SelectedIten();

        // pnlPersonalInfo = new JPanel();
        pnlHead = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel lblEmployer = new JLabel("Colaborador:");
        pnlHead.add(lblEmployer);

        txtEmployer = new JTextField(30);
        txtEmployer.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEmployer.setFont(new java.awt.Font("Tahoma", 1, 11));
        txtEmployer.setBackground(new java.awt.Color(255, 255, 200));
        txtEmployer.setForeground(new java.awt.Color(0, 0, 200));
        txtEmployer.setEditable(false);
        pnlHead.add(txtEmployer);

        x1 = new JPanel();
        x2 = new JPanel();
        x3 = new JPanel();
        x4 = new JPanel();
        x5 = new JPanel();

        y1 = new JPanel();
        y2 = new JPanel();
        y3 = new JPanel();

        tbnMain = new JTabbedPane();
        tbnPersonal = new JTabbedPane();
        tbnProfessional = new JTabbedPane();
        tbnFinancial = new JTabbedPane();

        tbnPersonal.addTab("Informações Pessoais", new EMP_DATAS());
        tbnPersonal.addTab("Contatos", new EMP_PHONES());
        tbnFinancial.addTab("Vínculos", new EmploymentsPanel());

        tbnProfessional.addTab("Vínculo", x1);
        tbnProfessional.addTab("Ocorrencias", x2);
        tbnProfessional.addTab("Habilidades", x3);
        tbnProfessional.addTab("Desempenho", x4);
        tbnProfessional.addTab("Avaliações", x5);

        
        tbnFinancial.addTab("Contratos", y1);
        tbnFinancial.addTab("Lançamentos", y2);
        tbnFinancial.addTab("Balanço", y3);

        tbnMain.addTab("Pessoal", tbnPersonal);
        tbnMain.addTab("Profissional", tbnProfessional);
        tbnMain.addTab("Financeiro", tbnFinancial);

        setDefault();

        add(pnlHead, BorderLayout.NORTH);
        add(tbnMain, BorderLayout.CENTER);

    }

    public void setDefault() {

        txtEmployer.setText(identifyEmployer);
        

    }

    private void event() {

        pnlCmds.cmdClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }

        });

    }
    

    private void configShow() {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(1024, 768)); // Tamanho
        setLocationRelativeTo(null); // Centralizar na tela
        setTitle("Colaboradores - Informações"); // Nome
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Images/work4.png"));
        this.setIconImage(imagemTitulo);

    }

}
