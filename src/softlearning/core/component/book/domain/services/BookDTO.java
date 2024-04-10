package softlearning.core.component.book.domain.services;

public class BookDTO {
    private final String name, owner, description, type, responsible, isbn, publicationDate;
    private final int id, edition;
    private final double price, weight, height, width, depth;
    private final boolean available, fragile;

    public BookDTO(String name, String owner, String description, String type, 
            String responsible, String isbn, String publicationDate, int id, 
            int edition, double price, double weight, double height, double width, 
            double depth, boolean available, boolean fragile) {
        this.name = name;
        this.owner = owner;
        this.description = description;
        this.type = type;
        this.responsible = responsible;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.id = id;
        this.edition = edition;
        this.price = price;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.available = available;
        this.fragile = fragile;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getResponsible() {
        return responsible;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public int getId() {
        return id;
    }

    public int getEdition() {
        return edition;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getDepth() {
        return depth;
    }

    public boolean getAvailable() {
        return available;
    }

    public boolean getFragile() {
        return fragile;
    }
}
