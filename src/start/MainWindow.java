package start;

import GNF.GNF_Cidades;
import GNF.GNF_Estados;
import frames.Form_GNF;
import frames.employee.FrontEmployee;
import old.CMP_GEN_CRUD_1_old;
import old.CMP_GenericCmdPnl;
import old.OLD_FRM_EMP_MAIN;
import old.pne_Status;

import java.awt.Container;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_HORIZ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

public class MainWindow extends javax.swing.JFrame {

    public Container contentPane;

    private JMenuBar mbBarraMenu;
    private JMenu mnArquivo, mnCadastro, mnUtilitarios, mnOpcoes;
    private JMenuItem miSair, miBairros, miPonto, miClientes, miFuncoes, miSetores, miColaboradores, miCidades, miEstados;

    public MainWindow() {

        initComponents();
        events();
    }

    public void initComponents() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Tela Cheia
        setMinimumSize(new Dimension(500, 300));
        setTitle("Integrado"); // Nome do form

        //Container que abrigara os componentes
        contentPane = getContentPane();

        //Barra do Menu
        mbBarraMenu = new JMenuBar();

        //Menu principal
        mnArquivo = new JMenu("Arquivo");
        mnArquivo.setMnemonic('A');
        mnCadastro = new JMenu("Cadastro");
        mnCadastro.setMnemonic('C');
        mnUtilitarios = new JMenu("Utilitários");
        mnUtilitarios.setMnemonic('U');
        mnOpcoes = new JMenu("Opções");
        mnOpcoes.setMnemonic('O');

        //Itens dos menus
        miSair = new JMenuItem("Sair", new javax.swing.ImageIcon(getClass().getResource("/Images/encerrar_32x32.png")));
        miSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                ActionEvent.ALT_MASK)); // define o atalho "ALT+S" para executar o comando

        miPonto = new JMenuItem("Ponto");
        miClientes = new JMenuItem("Clientes");
        miFuncoes = new JMenuItem("Funções");
        miSetores = new JMenuItem("Setores");
        miColaboradores = new JMenuItem("Servidores");
        miCidades = new JMenuItem("Cidades");
        miBairros = new JMenuItem("Bairros");
        miEstados = new JMenuItem("Estados");

        //Adicionando os Itens aos menus
        mnArquivo.add(miSair);
        mnUtilitarios.add(miPonto);
        mnCadastro.add(miClientes);
        mnCadastro.add(miColaboradores);
        mnCadastro.add(miSetores);
        mnCadastro.add(miFuncoes);
        mnCadastro.add(miCidades);
        mnCadastro.add(miBairros);
        mnCadastro.add(miEstados);

        //Adicionando os itens a barra de menu
        mbBarraMenu.add(mnArquivo);
        mbBarraMenu.add(mnCadastro);
        mbBarraMenu.add(mnUtilitarios);
        mbBarraMenu.add(mnOpcoes);

        //Definindo a Barra 'mbBarraMenu' como sendo a barra de menu do Frame
        setJMenuBar(mbBarraMenu);

        //Adicionando o painel de status
        pne_Status statusPanel = new pne_Status(null);
          
        statusPanel.setSize(MAXIMIZED_HORIZ, 50);
        add(statusPanel, "South");
        
  
        
        
        

    }

    public void events() {

        miSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        miClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //frm_Clientes dialog = new frm_Clientes(null, null);//(new pn_P1_add());
               // dialog.setVisible(true);

            }
        });

        miEstados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    GNF_Estados gnf = new GNF_Estados();
                    Form_GNF dialog = new Form_GNF(gnf);
                    dialog.setVisible(true);

                } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        miCidades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {

                    GNF_Cidades gnf = new GNF_Cidades();
                    Form_GNF dialog = new Form_GNF(gnf);
                    dialog.setVisible(true);

                } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        miSetores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                frm_AddGenericR1 dialog = new frm_AddGenericR1();
//                dialog.setVisible(true);
            }
        });

        miFuncoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //  frm_Cargos dialog = new frm_Cargos(null, null);
              //  dialog.setVisible(true);
            }
        });

        miBairros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              // frm_Bairros dialog = new frm_Bairros(null, null, null);
             //   dialog.setVisible(true);
            }
        });

        miPonto.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                
                System.out.println("apertei");
                CMP_GEN_CRUD_1_old dialog = new CMP_GEN_CRUD_1_old();
                dialog.setVisible(true);
                
            }
        });

//        miColaboradores.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                OLD_FRM_EMP_MAIN dialog;
//                try {
//                    try {
//                        dialog = new OLD_FRM_EMP_MAIN();
//                        dialog.setVisible(true);
//                    } catch (ParseException ex) {
//                        Logger.getLogger(MAIN_FRM.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    
//                } catch (SQLException ex) {
//                    Logger.getLogger(MAIN_FRM.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//
//            }
//        });
        
                miColaboradores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                FrontEmployee dialog;
                try {
                    try {
                        dialog = new FrontEmployee();
                        dialog.setVisible(true);
                    } catch (ParseException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                

            }
        });
        

    }
}
