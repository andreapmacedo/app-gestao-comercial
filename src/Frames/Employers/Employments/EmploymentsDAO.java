package Frames.Employers.Employments;

import DAO.GenericDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EmploymentsDAO extends GenericDAO {

    private final String tableName = "tb_employments";
    private final String[] attrb = {"EMT_ID", "EMT_EMP_ID", "EMT_INICIO", "EMT_FIM", "EMT_ACTIVE"};

    public EmploymentsDAO() {

    }

    public String get_AutoIncremente() throws SQLException {

        String query = "select auto_increment from information_schema.TABLES where TABLE_NAME = '" + tableName + "' and TABLE_SCHEMA = \"" + banco + "\"";

        return super.getNextAI(query);
    }

    public void add_Entity(Employments entity, int[] attr) throws SQLException {

        //    String query = "INSERT INTO tb_employers_data (EMD_EMP_ID, EMD_NOME, EMD_NASCIMENTO, EMD_SEXO, EMD_EST_CIVIL, EMD_IDENTIDADE, EMD_CPF, EMD_PIS, EMD_FILHOS, EMD_EMAIL, EMD_LOGRADOURO, EMD_NUMERO, EMD_COMPLEMENTO, EMD_BAIRRO, EMD_CID_ID, EMD_EST_ID) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String query = "INSERT INTO " + tableName + "(";
        String values = " ) values ( ";

        for (int i = 0; i < attr.length; i++) {
            if (i == attr.length - 1) {

                query = query + attrb[attr[i]];
                values = values + " ? ";

            } else {
                query = query + attrb[attr[i]] + " , ";
                values = values + " ? , ";
            }
        }
        query = query + values + " )";

//        String query = "INSERT INTO " + tableName + "(";
//        String values = " ) values ( ";
//
//        for (int i = 0; i < attrb.length - 1; i++) {
//            if (i + 1 == attrb.length - 1) {
//
//                query = query + attrb[i + 1];
//                values = values + " ?  ";
//
//            } else {
//                query = query + attrb[i + 1] + " , ";
//                values = values + " ? , ";
//            }
//        }
//        query = query + values + " )";
        //automatizar 
        executeCommand(query, entity.getIdEmployer(), entity.getStartDateEmployment(), entity.getStopedDateEmployment(), entity.getActivedEmployment());

    }

    public void update_Entity(Employments entity, int[] attr) throws SQLException {

        //String query = "UPDATE " + tableName + " SET " + attrb[2] + " = ?, " + attrb[3] + " = ?," + attrb[4] + " = ?  WHERE " + attrb[0] + " = ?";
        //      String query = "UPDATE " + tableName + " SET " + " EMD_NOME = ?, EMD_NASCIMENTO = ?, EMD_SEXO = ?, EMD_EST_CIVIL = ?, EMD_IDENTIDADE = ?, EMD_CPF = ?, EMD_PIS = ?, EMD_FILHOS = ?, EMD_EMAIL = ?, EMD_LOGRADOURO = ?, EMD_NUMERO = ?, EMD_COMPLEMENTO = ?, EMD_BAIRRO = ?, EMD_CID_ID = ?, EMD_EST_ID = ? WHERE EMD_ID = ? ";
        String query = "UPDATE " + tableName + " SET ";

        for (int i = 0; i < attr.length; i++) {
            if (i == attr.length - 1) {
                query = query + attrb[attr[i]] + " = ? , ";
            } else {
                query = query + attrb[attr[i]] + " = ?  ";
            }
        }
        query = query + " WHERE " + attrb[0] + " = ?";

//        String query = "UPDATE " + tableName + " SET ";
//
//        for (int i = 0; i < attrb.length - 2; i++) {
//            if (i + 1 == attrb.length - 2) {
//                query = query + attrb[i + 2] + " = ? , ";
//            } else {
//                query = query + attrb[i + 2] + " = ?  ";
//            }
//        }
//        query = query + " WHERE " + attrb[0] + " = ?";
        executeCommand(query, entity.getIdEmployer(), entity.getStartDateEmployment(), entity.getStopedDateEmployment(), entity.getActivedEmployment(), entity.getIdEmployment());

    }

    public void remove_Entity(int idPk) throws SQLException {

        executeCommand("DELETE FROM " + tableName + " WHERE " + attrb[0] + " = ?", idPk);
    }

    public Employments select_By_idPk(int idPk) throws SQLException {

        ResultSet rs = executeQuery("SELECT * FROM " + tableName + " WHERE " + attrb[0] + " = ?", idPk);

        Employments entity = null;
        if (rs.next()) {
            entity = setEntity(rs, 0);
        }
        rs.close();
        return entity;
    }

    public Employments select_ID(int idFk) throws SQLException {//provavel necessidade de alteração

        ResultSet rs = executeQuery("SELECT EMD_ID FROM " + tableName + " WHERE " + attrb[1] + " = ?", idFk);

        Employments entity = null;
        if (rs.next()) {
            entity = setEntity(rs, 1);
        }
        rs.close();
        return entity;
    }

    public List<Employments> Select_By_idFK_1(int idFK) throws SQLException {

        // String query = "call upAllAgeEmployer";
        //  executeCommand(query);
        ResultSet rs = executeQuery(" Select * From " + tableName + " WHERE  " + attrb[1] + "  = ? ", idFK);
        List<Employments> toReturn = new LinkedList<Employments>();

        while (rs.next()) {

            toReturn.add(setEntity(rs, 0));
        }

        rs.close();

        return toReturn;
    }

    public List<Employments> select_All() throws SQLException {
        ResultSet rs = executeQuery(" Select * From " + tableName);
        List<Employments> toReturn = new LinkedList<Employments>();
        while (rs.next()) {
            toReturn.add(setEntity(rs, 0));
        }
        rs.close();
        return toReturn;
    }

    public List<Employments> select_Filter(int idFk, ArrayList attr, ArrayList fieldsFilter) throws SQLException {

        //automatizar
        String query = " Select EMT_ID, EMT_INICIO, EMT_FIM, EMT_ACTIVE From " + tableName + " WHERE EMT_EMP_ID  = ? ";

        for (int i = 0; i < fieldsFilter.size(); i++) {
            query = query + " and " + attr.get(i) + " like " + fieldsFilter.get(i);
        }

        ResultSet rs = executeQuery(query, idFk);

        List<Employments> toReturn = new LinkedList<Employments>();
        while (rs.next()) {
            toReturn.add(setEntity(rs, 1));
        }
        rs.close();
        return toReturn;

    }

//    public List<Employments> select_Inner() throws SQLException {
//
//        //ResultSet rss = executeQuery(" select CID_ID, EST_NOME, CID_NOME from tb_cidades inner join tb_estados on tb_cidades.CID_EST_ID = tb_estados.EST_ID ");
//        ResultSet rs = executeQuery(" select " + attrb[0] + "," + attrb[5] + "," + attrb[2] + "," + attrb[3] + "," + attrb[4] + " from " + tableName + " inner join tb_employers on tb_employers_phone.EFN_EMP_ID = tb_employers.EMP_ID ");
//        List<Employments> toReturn = new LinkedList<Employments>();
//
//        while (rs.next()) {
//
//            toReturn.add(setEntity(rs, 1));
//
//        }
//
//        rs.close();
//
//        return toReturn;
//    }
//    public List<Employments> select_Inner_Filter(boolean status, ArrayList attr, ArrayList fieldsFilter) throws SQLException {
//
//        String query = " select EFN_ID, EMP_IDENTIFICACAO, EFN_NUMERO, EFN_TIPO, EFN_OPERADORA from tb_employers_phone inner join tb_employers on tb_employers_phone.EFN_EMP_ID = tb_employers.EMP_ID ";
//
//        for (int i = 0; i < fieldsFilter.size(); i++) {
//            query = query + " and " + attr.get(i) + " like " + fieldsFilter.get(i);
//        }
//
//        if (!status) {
//
//            query = query + " and tb_employers.EMP_STATUS = 1";
//        }
//
//        ResultSet rs = executeQuery(query);
//
//        List<Employments> toReturn = new LinkedList<Employments>();
//        while (rs.next()) {
//            toReturn.add(setEntity(rs, 1));
//        }
//        rs.close();
//        return toReturn;
//
//    }
    public static Object[][] populateTable(List<Employments> lista, int loadRef) {

        Object[][] iten = null;

        if (loadRef == 0) {
            int columns = 1;
            iten = new Object[lista.size()][columns];
            for (int i = 0; i < iten.length; i++) {
                Employments entity = lista.get(i);
                iten[i][0] = entity.getIdEmployment();
            }

        } else if (loadRef == 1) {
            int columns = 4;
            iten = new Object[lista.size()][columns];

            for (int i = 0; i < iten.length; i++) {
                Employments entity = lista.get(i);
                iten[i][0] = entity.getIdEmployment();
                iten[i][1] = defaultDateFormat.format(entity.getStartDateEmployment());
                if (entity.getStopedDateEmployment() != null) { //If por causa do formatador de data que não aceita trabalhar com null
                    iten[i][2] = defaultDateFormat.format(entity.getStopedDateEmployment());
                }
                if (entity.getActivedEmployment().equals(1)) {
                    iten[i][3] = "ATIVO";
                } else {
                    iten[i][3] = "INATIVO";
                }
            }
        }
        return iten;
    }


    public Employments setEntity(ResultSet rs, int loadRef) throws SQLException {

        // Essa função vai receber os elementos gerados pelo select na chamada do método. Se o select não contemplar todas as colunas, nem todos os atributos poderão ser setados a partir
        //desse método. Verificar o resultado do select previamente para saber que atributos serão setados
        Employments toReturn = new Employments();

        toReturn.setIdEmployment(rs.getInt(attrb[0]));

        if (loadRef == 1) {

            toReturn.setStartDateEmployment(rs.getDate(attrb[2]));
            toReturn.setStopedDateEmployment(rs.getDate(attrb[3]));
            toReturn.setActivedEmployment(rs.getInt(attrb[4]));

            return toReturn;

        } else {

        }
        return toReturn;
    }

}
