package Frames.Employers;

import DAO.CidadesDAO;

import DAO.EmployerDataDAO;
import DAO.EstadosDAO;
import Entidades.Cidades;
import Entidades.EmployerData;
import Entidades.Estados;
import Settings.SET_TextField_CPF;
import Settings.SET_TextField_Date_2;
import Settings.SET_TextField_JustNumber;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class EMP_DATA_ITENS extends JPanel {

    public JTextField txtEmployer, txtNome, txtNascimento, txtIdade, txtIdentidade, txtCPF, txtPIS, txtFilhos, txtEmail,
            txtLogradouro, txtNumero, txtComplemento, txtBairro;

    private JLabel lblEmployer, lblNome, lblNascimento, lblIdade, lblSexo, lblEstCivil, lblIdentidade, lblCPF,
            lblFilhos, lblPIS, lblEmail, lblLogradouro, lblNumero, lblComplemento, lblBairro, lblCidade, lblEstado;

    public JComboBox cmbSexo, cmbEstCivil, cmbCidade, cmbEstado;
    public JCheckBox statusEmployer;
    public JPanel pnlPersonalInfo, pnlAddress;

    private EmployerDataDAO itemDAO;
    private EMP_DATAS frmMain;
    List<EmployerData> list;

    GridBagConstraints gbl = new GridBagConstraints(); //Restriçoes

    EMP_DATA_ITENS(EMP_DATAS frmMain) throws SQLException {

        this.frmMain = frmMain;

        configShow();
        initComps();
        setDefault();
        event();
    }

    private void initComps() throws SQLException {

        BasicComboBoxRenderer.UIResource UIResource = new BasicComboBoxRenderer.UIResource();
        UIResource.setHorizontalAlignment(SwingConstants.CENTER);

        pnlPersonalInfo = new JPanel();
        pnlPersonalInfo.setLayout(new GridBagLayout());

        pnlPersonalInfo.setBorder(BorderFactory.createTitledBorder("Dados"));

        pnlAddress = new JPanel();
        pnlAddress.setLayout(new GridBagLayout());
        pnlAddress.setBorder(BorderFactory.createTitledBorder("Endereço"));

        gbl.insets = new Insets(4, 4, 4, 4);
        gbl.fill = GridBagConstraints.NONE;
        gbl.anchor = GridBagConstraints.NORTHWEST;

//        lblEmployer = new JLabel("Colaborador: ");
//        gbl.gridx = 0;
//        gbl.gridy = 0;
//        gbl.gridwidth = 1;
//        gbl.anchor = GridBagConstraints.EAST;
//        pnlPersonalInfo.add(lblEmployer, gbl);
//        
//        txtEmployer = new JTextField(30);
//        txtEmployer.setName("txtEmployer");
//        txtEmployer.setHorizontalAlignment(javax.swing.JTextField.LEFT);
//        txtEmployer.setFont(new java.awt.Font("Tahoma", 1, 11));
//        txtEmployer.setBackground(new java.awt.Color(255, 255, 200));
//        txtEmployer.setForeground(new java.awt.Color(0, 0, 200));
//        txtEmployer.setEditable(false);
//        gbl.gridx = 1;
//        gbl.gridwidth = 3;
//        gbl.anchor = GridBagConstraints.WEST;
//        pnlPersonalInfo.add(txtEmployer, gbl);
        lblNome = new JLabel("Nome:");
        gbl.gridy = 0;
        gbl.gridx = 0;
        gbl.gridwidth = 1;
        gbl.anchor = GridBagConstraints.EAST;
        pnlPersonalInfo.add(lblNome, gbl);

        txtNome = new JTextField(30);
        txtNome.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        gbl.gridx = 1;
        gbl.gridwidth = 3;
        gbl.anchor = GridBagConstraints.WEST;
        pnlPersonalInfo.add(txtNome, gbl);

        lblNascimento = new JLabel("Nascimento:");
        gbl.gridy = 2;
        gbl.gridx = 0;
        gbl.gridwidth = 1;
        gbl.anchor = GridBagConstraints.EAST;
        pnlPersonalInfo.add(lblNascimento, gbl);

        txtNascimento = new JTextField(11);
        txtNascimento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNascimento.setDocument(new SET_TextField_Date_2());
        gbl.gridx = 1;
        gbl.gridwidth = 1;
        gbl.anchor = GridBagConstraints.WEST;
        pnlPersonalInfo.add(txtNascimento, gbl);

        lblIdade = new JLabel("Idade:");
        //gbl.gridy = 3;
        gbl.gridx = 2;
        gbl.anchor = GridBagConstraints.EAST;
        pnlPersonalInfo.add(lblIdade, gbl);

        txtIdade = new JTextField(5);
        txtIdade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        //txtIdade.setDocument(new SET_TextField_Phone());
        txtIdade.setName("txtIdade");
        txtIdade.setEditable(false);
        gbl.gridx = 3;
        gbl.anchor = GridBagConstraints.WEST;
        pnlPersonalInfo.add(txtIdade, gbl);

        lblIdentidade = new JLabel("RG:");
        gbl.gridy = 3;
        gbl.gridx = 0;
        gbl.anchor = GridBagConstraints.EAST;
        pnlPersonalInfo.add(lblIdentidade, gbl);

        txtIdentidade = new JTextField(11);
        txtIdentidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdentidade.setDocument(new SET_TextField_JustNumber());
        gbl.gridx = 1;
        gbl.anchor = GridBagConstraints.WEST;
        pnlPersonalInfo.add(txtIdentidade, gbl);

        lblCPF = new JLabel("CPF:");
        //gbl.gridy = 5;
        gbl.gridx = 2;
        gbl.anchor = GridBagConstraints.EAST;
        pnlPersonalInfo.add(lblCPF, gbl);

        txtCPF = new JTextField(11);
        txtCPF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCPF.setDocument(new SET_TextField_CPF());
        gbl.gridx = 3;
        // gbl.gridwidth = 1;
        gbl.anchor = GridBagConstraints.EAST;
        pnlPersonalInfo.add(txtCPF, gbl);

        lblPIS = new JLabel("PIS:");
        gbl.gridy = 4;
        gbl.gridx = 0;
        gbl.gridwidth = 1;
        gbl.anchor = GridBagConstraints.EAST;
        pnlPersonalInfo.add(lblPIS, gbl);

        txtPIS = new JTextField(11);
        txtPIS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPIS.setDocument(new SET_TextField_CPF());
        gbl.gridx = 1;
        gbl.anchor = GridBagConstraints.WEST;
        pnlPersonalInfo.add(txtPIS, gbl);

        lblFilhos = new JLabel("Filhos:");
        //gbl.gridy = 7;
        gbl.gridx = 2;
        gbl.anchor = GridBagConstraints.EAST;
        pnlPersonalInfo.add(lblFilhos, gbl);

        txtFilhos = new JTextField(5);
        txtFilhos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFilhos.setDocument(new SET_TextField_JustNumber());
        gbl.gridx = 3;
        gbl.anchor = GridBagConstraints.WEST;
        pnlPersonalInfo.add(txtFilhos, gbl);

        lblEmail = new JLabel("E-Mail:");
        gbl.gridy = 8;
        gbl.gridx = 0;
        gbl.anchor = GridBagConstraints.EAST;
        pnlPersonalInfo.add(lblEmail, gbl);

        txtEmail = new JTextField(30);
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        // txtEmail.setDocument(new SET_TextField_Phone());
        gbl.gridx = 1;
        gbl.gridwidth = 3;
        gbl.anchor = GridBagConstraints.WEST;
        pnlPersonalInfo.add(txtEmail, gbl);

        lblSexo = new JLabel("Sexo:");
        gbl.gridy = 9;
        gbl.gridx = 0;
        gbl.gridwidth = 1;
        gbl.anchor = GridBagConstraints.EAST;
        pnlPersonalInfo.add(lblSexo, gbl);

        cmbSexo = new JComboBox();
        cmbSexo.setFont(new Font("Tahoma", Font.PLAIN, 11));
        cmbSexo.addItem("M");
        cmbSexo.addItem("F");
        //cmbSexo.setPreferredSize(new Dimension(50, 20));
        cmbSexo.setSelectedIndex(-1);
        cmbSexo.setRenderer(UIResource);
        cmbSexo.setPreferredSize(new Dimension(50, 20));
        gbl.gridx = 1;
        gbl.gridwidth = 2;
        gbl.anchor = GridBagConstraints.WEST;
        pnlPersonalInfo.add(cmbSexo, gbl);

        lblEstCivil = new JLabel("Estado Civil:");
        //gbl.gridy = 10;
        gbl.gridx = 2;
        gbl.gridwidth = 1;
        gbl.anchor = GridBagConstraints.EAST;
        pnlPersonalInfo.add(lblEstCivil, gbl);

        cmbEstCivil = new JComboBox();
        cmbEstCivil.setFont(new Font("Tahoma", Font.PLAIN, 11));
        cmbEstCivil.addItem("SOLTEIRO");
        cmbEstCivil.addItem("CASADO");
        cmbEstCivil.setSelectedIndex(-1);
        cmbEstCivil.setRenderer(UIResource);
        cmbEstCivil.setPreferredSize(new Dimension(124, 20));
        gbl.gridx = 3;
        //gbl.gridwidth = 1;
        gbl.anchor = GridBagConstraints.WEST;
        pnlPersonalInfo.add(cmbEstCivil, gbl);

        lblLogradouro = new JLabel("Logradouro:");
        gbl.gridy = 0;
        gbl.gridx = 0;
        gbl.anchor = GridBagConstraints.NORTHEAST;
        pnlAddress.add(lblLogradouro, gbl);

        txtLogradouro = new JTextField(30);
        txtLogradouro.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        gbl.gridx = 1;
        gbl.gridwidth = 3;
        gbl.anchor = GridBagConstraints.WEST;
        pnlAddress.add(txtLogradouro, gbl);

        lblNumero = new JLabel("Número:");
        gbl.gridy = 1;
        gbl.gridx = 0;
        gbl.gridwidth = 1;
        gbl.anchor = GridBagConstraints.EAST;
        pnlAddress.add(lblNumero, gbl);

        txtNumero = new JTextField(6);
        txtNumero.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumero.setDocument(new SET_TextField_JustNumber());
        gbl.gridx = 1;
        gbl.anchor = GridBagConstraints.WEST;
        pnlAddress.add(txtNumero, gbl);

        lblComplemento = new JLabel("Complemento:");
        gbl.gridy = 2;
        gbl.gridx = 0;
        gbl.anchor = GridBagConstraints.EAST;
        pnlAddress.add(lblComplemento, gbl);

        txtComplemento = new JTextField(30);
        txtComplemento.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        gbl.gridx = 1;
        gbl.gridwidth = 3;
        gbl.anchor = GridBagConstraints.WEST;
        pnlAddress.add(txtComplemento, gbl);

        lblBairro = new JLabel("Bairro:");
        gbl.gridy = 3;
        gbl.gridx = 0;
        gbl.gridwidth = 1;
        gbl.anchor = GridBagConstraints.EAST;
        pnlAddress.add(lblBairro, gbl);

        txtBairro = new JTextField(15);
        txtBairro.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        gbl.gridx = 1;
        gbl.anchor = GridBagConstraints.WEST;
        pnlAddress.add(txtBairro, gbl);

        lblEstado = new JLabel("Estado:");
        gbl.gridy = 4;
        gbl.gridx = 0;
        gbl.anchor = GridBagConstraints.EAST;
        pnlAddress.add(lblEstado, gbl);

        cmbEstado = new JComboBox();
        cmbEstado.setFont(new Font("Tahoma", Font.PLAIN, 11));
        cmbEstado.setPreferredSize(new Dimension(50, 20));
        cmbEstado.setRenderer(UIResource);
        loadCmbEstate();
        cmbEstado.setSelectedIndex(-1);
        gbl.gridx = 1;
        gbl.anchor = GridBagConstraints.WEST;
        pnlAddress.add(cmbEstado, gbl);

        lblCidade = new JLabel("Cidade:");
        gbl.gridy = 5;
        gbl.gridx = 0;
        gbl.anchor = GridBagConstraints.EAST;
        pnlAddress.add(lblCidade, gbl);

        cmbCidade = new JComboBox();
        cmbCidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
        cmbCidade.setSelectedIndex(-1);
        cmbCidade.setPreferredSize(new Dimension(200, 20));
        cmbCidade.setRenderer(UIResource);
        loadCmbCity(-1);
        gbl.gridx = 1;
        gbl.anchor = GridBagConstraints.WEST;
        pnlAddress.add(cmbCidade, gbl);

        //statusEmployer = new JCheckBox(" Incluir Colaborador inativo");
        //gbl.gridy = 6;
        //gbl.gridx = 0;
        //pnlPersonalInfo.add(statusEmployer, gbl);
        //loadItens(Integer.parseInt(frmMain.idFk));
        add(pnlPersonalInfo, BorderLayout.NORTH);
        add(pnlAddress, BorderLayout.CENTER);

    }

    public void setDefault() {

        itensEnable(pnlAddress.getComponents(), false);
        itensEnable(pnlPersonalInfo.getComponents(), false);

    }

    public void cleaningItens() {

        itensClean(pnlAddress.getComponents());
        itensClean(pnlPersonalInfo.getComponents());

    }

    public void itensEnable(java.awt.Component[] cpcount, boolean status) {

        for (int i = 0; i < cpcount.length; i++) {

            if (cpcount[i] instanceof JTextField || cpcount[i] instanceof JComboBox) {

                if (cpcount[i].getName() == "txtEmployer" || cpcount[i].getName() == "txtIdade") {

                } else {

                    // cpcount[i].setEnabled(status);
                    //falta colocar o cep no endereço
                    txtNome.setEditable(status);
                    txtNascimento.setEditable(status);
                    txtNumero.setEditable(status);
                    txtCPF.setEditable(status);
                    txtBairro.setEditable(status);
                    txtComplemento.setEditable(status);
                    txtEmail.setEditable(status);
                    txtLogradouro.setEditable(status);
                    txtPIS.setEditable(status);
                    txtIdentidade.setEditable(status);
                    txtFilhos.setEditable(status);
                    cmbCidade.setEnabled(status);
                    cmbEstCivil.setEnabled(status);
                    cmbEstado.setEnabled(status);
                    cmbSexo.setEnabled(status);

                    //cpcount[i].setBackground(new java.awt.Color(255, 255, 200));
                    //cpcount[i].setForeground(new java.awt.Color(0, 0, 0));
                }

            }
        }

    }

    public void itensClean(java.awt.Component[] cpcount) {

        for (int i = 0; i < cpcount.length; i++) {

            if (cpcount[i] instanceof JTextField) {
                if (cpcount[i].getName() == "txtEmployer") {

                } else {
                    JTextField field = (JTextField) cpcount[i];
                    field.setText("");
                }
            } else if (cpcount[i] instanceof JComboBox) {
                JComboBox cmb = (JComboBox) cpcount[i];
                cmb.setSelectedIndex(-1);
            }
        }

    }

    private void loadCmbEstate() throws SQLException {

        EstadosDAO itemDAO = new EstadosDAO();
        //Estados estado = new Estados();

        Vector<Estados> list = new Vector(itemDAO.get_All_Entity_OrderByItemName());
        for (Estados iten : list) {
            cmbEstado.addItem(iten.getNomeEstado());
        }

    }

    private void loadCmbCity(int idFk) throws SQLException {

        CidadesDAO itemDAO = new CidadesDAO();

        cmbCidade.removeAllItems();

        Vector<Cidades> list = new Vector(itemDAO.get_JustFk_Entity_OrderByItemName(idFk));

        if (cmbEstado.getSelectedIndex() > -1) {
            for (Cidades iten : list) {
                cmbCidade.addItem(iten.getNomeCidade());

            }
        }
    }

    private void event() {

        cmbEstado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                EstadosDAO itemDAO = new EstadosDAO();

                int idFk = itemDAO.get_Id_Entity((String) cmbEstado.getSelectedItem());

                try {

                    loadCmbCity(idFk);
                } catch (SQLException ex) {
                    Logger.getLogger(EMP_DATA_ITENS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    private void configShow() {

        setLayout(new GridLayout(1, 2));

    }

}

