package softlearning.core.component.shared.operations;

import softlearning.core.component.order.domain.model.OrderStatus;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import softlearning.core.component.shared.datachecks.Check;
import softlearning.core.component.shared.exceptions.BuildException;
import softlearning.core.component.shared.exceptions.GeneralDateTimeException;

public abstract class Operation {
    protected int ident;
    protected String description;
    protected OrderStatus status;
    protected double totalCost;
    protected LocalDateTime startDate, finishDate;
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss");

    public Operation() {
    }
    
    public void checkData(int id, String startDate, String description) throws BuildException{
        
        try {
            setIdent(id);
            setStartDate (startDate);
            setDescription(description);
        } catch (GeneralDateTimeException ex) {
            throw new BuildException(ex.getMessage());
        }
    }
            

    public int getIdent() {
        return this.ident;
    }

    public void setIdent(int ident) throws BuildException{
        if(Check.checkInteger(ident, 1) == 0){
            this.ident = ident;
        }
        else throw new BuildException("Bad ID");
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws BuildException{
        if(Check.checkString(description, 10) == 0){
            this.description = description;
        }
        else throw new BuildException("Bad Description");
    }

    public String getStatus() {
        return status.toString();
    }
    

    public double getTotalCost() {
        return totalCost;
    }


    public String getStartDate() {
        return startDate.format(this.formatter); 
    }

    public void setStartDate(String startDate) throws GeneralDateTimeException {        
        this.startDate = Check.convertStringToDateTime(startDate, this.formatter);
    }

    public String getFinishDate() {
        return finishDate.format(this.formatter); 
    }

    public void setFinishDate(String finishDate) throws GeneralDateTimeException {
        this.finishDate = Check.convertStringToDateTime(finishDate, this.formatter);
    }

    
}
