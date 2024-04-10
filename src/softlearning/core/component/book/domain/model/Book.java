package softlearning.core.component.book.domain.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import softlearning.core.component.shared.datachecks.Check;
import softlearning.core.component.shared.exceptions.BuildException;
import softlearning.core.component.shared.exceptions.GeneralDateTimeException;
import softlearning.core.component.shared.physics.PhysicalData;
import softlearning.core.component.shared.physics.Storable;
import softlearning.core.component.shared.products.Product;

public class Book extends Product implements Storable{

    protected PhysicalData physics;
    protected String isbn;
    protected int edition;
    protected LocalDate releaseDate;
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    protected Book() {}
            
    public static Book getInstance (int id, String name, String owner, String type, String description, String responsable, double price,
            String isbn, int edition, String releaseDate, double heigth, double width, double depht, double weigth, boolean fragile) 
            throws BuildException {
        
        String errorMessage = "";
        Book b = new Book();
        
        b.checkData (id, name, owner, type, description, responsable, price);
        
        b.physics = new PhysicalData(heigth, width, depht, weigth, fragile);
        b.isbn = isbn;
        b.edition = edition;
        try {
            b.setReleaseDate (releaseDate); 
        } catch (GeneralDateTimeException ex) {
            errorMessage += "Bad Release Date: " + ex.getMessage() + ";";
        }
        
        if (errorMessage.length()>0){
            b = null;
            throw new BuildException(errorMessage);
        }else{
            return b;
        }
    }

    @Override
    public String getSize() {
        return this.physics.getSize();
    }

    @Override
    public double getVolum() {
        return this.physics.getVolum();        
    }

    @Override
    public double getWeight() {
        return this.physics.getWeigth();
    }
    
    public double getHeight() {
        return this.physics.getHeigth();
    }
    
    public double getWidth() {
        return this.physics.getWidth();
    }
    
    public double getDepth() {
        return this.physics.getDepth();
    }

    @Override
    public boolean isFragile() {
        return this.physics.getFragile();
    }

    @Override
    public int getIdent() {
        return this.getId();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String getReleaseDate() {
        return releaseDate.format(formatter);
    }

    public void setReleaseDate(String releaseDate) throws GeneralDateTimeException  {
        this.releaseDate = Check.convertStringToDate(releaseDate, this.formatter);;
    }
    
    
}
