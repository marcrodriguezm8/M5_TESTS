package softlearning.core.component.client.domain.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import softlearning.core.component.shared.datachecks.Check;
import softlearning.core.component.shared.exceptions.BuildException;
import softlearning.core.component.shared.exceptions.GeneralDateTimeException;
import softlearning.core.component.shared.stakeholders.Person;
import softlearning.core.component.shared.stakeholders.Stakeholder;

public class Client extends Person implements Stakeholder{
    protected String creditcard, password;
    protected int code;
    protected Boolean premium;
    protected LocalDate since;
    protected DateTimeFormatter formatterSince = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    protected Client () {}

    public static Client getInstance(String name, String ident, String birthday, String address, String phone,
            String creditcard, String password, int code, Boolean premium, String since
    ) throws BuildException {
        Client c = new Client();
        String errorMessage = "";
        try {            
            c.checkPersonData(name, ident, birthday, address, phone);
        }catch (BuildException ex) {
            errorMessage += ex.getMessage();
        }
        if (c.setCreditcard(creditcard) != 0){
            errorMessage += "Bad credit card;";
        }
        if (c.setPassword(password) != 0){
            errorMessage += "Bad passwd;";
        }
        if (c.setCode(code) != 0){
            errorMessage += "Bad Code client;";
        }
        c.setPremium (premium);
        try {
            c.setSince(since);
        } catch (GeneralDateTimeException ex) {
            errorMessage += "Bad since date: " + ex.getMessage() + ";";
        }
        
        if (errorMessage.length()>0){
            c = null;
            throw new BuildException(errorMessage);
        }else{
            return c;
        }
    }

    public String getCreditcard() {
        return creditcard;
    }

    public int setCreditcard(String creditcard) {
        if (Check.checkString(creditcard, 10) != 0) {
            return -1;
        }
        this.creditcard = creditcard;        
        return 0;
    }

    public String getPassword() {
        return password;
    }

    public int setPassword(String password) {
        if (Check.checkString(password, 8) != 0) {
            return -1;
        }
        this.password = password;     
        return 0;        
    }

    public int getCode() {
        return this.code;
    }

    public int setCode(int code) {
        if (Check.checkInteger(code, 1) != 0) {
            return -1;
        }
        this.code = code;    
        return 0;
        
    }

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    public String getSince() {
        return since.format(this.formatterSince);
    }

    public void setSince(String since) throws GeneralDateTimeException {
        this.since = Check.convertStringToDate(since, this.formatterSince);
    }

    @Override
    public String getContactData() {
        return "phone:" + this.getPhone() + ";" + "address:" + this.getAddress();
    }

    @Override
    public String getDetails() {
        String data = this.getPremium()?"Premium":"NO Premium";
        return this.getCode()+ ";" + data + ";" + this.getSince(); 
    }
    
}
