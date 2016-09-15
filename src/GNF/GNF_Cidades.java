/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GNF;

import DAO.CidadesDAO;
import DAO.EstadosDAO;

import Entidades.Cidades;
import Entidades.Estados;
import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class GNF_Cidades {

    private final CidadesDAO itemDAO = new CidadesDAO();
    private final EstadosDAO subItemDAO = new EstadosDAO();
    public boolean statusCmd = false;
    public String statusErr = null;

    Cidades cidade = new Cidades();

    public String columnNames[] = {"ID", "ESTADO", " NOME"};



    public GNF_Cidades() throws SQLException {


    }

    public List listItens() throws SQLException {

        List<Cidades> list = new ArrayList(itemDAO.select_All_Entity_Inner_BondItemName());

        return list;

    }

    public String getNextId() throws SQLException {

        return itemDAO.get_AutoIncremente();

    }

    public List listItensBond(int x) throws SQLException {

        List<Cidades> list = new ArrayList(itemDAO.select_JustFk_Entity_Inner_BondItemName(x));

        return list;

    }

    public int codItem() {

        int y = 0;

        try {
            //int y = 0;
            Vector<Cidades> objeto = new Vector(itemDAO.get_All_Entity_SQLdefault());
            for (Cidades i : objeto) {
                y = i.getIdCidade();
            }
            //return = y + 1;

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao recuperar o código! " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return y + 1;

    }

    public void removeItem(int ref) throws SQLException {

        itemDAO.remove_Itentity(ref);

    }

    public void addItem(String itemText, int IdFK) {

// Variáveis globais do método.    
        Integer idTemp = null;

        try {

            Vector<Cidades> list = new Vector(itemDAO.get_JustFk_Entity_OrderByItemName(1));
            for (Cidades i : list) {
                String x = i.getNomeCidade();
                if (x.equals(itemText.toUpperCase())) {
                    //JOptionPane.showMessageDialog(null, "Esse campo já existe!");
                    statusCmd = false;
                    statusErr = "Item já existente na base de dados. Escolha outro nome!";

                    return;
                }
            }

            cidade.setNomeCidade(itemText.toUpperCase());

            cidade.setIdCidade(idTemp);
            cidade.setIdEstado(IdFK);

            //System.out.println("idfk " + IdFK);
            itemDAO.add_Entity(cidade);
            statusCmd = true;

        } catch (SQLException ex) {

            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Error" + ex, "Error", JOptionPane.ERROR_MESSAGE);//this, "Error" + ex, "Error", JOptionPane.ERROR_MESSAGE
            statusCmd = false;
            statusErr = "Erro SQL. =>  " + ex;

            return;

        }
    }

    public void updateItem(int index, int idFk, String itemText) {

        // Verifica se o registro já existe.                
        try {

            List<Cidades> list = new LinkedList(itemDAO.get_All_Entity_SQLdefault());
            for (Cidades i : list) {
                String x = i.getNomeCidade();
                if (x.equals(itemText.toUpperCase())) {
                    //JOptionPane.showMessageDialog(null, "Esse campo já existe!");
                    statusCmd = false;
                    statusErr = "Item já existente na base de dados. Escolha outro nome!";
                    return;
                }
            }

            cidade.setNomeCidade(itemText.toUpperCase());
            cidade.setIdCidade(index);
            cidade.setIdEstado(idFk);
            itemDAO.update_Entity(cidade);
            statusCmd = true;

        } catch (SQLException ex) {

            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Error adding user " + ex, "Error", JOptionPane.ERROR_MESSAGE);
            statusCmd = false;
            statusErr = "Erro SQL. =>  " + ex;

            return;
        }

    }

    public static Object[][] preencherTabela(List<Cidades> lista) throws SQLException {

        Object[][] resposta = new Object[lista.size()][3];

        for (int i = 0; i < resposta.length; i++) {
            Cidades orc = lista.get(i);

            resposta[i][0] = orc.getIdCidade();
            resposta[i][1] = orc.getNomeEstado().toUpperCase();
            resposta[i][2] = orc.getNomeCidade().toUpperCase();

        }

        return resposta;
    }

}
