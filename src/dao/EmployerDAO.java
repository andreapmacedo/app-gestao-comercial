/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import entities.Employees;

/**
 *
 * @author Andre
 */
public class EmployerDAO extends GenericDAO {

    private String tableName = "tb_employers";
    private String PK = "EMP_ID";
    private String FK = null;
    private String mainName = "EMP_IDENTIFICACAO";
    private String date = "EMP_DATA_REGISTRO";
    private String status = "EMP_STATUS";

    public String columnNames[] = {"ID", "DATA REGISTRO", "IDENTIFICAÇÃO"};

    public EmployerDAO() {
    }

    public String get_AutoIncremente() throws SQLException {

        String query = "select auto_increment from information_schema.TABLES where TABLE_NAME = '" + tableName + "' and TABLE_SCHEMA = \"" + banco + "\""; //"UPDATE " + tableName + " SET  " + mainName + "= ? WHERE " + PK + " = ?";

        return super.getNextAI(query);
    }

    public void add_Entity(Employees entity) throws SQLException {

        String query = "INSERT INTO " + tableName + " ( " + date + "," + mainName + " ) values (?,?)";
        executeCommand(query, entity.getDataRegistroEmployer(), entity.getIdentificacaoEmployer());

    }

    public void remove_Entity(int id) throws SQLException {

        System.out.println("id no remove: " + id);
        executeCommand("DELETE FROM tb_employers WHERE EMP_ID = ? ", id);



    }

    public void update_Entity(Employees entity) throws SQLException {

        String query = "UPDATE " + tableName + " SET  " + mainName + " = ?, " + status + " = ? WHERE " + PK + " = ?";

        executeCommand(query, entity.getIdentificacaoEmployer(), entity.getStatus(), entity.getIdEmployer());
    }

    public Employees get_Just_Entity(int id) throws SQLException {

        ResultSet rs = executeQuery("SELECT * FROM " + tableName + " WHERE " + PK + " = ?", id);

        Employees entity = null;
        if (rs.next()) {
            entity = populateEntityInfo(rs);
        }
        rs.close();
        return entity;
    }

    public List<Employees> get_All_Entity_OrderByItemName() throws SQLException {

        ResultSet rs = executeQuery("Select * From " + tableName + " Order By " + mainName + ";");
        List<Employees> toReturn = new LinkedList<Employees>();
        while (rs.next()) {
            toReturn.add(populateEntityInfo(rs));
        }
        rs.close();
        return toReturn;
    }

    public List<Employees> get_All_Entity_StatusFilter(int status) throws SQLException {

        ResultSet rs = executeQuery("select EMP_ID, EMP_DATA_REGISTRO, EMP_IDENTIFICACAO from tb_employers where EMP_STATUS = ?", status);

        List<Employees> toReturn = new LinkedList<Employees>();
        while (rs.next()) {
            toReturn.add(populateEntityInfo(rs));
        }
        rs.close();
        return toReturn;
    }

    public List<Employees> get_All_Entity_FullFilter(int status, ArrayList attr, ArrayList fieldsFilter) throws SQLException {


        String query = "select EMP_ID, EMP_DATA_REGISTRO, EMP_IDENTIFICACAO from tb_employers where EMP_STATUS = ?";

        for (int i = 0; i < fieldsFilter.size(); i++) {
            query = query + " and " + attr.get(i) + " like " + fieldsFilter.get(i);
        }

        ResultSet rs = executeQuery(query, status);

        List<Employees> toReturn = new LinkedList<Employees>();
        while (rs.next()) {
            toReturn.add(populateEntityInfo(rs));
        }
        rs.close();
        return toReturn;

    }

    public List<Employees> get_All_Entity_SQLdefault() throws SQLException {

        ResultSet rs = executeQuery("Select * From " + tableName);
        List<Employees> toReturn = new LinkedList<Employees>();
        while (rs.next()) {
            toReturn.add(populateEntityInfo(rs));
        }
        rs.close();
        return toReturn;
    }

    public int get_Id_Entity(String itemCmb) {

        int temp = -1;

        try {

            Vector<Employees> lista = new Vector(this.get_All_Entity_OrderByItemName());

            for (Employees i : lista) {

                int idFound = i.getIdEmployer();
                String itemFound = i.getIdentificacaoEmployer();

                if (itemFound.equals(itemCmb)) {

                    temp = idFound;
                    //Controller.idEstado = idFound;

                }
            }
        } catch (SQLException ex) {

        }

        return temp;
    }

    public Employees populateEntityInfo(ResultSet rs) throws SQLException {

        Employees toReturn = new Employees();
        toReturn.setIdEmployer(rs.getInt(PK));
        toReturn.setDataRegistroEmployer(rs.getDate(date));
        toReturn.setIdentificacaoEmployer(rs.getString(mainName));

        return toReturn;
    }

    public static Object[][] preencherTabela(List<Employees> lista) {

        DateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");

        Object[][] resposta = new Object[lista.size()][3];

        for (int i = 0; i < resposta.length; i++) {
            Employees entity = lista.get(i);
            resposta[i][0] = entity.getIdEmployer();
            resposta[i][1] = formatador.format(entity.getDataRegistroEmployer());
            resposta[i][2] = entity.getIdentificacaoEmployer();

        }

        return resposta;
    }

}
