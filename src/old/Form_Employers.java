
/*
 * frm_Cidades.java
 *
 * Created on 02/09/2011, 08:36:21
 */
package old;

import GNF.GNF_Cidades;
import GNF.GNF_Estados;
import dao.EstateDAO;
import entities.City;
import entities.Estate;
import settings.SET_Table_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import static java.lang.System.in;

import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Vector;

import java.util.logging.Level;
import java.util.logging.Logger;
//import static javafx.scene.paint.Color.color;
//import static javafx.scene.paint.Color.color;
//import static javafx.scene.paint.Color.color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
//import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Andre
 */
public class Form_Employers extends javax.swing.JFrame {

    public Container C;

    public static int qtdLinhas = 0;
    private static int switchVar = 0;
    public boolean bond = false;
    private int cmbBondIndex;
    private int oldCmbIndex = -1;
    public int correspIdItem;
    private int idItemRow = 0;
    private String tempTableItem = null;
    private int tempCorrespCmbIndex = 0;
    private static int depure = 0;
    private int configCtrlVar = 0;
    private int defaulConfig = 0;
    private Insets in = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());
    private CMP_GenericCmdPnl gcomp3, gcomp2;

    int[] jumpColumn;
    String columnNames[];
    TableModel model;

    private EstateDAO estadosDAO = new EstateDAO();

    private GNF_Estados gnfEstados = new GNF_Estados();
    private GNF_Cidades gnfCidades = new GNF_Cidades();

    public Form_Employers(GNF_Estados gnfEstados) throws SQLException {

        this.gnfEstados = gnfEstados;
        bond = false;
        genericLoad(1);
        this.setTitle("Estados");

    }

    public Form_Employers(GNF_Cidades gnfCidades) throws SQLException {

        this.gnfCidades = gnfCidades;
        bond = true;
//        genericLoad(2);
        this.setTitle("Cidades");

    }

    public Form_Employers() throws SQLException {

        initComponents();

        tbp_Main.setSelectedIndex(0);

        setDefaultConfigItens();

    }

    private void genericLoad(int x) throws SQLException {

        switchVar = x;

        cmbBondIndex = -1;
        correspIdItem = 0;

        initComponents();

        tbp_Main.setSelectedIndex(0);

        setDefaultConfigItens();

//        addComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbp_Main = new javax.swing.JTabbedPane();
        pnl_A1 = new javax.swing.JPanel();
        pnlFill_A1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtPesquisaPorNome = new javax.swing.JTextField();
        txtRegistros = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPesquisaPorID = new javax.swing.JTextField();
        lblRegistros = new javax.swing.JLabel();
        cmbVinculoPesquisa = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        btmClean = new javax.swing.JButton();
        pnlCmdExecute_A1 = new javax.swing.JPanel();
        cmd_Ex_Update_A1 = new javax.swing.JButton();
        cmd_Ex_Cancel_A1 = new javax.swing.JButton();
        cmd_Ex_Exclude_A1 = new javax.swing.JButton();
        cmd_Ex_Accept_A1 = new javax.swing.JButton();
        jScrollPane1_A1 = new javax.swing.JScrollPane();
        jTable1_A1 = new javax.swing.JTable();
        pnlStatus_A1 = new javax.swing.JPanel();
        txtStatusPesquisa = new javax.swing.JTextField();
        pnlCmdControl_A1 = new javax.swing.JPanel();
        cmdAdd_A1 = new javax.swing.JButton();
        cmdEdit_A1 = new javax.swing.JButton();
        cmdSeach_A1 = new javax.swing.JButton();
        cmdExclude_A1 = new javax.swing.JButton();
        tbp_A2 = new javax.swing.JTabbedPane();
        pnl_Pessoal_dados = new javax.swing.JPanel();
        pnl_A3_2 = new javax.swing.JPanel();
        pnl_A3_3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        pnlSearchFilter1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtPesquisaPorNome1 = new javax.swing.JTextField();
        txtRegistros1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtPesquisaPorID1 = new javax.swing.JTextField();
        lblRegistros1 = new javax.swing.JLabel();
        cmbVinculoPesquisa1 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        btmClean1 = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        EPI = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro");
        setName("formGNF"); // NOI18N

        pnl_A1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pnlFill_A1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Identificação:");

        txtRegistros.setEditable(false);
        txtRegistros.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtRegistros.setForeground(new java.awt.Color(51, 51, 255));
        txtRegistros.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRegistros.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Registros");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("ID");

        txtPesquisaPorID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesquisaPorIDKeyTyped(evt);
            }
        });

        cmbVinculoPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbVinculoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVinculoPesquisaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Vínculo");

        btmClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clean32x32.png"))); // NOI18N
        btmClean.setText("Limpar");
        btmClean.setMaximumSize(new java.awt.Dimension(113, 43));
        btmClean.setMinimumSize(new java.awt.Dimension(113, 43));
        btmClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmCleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFill_A1Layout = new javax.swing.GroupLayout(pnlFill_A1);
        pnlFill_A1.setLayout(pnlFill_A1Layout);
        pnlFill_A1Layout.setHorizontalGroup(
            pnlFill_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFill_A1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFill_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFill_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlFill_A1Layout.createSequentialGroup()
                        .addComponent(txtPesquisaPorID, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbVinculoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPesquisaPorNome, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(pnlFill_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFill_A1Layout.createSequentialGroup()
                        .addGap(326, 326, 326)
                        .addComponent(lblRegistros))
                    .addGroup(pnlFill_A1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btmClean, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFill_A1Layout.setVerticalGroup(
            pnlFill_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFill_A1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFill_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFill_A1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlFill_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPesquisaPorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbVinculoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFill_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPesquisaPorNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlFill_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btmClean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtRegistros)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addComponent(lblRegistros))
        );

        pnlCmdExecute_A1.setBackground(new java.awt.Color(204, 204, 204));
        pnlCmdExecute_A1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cmd_Ex_Update_A1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icn_C_Update_32x32.png"))); // NOI18N
        cmd_Ex_Update_A1.setText("Confirmar");
        cmd_Ex_Update_A1.setMaximumSize(new java.awt.Dimension(113, 43));
        cmd_Ex_Update_A1.setMinimumSize(new java.awt.Dimension(113, 43));
        cmd_Ex_Update_A1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_Ex_Update_A1ActionPerformed(evt);
            }
        });

        cmd_Ex_Cancel_A1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icn_C_Cancel_32x32.png"))); // NOI18N
        cmd_Ex_Cancel_A1.setText("Cancelar");
        cmd_Ex_Cancel_A1.setMaximumSize(new java.awt.Dimension(113, 43));
        cmd_Ex_Cancel_A1.setMinimumSize(new java.awt.Dimension(113, 43));
        cmd_Ex_Cancel_A1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_Ex_Cancel_A1ActionPerformed(evt);
            }
        });

        cmd_Ex_Exclude_A1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icn_C_Delete_32x32.png"))); // NOI18N
        cmd_Ex_Exclude_A1.setText("Confirmar");
        cmd_Ex_Exclude_A1.setMaximumSize(new java.awt.Dimension(113, 43));
        cmd_Ex_Exclude_A1.setMinimumSize(new java.awt.Dimension(113, 43));
        cmd_Ex_Exclude_A1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_Ex_Exclude_A1ActionPerformed(evt);
            }
        });

        cmd_Ex_Accept_A1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icn_C_Add_32x32.png"))); // NOI18N
        cmd_Ex_Accept_A1.setText("Confirmar");
        cmd_Ex_Accept_A1.setMaximumSize(new java.awt.Dimension(113, 43));
        cmd_Ex_Accept_A1.setMinimumSize(new java.awt.Dimension(113, 43));
        cmd_Ex_Accept_A1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_Ex_Accept_A1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCmdExecute_A1Layout = new javax.swing.GroupLayout(pnlCmdExecute_A1);
        pnlCmdExecute_A1.setLayout(pnlCmdExecute_A1Layout);
        pnlCmdExecute_A1Layout.setHorizontalGroup(
            pnlCmdExecute_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCmdExecute_A1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmd_Ex_Accept_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmd_Ex_Update_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmd_Ex_Exclude_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmd_Ex_Cancel_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlCmdExecute_A1Layout.setVerticalGroup(
            pnlCmdExecute_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCmdExecute_A1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCmdExecute_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmd_Ex_Update_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmd_Ex_Exclude_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmd_Ex_Cancel_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmd_Ex_Accept_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable1_A1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable1_A1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1_A1.setViewportView(jTable1_A1);

        pnlStatus_A1.setBackground(new java.awt.Color(204, 204, 204));
        pnlStatus_A1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtStatusPesquisa.setEditable(false);
        txtStatusPesquisa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStatusPesquisaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout pnlStatus_A1Layout = new javax.swing.GroupLayout(pnlStatus_A1);
        pnlStatus_A1.setLayout(pnlStatus_A1Layout);
        pnlStatus_A1Layout.setHorizontalGroup(
            pnlStatus_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatus_A1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtStatusPesquisa)
                .addContainerGap())
        );
        pnlStatus_A1Layout.setVerticalGroup(
            pnlStatus_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatus_A1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtStatusPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCmdControl_A1.setBackground(new java.awt.Color(204, 204, 204));
        pnlCmdControl_A1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        cmdAdd_A1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icnAdd_32x32.png"))); // NOI18N
        cmdAdd_A1.setText("Adicionar");
        cmdAdd_A1.setMaximumSize(new java.awt.Dimension(113, 43));
        cmdAdd_A1.setMinimumSize(new java.awt.Dimension(113, 43));
        cmdAdd_A1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAdd_A1ActionPerformed(evt);
            }
        });

        cmdEdit_A1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icnEdit_32x32.png"))); // NOI18N
        cmdEdit_A1.setText("Editar");
        cmdEdit_A1.setMaximumSize(new java.awt.Dimension(113, 43));
        cmdEdit_A1.setMinimumSize(new java.awt.Dimension(113, 43));
        cmdEdit_A1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEdit_A1ActionPerformed(evt);
            }
        });

        cmdSeach_A1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icnSerch_32x32.png"))); // NOI18N
        cmdSeach_A1.setText("Pesquisar");
        cmdSeach_A1.setMaximumSize(new java.awt.Dimension(113, 43));
        cmdSeach_A1.setMinimumSize(new java.awt.Dimension(113, 43));
        cmdSeach_A1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSeach_A1ActionPerformed(evt);
            }
        });

        cmdExclude_A1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icnRemove_32x32.png"))); // NOI18N
        cmdExclude_A1.setText("Excluir");
        cmdExclude_A1.setMaximumSize(new java.awt.Dimension(113, 43));
        cmdExclude_A1.setMinimumSize(new java.awt.Dimension(113, 43));
        cmdExclude_A1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdExclude_A1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCmdControl_A1Layout = new javax.swing.GroupLayout(pnlCmdControl_A1);
        pnlCmdControl_A1.setLayout(pnlCmdControl_A1Layout);
        pnlCmdControl_A1Layout.setHorizontalGroup(
            pnlCmdControl_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCmdControl_A1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdSeach_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdAdd_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdEdit_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdExclude_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(285, Short.MAX_VALUE))
        );
        pnlCmdControl_A1Layout.setVerticalGroup(
            pnlCmdControl_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCmdControl_A1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCmdControl_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdAdd_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdEdit_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdSeach_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdExclude_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnl_A1Layout = new javax.swing.GroupLayout(pnl_A1);
        pnl_A1.setLayout(pnl_A1Layout);
        pnl_A1Layout.setHorizontalGroup(
            pnl_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_A1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCmdExecute_A1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlStatus_A1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCmdControl_A1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFill_A1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1_A1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        pnl_A1Layout.setVerticalGroup(
            pnl_A1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_A1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCmdControl_A1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFill_A1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1_A1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCmdExecute_A1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlStatus_A1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tbp_Main.addTab("Cadastro Básico", pnl_A1);

        javax.swing.GroupLayout pnl_Pessoal_dadosLayout = new javax.swing.GroupLayout(pnl_Pessoal_dados);
        pnl_Pessoal_dados.setLayout(pnl_Pessoal_dadosLayout);
        pnl_Pessoal_dadosLayout.setHorizontalGroup(
            pnl_Pessoal_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 916, Short.MAX_VALUE)
        );
        pnl_Pessoal_dadosLayout.setVerticalGroup(
            pnl_Pessoal_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        tbp_A2.addTab("Contatos", pnl_Pessoal_dados);

        javax.swing.GroupLayout pnl_A3_2Layout = new javax.swing.GroupLayout(pnl_A3_2);
        pnl_A3_2.setLayout(pnl_A3_2Layout);
        pnl_A3_2Layout.setHorizontalGroup(
            pnl_A3_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 916, Short.MAX_VALUE)
        );
        pnl_A3_2Layout.setVerticalGroup(
            pnl_A3_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        tbp_A2.addTab("Endereços", pnl_A3_2);

        jLabel9.setText("nascimento, idade, identidade, cpf");

        pnlSearchFilter1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Nome");

        txtRegistros1.setEditable(false);
        txtRegistros1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtRegistros1.setForeground(new java.awt.Color(51, 51, 255));
        txtRegistros1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRegistros1.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Registros");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("ID");

        txtPesquisaPorID1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesquisaPorID1KeyTyped(evt);
            }
        });

        cmbVinculoPesquisa1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbVinculoPesquisa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVinculoPesquisa1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Vínculo");

        btmClean1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clean32x32.png"))); // NOI18N
        btmClean1.setText("Limpar");
        btmClean1.setMaximumSize(new java.awt.Dimension(113, 43));
        btmClean1.setMinimumSize(new java.awt.Dimension(113, 43));
        btmClean1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmClean1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSearchFilter1Layout = new javax.swing.GroupLayout(pnlSearchFilter1);
        pnlSearchFilter1.setLayout(pnlSearchFilter1Layout);
        pnlSearchFilter1Layout.setHorizontalGroup(
            pnlSearchFilter1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchFilter1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSearchFilter1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlSearchFilter1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(25, 25, 25)
                        .addComponent(txtPesquisaPorID1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbVinculoPesquisa1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSearchFilter1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisaPorNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnlSearchFilter1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSearchFilter1Layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(lblRegistros1)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSearchFilter1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                        .addComponent(btmClean1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txtRegistros1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSearchFilter1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
        );
        pnlSearchFilter1Layout.setVerticalGroup(
            pnlSearchFilter1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchFilter1Layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSearchFilter1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btmClean1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRegistros1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSearchFilter1Layout.createSequentialGroup()
                        .addGroup(pnlSearchFilter1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtPesquisaPorID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbVinculoPesquisa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlSearchFilter1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtPesquisaPorNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(lblRegistros1))
        );

        javax.swing.GroupLayout pnl_A3_3Layout = new javax.swing.GroupLayout(pnl_A3_3);
        pnl_A3_3.setLayout(pnl_A3_3Layout);
        pnl_A3_3Layout.setHorizontalGroup(
            pnl_A3_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_A3_3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(311, 311, 311))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_A3_3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSearchFilter1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_A3_3Layout.setVerticalGroup(
            pnl_A3_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_A3_3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSearchFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(151, 151, 151))
        );

        tbp_A2.addTab("Dados", pnl_A3_3);

        tbp_Main.addTab("Pessoal", tbp_A2);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 916, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Contrato", jPanel13);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 916, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Vinculos", jPanel3);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 916, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Habilidades", jPanel8);

        tbp_Main.addTab("Profissional", jTabbedPane2);

        jLabel8.setText("a ideia é ter uma lista e na coluna table marcar a q está em vigor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addComponent(jLabel8)
                .addContainerGap(244, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel8)
                .addContainerGap(408, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Contrato", jPanel1);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 916, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("balanço", jPanel14);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 916, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("CEI CUSTO EFETIVO INDIVIDUALIZADO", jPanel15);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 916, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Folha", jPanel2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 916, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Pagamentos", jPanel4);

        tbp_Main.addTab("Remunerações", jTabbedPane3);

        javax.swing.GroupLayout EPILayout = new javax.swing.GroupLayout(EPI);
        EPI.setLayout(EPILayout);
        EPILayout.setHorizontalGroup(
            EPILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 916, Short.MAX_VALUE)
        );
        EPILayout.setVerticalGroup(
            EPILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab1", EPI);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 916, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Referencias", jPanel6);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 916, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Pendencias", jPanel9);

        jLabel10.setText("tabela, emitir guias");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(jLabel10)
                .addContainerGap(581, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(jLabel10)
                .addContainerGap(347, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("EPI", jPanel10);

        jLabel11.setText("pelo vinculo, de faltas, afastamento por problema de saude, atestados etc");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jLabel11)
                .addContainerGap(260, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jLabel11)
                .addContainerGap(391, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Histórico", jPanel7);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 916, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Observações", jPanel12);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 916, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Avaliações", jPanel11);

        tbp_Main.addTab("Anotações", jTabbedPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbp_Main))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbp_Main))
        );

        setSize(new java.awt.Dimension(956, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void configCtrl(int itemGhost, java.awt.Component[] cpcount) {

        //  itemGhost--;
        //int ConfigCmdExecutePanel = 0;
        for (int i = 0; i < cpcount.length; i++) {

            if (cpcount[i] instanceof JButton) {

                if (i == itemGhost) {
                    cpcount[i].setBackground(new Color(204, 255, 255));

                } else {
                    cpcount[i].setBackground(new Color(240, 240, 240));
                }

            }

        }

        //Tela cheia.
        //int width = dimension.width - (in.left + in.top);
        //int height = dimension.height - (in.top + in.bottom);
        //setSize(width, height);
        //setLocation(in.left, in.top);
        Point position = pnlCmdExecute_A1.getPopupLocation(null);
        // itemGhost++;
        switch (itemGhost) {

            case 0:

                pnlCmdExecute_A1.setBackground(new Color(204, 204, 204));
                cmd_Ex_Accept_A1.setVisible(false);
                cmd_Ex_Update_A1.setVisible(false);
                cmd_Ex_Exclude_A1.setVisible(false);

                pnlStatus_A1.setVisible(true);
                pnlCmdExecute_A1.setVisible(false);

                break;

            case 1:

                pnlCmdExecute_A1.setBackground(new Color(204, 255, 153));
                cmd_Ex_Accept_A1.setVisible(true);

                cmd_Ex_Update_A1.setVisible(false);
                cmd_Ex_Exclude_A1.setVisible(false);
                cmd_Ex_Cancel_A1.setVisible(true);

                pnlStatus_A1.setVisible(true);
                pnlCmdExecute_A1.setVisible(true);

                //System.out.println("posit" + cmd_Ex_Accept_A1.getPopupLocation(null).toString());
                break;
            case 2:

                pnlCmdExecute_A1.setBackground(new Color(204, 255, 255));
                cmd_Ex_Accept_A1.setVisible(false);
                cmd_Ex_Update_A1.setVisible(true);
                cmd_Ex_Exclude_A1.setVisible(false);
                cmd_Ex_Cancel_A1.setVisible(true);

                pnlStatus_A1.setVisible(true);
                pnlCmdExecute_A1.setVisible(true);
                //cmd_Ex_Update_A1.setLocation(pnlCmdExecute_A1.getPopupLocation(null));

                break;
            case 3:
                cmd_Ex_Accept_A1.setVisible(false);
                cmd_Ex_Update_A1.setVisible(false);
                cmd_Ex_Exclude_A1.setVisible(true);
                cmd_Ex_Cancel_A1.setVisible(true);

                pnlStatus_A1.setVisible(true);
                pnlCmdExecute_A1.setVisible(true);
                // cmd_Ex_Update_A1.setLocation(position);

                pnlCmdExecute_A1.setBackground(new Color(255, 204, 204));

                break;

        }

    }

    private void switchCtrlConfig() {

        switch (configCtrlVar) {//esse shitch esta inutil pq ambos chamam a mesma coisa vou configuralo pra o painel

            case 0:

                configCtrl(configCtrlVar, pnlCmdControl_A1.getComponents());
                break;

            case 1:
                configCtrl(configCtrlVar, pnlCmdControl_A1.getComponents());
                break;
            case 2:

                configCtrl(configCtrlVar, pnlCmdControl_A1.getComponents());
                break;
            case 3:
                configCtrl(configCtrlVar, pnlCmdControl_A1.getComponents());
                break;

        }

    }

    private void setDefaultConfigItens() throws SQLException {

        configCtrlVar = 0;
        switchCtrlConfig();

        if (bond == false) {

            jLabel6.setVisible(false);

            cmbVinculoPesquisa.setVisible(false);

            loadTable1();

        } else if (bond == true) {

            jLabel6.setVisible(true);

            cmbVinculoPesquisa.setVisible(true);
            cmbVinculoPesquisa.setSelectedIndex(-1); // esse item vai chamar o actionperformed do cmb que chamara o load cmb e lá o loadtable

        }

    }

    private void cmd_Ex_Update_A1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_Ex_Update_A1ActionPerformed

        try {
            switchUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Employers.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_cmd_Ex_Update_A1ActionPerformed

    private void cmd_Ex_Exclude_A1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_Ex_Exclude_A1ActionPerformed

        int row = jTable1_A1.getSelectedRow();

        if (row == -1) {

            txtStatusPesquisarAlertConfig("ATENÇÃO: Escolha um item na tabela!");
            txtStatusPesquisa.requestFocus();

            return;
        }

        txtStatusPesquisarAlertConfig("ATENÇÃO: A exclusão deste item pode acarretar em perda de dados vinculados a outras informações");

        int resp = JOptionPane.showConfirmDialog(this, "Tem Certeza?", "Deseja excluir", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resp != 0) {

            txtStatusPesquisaFocusLost(null);

            return;
        }

        Object id = jTable1_A1.getValueAt(row, 0);
        String temp = String.valueOf(id);
        int IdPk = Integer.parseInt(temp);

        try {

            switchRemove(IdPk);

            btmClean.doClick();

            txtStatusPesquisa.setBackground(Color.white);
            txtStatusPesquisa.setForeground(Color.blue);
            txtStatusPesquisa.setText("Item EXCLUIDO com sucesso!");
            txtStatusPesquisa.requestFocus();

        } catch (SQLException ex) {
            Logger.getLogger(Form_Employers.class
                    .getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_cmd_Ex_Exclude_A1ActionPerformed

    private void cmd_Ex_Cancel_A1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_Ex_Cancel_A1ActionPerformed

        configCtrlVar = 0;
        switchCtrlConfig();


    }//GEN-LAST:event_cmd_Ex_Cancel_A1ActionPerformed

    private void cmd_Ex_Accept_A1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_Ex_Accept_A1ActionPerformed

        try {

            switchAdd();

        } catch (SQLException ex) {
            Logger.getLogger(Form_Employers.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_cmd_Ex_Accept_A1ActionPerformed

    private void txtPesquisaPorIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaPorIDKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }

    }//GEN-LAST:event_txtPesquisaPorIDKeyTyped

    private void cmbVinculoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVinculoPesquisaActionPerformed

        System.out.println("cmbVinculoPesquisarActionPerformed -> " + depure++);

        cmbBondIndex = cmbVinculoPesquisa.getSelectedIndex();

        if (cmbVinculoPesquisa.getItemCount() > 0 && cmbBondIndex != -1) {//
            String item = cmbVinculoPesquisa.getSelectedItem().toString();
            correspIdItem = estadosDAO.get_Id_Entity(item);

            if (oldCmbIndex != cmbBondIndex) {

                try {
                    loadTable1();
                } catch (SQLException ex) {
                    Logger.getLogger(Form_Employers.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {

            try {
                loadCmbBond();
            } catch (SQLException ex) {
                Logger.getLogger(Form_Employers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        oldCmbIndex = cmbBondIndex;

    }//GEN-LAST:event_cmbVinculoPesquisaActionPerformed

    private void btmCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmCleanActionPerformed

        txtPesquisaPorNome.setText(null);
        txtPesquisaPorID.setText(null);

        if (bond == true) {
            cmbVinculoPesquisa.setSelectedIndex(-1);
        } else {
            try {
                loadTable1();
            } catch (SQLException ex) {
                Logger.getLogger(Form_Employers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_btmCleanActionPerformed

    private void txtStatusPesquisaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStatusPesquisaFocusLost

        txtStatusPesquisa.setText(null);
        txtStatusPesquisa.setForeground(Color.black);
        txtStatusPesquisa.setBackground(Color.white);


    }//GEN-LAST:event_txtStatusPesquisaFocusLost

    private void cmbVinculoPesquisa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVinculoPesquisa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbVinculoPesquisa1ActionPerformed

    private void btmClean1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmClean1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btmClean1ActionPerformed

    private void txtPesquisaPorID1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaPorID1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaPorID1KeyTyped

    private void cmdAdd_A1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAdd_A1ActionPerformed
        configCtrlVar = 1;
        switchCtrlConfig();
    }//GEN-LAST:event_cmdAdd_A1ActionPerformed

    private void cmdEdit_A1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEdit_A1ActionPerformed
        configCtrlVar = 2;
        switchCtrlConfig();
    }//GEN-LAST:event_cmdEdit_A1ActionPerformed

    private void cmdExclude_A1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdExclude_A1ActionPerformed
        configCtrlVar = 3;
        switchCtrlConfig();
    }//GEN-LAST:event_cmdExclude_A1ActionPerformed

    private void cmdSeach_A1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSeach_A1ActionPerformed
        configCtrlVar = 0;
        switchCtrlConfig();
    }//GEN-LAST:event_cmdSeach_A1ActionPerformed

    private void txtStatusPesquisarAlertConfig(String texto) {

        txtStatusPesquisa.setText(texto);
        txtStatusPesquisa.setForeground(Color.red);
        txtStatusPesquisa.setBackground(Color.yellow);

    }

    public void loadTable1() throws SQLException {

        System.out.println("loadTable1 -> " + depure++);

        switchTable1();

        SET_Table_2 configT = new SET_Table_2();

        configT.loadTableGeneric(jTable1_A1, model, jumpColumn, txtRegistros, txtPesquisaPorID, txtPesquisaPorNome);

    }

    public void switchTable1() throws SQLException {

        switch (switchVar) {

            case 1:

                List<Estate> list = new ArrayList(gnfEstados.listItens());

                jumpColumn = new int[0]; //n colunas q vai pular  

                columnNames = gnfEstados.columnNames;

                model = new DefaultTableModel(GNF_Estados.preencherTabela(list), columnNames) {

                };

                break;

            case 2:

                List<?> newList = new ArrayList();

                jumpColumn = new int[1]; //n colunas q vai pular

                jumpColumn[0] = 1; // coluna pulada

                if (cmbBondIndex == -1) {

                    List<City> lista = new ArrayList(gnfCidades.listItens());
                    columnNames = gnfCidades.columnNames;
                    model = new DefaultTableModel(GNF_Cidades.preencherTabela(lista), columnNames) {

                    };

                } else {

                    List<City> lista = new ArrayList(gnfCidades.listItensBond(correspIdItem)); // lista com passagem do indice do combobox
                    columnNames = gnfCidades.columnNames;

                    model = new DefaultTableModel(GNF_Cidades.preencherTabela(lista), columnNames) {

                    };

                }

                break;

            case 3:

                break;

            default:
            //comand
        }

    }

    private void switchRemove(int IdPK) throws SQLException {

        switch (switchVar) {

            case 1:

                gnfEstados.removeItem(IdPK);

                break;

            case 2:

                gnfCidades.removeItem(IdPK);

                break;

            case 3:

                break;

            default:
            //comand
        }

    }

    private void switchUpdate() throws SQLException {

        int row = jTable1_A1.getSelectedRow();

        if (row == -1) {

            txtStatusPesquisarAlertConfig("ATENÇÃO: Escolha um item na tabela!");
            txtStatusPesquisa.requestFocus();

            return;
        }

        tbp_Main.setSelectedIndex(1);
        idItemRow = (Integer) jTable1_A1.getValueAt(row, 0);

        Object nome = null;

        switch (switchVar) {

            case 1:

                nome = jTable1_A1.getValueAt(row, 1);
                tempTableItem = String.valueOf(jTable1_A1.getValueAt(row, 1));

                break;

            case 2:

                nome = jTable1_A1.getValueAt(row, 2);
                tempTableItem = String.valueOf(jTable1_A1.getValueAt(row, 2));

                //cmbVinculoCadastro.setToolTipText(String.valueOf(jTable1.getValueAt(row, 1)));
                //if (cmbVinculoCadastro.getItemCount() > 0 && cmbBondIndex != -1) {//
                String item = String.valueOf(jTable1_A1.getValueAt(row, 1));
                tempCorrespCmbIndex = estadosDAO.get_Id_Entity(item);
                tempCorrespCmbIndex--;

                // }
                break;

            case 3:

                break;

            default:
            //comand
        }

    }

    private void switchAdd() throws SQLException {

        switch (switchVar) {

            case 1:

                break;

            case 2:

                break;

            case 3:

                break;

            default:
            //comand
        }

    }

    private void loadCmbBond() throws SQLException {

        System.out.println("loadCmbBond -> " + depure++);

        switch (switchVar) {

            case 2:

                Vector<Estate> estados = new Vector(estadosDAO.get_All_Entity_OrderByItemName());
                DefaultComboBoxModel cmb = new DefaultComboBoxModel(estados);
                cmbVinculoPesquisa.setModel(cmb);
                cmbVinculoPesquisa.setSelectedIndex(cmbBondIndex);

                try {
                    loadTable1();

                } catch (SQLException ex) {
                    Logger.getLogger(Form_Employers.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

                break;

            case 3:

                break;

            default:
            //comand
        }

    }

    public void selectTableRow(int idF) {

        int idFind = idF;
        idFind--;
        int linha = 1;
        int i = 0;
        boolean found = false;

        while (found == false) { // esse wile é mais eficiente que //while (i < jTable1.getRowCount()){

            if (Integer.parseInt(String.valueOf(jTable1_A1.getValueAt(i, 0))) == idFind) {

                linha = i;
                found = true;

            }

            i++;
        }

        jTable1_A1.setRowSelectionInterval(linha, linha);
    }

    public void addSucess(int request) throws SQLException {

        loadTable1();

        tbp_Main.setSelectedIndex(0);

        txtStatusPesquisa.requestFocus();
        txtStatusPesquisa.setForeground(Color.blue);

        switch (request) {

            case 1:

                txtStatusPesquisa.setText("Item ADICIONADO com sucesso!");

                break;

            case 2:
                txtStatusPesquisa.requestFocus();
                txtStatusPesquisa.setText("Item ATUALIZADO com sucesso!");

                break;
        }

    }

    private javax.swing.JPanel pnlNewData,
            pnlData, pnlAddress, pnlContacts,
            pnlContract, pnlLink, pnlSkill,
            pnlAgreement, pnlPaycheck, pnlPayments, pnlCET, pnlBLC,
            pnlobservation, pnlPerformance, pnlEvaluation, pnlHistorical, pnlReference, pnlEPI;

    private CMP_GenericCmdPnl gcpCpnlNewData,
            gcpCpnlData, gcpCpnlAddress, gcpCpnlContacts,
            gcpCpnlContract, gcpCpnlLink, gcpCpnlSkill,
            gcpCpnlAgreement, gcpCpnlPaycheck, gcpCpnlPayments, gcpCpnlCET, gcpCpnlBLC,
            gcpCpnlobservation, gcpCpnlPerformance, gcpCpnlEvaluation, gcpCpnlHistorical, gcpCpnlReference, gcpCpnlEPI;

    private CMP_GenericSettersPnl xa1;
    private CMP_GenericTablePnl xa2;
    private CMP_GenericStatusPnl xa3;

    private javax.swing.JTabbedPane tpnBasicData, tpnPersonal, tpnProfessional, tpnPayment, tpnNote;

    public void addComponents() {

//        C = getContentPane();
        
        //GridBagConstraints cons = new GridBagConstraints();
  //      GridBagLayout layout = new GridBagLayout();
//        C.setLayout(layout);
//        C.add(tpnBasicData("Esquerda"));
//        
         
        
        CMP_GEN_CRUD_1_old cmd = new CMP_GEN_CRUD_1_old();
        pnl_Pessoal_dados.add(cmd);
        
        
//        tpnBasicData = new JTabbedPane();
//        tpnPersonal = new JTabbedPane();
//        tpnProfessional = new JTabbedPane();
//        tpnPayment = new JTabbedPane();
//        tpnNote = new JTabbedPane();
//
//        tpnBasicData.setName("Cadastro básico");
//        tpnPersonal.setName("Pessoal");
//        tpnProfessional.setName("Profissional");
//        tpnPayment.setName("Remunerações");
//        tpnNote.setName("Anotações");
//
//
//        
//        
//        tbp_Main.add(tpnBasicData);
//        tbp_Main.add(tpnPersonal);
//        tbp_Main.add(tpnProfessional);
//        tbp_Main.add(tpnPayment);
//        tbp_Main.add(tpnNote);
//
//        gcpCpnlNewData = new CMP_GenericCmdPnl();
//        gcpCpnlData = new CMP_GenericCmdPnl();
//
//        xa1 = new CMP_GenericSettersPnl();
//        xa2 = new CMP_GenericTablePnl();
//        xa3 = new CMP_GenericStatusPnl();

        //pnlData = new JPanel(new FlowLayout(1, 3, 3));// linha coluna espaçamento h espaçamento v
        
//       pnlData.setLayout(layout);
        //pnlData = new JPanel(new BorderLayout());// linha coluna espaçamento h espaçamento v
        //pnlData = new JPanel(new GridLayout(4, 1, 3, 3));// linha coluna espaçamento h espaçamento v
        
        
//        pnlData.setName("Dados");
//
//        tpnBasicData.add(pnlData);

        
       // pnlData.add(new CMP_GenericCmdPnl(), cons);
        
        
//        pnlData.add(xa1);
//        pnlData.add(xa2);
//        pnlData.add(xa3);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EPI;
    private javax.swing.JButton btmClean;
    private javax.swing.JButton btmClean1;
    private javax.swing.JComboBox cmbVinculoPesquisa;
    private javax.swing.JComboBox cmbVinculoPesquisa1;
    private javax.swing.JButton cmdAdd_A1;
    private javax.swing.JButton cmdEdit_A1;
    private javax.swing.JButton cmdExclude_A1;
    private javax.swing.JButton cmdSeach_A1;
    private javax.swing.JButton cmd_Ex_Accept_A1;
    private javax.swing.JButton cmd_Ex_Cancel_A1;
    private javax.swing.JButton cmd_Ex_Exclude_A1;
    private javax.swing.JButton cmd_Ex_Update_A1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1_A1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    javax.swing.JTable jTable1_A1;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JLabel lblRegistros1;
    private javax.swing.JPanel pnlCmdControl_A1;
    private javax.swing.JPanel pnlCmdExecute_A1;
    private javax.swing.JPanel pnlFill_A1;
    private javax.swing.JPanel pnlSearchFilter1;
    private javax.swing.JPanel pnlStatus_A1;
    private javax.swing.JPanel pnl_A1;
    private javax.swing.JPanel pnl_A3_2;
    private javax.swing.JPanel pnl_A3_3;
    private javax.swing.JPanel pnl_Pessoal_dados;
    private javax.swing.JTabbedPane tbp_A2;
    private javax.swing.JTabbedPane tbp_Main;
    private javax.swing.JTextField txtPesquisaPorID;
    private javax.swing.JTextField txtPesquisaPorID1;
    private javax.swing.JTextField txtPesquisaPorNome;
    private javax.swing.JTextField txtPesquisaPorNome1;
    private javax.swing.JTextField txtRegistros;
    private javax.swing.JTextField txtRegistros1;
    private javax.swing.JTextField txtStatusPesquisa;
    // End of variables declaration//GEN-END:variables

}
