/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import entities.Estate;

/**
 *
 * @author Andre
 */
public class GenericItemDAO extends GenericDAO {

    private String tableName = "tb_estados";
    private String PK = "EST_ID";
    private String FK = null;
    private String mainName = "EST_NOME";
    
    public GenericItemDAO() {
    }

    public Estate getEstado(int id) throws SQLException {

        ResultSet rs = executeQuery("SELECT * FROM "+ tableName + " WHERE " + PK + " = ?", id);

        Estate estado = null;
        if (rs.next()) {
            estado = populateEstadosInfo(rs);
        }
        rs.close();
        return estado;
    }

    
    public List<Estate> getAll_Estados_ByName() throws SQLException {

        ResultSet rs = executeQuery("Select * From " + tableName + " Order By " + mainName + ";");
        List<Estate> toReturn = new LinkedList<Estate>();
        while (rs.next()) {
            toReturn.add(populateEstadosInfo(rs));
        }
        rs.close();
        return toReturn;
    }
    
    public List<Estate> getAll_Estados_ByIndex() throws SQLException {

        ResultSet rs = executeQuery("Select * From " + tableName);
        List<Estate> toReturn = new LinkedList<Estate>();
        while (rs.next()) {
            toReturn.add(populateEstadosInfo(rs));
        }
        rs.close();
        return toReturn;
    }

    //Esse Método é usado para recuperar os dados 
    public Estate populateEstadosInfo(ResultSet rs) throws SQLException {

        Estate toReturn = new Estate();
        toReturn.setIdEstado(rs.getInt(PK));
        toReturn.setNomeEstado(rs.getString(mainName));
        return toReturn;
    }
}