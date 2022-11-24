/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entities.Office;
import entities.Sector;

/**
 *
 * @author Andre
 */
public class OfficeDAO extends GenericDAO {

    public final String className = "Classe ->"+this.getClass().getSimpleName();
   
    //private final frm_Principal status;

   

     public OfficeDAO() {
        
    }


    
     public void addCargo(Office funcoes) throws SQLException {
        
        String query = "INSERT INTO TB_FUNCOES (FUN_NOME,FUN_SET_CODIGO) values (?,?)";
        executeCommand(query, funcoes.getNomeFuncao(),funcoes.getIdSetor());
        
    }
    

    public void removeCargo(int idFuncao) throws SQLException {
        
        executeCommand("DELETE FROM TB_FUNCOES WHERE FUN_CODIGO = ?", idFuncao);
    }

    public void updateCargo(Office funcoes) throws SQLException {
      
        String query = "UPDATE TB_FUNCOES SET FUN_NOME = ? WHERE FUN_CODIGO = ?";
        executeCommand(query, funcoes.getNomeFuncao(),funcoes.getIdFuncao());
    }

    public Office getCargo(int idCargo) throws SQLException {
       
        ResultSet rs = executeQuery("SELECT * FROM TB_FUNCOES WHERE FUN_CODIGO = ?", idCargo);
        
        
        Office funcoa = null;
        if (rs.next()) {
            funcoa = populateFuncoesInfo(rs);
        }
        rs.close();
        return funcoa;
    }
    
   
    
    public List<Office> getAll_Cargos_ByName() throws SQLException {
        ResultSet rs = executeQuery(" Select * From TB_FUNCOES Order By FUN_NOME");
        List<Office> toReturn = new LinkedList<Office>();
        while (rs.next()) {
            toReturn.add(populateFuncoesInfo(rs));
        }
        rs.close();
        return toReturn;
    }
    
    
    

    
    public List<Office> getForSetor_Cargos_ByName(int idSetor) throws SQLException {
       //o rs vai recuperar e guardar de uma so vez os dados de retorno do select
        ResultSet rs = executeQuery(" Select * From TB_FUNCOES WHERE FUN_SET_CODIGO = ? Order By FUN_NOME",idSetor);
       
        List<Office> toReturn = new LinkedList<Office>();
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

 
    public Office populateFuncoesInfo(ResultSet rs) throws SQLException { 
        
        Office toReturn = new Office();
        toReturn.setIdFuncao(rs.getInt("FUN_CODIGO"));
        toReturn.setNomeFuncao(rs.getString("FUN_NOME"));
        return toReturn;
    }
}