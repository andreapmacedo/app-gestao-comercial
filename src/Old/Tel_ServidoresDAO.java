/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Old;

import DAO.GenericDAO;
import Old.Tel_ServidoresDAO;
import java.lang.reflect.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Andre
 */
public class Tel_ServidoresDAO extends GenericDAO {
 public final String className = "Classe ->"+this.getClass().getSimpleName();
   

               
  
    public Tel_ServidoresDAO() {
         
    }

//
// 
//     public void addTel_Servidores(Employers_Contacts entidade) throws SQLException {
//        
//        String query = "INSERT INTO TB_FONE_SERVIDORES (FSE_FONE,FSE_SER_CODIGO) values (?,?)";
//      //  executeCommand(query, entidade.getFone(),entidade.getIdServidor());
//        
//    }
//    
//
//    public void removeTel_Servidores(String fone) throws SQLException {
//        
//        executeCommand("DELETE FROM TB_FONE_SERVIDORES WHERE FSE_FONE = ?", fone);
//    }
//
//    public void updateTel_Servidores(Employers_Contacts entidade, String oldFone) throws SQLException {
//      
//        String query = "UPDATE TB_FONE_SERVIDORES SET FSE_FONE = ? WHERE FSE_FONE = ?";
//      //  executeCommand(query, entidade.getFone(),oldFone);
//    }
//
//    public Employers_Contacts getTel_Servidores(int idServidor) throws SQLException {
//       
//        ResultSet rs = executeQuery("SELECT * FROM TB_FONE_SERVIDORES WHERE FSE_SER_CODIGO = ?", idServidor);
//        
//        
//        Employers_Contacts entidade = null;
//        if (rs.next()) {
//            entidade = populateTel_ServidoresInfo(rs);
//        }
//        rs.close();
//        return entidade;
//    }
//    
//        public List<Employers_Contacts> getForServidor_TelServidor_ByFone(int idServidor) throws SQLException {
//        ResultSet rs = executeQuery(" Select * From TB_FONE_SERVIDORES WHERE FSE_SER_CODIGO = ?", idServidor);
//        List<Employers_Contacts> toReturn = new LinkedList<Employers_Contacts>();
//        while (rs.next()) {
//            toReturn.add(populateTel_ServidoresInfo(rs));
//        }
//        rs.close();
//        return toReturn;
//    }
//        
//        
//    public List<Employers_Contacts> geAllTel_Servidores() throws SQLException {
//        ResultSet rs = executeQuery(" Select * From TB_FONE_SERVIDORES ");
//        List<Employers_Contacts> toReturn = new LinkedList<Employers_Contacts>();
//        while (rs.next()) {
//            toReturn.add(populateTel_ServidoresInfo(rs));
//        }
//        rs.close();
//        return toReturn;
//    }
//    
//    
//    
//
//    //Esse método retorna os dados da tabela cidade 
//    public List<Employers_Contacts> getAll_Tel_Servidores_ByFone() throws SQLException {
//       //o rs vai recuperar e guardar de uma so vez os dados de retorno do select
//        ResultSet rs = executeQuery(" Select * From TB_FONE_SERVIDORES Order By FSE_FONE");
//       
//        List<Employers_Contacts> toReturn = new LinkedList<Employers_Contacts>();
//        //enquanto tiver registro no rs o laço while é preenchido
//        while (rs.next()) {
//            
//            //Enquanto rs tiver dados toReturn recebe-os
//            toReturn.add(populateTel_ServidoresInfo(rs));
//        }
//        //rs é desalocado
//        rs.close();
//        //o metodo que é do tipo List agora é uma lista de dados de retorno do select
//        return toReturn;
//    }
//
//    //Esse Método é usado para recuperar os dados 
//    public Employers_Contacts populateTel_ServidoresInfo(ResultSet rs) throws SQLException { 
//        
//        Employers_Contacts toReturn = new Employers_Contacts();
//       // toReturn.setIdServidor(rs.getInt("FSE_SER_CODIGO"));
//       // toReturn.setFone(rs.getString("FSE_FONE"));
//        return toReturn;
//    }  

}
