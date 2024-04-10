package softlearning.core.component.order.domain.services;

public class OrderDTO {
    private final int ident;
    private final String description, startDate, finishDate, status, shopCart,
            clientAddres, clientPhone, clientEmail, clientId, clientName;
    private final double totalCost, heigth, width, depht, weigth;
    private final boolean fragile;

    public OrderDTO(int ident, String description, String startDate, String finishDate, String status, String shopCart, 
            String clientAddres, String clientPhone, String clientEmail, String clientId, String clientName, double totalCost, 
            double heigth, double width, double depht, double weigth, boolean fragile) {
        this.ident = ident;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.status = status;
        this.shopCart = shopCart;
        this.clientAddres = clientAddres;
        this.clientPhone = clientPhone;
        this.clientEmail = clientEmail;
        this.clientId = clientId;
        this.clientName = clientName;
        this.totalCost = totalCost;
        this.heigth = heigth;
        this.width = width;
        this.depht = depht;
        this.weigth = weigth;
        this.fragile = fragile;
    }

    public int getIdent() {
        return ident;
    }

    public String getDescription() {
        return description;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public String getStatus() {
        return status;
    }

    public String getShopCart() {
        return shopCart;
    }

    public String getClientAddres() {
        return clientAddres;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getHeigth() {
        return heigth;
    }

    public double getWidth() {
        return width;
    }

    public double getDepht() {
        return depht;
    }

    public double getWeigth() {
        return weigth;
    }

    public boolean isFragile() {
        return fragile;
    }

    
    
}
