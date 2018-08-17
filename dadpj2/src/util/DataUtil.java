/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Aluno
 */
public class DataUtil {
     
    public static String ConverterDataEmTexto(Calendar dataCalendar){
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String dataString = formatador.format(dataCalendar.getTime());
        
        return dataString;
    }
    
    public static Calendar ConverterTextoEmCalendar(String dataStr){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(dataStr));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        
        return c;
    }
    
}