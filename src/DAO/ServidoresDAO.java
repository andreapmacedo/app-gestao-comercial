/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Servidores;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Andre
 */
public class ServidoresDAO extends GenericDAO {

    public final String className = "Classe ->" + this.getClass().getSimpleName();

    //private final frm_Principal status;
    public ServidoresDAO() {
    }

    public void addServidores(Servidores servidores) throws SQLException {

        String query = "INSERT INTO TB_SERVIDORES (SER_NOME, SER_IDENTIDADE, SER_CPF, SER_CAR_TRAB, SER_DATA_NASCIMENTO,"
                + "SER_DATA_ADMISSAO, SER_DATA_REGISTRO, SER_SEXO, SER_ESTADO_CIVIL, SER_FILHOS, SER_EMAIL, SER_LOGRADOURO, SER_NUMERO,"
                + " SER_COMPLEMENTO, SER_CEP, SER_FUN_CODIGO, SER_SET_CODIGO, SER_BAI_CODIGO, SER_CID_CODIGO,"
                + " SER_EST_CODIGO) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        executeCommand(query, servidores.getNomeServidor(), servidores.getIdentidadeServidor(), servidores.getCpfServidor(),
                servidores.getCarteiraTrabalhoServidor(), servidores.getNascimentoServidor(), servidores.getAdmissaoServidor(), servidores.getRegistroServidor(),
                servidores.getSexoServidor(), servidores.getEstCivilServidor(), servidores.getFilhoServidor(), servidores.getEmailServidor(),
                servidores.getLogradouroServidor(), servidores.getNumeroServidor(), servidores.getComplementoServidor(), servidores.getCepServidor(),
                servidores.getFunServidor(), servidores.getSetServidor(), servidores.getBaiServidor(), servidores.getCidServidor(), servidores.getEstServidor());

    }

    public void removeSrvidores(int idServidor) throws SQLException {

        executeCommand("DELETE FROM TB_SERVIDORES WHERE SER_CODIGO = ?", idServidor);
    }

    public void updateServidores(Servidores servidores) throws SQLException {

        String query = "UPDATE TB_SERVIDORES SET SER_NOME = ?, SER_IDENTIDADE=?, SER_CPF = ?, SER_CAR_TRAB = ?, SER_DATA_NASCIMENTO = ?,"
                + "SER_DATA_ADMISSAO = ?, SER_SEXO = ?, SER_ESTADO_CIVIL = ?, SER_FILHOS = ?, SER_EMAIL = ?, SER_LOGRADOURO = ?, SER_NUMERO = ?,"
                + " SER_COMPLEMENTO = ?, SER_CEP = ?, SER_FUN_CODIGO = ?, SER_SET_CODIGO = ?, SER_BAI_CODIGO = ?, SER_CID_CODIGO = ?,"
                + " SER_EST_CODIGO = ? "
                + "WHERE SER_CODIGO = ?";
        executeCommand(query, servidores.getNomeServidor(), servidores.getIdentidadeServidor(), servidores.getCpfServidor(),
                servidores.getCarteiraTrabalhoServidor(), servidores.getNascimentoServidor(), servidores.getAdmissaoServidor(),
                servidores.getSexoServidor(), servidores.getEstCivilServidor(), servidores.getFilhoServidor(), servidores.getEmailServidor(),
                servidores.getLogradouroServidor(), servidores.getNumeroServidor(), servidores.getComplementoServidor(), servidores.getCepServidor(),
                servidores.getFunServidor(), servidores.getSetServidor(), servidores.getBaiServidor(), servidores.getCidServidor(), servidores.getEstServidor(), servidores.getIdServidor());
    }

    public Servidores getServidor(int idServidor) throws SQLException {

        ResultSet rs = executeQuery("SELECT * FROM TB_SERVIDORES WHERE SER_CODIGO = ?", idServidor);


        Servidores servidores = null;
        if (rs.next()) {
            servidores = populateServidoresInfo(rs);
        }
        rs.close();
        return servidores;
    }

    public List<Servidores> geAllServidores() throws SQLException {
        ResultSet rs = executeQuery(" Select * From TB_SERVIDORES ");
        List<Servidores> toReturn = new LinkedList<Servidores>();
        while (rs.next()) {
            toReturn.add(populateServidoresInfo(rs));
        }
        rs.close();
        return toReturn;
    }

    //Esse método retorna os dados da tabela cidade 
    public List<Servidores> getListServidores() throws SQLException {
        //o rs vai recuperar e guardar de uma so vez os dados de retorno do select
        ResultSet rs = executeQuery(" Select * From TB_SERVIDORES Order By SER_NOME");

        List<Servidores> toReturn = new LinkedList<Servidores>();
        //enquanto tiver registro no rs o laço while é preenchido
        while (rs.next()) {

            //Enquanto rs tiver dados toReturn recebe-os
            toReturn.add(populateServidoresInfo(rs));
        }
        //rs é desalocado
        rs.close();
        //o metodo que é do tipo List agora é uma lista de dados de retorno do select
        return toReturn;
    }

    //Esse Método é usado para recuperar os dados 
    public Servidores populateServidoresInfo(ResultSet rs) throws SQLException {

        Servidores toReturn = new Servidores();
        toReturn.setIdServidor(rs.getInt("SER_CODIGO"));
        toReturn.setNomeServidor(rs.getString("SER_NOME"));
        toReturn.setIdentidadeServidor(rs.getString("SER_IDENTIDADE"));
        toReturn.setCpfServidor(rs.getString("SER_CPF"));
        toReturn.setCarteiraTrabalhoServidor(rs.getString("SER_CAR_TRAB"));
        toReturn.setNascimentoServidor(rs.getDate("SER_DATA_NASCIMENTO"));
        toReturn.setAdmissaoServidor(rs.getDate("SER_DATA_ADMISSAO"));
        toReturn.setRegistroServidor(rs.getDate("SER_DATA_REGISTRO"));
        toReturn.setSexoServidor(rs.getString("SER_SEXO"));
        toReturn.setEstCivilServidor(rs.getString("SER_ESTADO_CIVIL"));
        toReturn.setFilhoServidor(rs.getInt("SER_FILHOS"));
        toReturn.setEmailServidor(rs.getString("SER_EMAIL"));
        toReturn.setLogradouroServidor(rs.getString("SER_LOGRADOURO"));
        toReturn.setNumeroServidor(rs.getString("SER_NUMERO"));
        toReturn.setComplementoServidor(rs.getString("SER_COMPLEMENTO"));
        toReturn.setCepServidor(rs.getString("SER_CEP"));
        toReturn.setFunServidor(rs.getInt("SER_FUN_CODIGO"));
        toReturn.setSetServidor(rs.getInt("SER_SET_CODIGO"));
        toReturn.setBaiServidor(rs.getInt("SER_BAI_CODIGO"));
        toReturn.setCidServidor(rs.getInt("SER_CID_CODIGO"));
        toReturn.setEstServidor(rs.getInt("SER_EST_CODIGO"));
        return toReturn;
    }
}