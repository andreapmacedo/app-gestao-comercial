/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entities.Sector;

/**
 *
 * @author Andre
 */
public class SectorDAO extends GenericDAO {

    public final String className = "Classe ->"+this.getClass().getSimpleName();
   
    //private final frm_Principal status;

   

    public SectorDAO() {
        
    }


    
     public void addSetores(Sector setores) throws SQLException {
        
        String query = "INSERT INTO TB_SETORES (SET_NOME) values (?)";
        executeCommand(query, setores.getNomeSetor());
        
    }
    

    public void removeSetores(int idSetor) throws SQLException {
        
        executeCommand("DELETE FROM TB_SETORES WHERE SET_CODIGO = ?", idSetor);
    }

    public void updateSetores(Sector Setores) throws SQLException {
      
        String query = "UPDATE TB_SETORES SET SET_NOME = ? WHERE SET_CODIGO = ?";
        executeCommand(query, Setores.getNomeSetor(),Setores.getIdSetor());
    }

    public Sector getSetor(int idSetor) throws SQLException {
       
        ResultSet rs = executeQuery("SELECT * FROM TB_SETORES WHERE SET_CODIGO = ?", idSetor);
        
        
        Sector cidade = null;
        if (rs.next()) {
            cidade = populateSetoresInfo(rs);
        }
        rs.close();
        return cidade;
    }
    
    
    public List<Sector> geAll_Setores_ByIndex() throws SQLException {
        ResultSet rs = executeQuery(" Select * From TB_SETORES ");
        List<Sector> toReturn = new LinkedList<Sector>();
        while (rs.next()) {
            toReturn.add(populateSetoresInfo(rs));
        }
        rs.close();
        return toReturn;
    }
    

    public List<Sector> getAll_Setores_ByName() throws SQLException {
        ResultSet rs = executeQuery(" Select * From TB_SETORES Order By SET_NOME");
       
        List<Sector> toReturn = new LinkedList<Sector>();
        while (rs.next()) {
            
            toReturn.add(populateSetoresInfo(rs));
        }
        rs.close();
        return toReturn;
    }

    public Sector populateSetoresInfo(ResultSet rs) throws SQLException { 
        
        Sector toReturn = new Sector();
        toReturn.setIdSetor(rs.getInt("SET_CODIGO"));
        toReturn.setNomeSetor(rs.getString("SET_NOME"));
        return toReturn;
    }
}