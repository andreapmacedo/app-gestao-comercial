
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;



public abstract class GenericDAO{

    String driver = "com.mysql.jdbc.Driver"; //Classe do driver JDBC
    public final String banco = "sisci"; //Nome do banco de dados
    String host = "localhost"; //servidor do banco de dados
    String str_conn = "jdbc:mysql://" + host + ":3306/" + banco; //URL de conexão
    String usuario = "root"; //usuário do banco de dados
    String senha = "1234"; //senha do banco de dados
    
    
    public static DateFormat defaultDateFormat = new SimpleDateFormat("dd-MM-yyyy");

       
    public GenericDAO() {
        


    }
    

    public Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver"); //Class.forName(DRIVER);//jdbc:mysql://localhost:3306/sisci?zeroDateTimeBehavior=convertToNull
            Connection cx = DriverManager.getConnection("jdbc:mysql://:3306/sisci", "root", "1234");//Connection cx = DriverManager.getConnection(str_conn, usuario, senha);//Connection cx = DriverManager.getConnection(URL, LOGIN, SENHA);
            return cx;
        } catch (Exception ex) {
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public Statement getStatement() throws SQLException {

        return getConnection().createStatement();
    }

    public PreparedStatement getStatement(String st) throws SQLException {

        return getConnection().prepareStatement(st);
    }

    public ResultSet executeQuery(String query, Object... params) throws SQLException {

        PreparedStatement ps = getStatement(query);
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
        return ps.executeQuery();
    }

    public int executeCommand(String query, Object... params) throws SQLException {

        PreparedStatement ps = getStatement(query);
        for (int i = 0; i < params.length; i++) {
            try {
                ps.setObject(i + 1, params[i]);
            } catch (Exception e) {
                System.out.println("Error to try " + i + " with value " + params[i]);
            }
        }
        int result = ps.executeUpdate();
        ps.close();
        return result;
    }

    public Integer getNextId(String tableName) throws SQLException {

        ResultSet rs = executeQuery("select MAX(ID) from " + tableName);
        rs.next();
        Object result = rs.getObject(1);
        if (result == null) {
            rs.close();
            return 1;
        } else {
            return ((Integer) result) + 1;
        }
    }

    public String getNextAI(String query) throws SQLException {

        ResultSet rs = executeQuery(query);
        rs.next();
        Object result = rs.getObject(1);
        return (result).toString();

    }

}


            //formato moeda 
           // resposta[i][4] = NumberFormat.getCurrencyInstance().format(entity.getSalary()); //deixei os dois exemplos
         //   resposta[i][5] = formatoDois.format(entity.getDeduction());

//outro exemplo:
//    DecimalFormat formatoDois = new DecimalFormat("R$ ##,###,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
                   // formatoDois.setMinimumFractionDigits(2);
       // formatoDois.setParseBigDecimal(true);