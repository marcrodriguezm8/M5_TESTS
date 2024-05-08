package softlearning.core.component.order.domain.model;

import java.util.ArrayList;
import softlearning.core.component.shared.products.Marketable;
import softlearning.core.component.shared.datachecks.Check;
import softlearning.core.component.shared.exceptions.BuildException;
import softlearning.core.component.shared.exceptions.ServiceException;
import softlearning.core.component.shared.physics.Storable;
import softlearning.core.component.shared.physics.PhysicalData;
import softlearning.core.component.client.domain.model.Client;
import softlearning.core.component.shared.operations.Operation;

public class Order extends Operation implements Storable {

    protected Client client;
    protected ArrayList<OrderDetail> shopCart;
    protected PhysicalData orderPackage = null;

    protected Order() {
        this.shopCart = new ArrayList<OrderDetail>();
        this.status = OrderStatus.CREATED;
    }

    public static Order getInstance(int id, String startDate, String description,
            Client c) throws BuildException {
        Order o = new Order();
        String errorMessage = "";
        o.client = c;
        try {
            o.checkData(id, startDate, description);
        } catch (BuildException ex) {
            errorMessage += ex.getMessage();
        }
        if (errorMessage.length() > 0) {
            throw new BuildException(errorMessage);
        }
        return o;
    }

    @Override
    public String getSize() {
        return this.orderPackage.getSize();
    }

    @Override
    public double getVolum() {
        return this.orderPackage.getVolum();
    }

    @Override
    public double getWeight() {
        return this.orderPackage.getWeigth();
    }

    @Override
    public boolean isFragile() {
        return this.orderPackage.getFragile();
    }

    public int getClientId() {
        return this.client.getCode();
    }

    public int getNumDetails() {
        return this.shopCart.size();
    }

    public int setDetail(Marketable product, int amount) throws BuildException, ServiceException {
        int error = 0;
    
        if (product == null) {
            error = -1;
        } else if (this.status == OrderStatus.CREATED) {
            OrderDetail od = this.findByRef(String.valueOf(product.getId()));
            if (od == null) {
                this.shopCart.add(OrderDetail.getInstance(product, amount, 0));
            } else {
                error = updateDetail(String.valueOf(product.getId()), (amount + od.getAmount()));
            }
        } else {
            error = -2; 
        }
    
        return error;
    }
    

    public String getDetail(int pos) throws ServiceException {
        return this.getDetail(this.findByPos(pos));
    }

    public String getDetail(String ref) throws ServiceException {
        return this.getDetail(this.findByRef(ref));
    }

    protected String getDetail(OrderDetail od) throws ServiceException {
        if (od == null) {
            throw new ServiceException("Detail not found");
        }
        return od.getDetail();
    }

    public int updateDetail(int pos, int amount) throws ServiceException {
        if (this.status == OrderStatus.CREATED) {
            return updateDetail(this.findByPos(pos), amount);
        }
        return -1;
    }

    public int updateDetail(String ref, int amount) throws ServiceException {
        if (this.status == OrderStatus.CREATED) {
            return updateDetail(this.findByRef(ref), amount);
        }
        return -1;
    }

    protected int updateDetail(OrderDetail od, int amount) throws ServiceException {
        if (Check.checkInteger(amount, 1) != 0) {
            throw new ServiceException("Amount can be greatter than 0");
        }
        if (od == null) {
            throw new ServiceException("Detail not found");
        }
        od.setAmount(amount);
        return 0;
    }

    public int deleteDetail(int pos) throws ServiceException {
        if (this.status == OrderStatus.CREATED) {
            return this.deleteDetail(this.findByPos(pos));
        }
        return -1;
    }

    public int deleteDetail(String ref) throws ServiceException {
        if (this.status == OrderStatus.CREATED) {
            return this.deleteDetail(this.findByRef(ref));
        }
        return -1;
    }

    public int deleteDetail(OrderDetail od) throws ServiceException {
        if (od == null) {
            throw new ServiceException("Detail not found");
        }
        this.shopCart.remove(od);
        return 0;
    }

    protected OrderDetail findByPos(int pos) {
        if (pos < 0 || pos >= this.shopCart.size()) {
            return null;
            
        }
        return this.shopCart.get(pos);
    }

    protected OrderDetail findByRef(String ref) {
        for (OrderDetail od : this.shopCart) {
            if (od.getStringRef().equals(ref)) {
                return od;
            }
        }
        return null;
    }

    public void orderConfirmation() {
        this.totalCost = this.getTotalCost();
        this.status = OrderStatus.CONFIRMED;
    }

    public void orderCanceled() {
        this.status = OrderStatus.CANCELED;
    }

    public void setPackageDimensions(String physics) throws BuildException {
        double heigth = 0, width = 0, depth = 0, weigth = 0;
        boolean fragile = false;

        String fields[] = physics.split(",");
        for (String field : fields) {
            String keyValue[] = field.split(":");
            switch (keyValue[0]) {
                case "h":
                    heigth = Double.valueOf(keyValue[1]);
                    break;
                case "w":
                    width = Double.valueOf(keyValue[1]);
                    break;
                case "d":
                    depth = Double.valueOf(keyValue[1]);
                    break;
                case "W":
                    weigth = Double.valueOf(keyValue[1]);
                    break;
                case "f":
                    fragile = Boolean.valueOf(keyValue[1]);
                    break;
            }
        }
        this.orderPackage = new PhysicalData(heigth, width, depth, weigth, fragile);
        this.status = OrderStatus.FORTHCOMMING;
    }

    @Override
    public double getTotalCost() {
        if (this.status != OrderStatus.CANCELED) {
            this.totalCost = 0;
            for (OrderDetail od : this.shopCart) {
                this.totalCost += od.getDetailCost();
            }
        }
        return this.totalCost;
    }

    public String getClientData() {
        return "name:" + this.client.getName() + ";" + this.client.getContactData();
    }

    public String getShopCart() {
        String s = "";
        for (OrderDetail od : this.shopCart) {
            s += od.getDetail() + ";";
        }
        return s;
    }
}
