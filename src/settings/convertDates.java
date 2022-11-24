package settings;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class convertDates {

    public Date toDate(String entrada) throws ParseException {
        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy");

        Date saida = null;
        saida = formataData.parse(entrada);

        return saida;
    }

    public String toString(Date entrada) {
        SimpleDateFormat formataData = new SimpleDateFormat("yyyy/MM/dd");

        String saida = formataData.format(entrada);

        return saida;
    }

    public java.sql.Date converteDataSql(String mydata) throws ParseException {
        java.sql.Date data = null;
       
            DateFormat dtOutput = new SimpleDateFormat("yyyy-MM-dd");
            data = (java.sql.Date) dtOutput.parse(mydata);

            return data;
        }

    

    public java.util.Date toJavaUtilDate(String mydata, String formater) throws ParseException {
        java.util.Date data = null;
       
            DateFormat dtOutput = new SimpleDateFormat(formater/*"dd-MM-yyyy"*/);
            data = dtOutput.parse(mydata);

            return data;
        }



    }


/*
 ID     Descrição
 %a     Nome da Semana Abreviado (Seg a Dom)
 %b     Nome do mês Abreviado (Jan a Dez)
 %c     Mês de forma numérica (1 a 12)
 %D     Dia do mês com o sufixo Inglês (1st, 2nd, 3rd, …)
 %d     Dia do Mês de forma numérica (01 a 31)
 %e     Dia do Mês de forma numérica (1 a 31)
 %f     Micro segundos (000000..999999)
 %H     Horas (00 a 23)
 %h     Horas (01 a 12)
 %I     Horas (01 a 12)
 %i     Minutos de forma numérica (00 a 59)
 %j     Dia do Ano (001 a 366)
 %k     Horas (0 a 23)
 %l     Horas (1 a 12)
 %M     Nome do mês (Janeiro a Dezembro)
 %m     Mês de forma numérica (01 a 12)
 %p     AM ou PM
 %r     Horas, 12-horas (hh:mm:ss seguidos de AM ou PM)
 %S     Segundos (00 a 59)
 %s     Segundos (00 a 59)
 %T     Horas, 24-horas (hh:mm:ss)
 %U     Semana (00 a 53), onde Domingo é o primeiro dia da semana
 %u     Semana (00 a 53), onde Segunda é o primeiro dia da semana
 %V     Semana (00 a 53), onde Domingo é o primeiro dia da semana; usado com %X
 %v     Semana (00 a 53), onde Segunda é o primeiro dia da semana; usado com %x
 %W     Nome do dia da semana (Segunda a Domingo)
 %w     Dia da semana (0=Domingo a 6=Sábado)
 %X     Dia da semana onde Domingo é o primeiro dia da semana, de forma numérica com 4 dígitos, usado com %V
 %x     Ano da semana, onde Segunda é o primeiro dia da semana, de forma numérica, com 4 dígitos, usado com %v
 %Y     Ano numérico com 4 dígitos
 %y     Ano numérico com 2 dígitos
 %%     Um simples caracter “%”
 %x     x, para qualquer “x” não listado acima
 */
