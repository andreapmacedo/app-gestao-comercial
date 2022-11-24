package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import entities.City;

public class CityDAO extends GenericDAO {

    private String tableName = "tb_cidades";
    private String PK = "CID_ID";
    private String FK = "CID_EST_ID";
    private String mainEntity = "CID_NOME";
    private String foreignEntity = "EST_NOME";

    public CityDAO() {

    }

    public int get_Id_Entity(String itemCmb, int idFk) {

        int idFound = 0;

        try {

            Vector<City> list = new Vector(this.get_JustFk_Entity_OrderByItemName(idFk));

            for (City iten : list) {

                if (iten.getNomeCidade().equals(itemCmb)) {

                    idFound = iten.getIdCidade();

                }
            }
        } catch (SQLException ex) {

        }

        return idFound;

    }

    public String get_AutoIncremente() throws SQLException {

        String query = "select auto_increment from information_schema.TABLES where TABLE_NAME = '" + tableName + "' and TABLE_SCHEMA = \"" + banco + "\"";

        return super.getNextAI(query);
    }

    public void add_Entity(City entity) throws SQLException {

        String query = "INSERT INTO " + tableName + "(" + mainEntity + "," + FK + ") values (?,?)";
        executeCommand(query, entity.getNomeCidade(), entity.getIdEstado());

    }

    public void remove_Itentity(int id) throws SQLException {

        executeCommand("DELETE FROM " + tableName + " WHERE " + PK + " = ?", id);
    }

    public void update_Entity(City entity) throws SQLException {

        String query = "UPDATE " + tableName + " SET " + mainEntity + " = ?" + " , " + FK + " = ? WHERE " + PK + " = ?";
        executeCommand(query, entity.getNomeCidade(), entity.getIdEstado(), entity.getIdCidade());
    }

    public City get_Just_Entity(int idPk) throws SQLException {

        ResultSet rs = executeQuery("SELECT CID_NOME FROM " + tableName + " WHERE " + PK + " = ?", idPk);

        City entity = null;
        if (rs.next()) {
            entity = populate_EntityInfo(rs, 1);
        }
        rs.close();
        return entity;
    }

    public List<City> get_All_Entity_SQLdefault() throws SQLException {
        ResultSet rs = executeQuery(" Select * From " + tableName);
        List<City> toReturn = new LinkedList<City>();
        while (rs.next()) {
            toReturn.add(populate_EntityInfo(rs,0));
        }
        rs.close();
        return toReturn;
    }

    public List<City> get_JustFk_Entity_OrderByItemName(int idFK) throws SQLException {

        ResultSet rs = executeQuery(" Select * From " + tableName + " WHERE " + FK + " = ? Order By " + mainEntity, idFK);

        List<City> toReturn = new LinkedList<City>();

        while (rs.next()) {

            toReturn.add(populate_EntityInfo(rs,0));
        }

        rs.close();

        return toReturn;
    }

    public List<City> select_All_Entity_Inner_BondItemName() throws SQLException {

        ResultSet rs = executeQuery(" select CID_ID, EST_NOME, CID_NOME from tb_cidades inner join tb_estados on tb_cidades.CID_EST_ID = tb_estados.EST_ID ");

        List<City> toReturn = new LinkedList<City>();

        while (rs.next()) {

            toReturn.add(populate_EntityInfo_2(rs));

        }

        rs.close();

        return toReturn;
    }

    public List<City> select_JustFk_Entity_Inner_BondItemName(int idFK) throws SQLException {

        ResultSet rs = executeQuery(" select CID_ID, EST_NOME, CID_NOME from tb_cidades inner join tb_estados on tb_cidades.CID_EST_ID = tb_estados.EST_ID where EST_ID = ?", idFK);

        List<City> toReturn = new LinkedList<City>();

        while (rs.next()) {

            toReturn.add(populate_EntityInfo_2(rs));

        }

        rs.close();

        return toReturn;
    }

    public City populate_EntityInfo(ResultSet rs, int type) throws SQLException {

        City toReturn = new City();
        if (type == 1) {
            toReturn.setNomeCidade(rs.getString(mainEntity));

            return toReturn;

        } else {

            toReturn.setIdCidade(rs.getInt(PK));
            toReturn.setNomeCidade(rs.getString(mainEntity));
            toReturn.setIdEstado(rs.getInt(FK));

            return toReturn;
        }
    }

    public City populate_EntityInfo_2(ResultSet rs) throws SQLException {

        City toReturn = new City();
        toReturn.setIdCidade(rs.getInt(PK));
        toReturn.setNomeCidade(rs.getString(mainEntity));
        toReturn.setNomeEstado(rs.getString(foreignEntity));

        return toReturn;
    }

}
