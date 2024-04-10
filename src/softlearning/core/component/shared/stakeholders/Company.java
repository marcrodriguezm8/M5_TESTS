package softlearning.core.component.shared.stakeholders;

import softlearning.core.component.shared.datachecks.Check;
import softlearning.core.component.shared.exceptions.BuildException;

public class Company {
    protected String type, socialReason;

    protected Company() {}

    public static Company getInstance (String type, String socialReason) throws BuildException {        
        Company c = new Company();
        String errorMessage = "";        
        if (c.setType(type) != 0) {
            errorMessage += "Bad Type;";
        }
        if (c.setSocialReason (socialReason) != 0) {
            errorMessage += "Bad SocialReason;";
        }        
        if (errorMessage.length()>0){
            c = null;
            throw new BuildException(errorMessage);
        }else{
            return c;
        }       
    }
    
    public String getType() {
        return type;
    }

    public int setType(String type) {
        if (Check.checkString(type, 2) != 0) {
            return -1;
        }
        this.type = type;     
        return 0;        
    }

    public String getSocialReason() {
        return socialReason;
    }

    public int setSocialReason(String socialReason) {
        if (Check.checkString(socialReason, 8) != 0) {
            return -1;
        }
        this.socialReason = socialReason;    
        return 0;           
    }
    
}
