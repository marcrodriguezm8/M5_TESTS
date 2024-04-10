package softlearning.core.component.shared.products;

import softlearning.core.component.shared.exceptions.BuildException;

public abstract class Product implements Marketable{
   protected int id;
   protected String name, owner, type, description, responsable;
   protected double price;
   protected boolean availability;

    protected Product() {
    }

    protected void checkData (int id, String name, String owner, String type, String description, 
            String responsable, double price) throws BuildException {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.type = type;
        this.description = description;
        this.responsable = responsable;
        this.price = price;
        this.availability = true;
    }
    

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    
   
}
