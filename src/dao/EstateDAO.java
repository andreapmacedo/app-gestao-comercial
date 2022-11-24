/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import entities.Estate;

public class EstateDAO extends GenericDAO {

    private final String tableName = "tb_estados";
    private final String PK = "EST_ID";
    private final String FK = null;
    private final String mainName = "EST_NOME";

    public EstateDAO() {
    }

    public String get_AutoIncremente() throws SQLException {

        String query = "select auto_increment from information_schema.TABLES where TABLE_NAME = '" + tableName + "' and TABLE_SCHEMA = \"" + banco + "\""; //"UPDATE " + tableName + " SET  " + mainName + "= ? WHERE " + PK + " = ?";

        return super.getNextAI(query);
    }

    public void add_Entity(Estate entity) throws SQLException {

        String query = "INSERT INTO " + tableName + " ( " + mainName + " ) values (?)";
        executeCommand(query, entity.getNomeEstado());

    }

    public void remove_Entity(int id) throws SQLException {

        executeCommand("DELETE FROM " + tableName + " WHERE " + PK + " = ?", id);
    }

    public void update_Entity(Estate entity) throws SQLException {

        String query = "UPDATE " + tableName + " SET  " + mainName + "= ? WHERE " + PK + " = ?";
        executeCommand(query, entity.getNomeEstado(), entity.getIdEstado());
    }

    public Estate get_Just_Entity(int idPk) throws SQLException {

        ResultSet rs = executeQuery("SELECT * FROM " + tableName + " WHERE " + PK + " = ?", idPk);

        Estate estado = null;
        if (rs.next()) {
            estado = populateEntityInfo(rs);
        }
        rs.close();
        return estado;
    }
//    public List<Estados> get_Just_Entity(int idPk) throws SQLException {
//
//        ResultSet rs = executeQuery("SELECT * FROM " + tableName + " WHERE " + PK + " = ?", idPk);
//
//        List<Estados> toReturn = new LinkedList<Estados>();
//        while (rs.next()) {
//            toReturn.add(populateEntityInfo(rs));
//        }
//        rs.close();
//        return toReturn;
//    }

    public List<Estate> get_All_Entity_OrderByItemName() throws SQLException {

        ResultSet rs = executeQuery("Select * From " + tableName + " Order By " + mainName + ";");
        List<Estate> toReturn = new LinkedList<Estate>();
        while (rs.next()) {
            toReturn.add(populateEntityInfo(rs));
        }
        rs.close();
        return toReturn;
    }

    public List<Estate> get_All_Entity_SQLdefault() throws SQLException {

        ResultSet rs = executeQuery("Select * From " + tableName);
        List<Estate> toReturn = new LinkedList<Estate>();
        while (rs.next()) {
            toReturn.add(populateEntityInfo(rs));
        }
        rs.close();
        return toReturn;
    }

    public int get_Id_Entity(String itemCmb) {

        int idFound = 0;

        try {

            Vector<Estate> list = new Vector(this.get_All_Entity_OrderByItemName());

            for (Estate iten : list) {

                if (iten.getNomeEstado().equals(itemCmb)) {

                    idFound = iten.getIdEstado();

                }
            }
        } catch (SQLException ex) {

        }

        return idFound;

    }

    public Estate populateEntityInfo(ResultSet rs) throws SQLException {
        Estate toReturn = new Estate();
        toReturn.setIdEstado(rs.getInt(PK));
        toReturn.setNomeEstado(rs.getString(mainName));
        return toReturn;
    }
}
