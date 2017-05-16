package Entity;

/**
 * Created by cdewse on 17-5-7.
 */
public class Goods {

    private int id;
    private String name;
    private int inputPrice;
    private int outputPrice;
    private double quality;
    private int type;
    private String brand;

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

    public int getInputPrice() {
        return inputPrice;
    }

    public void setInputPrice(int inputPrice) {
        this.inputPrice = inputPrice;
    }

    public int getOutputPrice() {
        return outputPrice;
    }

    public void setOutputPrice(int outputPrice) {
        this.outputPrice = outputPrice;
    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
