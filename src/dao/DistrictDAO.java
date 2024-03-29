/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entities.District;

/**
 *
 * @author Andre
 */
public class DistrictDAO extends GenericDAO {

    public final String className = "Classe ->" + this.getClass().getSimpleName();

    public DistrictDAO() {
    }

    public void addBairros(District bairros) throws SQLException {

        String query = "INSERT INTO TB_BAIRROS (BAI_NOME, BAI_CID_CODIGO) values (?,?)";
        executeCommand(query, bairros.getNomeBairro(), bairros.getIdCidade());

    }

    public void removeBairros(int idBairro) throws SQLException {

        executeCommand("DELETE FROM TB_BAIRROS WHERE BAI_CODIGO = ?", idBairro);
    }

    public void updateBairros(District bairros) throws SQLException {

        String query = "UPDATE TB_BAIRROS SET BAI_NOME = ? WHERE BAI_CODIGO = ?";
        executeCommand(query, bairros.getNomeBairro(), bairros.getIdBairro());
    }

    public District getBairro(int idBairro) throws SQLException {

        ResultSet rs = executeQuery("SELECT * FROM TB_BAIRROS WHERE BAI_CODIGO = ? Order By BAI_NOME ", idBairro);


        District bairros = null;
        if (rs.next()) {
            bairros = populateBairrosInfo(rs);
        }
        rs.close();
        return bairros;
    }
    
       public District getBairroPorLocalidade(int idBairro,int idCidade) throws SQLException {
           //System.out.println("id bairro = "+idBairro+" id cidade = "+idCidade);
        ResultSet rs = executeQuery("SELECT * FROM TB_BAIRROS WHERE BAI_CODIGO = ? AND BAI_CID_CODIGO = ?", idBairro, idCidade);


        District bairros = null;
        if (rs.next()) {
            bairros = populateBairrosInfo(rs);
        }
        rs.close();
        return bairros;
    }

    //Esse método retorna os dados da tabela cidade 
    public List<District> getAll_Bairros_ByIndex() throws SQLException {
        ResultSet rs = executeQuery("Select * FROM TB_BAIRROS");
        List<District> toReturn = new LinkedList<District>();
        while (rs.next()) {
            toReturn.add(populateBairrosInfo(rs));
        }
        rs.close();
        return toReturn;
    }

    public List<District> getForLocale_Bairros_ByName(int idCidade, int idEstado) throws SQLException {

        //System.out.println("parametros " + idCidade + idEstado);
        ResultSet rs = executeQuery("Select *"
                + "FROM TB_ESTADOS "
                + "JOIN TB_CIDADES ON(CID_EST_CODIGO = EST_CODIGO) "
                + "JOIN TB_BAIRROS ON(BAI_CID_CODIGO = CID_CODIGO) "
                + "WHERE BAI_CID_CODIGO = ? "
                + "AND 	EST_CODIGO = ? "
                + "Order By BAI_NOME ", idCidade, idEstado);


        List<District> toReturn = new LinkedList<District>();
        //enquanto tiver registro no rs o laço while é preenchido
        while (rs.next()) {

            //Enquanto rs tiver dados toReturn recebe-os
            toReturn.add(populateBairrosInfo(rs));
        }
        //rs é desalocado
        rs.close();
        //o metodo que é do tipo List agora é uma lista de dados de retorno do select
        return toReturn;
    }

    //Esse Método é usado para recuperar os dados 
    public District populateBairrosInfo(ResultSet rs) throws SQLException {

        District toReturn = new District();
        toReturn.setIdBairro(rs.getInt("BAI_CODIGO"));
        toReturn.setNomeBairro(rs.getString("BAI_NOME"));
        toReturn.setIdCidade(rs.getInt("BAI_CID_CODIGO"));
        return toReturn;
    }
}
