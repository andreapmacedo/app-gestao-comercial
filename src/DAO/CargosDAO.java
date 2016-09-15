/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Cargos;
import Entidades.Setores;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Andre
 */
public class CargosDAO extends GenericDAO {

    public final String className = "Classe ->"+this.getClass().getSimpleName();
   
    //private final frm_Principal status;

   

     public CargosDAO() {
        
    }


    
     public void addCargo(Cargos funcoes) throws SQLException {
        
        String query = "INSERT INTO TB_FUNCOES (FUN_NOME,FUN_SET_CODIGO) values (?,?)";
        executeCommand(query, funcoes.getNomeFuncao(),funcoes.getIdSetor());
        
    }
    

    public void removeCargo(int idFuncao) throws SQLException {
        
        executeCommand("DELETE FROM TB_FUNCOES WHERE FUN_CODIGO = ?", idFuncao);
    }

    public void updateCargo(Cargos funcoes) throws SQLException {
      
        String query = "UPDATE TB_FUNCOES SET FUN_NOME = ? WHERE FUN_CODIGO = ?";
        executeCommand(query, funcoes.getNomeFuncao(),funcoes.getIdFuncao());
    }

    public Cargos getCargo(int idCargo) throws SQLException {
       
        ResultSet rs = executeQuery("SELECT * FROM TB_FUNCOES WHERE FUN_CODIGO = ?", idCargo);
        
        
        Cargos funcoa = null;
        if (rs.next()) {
            funcoa = populateFuncoesInfo(rs);
        }
        rs.close();
        return funcoa;
    }
    
   
    
    public List<Cargos> getAll_Cargos_ByName() throws SQLException {
        ResultSet rs = executeQuery(" Select * From TB_FUNCOES Order By FUN_NOME");
        List<Cargos> toReturn = new LinkedList<Cargos>();
        while (rs.next()) {
            toReturn.add(populateFuncoesInfo(rs));
        }
        rs.close();
        return toReturn;
    }
    
    
    

    
    public List<Cargos> getForSetor_Cargos_ByName(int idSetor) throws SQLException {
       //o rs vai recuperar e guardar de uma so vez os dados de retorno do select
        ResultSet rs = executeQuery(" Select * From TB_FUNCOES WHERE FUN_SET_CODIGO = ? Order By FUN_NOME",idSetor);
       
        List<Cargos> toReturn = new LinkedList<Cargos>();
        //enquanto tiver registro no rs o laço while é preenchido
        while (rs.next()) {
            
            //Enquanto rs tiver dados toReturn recebe-os
            toReturn.add(populateFuncoesInfo(rs));
            
        }
        //rs é desalocado
        rs.close();
        //o metodo que é do tipo List agora é uma lista de dados de retorno do select
        return toReturn;
    }

 
    public Cargos populateFuncoesInfo(ResultSet rs) throws SQLException { 
        
        Cargos toReturn = new Cargos();
        toReturn.setIdFuncao(rs.getInt("FUN_CODIGO"));
        toReturn.setNomeFuncao(rs.getString("FUN_NOME"));
        return toReturn;
    }
}