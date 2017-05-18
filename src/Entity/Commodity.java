package Entity;

/**
 * Created by cdewse on 17-5-7.
 */
public class Commodity {

    private int cid;
    private String name;
    private int inputPrice;
    private int outputPrice;
    private double quality;
    private String picture;
    private int amount;
    private int type;
    private String brand;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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
