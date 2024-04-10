package softlearning.core.component.shared.stakeholders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import softlearning.core.component.shared.datachecks.Check;
import softlearning.core.component.shared.exceptions.BuildException;
import softlearning.core.component.shared.exceptions.GeneralDateTimeException;

public abstract class Person {

    protected String name, ident, address, phone;
    protected LocalDate birthday;
    protected boolean company;
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    //CONTRUCTORS
    protected Person() {
    }

    protected void checkPersonData(String name, String ident, String birthday,
            String address, String phone) throws BuildException {

        String errorMessage = "";
        if (this.setName(name) != 0) {
            errorMessage += "Bad Name;";
        }
        if (this.setIdent(ident) != 0) {
            errorMessage += "Bad Ident;";
        }
        try {
            this.setBirthday(birthday);
        } catch (GeneralDateTimeException ex) {
            errorMessage += "Bad Birthday: " + ex.getMessage() + ";";
        }
        if (this.setAddress(address) != 0) {
            errorMessage += "Bad Address;";
        }
        if (this.setPhone(phone) != 0) {
            errorMessage += "Bad Phone;";
        }
        this.company = false;

        if (errorMessage.length() > 0) {
            throw new BuildException(errorMessage);
        }
    }

    //GETTER & SETTERS
    public String getName() {
        return name;
    }

    public int setName(String nom) {
        if (Check.checkString(nom, 10) != 0) {
            return -1;
        }
        //si todo ok se guarda nombre
        this.name = nom;
        return 0;
    }

    public String getIdent() {
        return ident;
    }

    public int setIdent(String ident) {
        if (Check.checkString(ident, 9) != 0) {
            return -1;
        }
        this.ident = ident;
        return 0;
    }

    public String getBirthday() {
        return birthday.format(this.formatter);
    }

    public void setBirthday(String birthday) throws GeneralDateTimeException {
        this.birthday = Check.convertStringToDate(birthday, this.formatter);
    }

    public String getAddress() {
        return address;
    }

    public int setAddress(String address) {
        if (Check.checkString(address, 9) != 0) {
            return -1;
        }
        this.address = address;
        return 0;
    }

    public Boolean isCompany() {
        return company;
    }

    public String getPhone() {
        return phone;
    }

    public int setPhone(String phone) {
        if (Check.checkString(phone, 9) != 0) {
            return -1;
        }
        this.phone = phone;
        return 0;
    }

    // SPECIFICS METHODS
    @Override
    public String toString() {
        return this.name + ";" + ";" + ident + ";" + this.getBirthday() + ";"
                + this.address + ";" + this.company;
    }
}
