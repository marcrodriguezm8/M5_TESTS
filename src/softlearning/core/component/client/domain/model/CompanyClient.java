package softlearning.core.component.client.domain.model;

import softlearning.core.component.client.domain.model.Client;
import java.util.logging.Level;
import java.util.logging.Logger;
import softlearning.core.component.shared.datachecks.Check;
import softlearning.core.component.shared.exceptions.BuildException;
import softlearning.core.component.shared.exceptions.GeneralDateTimeException;
import softlearning.core.component.shared.stakeholders.Company;

public class CompanyClient extends Client {

    protected Company comp;

    public static CompanyClient getInstance(String name, String ident, String birthday, String address, String phone,
            String creditcard, String password, int code, Boolean premium, String since, String type, String socialReason
    ) throws BuildException {

        String errorMessage = "";
        CompanyClient cc = new CompanyClient();
        try {
            Client.getInstance(name, ident, birthday, address, phone,
                    creditcard, password, code, premium, since);
            cc.name = name;
            cc.ident = ident;
            cc.address = address;
            cc.phone = phone;
            cc.creditcard = creditcard;
            cc.password = password;
            cc.code = code;
            cc.premium = premium;
            try {  //SOLO PORQUE JAVA LO EXIGE
                cc.setBirthday(birthday);
                cc.setSince(since);
            } catch (GeneralDateTimeException ex) {
                errorMessage += ex.getMessage();
            }                       
        } catch (BuildException ex) {
            errorMessage += ex.getMessage();
        }
        try {
            Company compData = Company.getInstance(type, socialReason);
            cc.setComp(compData);
            cc.company = true;
        } catch (BuildException ex) {
            errorMessage += ex.getMessage();
        }
        if (errorMessage.length() > 0) {
            cc = null;
            throw new BuildException(errorMessage);
        } else {
            return cc;
        }
    }
    protected Company getComp() {
        return comp;
    }
    protected void setComp(Company comp) {
        this.comp = comp;
    }
    public String getType() {
        return this.comp.getType();
    }
    public int setType(String type) {
        return this.comp.setType(type);
    }
    public String getSocialReason() {
        return this.comp.getSocialReason();
    }
    public int setSocialReason(String socialReason) {
        return this.comp.setSocialReason(socialReason);
    }

    @Override
    public String getContactData() {
        return super.getContactData() + ";"+ this.getSocialReason();
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ";"+ this.getType(); 
    }
}
