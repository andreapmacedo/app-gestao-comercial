
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import entities.EmployeesPhone;


public class EmployerPhoneDAO extends GenericDAO {

    private String tableName = "tb_employers_phone";

    private String[] attrb = new String[]{"EFN_ID", "EFN_EMP_ID", "EFN_NUMERO", "EFN_TIPO", "EFN_OPERADORA", "EMP_IDENTIFICACAO"};

    public String[] columnNames = {"ID", "COLABORADOR", "NUMERO", "TIPO", "OPERADORA"};

    public EmployerPhoneDAO() {

    }

    public String get_AutoIncremente() throws SQLException {

        String query = "select auto_increment from information_schema.TABLES where TABLE_NAME = '" + tableName + "' and TABLE_SCHEMA = \"" + banco + "\"";

        return super.getNextAI(query);
    }

    public void add_Entity(EmployeesPhone entity) throws SQLException {

        String query = "INSERT INTO " + tableName + "(" + attrb[1] + "," + attrb[2] + "," + attrb[3] + "," + attrb[4] + ") values (?,?,?,?)";
        executeCommand(query, entity.getIdFK_Employer(), entity.getNumero(), entity.getTipo(), entity.getOperadora());

    }

    public void remove_Entity(int id) throws SQLException {

        executeCommand("DELETE FROM " + tableName + " WHERE " + attrb[0] + " = ?", id);
    }

    public void update_Entity(EmployeesPhone entity) throws SQLException {

        String query = "UPDATE " + tableName + " SET " + attrb[2] + " = ?, " + attrb[3] + " = ?," + attrb[4] + " = ?  WHERE " + attrb[0] + " = ?";
        executeCommand(query, entity.getNumero(), entity.getTipo(), entity.getOperadora(), entity.getIdPk());

    }

    public EmployeesPhone select_idPk(int idPk) throws SQLException {

        ResultSet rs = executeQuery("SELECT * FROM " + tableName + " WHERE " + attrb[0] + " = ?", idPk);

        EmployeesPhone entity = null;
        if (rs.next()) {
            entity = get_Entity(rs, 0);
        }
        rs.close();
        return entity;
    }

    public List<EmployeesPhone> Select_idFK(int idFK) throws SQLException {

        ResultSet rs = executeQuery(" Select * From tb_employers_phone WHERE  EFN_EMP_ID  = ? ", idFK);
        List<EmployeesPhone> toReturn = new LinkedList<EmployeesPhone>();

        while (rs.next()) {

            toReturn.add(get_Entity(rs, 0));
        }

        rs.close();

        return toReturn;
    }

    public List<EmployeesPhone> select_full() throws SQLException {
        ResultSet rs = executeQuery(" Select * From " + tableName);
        List<EmployeesPhone> toReturn = new LinkedList<EmployeesPhone>();
        while (rs.next()) {
            toReturn.add(get_Entity(rs, 0));
        }
        rs.close();
        return toReturn;
    }

    public List<EmployeesPhone> select_Filter(int idFk, ArrayList attr, ArrayList fieldsFilter) throws SQLException {

        String query = " Select EFN_ID, EFN_NUMERO, EFN_TIPO, EFN_OPERADORA From tb_employers_phone WHERE EFN_EMP_ID  = ? ";

        for (int i = 0; i < fieldsFilter.size(); i++) {
            query = query + " and " + attr.get(i) + " like " + fieldsFilter.get(i);
        }

        System.out.println("query "+query);
        System.out.println("id fk: "+idFk);
        
        ResultSet rs = executeQuery(query, idFk);

        List<EmployeesPhone> toReturn = new LinkedList<EmployeesPhone>();
        while (rs.next()) {
            toReturn.add(get_Entity(rs, 0));
        }
        rs.close();
        return toReturn;

    }

    public List<EmployeesPhone> select_Inner() throws SQLException {

        //ResultSet rss = executeQuery(" select CID_ID, EST_NOME, CID_NOME from tb_cidades inner join tb_estados on tb_cidades.CID_EST_ID = tb_estados.EST_ID ");
        ResultSet rs = executeQuery(" select " + attrb[0] + "," + attrb[5] + "," + attrb[2] + "," + attrb[3] + "," + attrb[4] + " from " + tableName + " inner join tb_employers on tb_employers_phone.EFN_EMP_ID = tb_employers.EMP_ID ");
        List<EmployeesPhone> toReturn = new LinkedList<EmployeesPhone>();

        while (rs.next()) {

            toReturn.add(get_Entity(rs, 1));

        }

        rs.close();

        return toReturn;
    }
    
    
    

    public List<EmployeesPhone> select_InnerFilter(boolean status, ArrayList attr, ArrayList fieldsFilter) throws SQLException {

        String query = " select EFN_ID, EMP_IDENTIFICACAO, EFN_NUMERO, EFN_TIPO, EFN_OPERADORA from tb_employers_phone "
                + "inner join tb_employers on tb_employers_phone.EFN_EMP_ID = tb_employers.EMP_ID ";

        for (int i = 0; i < fieldsFilter.size(); i++) {
            query = query + " and " + attr.get(i) + " like " + fieldsFilter.get(i);
        }

        if(!status){
        
        query = query + " and tb_employers.EMP_STATUS = 1";
        }
        
        
        
        ResultSet rs = executeQuery(query);

        List<EmployeesPhone> toReturn = new LinkedList<EmployeesPhone>();
        while (rs.next()) {
            toReturn.add(get_Entity(rs, 1));
        }
        rs.close();
        return toReturn;


    }

    public static Object[][] populateTable_1(List<EmployeesPhone> lista) {

        int columns = 5;

        Object[][] resposta = new Object[lista.size()][columns];

        for (int i = 0; i < resposta.length; i++) {
            EmployeesPhone entity = lista.get(i);
            resposta[i][0] = entity.getIdPk();
            resposta[i][1] = entity.getNomeColaborador();
            resposta[i][2] = entity.getNumero();
            resposta[i][3] = entity.getTipo();
            resposta[i][4] = entity.getOperadora();

        }

        return resposta;
    }

    public static Object[][] populateTable_2(List<EmployeesPhone> lista) {

        int columns = 4;

        Object[][] resposta = new Object[lista.size()][columns];

        for (int i = 0; i < resposta.length; i++) {
            EmployeesPhone entity = lista.get(i);
            resposta[i][0] = entity.getIdPk();
            resposta[i][1] = entity.getNumero();
            resposta[i][2] = entity.getTipo();
            resposta[i][3] = entity.getOperadora();

        }

        return resposta;
    }

    public EmployeesPhone get_Entity(ResultSet rs, int loadGetType) throws SQLException {

        EmployeesPhone toReturn = new EmployeesPhone();

        if (loadGetType == 1) {
            toReturn.setIdPk(rs.getInt(attrb[0]));
            toReturn.setNumero(rs.getString(attrb[2]));
            toReturn.setTipo(rs.getString(attrb[3]));
            toReturn.setOperadora(rs.getString(attrb[4]));
            toReturn.setNomeColaborador(rs.getString(attrb[5]));
            return toReturn;

        } else {
            toReturn.setIdPk(rs.getInt(attrb[0]));
            toReturn.setNumero(rs.getString(attrb[2]));
            toReturn.setTipo(rs.getString(attrb[3]));
            toReturn.setOperadora(rs.getString(attrb[4]));
            return toReturn;
        }
    }

}
