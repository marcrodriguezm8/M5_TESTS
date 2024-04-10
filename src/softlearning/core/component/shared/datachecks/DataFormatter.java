package softlearning.core.component.shared.datachecks;

public class DataFormatter {
    public static String changeDateFormat(String data) {
        String sep = data.contains("-") ? "-" : "/";

        String fields[] = data.split(sep);
        if (fields.length == 3) {
            return fields[2] + sep + fields[1] + sep + fields[0];
        }
        return null;
    }
    
    public static boolean changeBoolFormat (String booldata){
        return booldata.equals("true");
    }
}
