
/*
 * frm_Cidades.java
 *
 * Created on 02/09/2011, 08:36:21
 */
package Frames;

import DAO.EstadosDAO;
import Entidades.Cidades;
import Entidades.Estados;
import GNF.GNF_Cidades;
import GNF.GNF_Estados;

import Settings.SET_Table_2;
import java.awt.Color;

import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Vector;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Andre
 */
public class Form_GNF extends javax.swing.JFrame {
    
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
    
    int[] jumpColumn;
    String columnNames[];
    TableModel model;
    
    private EstadosDAO estadosDAO = new EstadosDAO();
    
    private GNF_Estados gnfEstados = new GNF_Estados();
    private GNF_Cidades gnfCidades = new GNF_Cidades();
    
    public Form_GNF(GNF_Estados gnfEstados) throws SQLException {
        
        this.gnfEstados = gnfEstados;
        bond = false;
        genericLoad(1);
        this.setTitle("Estados");
        
    }
    
    public Form_GNF(GNF_Cidades gnfCidades) throws SQLException {
        
        this.gnfCidades = gnfCidades;
        bond = true;
        genericLoad(2);
        this.setTitle("Cidades");
        
    }
    
    public Form_GNF() throws SQLException {
        
        initComponents();
        
        tbpMain.setSelectedIndex(0);
        //jTabbedPane1.setMnemonicAt(0, KeyEvent.VK_1);
        //jTabbedPane1.setMnemonicAt(1, KeyEvent.VK_2);

        //loadTable1();
        //txtCodigo.setText(String.valueOf(gnf.codItem()));
        setDefaultConfigItens();
        
    }
    
    private void genericLoad(int x) throws SQLException {
        
        switchVar = x;
        
        cmbBondIndex = -1;
        correspIdItem = 0;
        
        initComponents();
        
        tbpMain.setSelectedIndex(0);
        
        setDefaultConfigItens();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbpMain = new javax.swing.JTabbedPane();
        pnlSearch = new javax.swing.JPanel();
        pnlSearchFilter = new javax.swing.JPanel();
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
        pnlCmdSearch = new javax.swing.JPanel();
        btmEdit = new javax.swing.JButton();
        btmExit = new javax.swing.JButton();
        btmExclude = new javax.swing.JButton();
        btmInclude = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnlStatusPesquisa = new javax.swing.JPanel();
        txtStatusPesquisa = new javax.swing.JTextField();
        pnlCadastre = new javax.swing.JPanel();
        pnlStatusCadastro = new javax.swing.JPanel();
        txtStatusCadastro = new javax.swing.JTextField();
        pnlCmdCadastre = new javax.swing.JPanel();
        btmExit1 = new javax.swing.JButton();
        btmAdd = new javax.swing.JButton();
        btmCancel = new javax.swing.JButton();
        btmUpdate = new javax.swing.JButton();
        btmNext = new javax.swing.JButton();
        pnlItem = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCadastro = new javax.swing.JTextField();
        cmbVinculoCadastro = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro");
        setName("formGNF"); // NOI18N

        pnlSearch.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pnlSearchFilter.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro de Pesquisa"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Nome");

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

        btmClean.setText("Limpar");
        btmClean.setMaximumSize(new java.awt.Dimension(113, 43));
        btmClean.setMinimumSize(new java.awt.Dimension(113, 43));
        btmClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmCleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSearchFilterLayout = new javax.swing.GroupLayout(pnlSearchFilter);
        pnlSearchFilter.setLayout(pnlSearchFilterLayout);
        pnlSearchFilterLayout.setHorizontalGroup(
            pnlSearchFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchFilterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSearchFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlSearchFilterLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(25, 25, 25)
                        .addComponent(txtPesquisaPorID, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbVinculoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSearchFilterLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisaPorNome, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btmClean, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlSearchFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlSearchFilterLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(lblRegistros)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSearchFilterLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addContainerGap())))
        );
        pnlSearchFilterLayout.setVerticalGroup(
            pnlSearchFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchFilterLayout.createSequentialGroup()
                .addGroup(pnlSearchFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSearchFilterLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel5))
                    .addGroup(pnlSearchFilterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlSearchFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRegistros, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSearchFilterLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(pnlSearchFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtPesquisaPorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbVinculoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlSearchFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtPesquisaPorNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btmClean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(lblRegistros))
        );

        pnlCmdSearch.setBackground(new java.awt.Color(204, 204, 204));
        pnlCmdSearch.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btmEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/editar_32x32.png"))); // NOI18N
        btmEdit.setText("Editar");
        btmEdit.setMaximumSize(new java.awt.Dimension(113, 43));
        btmEdit.setMinimumSize(new java.awt.Dimension(113, 43));
        btmEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmEditActionPerformed(evt);
            }
        });

        btmExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sair_32x32.png"))); // NOI18N
        btmExit.setText("Sair");
        btmExit.setMaximumSize(new java.awt.Dimension(113, 43));
        btmExit.setMinimumSize(new java.awt.Dimension(113, 43));
        btmExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmExitActionPerformed(evt);
            }
        });

        btmExclude.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/excluir_32x32.png"))); // NOI18N
        btmExclude.setText("Excluir");
        btmExclude.setMaximumSize(new java.awt.Dimension(113, 43));
        btmExclude.setMinimumSize(new java.awt.Dimension(113, 43));
        btmExclude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmExcludeActionPerformed(evt);
            }
        });

        btmInclude.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/adicionar_12x12.png"))); // NOI18N
        btmInclude.setText("Incluir");
        btmInclude.setMaximumSize(new java.awt.Dimension(113, 43));
        btmInclude.setMinimumSize(new java.awt.Dimension(113, 43));
        btmInclude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmIncludeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCmdSearchLayout = new javax.swing.GroupLayout(pnlCmdSearch);
        pnlCmdSearch.setLayout(pnlCmdSearchLayout);
        pnlCmdSearchLayout.setHorizontalGroup(
            pnlCmdSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCmdSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btmInclude, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btmEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btmExclude, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btmExit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlCmdSearchLayout.setVerticalGroup(
            pnlCmdSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCmdSearchLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCmdSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btmEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btmExclude, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btmExit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btmInclude, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        pnlStatusPesquisa.setBackground(new java.awt.Color(204, 204, 204));
        pnlStatusPesquisa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtStatusPesquisa.setEditable(false);
        txtStatusPesquisa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStatusPesquisaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout pnlStatusPesquisaLayout = new javax.swing.GroupLayout(pnlStatusPesquisa);
        pnlStatusPesquisa.setLayout(pnlStatusPesquisaLayout);
        pnlStatusPesquisaLayout.setHorizontalGroup(
            pnlStatusPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatusPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtStatusPesquisa)
                .addContainerGap())
        );
        pnlStatusPesquisaLayout.setVerticalGroup(
            pnlStatusPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatusPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtStatusPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlSearchLayout = new javax.swing.GroupLayout(pnlSearch);
        pnlSearch.setLayout(pnlSearchLayout);
        pnlSearchLayout.setHorizontalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCmdSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSearchFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlStatusPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        pnlSearchLayout.setVerticalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSearchFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCmdSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlStatusPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tbpMain.addTab("Pesquisa", pnlSearch);

        pnlStatusCadastro.setBackground(new java.awt.Color(204, 204, 204));
        pnlStatusCadastro.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtStatusCadastro.setEditable(false);
        txtStatusCadastro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStatusCadastroFocusLost(evt);
            }
        });

        javax.swing.GroupLayout pnlStatusCadastroLayout = new javax.swing.GroupLayout(pnlStatusCadastro);
        pnlStatusCadastro.setLayout(pnlStatusCadastroLayout);
        pnlStatusCadastroLayout.setHorizontalGroup(
            pnlStatusCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatusCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtStatusCadastro)
                .addContainerGap())
        );
        pnlStatusCadastroLayout.setVerticalGroup(
            pnlStatusCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatusCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtStatusCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCmdCadastre.setBackground(new java.awt.Color(204, 204, 204));
        pnlCmdCadastre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btmExit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sair_32x32.png"))); // NOI18N
        btmExit1.setText("Sair");
        btmExit1.setMaximumSize(new java.awt.Dimension(113, 43));
        btmExit1.setMinimumSize(new java.awt.Dimension(113, 43));
        btmExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmExit1ActionPerformed(evt);
            }
        });

        btmAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ok_32x32.png"))); // NOI18N
        btmAdd.setText("Confirmar");
        btmAdd.setMaximumSize(new java.awt.Dimension(113, 43));
        btmAdd.setMinimumSize(new java.awt.Dimension(113, 43));
        btmAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmAddActionPerformed(evt);
            }
        });

        btmCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancelar_32x32.png"))); // NOI18N
        btmCancel.setText("Cancelar");
        btmCancel.setMaximumSize(new java.awt.Dimension(113, 43));
        btmCancel.setMinimumSize(new java.awt.Dimension(113, 43));
        btmCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmCancelActionPerformed(evt);
            }
        });

        btmUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/atualizar_32_32.png"))); // NOI18N
        btmUpdate.setText("Atualizar");
        btmUpdate.setMaximumSize(new java.awt.Dimension(113, 43));
        btmUpdate.setMinimumSize(new java.awt.Dimension(113, 43));
        btmUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmUpdateActionPerformed(evt);
            }
        });

        btmNext.setText("Pesquisa");
        btmNext.setMaximumSize(new java.awt.Dimension(113, 43));
        btmNext.setMinimumSize(new java.awt.Dimension(113, 43));
        btmNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCmdCadastreLayout = new javax.swing.GroupLayout(pnlCmdCadastre);
        pnlCmdCadastre.setLayout(pnlCmdCadastreLayout);
        pnlCmdCadastreLayout.setHorizontalGroup(
            pnlCmdCadastreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCmdCadastreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btmAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btmUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btmCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btmNext, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btmExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlCmdCadastreLayout.setVerticalGroup(
            pnlCmdCadastreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCmdCadastreLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCmdCadastreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btmNext, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCmdCadastreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btmExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btmAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btmCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btmUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pnlItem.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Código");

        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nome");

        txtCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCadastroMouseClicked(evt);
            }
        });
        txtCadastro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCadastroKeyPressed(evt);
            }
        });

        cmbVinculoCadastro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbVinculoCadastro.setMaximumSize(new java.awt.Dimension(60, 32767));
        cmbVinculoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVinculoCadastroActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Vínculo");

        javax.swing.GroupLayout pnlItemLayout = new javax.swing.GroupLayout(pnlItem);
        pnlItem.setLayout(pnlItemLayout);
        pnlItemLayout.setHorizontalGroup(
            pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbVinculoCadastro, 0, 225, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlItemLayout.setVerticalGroup(
            pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbVinculoCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCadastreLayout = new javax.swing.GroupLayout(pnlCadastre);
        pnlCadastre.setLayout(pnlCadastreLayout);
        pnlCadastreLayout.setHorizontalGroup(
            pnlCadastreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCadastreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlStatusCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCmdCadastre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlCadastreLayout.setVerticalGroup(
            pnlCadastreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadastreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlCmdCadastre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlStatusCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tbpMain.addTab("Cadastro", pnlCadastre);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbpMain))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbpMain)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(912, 659));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void setDefaultConfigItens() throws SQLException {

        //System.out.println("setDefaultConfigFormItens() <- executado" + depure++);
        btmUpdate.setVisible(false);
        btmInclude.requestFocus();
        pnlSearchFilter.setVisible(true);
        pnlCmdSearch.setVisible(true);
        
        if (bond == false) {
            
            jLabel6.setVisible(false);
            jLabel7.setVisible(false);
            
            cmbVinculoPesquisa.setVisible(false);
            cmbVinculoCadastro.setVisible(false);
            
            loadTable1();
            
        } else if (bond == true) {
            
            jLabel6.setVisible(true);
            jLabel7.setVisible(true);
            
            cmbVinculoPesquisa.setVisible(true);
            cmbVinculoPesquisa.setSelectedIndex(-1); // esse item vai chamar o actionperformed do cmb que chamara o load cmb e lá o loadtable
            cmbVinculoCadastro.setVisible(true);
            cmbVinculoCadastro.setSelectedIndex(-1);
            
        }
        
    }

    private void btmEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmEditActionPerformed
        
        try {
            switchUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Form_GNF.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_btmEditActionPerformed

    private void btmExcludeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmExcludeActionPerformed
        
        int row = jTable1.getSelectedRow();
        
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
        
        Object id = jTable1.getValueAt(row, 0);
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
            Logger.getLogger(Form_GNF.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_btmExcludeActionPerformed

    private void btmExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmExitActionPerformed
        if (null == null) {
            dispose();
        }
    }//GEN-LAST:event_btmExitActionPerformed

    private void btmIncludeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmIncludeActionPerformed
        
        tbpMain.setSelectedIndex(1);
        btmUpdate.setVisible(false);
        btmAdd.setVisible(true);
        txtCadastro.setText(null);
        //cmbVinculoCadastro.setSelectedIndex(cmbVinculoPesquisa.getSelectedIndex()); // se assim for o usuario pode cadastrar o item no vinculo errado sem perceber

        try {
            
            switchAdd();
            
        } catch (SQLException ex) {
            Logger.getLogger(Form_GNF.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_btmIncludeActionPerformed

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
                    Logger.getLogger(Form_GNF.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        } else {
            
            try {
                loadCmbBond();
            } catch (SQLException ex) {
                Logger.getLogger(Form_GNF.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Form_GNF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }//GEN-LAST:event_btmCleanActionPerformed

    private void btmExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmExit1ActionPerformed
        if (null == null) {
            dispose();
            
        } else {
            //            frm_Servidores reloadItens = new frm_Servidores(null, null);
            //            reloadItens.loadInitialCombo_Setores();
            //            dispose();
        }
    }//GEN-LAST:event_btmExit1ActionPerformed

    private void btmAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmAddActionPerformed
        
        String itemCadastro;
        
        if (txtCadastro.getText().equals("")) {
            txtStatusCadastro.setForeground(Color.red);
            txtStatusCadastro.setText("Erro: Preencha um nome!");
            txtCadastro.requestFocus();
            return;
        } else {
            itemCadastro = txtCadastro.getText();
        }
        
        if (bond == true && cmbBondIndex == -1) {
            
            txtStatusCadastro.setForeground(Color.red);
            txtStatusCadastro.setText("Erro: Favor escolher um vínculo!");
            cmbVinculoCadastro.requestFocus();
            
            return;
            
        }
        
        switch (switchVar) {
            
            case 1:
                
                gnfEstados.addItem(itemCadastro);
                
                if (gnfEstados.statusCmd == true) {
                    try {
                        
                        addSucess(1);
                        selectTableRow(Integer.parseInt(String.valueOf(gnfEstados.getNextId())));
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(Form_GNF.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    txtStatusCadastro.setForeground(Color.red);
                    txtStatusCadastro.setText(gnfEstados.statusErr);
                }
                
                break;
            
            case 2:
                
                gnfCidades.addItem(itemCadastro, correspIdItem);
                
                if (gnfCidades.statusCmd == true) {
                    try {
                        
                        addSucess(1);
                        selectTableRow(Integer.parseInt(String.valueOf(gnfCidades.getNextId())));
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(Form_GNF.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    txtStatusCadastro.setForeground(Color.red);
                    txtStatusCadastro.setText(gnfCidades.statusErr);
                }
                break;
            
            case 3:
                
                break;
            
            default:
            //comand

        }

    }//GEN-LAST:event_btmAddActionPerformed

    private void btmCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmCancelActionPerformed
        
        txtCodigo.setText(null);
        txtCadastro.setText(null);
        cmbVinculoCadastro.setSelectedIndex(-1);
        btmCleanActionPerformed(evt);
        tbpMain.setSelectedIndex(0);
        btmAdd.setVisible(true);
        btmUpdate.setVisible(false);
        

    }//GEN-LAST:event_btmCancelActionPerformed

    private void btmUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmUpdateActionPerformed

//        int opt = JOptionPane.showConfirmDialog(this, "Você tem certeza?", "Comfirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//        if (opt == 0) {
        if (txtCadastro.getText().equals("")) {
            txtStatusCadastro.setForeground(Color.red);
            txtStatusCadastro.setText("Erro: Preencha um nome!");
            txtCadastro.requestFocus();
            return;
        } else {
            
            String itemCadastro = txtCadastro.getText();
            
            switch (switchVar) {
                
                case 1:
                    
                    gnfEstados.updateItem(idItemRow, itemCadastro);
                    
                    if (gnfEstados.statusCmd == true) {
                        try {
                            addSucess(2);
                        } catch (SQLException ex) {
                            Logger.getLogger(Form_GNF.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        txtStatusCadastro.setForeground(Color.red);
                        txtStatusCadastro.setText(gnfEstados.statusErr);
                    }
                    
                    break;
                
                case 2:

//                    if (bond == true && cmbBondIndex == -1) {
//
//                        txtStatusCadastro.setForeground(Color.red);
//                        txtStatusCadastro.setText("Erro: Favor escolher um vínculo!");
//                        cmbVinculoCadastro.requestFocus();
//
//                        return;
//
//                    }
                    if (cmbVinculoCadastro.getItemCount() > 0 && cmbBondIndex != -1) {//
                        String item = cmbVinculoPesquisa.getSelectedItem().toString();
                        tempCorrespCmbIndex = estadosDAO.get_Id_Entity(item);
                        
                        gnfCidades.updateItem(idItemRow, tempCorrespCmbIndex, itemCadastro);
                        
                        if (gnfCidades.statusCmd == true) {
                            try {
                                addSucess(2);
                            } catch (SQLException ex) {
                                Logger.getLogger(Form_GNF.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            txtStatusCadastro.setForeground(Color.red);
                            txtStatusCadastro.setText(gnfCidades.statusErr);
                        }
                    } else {
                        
                        txtStatusCadastro.setForeground(Color.red);
                        txtStatusCadastro.setText("Erro: Favor escolher um vínculo!");
                        cmbVinculoCadastro.requestFocus();
                        
                        return;
                    }
                    
                    break;
                
            }
        }
        //}
    }//GEN-LAST:event_btmUpdateActionPerformed

    private void txtCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCadastroMouseClicked
        txtStatusCadastro.setText(null);
        txtStatusCadastro.setForeground(Color.black);
    }//GEN-LAST:event_txtCadastroMouseClicked

    private void txtCadastroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCadastroKeyPressed
        //        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        //            btmAdd.doClick();
        //        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
        //            btmCancel.doClick();
        //        }
    }//GEN-LAST:event_txtCadastroKeyPressed

    private void cmbVinculoCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVinculoCadastroActionPerformed
        

    }//GEN-LAST:event_cmbVinculoCadastroActionPerformed

    private void btmNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmNextActionPerformed
        tbpMain.setSelectedIndex(0);
    }//GEN-LAST:event_btmNextActionPerformed

    private void txtStatusCadastroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStatusCadastroFocusLost
        
        txtStatusCadastro.setText(null);
        txtStatusCadastro.setForeground(Color.black);
        txtStatusCadastro.setBackground(Color.white);
        

    }//GEN-LAST:event_txtStatusCadastroFocusLost

    private void txtStatusPesquisaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStatusPesquisaFocusLost
        
        txtStatusPesquisa.setText(null);
        txtStatusPesquisa.setForeground(Color.black);
        txtStatusPesquisa.setBackground(Color.white);
        

    }//GEN-LAST:event_txtStatusPesquisaFocusLost
    
    private void txtStatusPesquisarAlertConfig(String texto) {
        
        txtStatusPesquisa.setText(texto);
        txtStatusPesquisa.setForeground(Color.red);
        txtStatusPesquisa.setBackground(Color.yellow);
        
    }
    
    public void loadTable1() throws SQLException {
        
        System.out.println("loadTable1 -> " + depure++);
        
        switchTable1();
        
        SET_Table_2 configT = new SET_Table_2();
        
        configT.loadTableGeneric(jTable1, model, jumpColumn, txtRegistros, txtPesquisaPorID, txtPesquisaPorNome);
        
    }
    
    public void switchTable1() throws SQLException {
        
        switch (switchVar) {
            
            case 1:
                
                List<Estados> list = new ArrayList(gnfEstados.listItens());
                
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
                    
                    List<Cidades> lista = new ArrayList(gnfCidades.listItens());
                    columnNames = gnfCidades.columnNames;
                    model = new DefaultTableModel(GNF_Cidades.preencherTabela(lista), columnNames) {
                        
                    };
                    
                } else {
                    
                    List<Cidades> lista = new ArrayList(gnfCidades.listItensBond(correspIdItem)); // lista com passagem do indice do combobox
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
        
        int row = jTable1.getSelectedRow();
        
        if (row == -1) {
            
            txtStatusPesquisarAlertConfig("ATENÇÃO: Escolha um item na tabela!");
            txtStatusPesquisa.requestFocus();
            
            return;
        }
        
        btmUpdate.setVisible(true);
        btmAdd.setVisible(false);
        
        tbpMain.setSelectedIndex(1);
        idItemRow = (Integer) jTable1.getValueAt(row, 0);
        
        txtCodigo.setText(String.valueOf(idItemRow));
        
        Object nome = null;
        
        switch (switchVar) {
            
            case 1:
                
                nome = jTable1.getValueAt(row, 1);
                tempTableItem = String.valueOf(jTable1.getValueAt(row, 1));
                txtCadastro.setText(nome.toString());
                break;
            
            case 2:
                
                nome = jTable1.getValueAt(row, 2);
                tempTableItem = String.valueOf(jTable1.getValueAt(row, 2));
                txtCadastro.setText(nome.toString());

                //cmbVinculoCadastro.setToolTipText(String.valueOf(jTable1.getValueAt(row, 1)));
                //if (cmbVinculoCadastro.getItemCount() > 0 && cmbBondIndex != -1) {//
                String item = String.valueOf(jTable1.getValueAt(row, 1));
                tempCorrespCmbIndex = estadosDAO.get_Id_Entity(item);
                tempCorrespCmbIndex--;
                cmbVinculoCadastro.setSelectedIndex(tempCorrespCmbIndex);
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
                
                txtCodigo.setText(gnfEstados.getNextId());
                
                break;
            
            case 2:
                
                txtCodigo.setText(gnfCidades.getNextId());
                
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
                
                Vector<Estados> estados = new Vector(estadosDAO.get_All_Entity_OrderByItemName());
                DefaultComboBoxModel cmb = new DefaultComboBoxModel(estados);
                cmbVinculoPesquisa.setModel(cmb);
                cmbVinculoPesquisa.setSelectedIndex(cmbBondIndex);
                cmbVinculoCadastro.setModel(cmb);
                cmbVinculoCadastro.setSelectedIndex(cmbBondIndex);
                try {
                    loadTable1();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Form_GNF.class
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

            if (Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 0))) == idFind) {
                
                linha = i;
                found = true;
                
            }
            
            i++;
        }
        
        jTable1.setRowSelectionInterval(linha, linha);
    }
    
    public void addSucess(int request) throws SQLException {
        
        loadTable1();
        
        tbpMain.setSelectedIndex(0);
        
        btmUpdate.setVisible(false);
        btmAdd.setVisible(true);
        cmbVinculoCadastro.setSelectedIndex(-1);
        txtCadastro.setText(null);
        txtCodigo.setText(null);
        txtStatusPesquisa.requestFocus();
        txtStatusCadastro.setForeground(Color.blue);
        txtStatusPesquisa.setForeground(Color.blue);
        txtCadastro.setBackground(Color.white);
        
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmAdd;
    private javax.swing.JButton btmCancel;
    private javax.swing.JButton btmClean;
    private javax.swing.JButton btmEdit;
    private javax.swing.JButton btmExclude;
    private javax.swing.JButton btmExit;
    private javax.swing.JButton btmExit1;
    private javax.swing.JButton btmInclude;
    private javax.swing.JButton btmNext;
    private javax.swing.JButton btmUpdate;
    private javax.swing.JComboBox cmbVinculoCadastro;
    private javax.swing.JComboBox cmbVinculoPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    javax.swing.JTable jTable1;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JPanel pnlCadastre;
    private javax.swing.JPanel pnlCmdCadastre;
    private javax.swing.JPanel pnlCmdSearch;
    private javax.swing.JPanel pnlItem;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JPanel pnlSearchFilter;
    private javax.swing.JPanel pnlStatusCadastro;
    private javax.swing.JPanel pnlStatusPesquisa;
    private javax.swing.JTabbedPane tbpMain;
    private javax.swing.JTextField txtCadastro;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtPesquisaPorID;
    private javax.swing.JTextField txtPesquisaPorNome;
    private javax.swing.JTextField txtRegistros;
    public javax.swing.JTextField txtStatusCadastro;
    private javax.swing.JTextField txtStatusPesquisa;
    // End of variables declaration//GEN-END:variables

}
