/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Old;

import DAO.BairrosDAO;
import DAO.CargosDAO;
import DAO.CidadesDAO;
import DAO.EstadosDAO;
import DAO.ServidoresDAO;
import DAO.SetoresDAO;
import Entidades.Bairros;
import Entidades.Cargos;
import Entidades.Cidades;
import Entidades.Estados;
import Entidades.Servidores;
import Entidades.Setores;
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
        BairrosDAO bairrosDAO = new BairrosDAO();
        if (item != null) {
            try {
                Vector<Bairros> bairros = new Vector(bairrosDAO.getAll_Bairros_ByIndex());
                for (Bairros objeto : bairros) {
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
        CidadesDAO cidadesDAO = new CidadesDAO();
        if (item != null) {
            try {
                Vector<Cidades> cidades = new Vector(cidadesDAO.get_JustFk_Entity_OrderByItemName(idEstado));
                for (Cidades objetoCidade : cidades) {
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
        CargosDAO cargosDAO = new CargosDAO();
         if (item != null) {
        try {
            Vector<Cargos> objeto = new Vector(cargosDAO.getForSetor_Cargos_ByName(idSetor));
            for (Cargos i : objeto) {
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
        SetoresDAO setoresDAO = new SetoresDAO();
        if (item != null) {
        try {
            Vector<Setores> objeto = new Vector(setoresDAO.getAll_Setores_ByName());
            for (Setores i : objeto) {
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
        ServidoresDAO servidoresDAO = new ServidoresDAO();
         if (item != null) {
        try {
            Vector<Servidores> objeto = new Vector(servidoresDAO.getListServidores());
            for (Servidores i : objeto) {
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
        CidadesDAO cidadesDAO = new CidadesDAO();
        int cont = 0;
        
        try {
            Vector<Cidades> objeto = new Vector(cidadesDAO.get_JustFk_Entity_OrderByItemName(idEstado));
            for (Cidades i : objeto) {
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
        BairrosDAO bairrosDAO = new BairrosDAO();
        int cont = 0;
        
        try {
            Vector<Bairros> objeto = new Vector(bairrosDAO.getForLocale_Bairros_ByName(idCidade, idEstado));
            for (Bairros i : objeto) {
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
        SetoresDAO setoresDAO = new SetoresDAO();
        int cont = 0;
        
        try {
            Vector<Setores> objeto = new Vector(setoresDAO.getAll_Setores_ByName());
            for (Setores i : objeto) {
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
        CargosDAO cargosDAO = new CargosDAO();
        int cont = 0;
        
        try {
            Vector<Cargos> objeto = new Vector(cargosDAO.getForSetor_Cargos_ByName(idSetor));
            for (Cargos i : objeto) {
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
        CidadesDAO cidadesDAO = new CidadesDAO();
        Vector<Cidades> objeto = new Vector(cidadesDAO.get_JustFk_Entity_OrderByItemName(idEstado));
        for (Cidades i : objeto) {
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
        BairrosDAO bairrosDAO = new BairrosDAO();
        Vector<Bairros> objeto = new Vector(bairrosDAO.getForLocale_Bairros_ByName(idCidade, idEstado));
        for (Bairros i : objeto) {
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
        SetoresDAO setoresDAO = new SetoresDAO();
        Vector<Setores> objeto = new Vector(setoresDAO.getAll_Setores_ByName());
        for (Setores i : objeto) {
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
        CargosDAO cargosDAO = new CargosDAO();
        Vector<Cargos> objeto = new Vector(cargosDAO.getForSetor_Cargos_ByName(idSetor));
        for (Cargos i : objeto) {
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
        CargosDAO cargosDAO = new CargosDAO();
        Cargos x = cargosDAO.getCargo(v);
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
