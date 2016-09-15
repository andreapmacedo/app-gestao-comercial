/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Estados;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public Estados getEstado(int id) throws SQLException {

        ResultSet rs = executeQuery("SELECT * FROM "+ tableName + " WHERE " + PK + " = ?", id);

        Estados estado = null;
        if (rs.next()) {
            estado = populateEstadosInfo(rs);
        }
        rs.close();
        return estado;
    }

    
    public List<Estados> getAll_Estados_ByName() throws SQLException {

        ResultSet rs = executeQuery("Select * From " + tableName + " Order By " + mainName + ";");
        List<Estados> toReturn = new LinkedList<Estados>();
        while (rs.next()) {
            toReturn.add(populateEstadosInfo(rs));
        }
        rs.close();
        return toReturn;
    }
    
    public List<Estados> getAll_Estados_ByIndex() throws SQLException {

        ResultSet rs = executeQuery("Select * From " + tableName);
        List<Estados> toReturn = new LinkedList<Estados>();
        while (rs.next()) {
            toReturn.add(populateEstadosInfo(rs));
        }
        rs.close();
        return toReturn;
    }

    //Esse Método é usado para recuperar os dados 
    public Estados populateEstadosInfo(ResultSet rs) throws SQLException {

        Estados toReturn = new Estados();
        toReturn.setIdEstado(rs.getInt(PK));
        toReturn.setNomeEstado(rs.getString(mainName));
        return toReturn;
    }
}