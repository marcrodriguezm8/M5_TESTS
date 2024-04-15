package softlearning.core.component.shared.physics;
import softlearning.core.component.shared.datachecks.Check;
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

    public int setHeigth(double heigth) {
        if (Check.checkDouble(heigth) != 0) { 
            return -1; 
        }
        this.heigth = heigth;
        return 0; 
    }
    

    public double getWidth() {
        return width;
    }

    public int setWidth(double width) {
        if (Check.checkDouble(width) != 0) { 
            return -1; 
        }
        this.width = width;
        return 0; 
    }

    public double getDepth() {
        return depth;
    }

    public int setDepth(double depth) {
        if (Check.checkDouble(depth) != 0) { 
            return -1; 
        }
        this.depth = depth;
        return 0; 
    }

    public double getWeigth() {
        return weigth;
    }

    public int setWeigth(double weigth) {
        if (Check.checkDouble(weigth) != 0) { 
            return -1; 
        }
        this.weigth = weigth;
        return 0; 
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
