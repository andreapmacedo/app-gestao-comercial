/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GNF;

import DAO.EstadosDAO;
import Entidades.Estados;
import Frames.Form_GNF;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Andre
 */
public class GNF_Estados {

    private final EstadosDAO itemDAO = new EstadosDAO();
    Estados estado = new Estados();
    public String columnNames[] = {"ID", "NOME"};
    public boolean statusCmd = false;
    public String statusErr = null;

    public GNF_Estados() throws SQLException {

    }

    public List listItens() throws SQLException {

        List<Estados> list = new ArrayList(itemDAO.get_All_Entity_OrderByItemName());

        return list;

    }

    public String getNextId() throws SQLException {

        return itemDAO.get_AutoIncremente();

    }

    public int codItem() {

        int y = 0;

        try {
            //int y = 0;
            Vector<Estados> objeto = new Vector(itemDAO.get_All_Entity_SQLdefault());
            for (Estados i : objeto) {
                y = i.getIdEstado();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao recuperar o código! " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return y + 1;

    }

    public void removeItem(int ref) throws SQLException {

        itemDAO.remove_Entity(ref);

    }

    public void addItem(String itemText) {

        Integer idTemp = null;

        try {

            Vector<Estados> list = new Vector(itemDAO.get_All_Entity_OrderByItemName());
            for (Estados i : list) {
                String x = i.getNomeEstado();
                if (x.equals(itemText.toUpperCase())) {
                    //JOptionPane.showMessageDialog(null, "Esse campo já existe!");

                    //   super.txtStatusCadastro.setText("Esse campo já existe!");
                    statusCmd = false;
                    statusErr = "Item já existente na base de dados. Escolha outro nome!";
                    return;
                }
            }

            estado.setNomeEstado(itemText.toUpperCase());
            estado.setIdEstado(idTemp);

            itemDAO.add_Entity(estado);
            statusCmd = true;
            //super.addSucess(1);

        } catch (SQLException ex) {

            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Error" + ex, "Error", JOptionPane.ERROR_MESSAGE);//this, "Error" + ex, "Error", JOptionPane.ERROR_MESSAGE
            statusCmd = false;
            statusErr = "Erro SQL. =>  " + ex;
            return;

        }
    }

    public void updateItem(int index, String itemText) {

        // Verifica se o registro já existe.                
        try {

            List<Estados> list = new LinkedList(itemDAO.get_All_Entity_SQLdefault());
            for (Estados i : list) {
                String x = i.getNomeEstado();
                if (x.equals(itemText.toUpperCase())) {
                    //JOptionPane.showMessageDialog(null, "Esse campo já existe!");
                    statusCmd = false;
                    statusErr = "Item já existente na base de dados. Escolha outro nome!";
                    return;
                }
            }

            estado.setNomeEstado(itemText.toUpperCase());
            estado.setIdEstado(index);
            itemDAO.update_Entity(estado);
            statusCmd = true; // se não alterar o status o addsusses não vai ser acionado e a tela ficará paralizada dando aspecto q nada ocorreu.

        } catch (SQLException ex) {

            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Error adding user " + ex, "Error", JOptionPane.ERROR_MESSAGE);
            statusCmd = false;
            statusErr = "Erro SQL. =>  " + ex;
            return;
        }

    }

    public static Object[][] preencherTabela(List<Estados> lista) {

        Object[][] resposta = new Object[lista.size()][2];

        for (int i = 0; i < resposta.length; i++) {
            Estados orc = lista.get(i);
            // resposta[i][2] = orc.setIdCidade();
            resposta[i][0] = orc.getIdEstado();
            resposta[i][1] = orc.getNomeEstado();

        }

        return resposta;
    }

}
