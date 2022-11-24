package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import entities.PayStub;

public class PayStubDAO extends GenericDAO {

    private final String tableName = "tb_holerite";
    private final String[] attrb = new String[]{"HOL_ID", "HOL_EMP_ID", "HOL_HLD_COD", "HOL_QTD", "HOL_VENCIMENTO", "HOL_DESCONTO", "HLD_DESCRIPTION", "HLD_REFERENCE_TYPE", "HLD_INCIDENCE"};

    public PayStubDAO() {

    }

    public String get_AutoIncremente() throws SQLException {

        String query = "select auto_increment from information_schema.TABLES where TABLE_NAME = '" + tableName + "' and TABLE_SCHEMA = \"" + banco + "\"";

        return super.getNextAI(query);
    }
    
    public boolean istanceExist(String text){
        
        boolean status = false;
        
        
        
        
        return status;
    }
    

    public void add_Entity(PayStub entity) throws SQLException {

        String query = "INSERT INTO " + tableName + " ( " + attrb[1] + " , " + attrb[2] + "," + attrb[3] + "," + attrb[4] + "," + attrb[5] + ") values (?,?,?,?,?)";

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
        System.out.println("idfk" + entity.getIdFk_Employer());
        executeCommand(query, entity.getIdFk_Employer(), entity.getIdFk_Description(), entity.getQuantity(), entity.getSalary(), entity.getDeduction());

    }

    public void update_Entity(PayStub entity) throws SQLException {

        String query = "UPDATE " + tableName + " SET " + attrb[1] + " = ?, " + attrb[2] + " = ?," + attrb[3] + " = ?, " + attrb[4] + " = ?," + attrb[5] + " = ? WHERE " + attrb[0] + " = ?";
        // String query = "UPDATE " + tableName + " SET " + " EMD_NOME = ?, EMD_NASCIMENTO = ?
        //, EMD_SEXO = ?, EMD_EST_CIVIL = ?, EMD_IDENTIDADE = ?, EMD_CPF = ?,
        //EMD_PIS = ?, EMD_FILHOS = ?, EMD_EMAIL = ?, EMD_LOGRADOURO = ?, EMD_NUMERO = ?, EMD_COMPLEMENTO = ?, EMD_BAIRRO = ?, EMD_CID_ID = ?, EMD_EST_ID = ? WHERE EMD_ID = ? ";

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
        executeCommand(query, entity.getIdFk_Employer(), entity.getIdFk_Description(), entity.getQuantity(), entity.getSalary(), entity.getDeduction(), entity.getIdPk());

        // String query2 = "call upAgeEmployer(?)";
        // executeCommand(query2, entity.getIdPk());
    }

    public void remove_Entity(int idPk) throws SQLException {

        executeCommand("DELETE FROM " + tableName + " WHERE " + attrb[0] + " = ?", idPk);
    }

    public PayStub select_By_idPk(int idPk) throws SQLException {

        ResultSet rs = executeQuery("SELECT * FROM " + tableName + " WHERE " + attrb[0] + " = ?", idPk);

        PayStub entity = null;
        if (rs.next()) {
            entity = setAtributes(rs, 0);
        }
        rs.close();
        return entity;
    }

    public PayStub select_ID(int idFk) throws SQLException {

        ResultSet rs = executeQuery("SELECT" + attrb[0] + " FROM " + tableName + " WHERE " + attrb[1] + " = ?", idFk);

        PayStub entity = null;
        if (rs.next()) {
            entity = setAtributes(rs, 1);
        }
        rs.close();
        return entity;
    }

    public List<PayStub> Select_By_idFK(int idFK) throws SQLException {

        String query = (" select HOL_ID, HLD_DESCRIPTION, HLD_REFERENCE_TYPE, HOL_QTD, HOL_VENCIMENTO, HOL_DESCONTO, HLD_INCIDENCE FROM tb_holerite "
                + "INNER join tb_holerite_description on tb_holerite.HOL_HLD_COD = tb_holerite_description.HLD_COD "
                //                + "INNER join tb_holerite_reference on tb_holerite.HOL_HLR_ID = tb_holerite_reference.HLR_ID  WHERE HOL_EMP_ID  = ?");
                + "WHERE HOL_EMP_ID  = ?");

        ResultSet rs = executeQuery(query, idFK);

        List<PayStub> toReturn = new LinkedList<PayStub>();
        while (rs.next()) {
            toReturn.add(setAtributes(rs, 2));
        }
        rs.close();
        return toReturn;

    }

    public List<PayStub> select_All() throws SQLException {
        ResultSet rs = executeQuery(" Select * From " + tableName);
        List<PayStub> toReturn = new LinkedList<PayStub>();
        while (rs.next()) {
            toReturn.add(setAtributes(rs, 0));
        }
        rs.close();
        return toReturn;
    }

    public List<PayStub> select_Inner() throws SQLException {

//        ResultSet rs = executeQuery(" select HOL_ID, HLD_DESCRIPTION, HLR_REFERENCE, HOL_QTD, HOL,VENCIMENTO, HOL_DESCONTO FROM tb_holerite "
//                + "inner join tb_holerite_description on tb_holerite.HOL_HLD_COD = tb_holerite_description.HLD_COD INNER join tb_holerite_reference on tb_holerite.HOL_HLR_ID = tb_holerite_reference.HLR_ID");
        ResultSet rs = executeQuery(" select  HOL_ID, HLD_DESCRIPTION, HLD_REFERENCE_TYPE, HOL_QTD, HOL_VENCIMENTO, HOL_DESCONTO, HLD_INCIDENCE FROM tb_holerite "
                + "inner join tb_holerite_description on tb_holerite.HOL_HLD_COD = tb_holerite_description.HLD_ID");

        List<PayStub> toReturn = new LinkedList<PayStub>();

        while (rs.next()) {

            toReturn.add(setAtributes(rs, 2));

        }

        rs.close();

        return toReturn;
    }

//    public List<Holerite> select_Filter(int idFk, ArrayList attr, ArrayList fieldsFilter) throws SQLException {
//
//        String query = " Select EFN_ID, EFN_NUMERO, EFN_TIPO, EFN_OPERADORA From tb_employers_phone WHERE EFN_EMP_ID  = ? ";
//        // " select " + attrb[0] + "," + attrb[5] + "," + attrb[2] + "," + attrb[3] + "," + attrb[4] + " from " + tableName + "
//
//        for (int i = 0; i < fieldsFilter.size(); i++) {
//            query = query + " and " + attr.get(i) + " like " + fieldsFilter.get(i);
//        }
//
//        ResultSet rs = executeQuery(query, idFk);
//
//        List<Holerite> toReturn = new LinkedList<Holerite>();
//        while (rs.next()) {
//            toReturn.add(setAtributes(rs, 0));
//        }
//        rs.close();
//        return toReturn;
//
//    }
    public List<PayStub> select_InnerFilter(int idFk, ArrayList attr, ArrayList fieldsFilter) throws SQLException {

        String query = (" select  HOL_ID, HLD_DESCRIPTION, HLD_REFERENCE_TYPE, HOL_QTD, HOL_VENCIMENTO, HOL_DESCONTO, HLD_INCIDENCE FROM tb_holerite "
                + "INNER join tb_holerite_description on tb_holerite.HOL_HLD_COD = tb_holerite_description.HLD_ID "
                + "WHERE HOL_EMP_ID  = ?");

        for (int i = 0; i < fieldsFilter.size(); i++) {
            query = query + " and " + attr.get(i) + " like " + fieldsFilter.get(i);
        }

//        if (!status) {
//
//            query = query + " and tb_employers.EMP_STATUS = 1";
//        }
        ResultSet rs = executeQuery(query, idFk);

        List<PayStub> toReturn = new LinkedList<PayStub>();
        while (rs.next()) {
            toReturn.add(setAtributes(rs, 2));
        }
        rs.close();
        return toReturn;

    }

    public static Object[][] populateTable_1(List<PayStub> lista) {

        int columns = 6;

        Object[][] resposta = new Object[lista.size()][columns];

        for (int i = 0; i < resposta.length; i++) {
            PayStub entity = lista.get(i);

            resposta[i][0] = entity.getIdPk();
            resposta[i][1] = entity.getIdFk_Employer();
            resposta[i][2] = entity.getIdFk_Description();
            resposta[i][3] = entity.getQuantity();
            resposta[i][4] = entity.getSalary();
            resposta[i][5] = entity.getDeduction();

        }

        return resposta;
    }

    
    // aperfeiçoar para termos apenas um método que recebe pelo parametro defina qual leitura terá
    //futuramente procurar automatizar
    
    public static Object[][] populateTable_2(List<PayStub> lista) {

        int columns = 7;

        DecimalFormat formatoDois = new DecimalFormat("R$ ##,###,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
        formatoDois.setMinimumFractionDigits(2);
        formatoDois.setParseBigDecimal(true);
        //NumberFormat.getCurrencyInstance().format(2345);
        
        
        Object[][] resposta = new Object[lista.size()][columns];

        for (int i = 0; i < resposta.length; i++) {
            PayStub entity = lista.get(i);
            resposta[i][0] = entity.getIdPk();
            resposta[i][1] = entity.getHolDescription();
            resposta[i][2] = entity.getQuantity();
            resposta[i][3] = entity.getHolReference();
           // resposta[i][4] = entity.getSalary();
            //  resposta[i][5] = entity.getDeduction();
            // resposta[i][4] = formatoDois.format(entity.getSalary());
            //resposta[i][5] = formatoDois.format(entity.getDeduction());
            resposta[i][4] = NumberFormat.getCurrencyInstance().format(entity.getSalary()); //deixei os dois exemplos
            resposta[i][5] = formatoDois.format(entity.getDeduction());

            resposta[i][6] = entity.getHolIncidence();
        }

        return resposta;
    }

    public PayStub setAtributes(ResultSet rs, int loadGetType) throws SQLException {

        PayStub toReturn = new PayStub();

        if (loadGetType == 1) {
            toReturn.setIdFk_Description(rs.getInt(attrb[0]));

            return toReturn;

        } else if (loadGetType == 2) {

            toReturn.setIdPk(rs.getInt(attrb[0]));

            toReturn.setHolDescription(rs.getString(attrb[6]));
            toReturn.setHolReference(rs.getString(attrb[7]));
            toReturn.setQuantity(rs.getBigDecimal(attrb[3]));
            toReturn.setSalary(rs.getBigDecimal(attrb[4]));
            toReturn.setDeduction(rs.getBigDecimal(attrb[5]));
            toReturn.setHolIncidence(rs.getString(attrb[8]));

            return toReturn;

        } else {
            toReturn.setIdPk(rs.getInt(attrb[0]));
            toReturn.setIdFk_Employer(rs.getInt(attrb[1]));
            toReturn.setIdFk_Description(rs.getInt(attrb[2]));
            toReturn.setQuantity(rs.getBigDecimal(attrb[4]));
            toReturn.setSalary(rs.getBigDecimal(attrb[5]));
            toReturn.setDeduction(rs.getBigDecimal(attrb[6]));

            return toReturn;
        }

    }
}
