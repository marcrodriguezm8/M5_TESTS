package softlearning.core.component.shared.datachecks;

import java.time.LocalDate;
import softlearning.core.component.shared.exceptions.GeneralDateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Check {
    public static int checkDNI(String dni) {
        if (dni == null || dni.trim().length() != 9) {
            return -1;
        }
        return 0;
    }
    
    public static int checkEmail (String em){
        if (em == null || em.trim().length() <= 20) {
            return -1;
        }
        return 0;
    }
    
    public static int checkString(String s, int min){
        if (s == null || s.trim().length() < min) {
            return -1;
        }
        return 0;
    }
    
    public static int checkInteger(int value, int min){
        if (value < min) {
            return -1;
        }
        return 0;
    }
    
    public static LocalDateTime convertStringToDateTime(String s, DateTimeFormatter formatter) throws GeneralDateTimeException {        
        try {
            return LocalDateTime.parse(s, formatter);
        } catch (NullPointerException e ) {
            throw new GeneralDateTimeException ("HEMOS RECIBIDO UN NULL EN LUGAR DE UNA FECHA");
        } catch (DateTimeParseException e) {
            throw new GeneralDateTimeException ("ERROR AL PARSEAR FECHA: " + e.getMessage());
        } catch (Exception e) {
            throw new GeneralDateTimeException ("ERROR INESPERADO: " + e);
        } 
    }
    
    public static LocalDate convertStringToDate(String s, DateTimeFormatter formatter) throws GeneralDateTimeException {        
        try {
            return LocalDate.parse(s, formatter);
        } catch (NullPointerException e ) {
            throw new GeneralDateTimeException ("HEMOS RECIBIDO UN NULL EN LUGAR DE UNA FECHA");
        } catch (DateTimeParseException e) {
            throw new GeneralDateTimeException ("ERROR AL PARSEAR FECHA: " + e.getMessage());
        } catch (Exception e) {
            throw new GeneralDateTimeException ("ERROR INESPERADO: " + e);
        } 
    }
}
