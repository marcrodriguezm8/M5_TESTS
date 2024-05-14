package softlearning.core.component.order.domain.model;

import softlearning.core.component.shared.products.Marketable;
import softlearning.core.component.shared.datachecks.Check;
import softlearning.core.component.shared.exceptions.BuildException;

public class OrderDetail {
    protected Marketable m;
    protected int amount;
    protected double discount;

    public OrderDetail() {
    }
      
    public static OrderDetail getInstance (Marketable m, int amount, double discount) throws BuildException{
        OrderDetail od = new OrderDetail();
        String errorMessage = "";
        if(od.setMarketable(m) == -1) errorMessage += "Bad marketable;";
        if(od.setAmount(amount) == -1) errorMessage += "Bad amount;";
        if(od.setDiscount(discount) == -1) errorMessage += "Bad discount;";
        
        
        if (errorMessage.length() > 0) {
            throw new BuildException(errorMessage);
        }
        return od;
    }

    public int getAmount() {
        return this.amount;
    }

    public int setAmount(int amount) {
        if (Check.checkInteger(amount, 1) != 0) {
            return -1;
        }
        this.amount = amount;
        return 0;
    }

    public double getDiscount() {
        return discount;
    }

    public int setDiscount(double discount) {
        if(Check.checkDouble(discount) == -1) return -1;
        this.discount = discount;
        return 0;
    }   

    protected int setMarketable (Marketable m) {
        if(m == null) return -1;
        this.m = m;
        return 0;
    }
    
    public double getDetailCost() {
        return this.amount * this.m.getPrice() * (1-this.getDiscount());
    }
    
    public String getDetail(){
        return this.m.getId()+","+this.m.getName()+","+this.m.getPrice()+","+
                this.amount+","+this.discount;
    }
    
    @Override
    public String toString(){
        return this.m.getId()+","+this.m.getName()+","+this.m.getPrice()+","+
                this.amount+","+this.discount;
    }
    
    public int getIntRef() {
        return this.m.getId();
    }
    
     public String getStringRef() {
        return String.valueOf(this.m.getId());
    }
}
