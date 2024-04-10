package softlearning.core.component.client.domain.services;

public class ClientDTO {
    private final String name, ident, address, phone, birthday, creditcard, password, since;
    private final int code;
    private final boolean premium, company;

    public ClientDTO(String name, String ident, String birthday, String address, String phone, 
            String creditcard, String password, int code, boolean premium, String since) {
        this.name = name;
        this.ident = ident;
        this.address = address;
        this.phone = phone;
        this.birthday = birthday;
        this.creditcard = creditcard;
        this.password = password;
        this.since = since;
        this.code = code;
        this.premium = premium;
        this.company = false;
    }
   
    public String getName() {
        return name;
    }

    public String getIdent() {
        return ident;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getCreditcard() {
        return creditcard;
    }

    public String getPassword() {
        return password;
    }

    public String getSince() {
        return since;
    }

    public int getCode() {
        return code;
    }

    public boolean isPremium() {
        return premium;
    }

    public boolean isCompany() {
        return company;
    }
    
    
}
