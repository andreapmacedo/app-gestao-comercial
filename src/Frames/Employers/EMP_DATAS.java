package Frames.Employers;

import Components.CMD.CMP_CMD_Confirm;
import DAO.CidadesDAO;
import DAO.EmployerDataDAO;
import DAO.EstadosDAO;
import Entidades.EmployerData;
import Settings.convertDates;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class EMP_DATAS extends JPanel {

    private EMP_DATA_ITENS cmpItens;
    private CMP_CMD_Confirm cmpCMD;
    public EmployerDataDAO itenDAO;
    private EmployerData iten;


    DateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");

    EstadosDAO itenEstadoDAO = new EstadosDAO();
    CidadesDAO itenCidadeDAO = new CidadesDAO();

    public EMP_DATAS() throws SQLException, ParseException {

        configShow();
        initComps();
        event();
    }

    private void initComps() throws SQLException, ParseException {

        itenDAO = new EmployerDataDAO();

        cmpItens = new EMP_DATA_ITENS(this);
        cmpCMD = new CMP_CMD_Confirm();

        setDefault();

        add(cmpItens, BorderLayout.NORTH);
        add(cmpCMD, BorderLayout.SOUTH);

        loadItens();

    }

    public void setDefault() {

        //  gneTable.cmpCrud.remove(gneTable.cmpCrud.cmdInformations);

    }

    private void reloadForm() {
        cmpItens.cleaningItens();

        try {
            loadItens();
        } catch (SQLException ex) {
            Logger.getLogger(EMP_DATAS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadItens() throws SQLException {

        List<EmployerData> list; //o ideal é não fazer com lista pois é desnecessário. mas fica o exemplo

        list = new ArrayList(itenDAO.Select_By_idFK(EMP_INFO.idEmployer));

        if (list.isEmpty()) {

        } else {

            for (EmployerData iten : list) {

                cmpItens.txtNome.setText(iten.getNome());
                cmpItens.txtIdade.setText(iten.getIdade().toString());
                cmpItens.cmbSexo.setSelectedItem(iten.getSexo());
                cmpItens.txtIdentidade.setText(iten.getIdentidade());
                cmpItens.cmbEstCivil.setSelectedItem(iten.getEstadoCivil());
                cmpItens.txtCPF.setText(iten.getCpf());
                cmpItens.txtPIS.setText(iten.getPis());
                cmpItens.txtFilhos.setText(iten.getFilhos().toString());
                cmpItens.txtEmail.setText(iten.getEmail());
                cmpItens.txtLogradouro.setText(iten.getLogradouro());
                cmpItens.txtNumero.setText(iten.getNumero());
                cmpItens.txtComplemento.setText(iten.getComplemento());
                cmpItens.txtBairro.setText(iten.getBairro());

                if (iten.getNascimento() != null) {
                    cmpItens.txtNascimento.setText(formatador.format(iten.getNascimento()));
                }

                if (iten.getIdFK_Estado() == 0) {
                } else {
                    cmpItens.cmbEstado.setSelectedItem(itenEstadoDAO.get_Just_Entity(iten.getIdFK_Estado()).getNomeEstado());
                }
                if (iten.getIdFK_Cidade() == 0) {
                } else {
                    cmpItens.cmbCidade.setSelectedItem(itenCidadeDAO.get_Just_Entity(iten.getIdFK_Cidade()).getNomeCidade());
                }

            }

        }
    }

    private void event() {

        cmpCMD.cmdEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmpItens.itensEnable(cmpItens.pnlPersonalInfo.getComponents(), true);
                cmpItens.itensEnable(cmpItens.pnlAddress.getComponents(), true);
            }
        });

        cmpCMD.cmdConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmpItens.itensEnable(cmpItens.pnlPersonalInfo.getComponents(), false);
                cmpItens.itensEnable(cmpItens.pnlAddress.getComponents(), false);

                iten = new EmployerData();

                try {

                    List<EmployerData> list = itenDAO.Select_By_idFK(EMP_INFO.idEmployer);

                    if (list.isEmpty()) {

                        iten.setIdPk(Integer.parseInt(itenDAO.get_AutoIncremente()));

                    } else {

                        itenDAO.select_ID(EMP_INFO.idEmployer).getIdPk(); //setar o id pk
                        iten.setIdPk(itenDAO.select_ID(EMP_INFO.idEmployer).getIdPk());
                    }

                    iten.setIdFK_Employer(EMP_INFO.idEmployer);
                    iten.setNome(cmpItens.txtNome.getText().toUpperCase());
                    iten.setIdentidade(cmpItens.txtIdentidade.getText().toUpperCase());
                    iten.setCpf(cmpItens.txtCPF.getText().toUpperCase());
                    iten.setPis(cmpItens.txtPIS.getText().toUpperCase());
                    iten.setEmail(cmpItens.txtEmail.getText().toUpperCase());
                    iten.setLogradouro(cmpItens.txtLogradouro.getText().toUpperCase());
                    iten.setNumero(cmpItens.txtNumero.getText().toUpperCase());
                    iten.setBairro(cmpItens.txtBairro.getText().toUpperCase());

                    if (!cmpItens.txtNascimento.getText().equals("")) {
                        iten.setNascimento(new java.sql.Date(new convertDates().toJavaUtilDate(cmpItens.txtNascimento.getText(), "dd-MM-yyyy").getTime()));
                    }
                    if (cmpItens.cmbSexo.getSelectedIndex() == -1) {
                        iten.setSexo(null);
                    } else {
                        iten.setSexo(cmpItens.cmbSexo.getSelectedItem().toString().toUpperCase());
                    }

                    if (cmpItens.cmbEstCivil.getSelectedIndex() == -1) {
                        iten.setEstadoCivil(null);
                    } else {
                        iten.setEstadoCivil(cmpItens.cmbEstCivil.getSelectedItem().toString().toUpperCase());
                    }

                    if (cmpItens.txtFilhos.getText().equals("") || cmpItens.txtFilhos.getText().equals(null)) {
                        iten.setFilhos(0);
                    } else {
                        iten.setFilhos(Integer.parseInt(cmpItens.txtFilhos.getText()));
                    }

                    int idEstado = itenEstadoDAO.get_Id_Entity((String) cmpItens.cmbEstado.getSelectedItem());
                    int idCidade = itenCidadeDAO.get_Id_Entity((String) cmpItens.cmbCidade.getSelectedItem(), idEstado);

                    iten.setIdFK_Cidade(idCidade);
                    iten.setIdFK_Estado(idEstado);

                    if (list.isEmpty()) {
                        itenDAO.add_Entity(iten);
                        reloadForm();
                    } else {
                        itenDAO.update_Entity(iten);
                        reloadForm();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(EMP_MAIN_ADD.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(EMP_DATAS.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        cmpCMD.cmdClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmpItens.cleaningItens();

            }
        });

        cmpCMD.cmdCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmpItens.itensEnable(cmpItens.pnlPersonalInfo.getComponents(), false);
                cmpItens.itensEnable(cmpItens.pnlAddress.getComponents(), false);

                reloadForm();
//                cmpItens.cleaningItens();
//
//                try {
//                    loadItens(idFk);
//                } catch (SQLException ex) {
//                    Logger.getLogger(EMP_DATAS.class.getName()).log(Level.SEVERE, null, ex);
//                }

            }
        });

//        gneTable.cmpCrud.cmdAdd.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                try {
//                    callAdd(0);
//                } catch (SQLException ex) {
//                    Logger.getLogger(EMP_PHONES.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ParseException ex) {
//                    Logger.getLogger(EMP_PHONES.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            }
//
//        });
//
//        gneTable.cmpCrud.cmdExclude.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    itenDAO.remove_Entity(new ID_Find().ID_PK(table));
//                    reloadTable();
//                } catch (SQLException ex) {
//                    Logger.getLogger(EMP_MAIN.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//
//        });
//
//        gneTable.cmpCrud.cmdAll.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//
//                    EMP_PHONES_ALL dialog = new EMP_PHONES_ALL();
//                    dialog.setVisible(true);
//
//                } catch (SQLException ex) {
//                    Logger.getLogger(EMP_MAIN.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ParseException ex) {
//                    Logger.getLogger(EMP_PHONES.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//
//        });
//
//        gneTable.cmpCrud.cmdEdit.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                int row = table.getSelectedRow();
//                if (row != -1) {
//
//                    try {
//                        callAdd(1);
//                    } catch (SQLException ex) {
//                        Logger.getLogger(EMP_PHONES.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (ParseException ex) {
//                        Logger.getLogger(EMP_PHONES.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//
//                    frmAdd.cmpItens.txtNumero.setText(((String) table.getValueAt(row, 1)).replaceAll("\\(", ""));
//                    frmAdd.cmpItens.cmbType.setSelectedItem((String) table.getValueAt(row, 2));
//                    frmAdd.cmpItens.cmbCarrier.setSelectedItem((String) table.getValueAt(row, 3));
//
//                }
//            }
//
//        });
//
//        gneTable.cmpConfigFilter.cmdClean.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                cmpItens.setDefault();
//                try {
//                    reloadTable();
//                } catch (SQLException ex) {
//                    Logger.getLogger(EMP_PHONES.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            }
//        });
//
//        gneTable.cmpConfigFilter.cmbFilter_FullPart.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                gneTable.cmpConfigFilter.index_Filter_FullPart = gneTable.cmpConfigFilter.cmbFilter_FullPart.getSelectedIndex();
//                try {
//                    reloadTable();
//                } catch (SQLException ex) {
//                    Logger.getLogger(EMP_PHONES.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            }
//        });
//
//        gneTable.cmpConfigFilter.cmdSerch.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                gneTable.cmpConfigFilter.index_Filter_FullPart = gneTable.cmpConfigFilter.cmbFilter_FullPart.getSelectedIndex();
//                gneTable.cmpConfigFilter.index_Filter_AutoMan = gneTable.cmpConfigFilter.cmbFilter_AutoMan.getSelectedIndex();
//                try {
//                    reloadTable();
//                } catch (SQLException ex) {
//                    Logger.getLogger(EMP_PHONES.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            }
//
//        });
    }

    private void callAdd(int callType) throws SQLException, ParseException {

        //frmAdd = new EMP_PHONES_ADD(this, callType);
        // frmAdd.setVisible(true);
    }

//    public void reloadTable() throws SQLException {
//
//        ArrayList<String> fieldsFilter = new ArrayList<String>();
//
//        fieldsFilter.add(cmpItens.txtNumero.getText());
//        fieldsFilter.add(cmpItens.cmbType.getSelectedItem().toString());
//        fieldsFilter.add(cmpItens.cmbCarrier.getSelectedItem().toString());
//
//        ArrayList<String> attr = new ArrayList<String>();
//
//        attr.add("EFN_NUMERO");
//        attr.add("EFN_TIPO");
//        attr.add("EFN_OPERADORA");
//
//        for (int i = 0; i < fieldsFilter.size(); i++) {
//            if (fieldsFilter.get(i).isEmpty()) {
//                fieldsFilter.remove(i);
//                attr.remove(i);
//
//                i--;
//            }
//        }
//
//        if (gneTable.cmpConfigFilter.index_Filter_FullPart == 0) {
//            for (int i = 0; i < fieldsFilter.size(); i++) {
//                fieldsFilter.set(i, "'%" + fieldsFilter.get(i) + "%'");
//            }
//        } else {
//            for (int i = 0; i < fieldsFilter.size(); i++) {
//                fieldsFilter.set(i, "'" + fieldsFilter.get(i) + "%'");
//            }
//        }
//
//        setTable.reloadTable(Integer.parseInt(idFk), gneTable.cmpSelectedIten.txtRegistros, attr, fieldsFilter);
//    }
    private void configShow() {

        setLayout(new BorderLayout());

    }

}
