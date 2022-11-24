package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import entities.EmployeeData;

public class EmployerDataDAO extends GenericDAO {

    private String tableName = "tb_employers_data";
    private String[] attrb = new String[]{"EMD_ID", "EMD_EMP_ID", "EMD_NOME", "EMD_NASCIMENTO", "EMD_IDADE", "EMD_SEXO", "EMD_EST_CIVIL", "EMD_IDENTIDADE",
        "EMD_CPF", "EMD_PIS", "EMD_FILHOS", "EMD_EMAIL", "EMD_LOGRADOURO", "EMD_NUMERO", "EMD_COMPLEMENTO", "EMD_BAIRRO",
        "EMD_CID_ID", "EMD_EST_ID", "EMD_EMP_ID"};
    //public String[] columnNames = {"ID", "COLABORADOR", "NUMERO", "TIPO", "OPERADORA"};

    public EmployerDataDAO() {

    }

    public String get_AutoIncremente() throws SQLException {

        String query = "select auto_increment from information_schema.TABLES where TABLE_NAME = '" + tableName + "' and TABLE_SCHEMA = \"" + banco + "\"";

        return super.getNextAI(query);
    }

    public void add_Entity(EmployeeData entity) throws SQLException {

//        String query = "INSERT INTO " + tableName + "(EMD_EMP_ID, EMD_NOME, EMD_NASCIMENTO, EMD_SEXO, EMD_EST_CIVIL, EMD_IDENTIDADE, "
//                + "EMD_CPF, EMD_PIS, EMD_FILHOS, EMD_E-MAIL, EMD_LOGRADOURO, EMD_NUMERO, EMD_COMPLEMENTO, EMD_BAIRRO, EMD_CID_ID, EMD_EST_ID) "
//                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String query = "INSERT INTO tb_employers_data (EMD_EMP_ID, EMD_NOME, EMD_NASCIMENTO, EMD_SEXO, EMD_EST_CIVIL, EMD_IDENTIDADE, EMD_CPF, EMD_PIS, EMD_FILHOS, EMD_EMAIL, EMD_LOGRADOURO, EMD_NUMERO, EMD_COMPLEMENTO, EMD_BAIRRO, EMD_CID_ID, EMD_EST_ID) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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
        System.out.println("bairro " + entity.getBairro().toString());
        executeCommand(query, entity.getIdFK_Employer(), entity.getNome(), entity.getNascimento(),/* entity.getIdade(), */ entity.getSexo(), entity.getEstadoCivil(),
                entity.getIdentidade(), entity.getCpf(), entity.getPis(), entity.getFilhos(), entity.getEmail(), entity.getLogradouro(), entity.getNumero(),
                entity.getComplemento(), entity.getBairro(), entity.getIdFK_Cidade(), entity.getIdFK_Estado());

    }

    public void update_Entity(EmployeeData entity) throws SQLException {

        //String query = "UPDATE " + tableName + " SET " + attrb[2] + " = ?, " + attrb[3] + " = ?," + attrb[4] + " = ?  WHERE " + attrb[0] + " = ?";
        String query = "UPDATE " + tableName + " SET " + " EMD_NOME = ?, EMD_NASCIMENTO = ?, EMD_SEXO = ?, EMD_EST_CIVIL = ?, EMD_IDENTIDADE = ?, EMD_CPF = ?, EMD_PIS = ?, EMD_FILHOS = ?, EMD_EMAIL = ?, EMD_LOGRADOURO = ?, EMD_NUMERO = ?, EMD_COMPLEMENTO = ?, EMD_BAIRRO = ?, EMD_CID_ID = ?, EMD_EST_ID = ? WHERE EMD_ID = ? ";

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
        executeCommand(query, entity.getNome(), entity.getNascimento(), /*entity.getIdade(),*/ entity.getSexo(), entity.getEstadoCivil(),
                entity.getIdentidade(), entity.getCpf(), entity.getPis(), entity.getFilhos(), entity.getEmail(), entity.getLogradouro(), entity.getNumero(),
                entity.getComplemento(), entity.getBairro(), entity.getIdFK_Cidade(), entity.getIdFK_Estado(), entity.getIdPk());

        String query2 = "call upAgeEmployer(?)";
        executeCommand(query2, entity.getIdPk());

    }

    public void remove_Entity(int idPk) throws SQLException {

        executeCommand("DELETE FROM " + tableName + " WHERE " + attrb[0] + " = ?", idPk);
    }

    public EmployeeData select_By_idPk(int idPk) throws SQLException {

        ResultSet rs = executeQuery("SELECT * FROM " + tableName + " WHERE " + attrb[0] + " = ?", idPk);

        EmployeeData entity = null;
        if (rs.next()) {
            entity = setEntity(rs, 0);
        }
        rs.close();
        return entity;
    }

    public EmployeeData select_ID(int idFk) throws SQLException {

        ResultSet rs = executeQuery("SELECT EMD_ID FROM " + tableName + " WHERE " + attrb[1] + " = ?", idFk);

        EmployeeData entity = null;
        if (rs.next()) {
            entity = setEntity(rs, 1);
        }
        rs.close();
        return entity;
    }

    public List<EmployeeData> Select_By_idFK(int idFK) throws SQLException {

        String query = "call upAllAgeEmployer";
        executeCommand(query);

        ResultSet rs = executeQuery(" Select * From " + tableName + " WHERE  " + attrb[1] + "  = ? ", idFK);
        List<EmployeeData> toReturn = new LinkedList<EmployeeData>();

        while (rs.next()) {

            toReturn.add(setEntity(rs, 0));
        }

        rs.close();

        return toReturn;
    }

    public List<EmployeeData> select_All() throws SQLException {
        ResultSet rs = executeQuery(" Select * From " + tableName);
        List<EmployeeData> toReturn = new LinkedList<EmployeeData>();
        while (rs.next()) {
            toReturn.add(setEntity(rs, 0));
        }
        rs.close();
        return toReturn;
    }

    public List<EmployeeData> select_Filter(int idFk, ArrayList attr, ArrayList fieldsFilter) throws SQLException {

        String query = " Select EFN_ID, EFN_NUMERO, EFN_TIPO, EFN_OPERADORA From tb_employers_phone WHERE EFN_EMP_ID  = ? ";

        for (int i = 0; i < fieldsFilter.size(); i++) {
            query = query + " and " + attr.get(i) + " like " + fieldsFilter.get(i);
        }

        ResultSet rs = executeQuery(query, idFk);

        List<EmployeeData> toReturn = new LinkedList<EmployeeData>();
        while (rs.next()) {
            toReturn.add(setEntity(rs, 0));
        }
        rs.close();
        return toReturn;

    }

    public List<EmployeeData> select_Inner() throws SQLException {

        //ResultSet rss = executeQuery(" select CID_ID, EST_NOME, CID_NOME from tb_cidades inner join tb_estados on tb_cidades.CID_EST_ID = tb_estados.EST_ID ");
        ResultSet rs = executeQuery(" select " + attrb[0] + "," + attrb[5] + "," + attrb[2] + "," + attrb[3] + "," + attrb[4] + " from " + tableName + " inner join tb_employers on tb_employers_phone.EFN_EMP_ID = tb_employers.EMP_ID ");
        List<EmployeeData> toReturn = new LinkedList<EmployeeData>();

        while (rs.next()) {

            toReturn.add(setEntity(rs, 1));

        }

        rs.close();

        return toReturn;
    }

    public List<EmployeeData> select_Inner_Filter(boolean status, ArrayList attr, ArrayList fieldsFilter) throws SQLException {

        String query = " select EFN_ID, EMP_IDENTIFICACAO, EFN_NUMERO, EFN_TIPO, EFN_OPERADORA from tb_employers_phone inner join tb_employers on tb_employers_phone.EFN_EMP_ID = tb_employers.EMP_ID ";

        for (int i = 0; i < fieldsFilter.size(); i++) {
            query = query + " and " + attr.get(i) + " like " + fieldsFilter.get(i);
        }

        if (!status) {

            query = query + " and tb_employers.EMP_STATUS = 1";
        }

        ResultSet rs = executeQuery(query);

        List<EmployeeData> toReturn = new LinkedList<EmployeeData>();
        while (rs.next()) {
            toReturn.add(setEntity(rs, 1));
        }
        rs.close();
        return toReturn;

    }

    // esse só deve ter uma tabela. a de todos
    public static Object[][] populateTable_1(List<EmployeeData> lista) {

        int columns = 17;

        Object[][] resposta = new Object[lista.size()][columns];

        for (int i = 0; i < resposta.length; i++) {
//            EmployerData entity = lista.get(i);
//            resposta[i][0] = entity.getIdPk();
//            resposta[i][1] = entity.getNome();
//            resposta[i][2] = entity.getNome();
//            resposta[i][0] = entity.getIdPk();
//            resposta[i][1] = entity.getNome();
//            resposta[i][2] = entity.getNascimento();
//            resposta[i][0] = entity.getIdPk();
//            resposta[i][1] = entity.getNome();
//            resposta[i][2] = entity.getNascimento();
//            resposta[i][0] = entity.getIdPk();
//            resposta[i][1] = entity.getNome();
//            resposta[i][2] = entity.getNascimento();
//            resposta[i][0] = entity.getIdPk();
//            resposta[i][1] = entity.getNome();
//            resposta[i][2] = entity.getNascimento();

        }

        return resposta;
    }

    public static Object[][] populateTable_2(List<EmployeeData> lista) {

        int columns = 16;

        Object[][] resposta = new Object[lista.size()][columns];

        for (int i = 0; i < resposta.length; i++) {
//            EmployerData entity = lista.get(i);
//            resposta[i][0] = entity.getIdPk();
//            resposta[i][1] = entity.getNome();
//            resposta[i][2] = entity.getNascimento();
//            resposta[i][0] = entity.getIdPk();
//            resposta[i][1] = entity.getNome();
//            resposta[i][2] = entity.getNascimento();
//            resposta[i][0] = entity.getIdPk();
//            resposta[i][1] = entity.getNome();
//            resposta[i][2] = entity.getNascimento();
//            resposta[i][0] = entity.getIdPk();
//            resposta[i][1] = entity.getNome();
//            resposta[i][2] = entity.getNascimento();
//            resposta[i][0] = entity.getIdPk();
//            resposta[i][1] = entity.getNome();
//            resposta[i][2] = entity.getNascimento();

        }

        return resposta;
    }

    public EmployeeData setEntity(ResultSet rs, int loadGetType) throws SQLException {

        EmployeeData toReturn = new EmployeeData();

        if (loadGetType == 1) {
            toReturn.setIdPk(rs.getInt(attrb[0]));

            return toReturn;

        } else {
            toReturn.setIdPk(rs.getInt(attrb[0]));
            toReturn.setIdFK_Employer(rs.getInt(attrb[1]));
            toReturn.setNome(rs.getString(attrb[2]));
            toReturn.setNascimento(rs.getDate(attrb[3]));
            toReturn.setIdade(rs.getInt(attrb[4]));
            toReturn.setSexo(rs.getString(attrb[5]));
            toReturn.setEstadoCivil(rs.getString(attrb[6]));
            toReturn.setIdentidade(rs.getString(attrb[7]));
            toReturn.setCpf(rs.getString(attrb[8]));
            toReturn.setPis(rs.getString(attrb[9]));
            toReturn.setFilhos(rs.getInt(attrb[10]));
            toReturn.setEmail(rs.getString(attrb[11]));
            toReturn.setLogradouro(rs.getString(attrb[12]));
            toReturn.setNumero(rs.getString(attrb[13]));
            toReturn.setComplemento(rs.getString(attrb[14]));
            toReturn.setBairro(rs.getString(attrb[15]));
            toReturn.setIdFK_Cidade(rs.getInt(attrb[16]));
            toReturn.setIdFK_Estado(rs.getInt(attrb[17]));

            return toReturn;
        }
    }

}
