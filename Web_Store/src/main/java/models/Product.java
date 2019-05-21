package models;

public class Product {
    private int ID;
    private String name;
    private String manufacturer;
    private double price;
    private String category;
    private String image;

    public Product(int ID, String name, String manufacturer, double price, String category, String image) {
        this.ID = ID;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.category = category;
        this.image = image;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
