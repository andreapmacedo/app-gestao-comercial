package DAO;

import Entidades.HoleriteDescription;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class HoleriteDescriptionDAO extends GenericDAO {

    private final String tableName = "tb_holerite_description";
    private final String PK = "HLD_COD";
    private final String FK = null;
    private final String mainName = "HLD_DESCRIPTION";

    private final String[] attrb = new String[]{"HLD_ID", "HLD_DESCRIPTION", "HLD_TYPE", "HLD_REFERENCE_TYPE", "HLD_REFERENCE_VALUE", "HLD_INCIDENCE", "HLD_INSS_FOCUS", "HLD_FGTS_FOCUS", "HLD_IR_FOCUS"};

    public HoleriteDescriptionDAO() {
    }

    public String get_AutoIncremente() throws SQLException {

        String query = "select auto_increment from information_schema.TABLES where TABLE_NAME = '" + tableName + "' and TABLE_SCHEMA = \"" + banco + "\""; //"UPDATE " + tableName + " SET  " + mainName + "= ? WHERE " + PK + " = ?";

        return super.getNextAI(query);
    }

    public void add_Entity(HoleriteDescription entity) throws SQLException {

        String query = "INSERT INTO " + tableName + " ( " + attrb[1] + "," + attrb[2] + "," + attrb[3] + "," + attrb[4]+ "," + attrb[5] + "," + attrb[6] + "," + attrb[7] + "," + attrb[8] + ") values (?,?,?,?,?,?,?,?)";
        executeCommand(query, entity.getDescription(), entity.getType(), entity.getReferenceType(), entity.getReferenceValue(), entity.getIncidence(), entity.getInssFocus(), entity.getFgtsFocus(), entity.getIrFocus());

    }

    public void remove_Entity(int idPk) throws SQLException {

        executeCommand("DELETE FROM " + tableName + " WHERE " + PK + " = ?", idPk);
    }

    public void update_Entity(HoleriteDescription entity) throws SQLException {

        String query = "UPDATE " + tableName + " SET  " + attrb[1] + "= ?, " + attrb[2] + "= ?, " + attrb[3] + "= ?, " + attrb[4] + " = ?" + attrb[5] + "= ?, " + attrb[6] + "= ?, " + attrb[7] + "= ?, " + attrb[8] + "= ? WHERE " + attrb[0] + " = ?";
        executeCommand(query, entity.getDescription(), entity.getType(), entity.getReferenceType(), entity.getReferenceValue(), entity.getIncidence(), entity.getInssFocus(), entity.getFgtsFocus(), entity.getIrFocus(), entity.getIdPk());
    }

    public HoleriteDescription Select_Iten_By_idFK(int idPk) throws SQLException {

        ResultSet rs = executeQuery("SELECT * FROM " + tableName + " WHERE " + attrb[0] + " = ?", idPk);

        HoleriteDescription iten = null;
        if (rs.next()) {
            iten = getFromSQL(rs,0);
        }
        rs.close();
        return iten;
    }

    public HoleriteDescription get_Iten_Entity_1(int idPk) throws SQLException {

        ResultSet rs = executeQuery("SELECT HLD_TYPE, HLD_REFERENCE_TYPE, HLD_REFERENCE_VALUE FROM " + tableName + " WHERE " + attrb[0] + " = ?", idPk);

        HoleriteDescription iten = null;
        if (rs.next()) {
            iten = getFromSQL(rs, 1);
        }
        rs.close();
        return iten;
    }

//    public List<HoleriteDescription> get_Just_Entity(int idPk) throws SQLException {
//
//        ResultSet rs = executeQuery("SELECT * FROM " + tableName + " WHERE " + PK + " = ?", idPk);
//
//        List<Estados> entity = new LinkedList<Estados>();
//        while (rs.next()) {
//            entity.add(getFromSQL(rs));
//        }
//        rs.close();
//        return entity;
//    }
    public List<HoleriteDescription> get_All_Entity_OrderByItemName() throws SQLException {

        ResultSet rs = executeQuery("Select * From " + tableName + " Order By " + mainName + ";");
        List<HoleriteDescription> toReturn = new LinkedList<HoleriteDescription>();
        while (rs.next()) {
            toReturn.add(getFromSQL(rs,0));
        }
        rs.close();
        return toReturn;
    }

    public List<HoleriteDescription> get_All_Entity_SQLdefault() throws SQLException {

        ResultSet rs = executeQuery("Select * From " + tableName);
        List<HoleriteDescription> toReturn = new LinkedList<HoleriteDescription>();
        while (rs.next()) {
            toReturn.add(getFromSQL(rs,0));
        }
        rs.close();
        return toReturn;
    }

    public int get_Id_Entity(String itemCmb) {

        int idFound = 0;

        try {

            Vector<HoleriteDescription> list = new Vector(this.get_All_Entity_OrderByItemName());

            for (HoleriteDescription iten : list) {

                if (iten.getDescription().equals(itemCmb)) {

                    idFound = iten.getIdPk();

                }
            }
        } catch (SQLException ex) {

        }

        return idFound;

    }

    public static Object[][] getFromRAM(List<HoleriteDescription> lista) {

        int columns = 9;

        Object[][] resposta = new Object[lista.size()][columns];

        for (int i = 0; i < resposta.length; i++) {
            HoleriteDescription entity = lista.get(i);
            resposta[i][0] = entity.getIdPk();
            resposta[i][1] = entity.getDescription();
            resposta[i][2] = entity.getType();
            resposta[i][3] = entity.getReferenceType();
            resposta[i][4] = entity.getReferenceValue();
            resposta[i][5] = entity.getIncidence();
            resposta[i][6] = entity.getInssFocus();
            resposta[i][7] = entity.getFgtsFocus();
            resposta[i][8] = entity.getIrFocus();

        }
        return resposta;
    }

    public HoleriteDescription getFromSQL(ResultSet rs, int loadGetType) throws SQLException {

        HoleriteDescription entity = new HoleriteDescription();

        if (loadGetType == 1) {
            entity.setType(rs.getInt(attrb[2]));
            entity.setReferenceType(rs.getString(attrb[3]));
            entity.setReferenceValue(rs.getBigDecimal(attrb[4]));
            return entity;

        } else {
            entity.setIdPk(rs.getInt(attrb[0]));
            entity.setDescription(rs.getString(attrb[1]));
            entity.setType(rs.getInt(attrb[2]));
            entity.setReferenceType(rs.getString(attrb[3]));
            entity.setReferenceValue(rs.getBigDecimal(attrb[4]));
            entity.setIncidence(rs.getString(attrb[5]));
            entity.setInssFocus(rs.getInt(attrb[6]));
            entity.setFgtsFocus(rs.getInt(attrb[7]));
            entity.setIrFocus(rs.getInt(attrb[8]));
            return entity;
        }

    }
}
