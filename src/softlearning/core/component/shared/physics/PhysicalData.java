package softlearning.core.component.shared.physics;

public class PhysicalData  {
    protected double heigth, width, depth, weigth;
    protected boolean fragile;

    protected PhysicalData() {
    }

    public PhysicalData(double heigth, double width, double depht, double weigth, boolean fragile) {
        this.heigth = heigth;
        this.width = width;
        this.depth = depht;
        this.weigth = weigth;
        this.fragile = fragile;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getWeigth() {
        return weigth;
    }

    public void setWeigth(double weigth) {
        this.weigth = weigth;
    }

    public boolean getFragile() {
        return fragile;
    }

    public void setFragile(Boolean fragile) {
        this.fragile = fragile;
    }

    public String getSize() {
        return  "heigth:" + this.heigth + ";width:" + this.width  + ";depth:" + this.depth;
    }

    public double getVolum() {
        return  this.heigth * this.width * this.depth;
    }
  
}
