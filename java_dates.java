
package interfaz;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import static java.util.Calendar.*;
import java.util.Date;

public class calculofechas {

public static int getDiffYears(Date primera, Date segunda) {
    Calendar a = getCalendar(primera);
    Calendar b = getCalendar(segunda);
    int diff = b.get(YEAR) - a.get(YEAR);
    if (a.get(MONTH) > b.get(MONTH) || 
        (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
        diff--;
    }
    return diff;
}

public static Calendar getCalendar(Date date) {
    Calendar cal = Calendar.getInstance(Locale.US);
    cal.setTime(date);
    return cal;
}

public static String cambiarafechaespana (String fecha) throws ParseException {
    //Recibe una fecha en un formato como String y la parsea a fecha
    Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
    //Definimos un patron de fecha a la que pasarlo
    String patron = "dd/MM/yyyy";
    //Formateamos la fecha
    DateFormat df = new SimpleDateFormat(patron);
    //Pasamos a String la fecha
    String  fechacambiada = df.format(date1);
    //Devolvemos el String con la fecha cambiada
    return fechacambiada;
}

public static String cambiarafechaMySQL(String fecha) throws ParseException {
    //Recibe una fecha en un formato como String y la parsea a fecha
    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
    //Definimos un patron de fecha a la que pasarlo
    String patron = "yyyy-MM-dd";
    //Formateamos la fecha
    DateFormat df = new SimpleDateFormat(patron);
    //Pasamos a String la fecha
    String  fechacambiada = df.format(date1);
    //Devolvemos el String con la fecha cambiada
    return fechacambiada;
}

public static String dateAString (Date fecha){
    //Definimos un patron
    String patron = "yyyy-MM-dd";
    //Formateamos la fecha
    DateFormat df = new SimpleDateFormat(patron);
    //Pasamos a String la fecha
    String  fechaString = df.format(fecha);
    //Devolvemos un string
    return fechaString;
}


public static String dateAStringconHora (Date fecha, Object hora){
    //Definimos un patron de fecha y hora
    String patronf = "yyyy-MM-dd";
    String patronh = "HH:mm:ss";
    //Formateamos la fecha y la hora
    DateFormat df = new SimpleDateFormat(patronf);
    DateFormat tf = new SimpleDateFormat(patronh);
    //Pasamos a String la fecha
    String  fechaString = df.format(fecha);
    String horaString = tf.format (hora);
    //Devolvemos un string
    String completo = fechaString + " " + horaString;
    return completo;
}

public static String dateAFechaEscrita (Date fecha){
    //Definimos un patron de dia semana, dia, mes y año
    String patrondiaEscrito = "EEEE";
    String patrondia = "dd";
    String patronmes = "MMMMM";
    String patronano = "yyyy";
    //Formateamos la fecha en local español
    SimpleDateFormat deformat =new SimpleDateFormat(patrondiaEscrito, new Locale("es", "ES"));
    SimpleDateFormat dformat =new SimpleDateFormat(patrondia, new Locale("es", "ES"));
    SimpleDateFormat mformat =new SimpleDateFormat(patronmes, new Locale("es", "ES"));
    SimpleDateFormat aformat =new SimpleDateFormat(patronano, new Locale("es", "ES"));
    //Devolvemos un string sumando todo
    String textofecha = deformat.format(fecha) + " dia " + dformat.format(fecha) + " de " + mformat.format(fecha) + " del " + aformat.format(fecha) ;
    
    return textofecha;
}

public static String mesActual(Date fecha){
    //Definimos un patron de mes
    String patronmes = "MMMMM";
    //Formateamos la fecha en local español
    SimpleDateFormat mformat =new SimpleDateFormat(patronmes, new Locale("es", "ES"));
    //Devolvemos un string
    String textomes = mformat.format(fecha);
    
    return textomes;
}

public static String anoActual(Date fecha){
    //Definimos un patron de mes
    String patronano = "yyyy";
    //Formateamos la fecha en local español
    SimpleDateFormat mformat =new SimpleDateFormat(patronano, new Locale("es", "ES"));
    //Devolvemos un string
    String textoano = mformat.format(fecha);
    
    return textoano;
}

public static String dateAFechaEscritaconHora (Date fecha){
    //Definimos un patron de dia semana, dia, mes y año
    String patrondiaEscrito = "EEEE";
    String patrondia = "dd";
    String patronhora = "HH:mm:ss";
    //Formateamos la fecha en local español
    SimpleDateFormat deformat =new SimpleDateFormat(patrondiaEscrito, new Locale("es", "ES"));
    SimpleDateFormat dformat =new SimpleDateFormat(patrondia, new Locale("es", "ES"));
    SimpleDateFormat hformat =new SimpleDateFormat(patronhora, new Locale("es", "ES"));
    //Devolvemos un string sumando todo
    String textofecha = (deformat.format(fecha)).toUpperCase() + " dia " + dformat.format(fecha) + ", a las - " + hformat.format(fecha);
    
    return textofecha;
}

public static String dateaStringCodigo (Date fecha){
    //Definimos un patron
    String patron = "dd.MM.yyyy";
    //Formateamos la fecha
    DateFormat df = new SimpleDateFormat(patron);
    //Pasamos a String la fecha
    String  fechaString = df.format(fecha);
    //Devolvemos un string
    return fechaString;
}

public static String dateAStringHora (Date fecha){
    //Definimos un patron
    String patron = "HH:mm:ss";
    //Formateamos la fecha
    DateFormat df = new SimpleDateFormat(patron);
    //Pasamos a String la fecha
    String  fechaString = df.format(fecha);
    //Devolvemos un string
    return fechaString;
}


public static Date stringADate (String fecha) throws ParseException{
    Date fechasalida=new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
    return fechasalida;
}

public static Date stringADatecompleta (String fecha) throws ParseException{
    Date fechasalida=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fecha);
    return fechasalida;
}

public static String fechaparaSpinner (Date fecha) {
    Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        Date horasfecha = c.getTime();
        int h = c.get(Calendar.HOUR_OF_DAY);
        int m = c.get(Calendar.MINUTE);
        int s = c.get(Calendar.SECOND);
        String horas = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
        String minutos = Integer.toString(c.get(Calendar.MINUTE));
        String segundos = Integer.toString(c.get(Calendar.SECOND));  
    String salida = (horas + ":" + minutos + ":" + segundos);    
    return salida;
}
    
}
