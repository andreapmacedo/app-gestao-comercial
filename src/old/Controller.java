/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

import entities.District;
import entities.Office;
import entities.City;
import entities.Estate;
import entities.Employee;
import entities.Sector;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

import dao.CityDAO;
import dao.DistrictDAO;
import dao.EmployeeDAO;
import dao.EstateDAO;
import dao.OfficeDAO;
import dao.SectorDAO;

/**
 *
 * @author Andre
 */
public class Controller {

    public final String className = "Classe ->" + this.getClass().getSimpleName();
    public static Integer idEstado = null;
    public static Integer idCidade = null;
    public static Integer idBairro = null;
    public static Integer idCargo = null;
    public static Integer idSetor = null;
    public static Integer idServidor = null;
    public static Integer indiceCmbCidade = null;
    public static Integer indiceCmbEstado = 1;
    public static Integer indiceCmbBairro = null;
    public static Integer indiceCmbCargo = null;
    public static Integer indiceCmbSetor = null;
    public static Object nomeServidorObject = null;
    public static String nomeServidorString = null;
    public static Date DataNow = new java.sql.Date(new java.util.Date().getTime());
    public static String getClass = null;

// p/ discobrir o id da cidade
    public static void setIdBairro(String item) {
        System.out.println("Controller setIdBairro");
        DistrictDAO bairrosDAO = new DistrictDAO();
        if (item != null) {
            try {
                Vector<District> bairros = new Vector(bairrosDAO.getAll_Bairros_ByIndex());
                for (District objeto : bairros) {
                    int y = objeto.getIdBairro();
                    String x = objeto.getNomeBairro();
                    if (x.equals(item)) {
                        Controller.idBairro = y;
                        System.out.println("--> Classe: Controller " + "Metodo: setIdBairro(String " + item + ") Controller.idBairro: " + y);
                    break;
                    }
                }

            } catch (SQLException ex) {

            }
        } else {
            System.out.println("combo null");
            Controller.idBairro = null;
            System.out.println("--> Classe: Controller " + "Metodo: setIdBairro(String " + item + ") Controller.idBairro: NULL" );
        }
    }

    public static void setIdCidade(String item) {
        System.out.println("Controller setIdCidade");
        CityDAO cidadesDAO = new CityDAO();
        if (item != null) {
            try {
                Vector<City> cidades = new Vector(cidadesDAO.get_JustFk_Entity_OrderByItemName(idEstado));
                for (City objetoCidade : cidades) {
                    int y = objetoCidade.getIdCidade();
                    String x = objetoCidade.getNomeCidade();
                    if (x.equals(item)) {
                        Controller.idCidade = y;
                        System.out.println("--> Classe: Controller " + "Metodo: setIdCidade(String " + item + ") Controller.idCidade: " + y);
                    break;
                    }
                }

            } catch (SQLException ex) {

            }
        } else {
            System.out.println("combo null");
            Controller.idCidade = null;
            System.out.println("--> Classe: Controller " + "Metodo: setIdCidade(String " + item + ") Controller.idCidade: NULL" );
        }
    }


    
    public static void setIdCargo(String item) {
        System.out.println("Controller setIdCargo");
        OfficeDAO cargosDAO = new OfficeDAO();
         if (item != null) {
        try {
            Vector<Office> objeto = new Vector(cargosDAO.getForSetor_Cargos_ByName(idSetor));
            for (Office i : objeto) {
                int y = i.getIdFuncao();
                String x = i.getNomeFuncao();
                if (x.equals(item)) {
                    Controller.idCargo = y;
                    System.out.println("--> Classe: Controller " + "Metodo: setIdCargo(String " + item + ") Controller.idCargo: " + y);
                break;
                }
            }
        } catch (SQLException ex) {

        }
        } else {
             System.out.println("combo null");
            Controller.idCargo = null;
            System.out.println("--> Classe: Controller " + "Metodo: setIdCargo(String " + item + ") Controller.idCargo: null " );
        }
    }

    public static void setIdSetor(String item) {
        System.out.println("Controller setIdSetor");
        SectorDAO setoresDAO = new SectorDAO();
        if (item != null) {
        try {
            Vector<Sector> objeto = new Vector(setoresDAO.getAll_Setores_ByName());
            for (Sector i : objeto) {
                int y = i.getIdSetor();
                String x = i.getNomeSetor();
                if (x.equals(item)) {
                    Controller.idSetor = y;
                    System.out.println("--> Classe: Controller " + "Metodo: setIdSetor(String " + item + ") Controller.idSetor: " + y);
                break;
                }
            }
        } catch (SQLException ex) {

        }
         } else {
            System.out.println("combo null");
            Controller.idSetor = null;
            System.out.println("--> Classe: Controller " + "Metodo: setIdSetor(String " + item + ") Controller.idSetor: null" );
        }
    }

    public static void setIdServidor(String item) {
        System.out.println("Controller setIdServidor");
        EmployeeDAO servidoresDAO = new EmployeeDAO();
         if (item != null) {
        try {
            Vector<Employee> objeto = new Vector(servidoresDAO.getListServidores());
            for (Employee i : objeto) {
                int y = i.getIdServidor();
                String x = i.getNomeServidor();
                if (x.equals(item)) {
                    Controller.idServidor = y;
                    System.out.println("--> Classe: Controller " + " Metodo: setIdServidor(String " + item + ") Controller.idServidor: " + y);
                break;
                }

            }
        } catch (SQLException ex) {

        }
        } else {
            System.out.println("combo null");
            Controller.idServidor = null;
        }
    }
    

    
    public void setIndiceCidade(String item) {
        CityDAO cidadesDAO = new CityDAO();
        int cont = 0;
        
        try {
            Vector<City> objeto = new Vector(cidadesDAO.get_JustFk_Entity_OrderByItemName(idEstado));
            for (City i : objeto) {
                int y = cont++;
                String x = i.getNomeCidade();
                if (x.equals(item)) {
                    Controller.indiceCmbCidade = y;
                    
                    System.out.println("--> Classe: Controller " + "Metodo: setIndiceCidade(String " + item + ") Controller.indiceCmbCidade: " + y);
                break;
                }
                
            }
        } catch (SQLException ex) {
            
        }
       
    }
    
    public void setIndiceBairro(String item) {
        DistrictDAO bairrosDAO = new DistrictDAO();
        int cont = 0;
        
        try {
            Vector<District> objeto = new Vector(bairrosDAO.getForLocale_Bairros_ByName(idCidade, idEstado));
            for (District i : objeto) {
                int y = cont++;
                String x = i.getNomeBairro();
                if (x.equals(item)) {
                    Controller.indiceCmbBairro = y;
                    
                    System.out.println("--> Classe: Controller " + "Metodo: setIndiceBairro(String " + item + ") Controller.indiceCmbBairro: " + y);
                break;
                }
                
            }
        } catch (SQLException ex) {
            
        }
       
    }
    
    public void setIndiceSetor(String item) {
        SectorDAO setoresDAO = new SectorDAO();
        int cont = 0;
        
        try {
            Vector<Sector> objeto = new Vector(setoresDAO.getAll_Setores_ByName());
            for (Sector i : objeto) {
                int y = cont++;
                String x = i.getNomeSetor();
                if (x.equals(item)) {
                    Controller.indiceCmbSetor = y;
                    
                    System.out.println("--> Classe: Controller " + "Metodo: setIndiceSetor(String " + item + ") Controller.indiceCmbSetor: " + y);
                break;
                }
                
            }
        } catch (SQLException ex) {
            
        }
       
    }
    
    public void setIndiceCargo(String item) {
        OfficeDAO cargosDAO = new OfficeDAO();
        int cont = 0;
        
        try {
            Vector<Office> objeto = new Vector(cargosDAO.getForSetor_Cargos_ByName(idSetor));
            for (Office i : objeto) {
                int y = cont++;
                String x = i.getNomeFuncao();
                if (x.equals(item)) {
                    Controller.indiceCmbCargo = y;
                    
                    System.out.println("--> Classe: Controller " + "Metodo: setIndiceCargo(String " + item + ") Controller.indiceCmbCargo: " + y);
                break;
                }
                
            }
        } catch (SQLException ex) {
            
        }
       
    }

    public int getIdCidade(String v) throws SQLException {

        int id = 0;
        CityDAO cidadesDAO = new CityDAO();
        Vector<City> objeto = new Vector(cidadesDAO.get_JustFk_Entity_OrderByItemName(idEstado));
        for (City i : objeto) {
            int y = i.getIdCidade();
            String x = i.getNomeCidade();
            if (x.equals(v)) {
                id = y;
            break;
            }

        }
        System.out.println(className + " Metodo: getIdCidade(String " + v + ") return: " + id);
        return id;

    }



    public int getIdBairro(String v) throws SQLException {
        int id = 0;
        DistrictDAO bairrosDAO = new DistrictDAO();
        Vector<District> objeto = new Vector(bairrosDAO.getForLocale_Bairros_ByName(idCidade, idEstado));
        for (District i : objeto) {
            int y = i.getIdBairro();
            String x = i.getNomeBairro();
            if (x.equals(v)) {
                id = y;
            break;
            }
        }
        System.out.println(className + " Metodo: getIdBairro(String " + v + ") return: " + id);
        return id;
    }

    public int getIdSetor(String v) throws SQLException {
        int id = 0;
        SectorDAO setoresDAO = new SectorDAO();
        Vector<Sector> objeto = new Vector(setoresDAO.getAll_Setores_ByName());
        for (Sector i : objeto) {
            int y = i.getIdSetor();
            String x = i.getNomeSetor();
            if (x.equals(v)) {
                id = y;
            break;
            }
        }
        System.out.println(className + " Metodo: getIdSetor(String " + v + ") return: " + id);
        return id;
    }

    public int getIdCargo(String v) throws SQLException {
        int id = 0;
        OfficeDAO cargosDAO = new OfficeDAO();
        Vector<Office> objeto = new Vector(cargosDAO.getForSetor_Cargos_ByName(idSetor));
        for (Office i : objeto) {
            int y = i.getIdFuncao();
            String x = i.getNomeFuncao();
            if (x.equals(v)) {
                id = y;
            break;
            }
        }
        System.out.println(className + " Metodo: getIdCargo(String " + v + ") return: " + id);
        return id;
    }

    public String getCargo(int v) throws SQLException {
        OfficeDAO cargosDAO = new OfficeDAO();
        Office x = cargosDAO.getCargo(v);
        String cargo = x.toString();
        System.out.println("--> Classe: " + className + " Metodo: getCargo(int " + v + ") return: " + cargo);
        return cargo;
    }

    public int getIndiceSexo(String v) {
        int indice = -1;
        if (v.equals("M")) {
            indice = 0;
        } else if(v.equals("F")){
            indice = 1;
        }

        System.out.println("--> Classe: " + className + " Metodo: getIndiceSexo(String " + v + ") return: " + indice);
        return indice;
    }

    public int getIndiceEstadoCivil(String v) {
        int indice = -1;
        if (v.equals("SOLTEIRO(A)")) {
            indice = 0;
        } else if(v.equals("CASADO(A)")){
            indice = 1;
        }

        System.out.println("--> Classe: " + className + " Metodo: getIndiceEstadoCivil(String " + v + ") return: " + indice);
        return indice;
    }

    public String SomenteNumeros(String v) {
        String result = null;
        result = v.replaceAll("[^0-9]", "");
        return result;
    }

    public String FormatarCPF(String v) {
        final String result = null;
        DecimalFormat dec = new DecimalFormat("###.###.###-##");
        return result;
    }

    public static Date inFormatData(String data) throws ParseException {
        String s = data;

        //converter para data USA
        SimpleDateFormat in = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");
        String result = out.format(in.parse(s.toString()));



        //transforma java date em sql date!
        SimpleDateFormat formatJava;
        formatJava = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date newData = formatJava.parse(result.toString());
        java.sql.Date dataSql = new java.sql.Date(newData.getTime());


        //System.out.println("data = " + dataSql);

        return dataSql;
    }

    public static String outFormatData(Date data) throws ParseException {

        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        String result = out.format(in.parse(data.toString()));

        //System.out.println("result = "+result);
        return result;
    }
    
    
}
