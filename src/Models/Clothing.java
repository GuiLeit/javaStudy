package Models;

public class Clothing {
    private String description;
    private double price;
    private String size;

    // Builder Pattern Overview
    // The class Builder is declared as a static nested class within Clothing. Declaring it static means it doesn’t need an instance of Clothing to be used. It holds the same fields as Clothing (description, price, and size).
    public static class Builder {
        private String description;
        private double price;
        private String size = "M"; // Default size

        public Builder description(String description) {
            this.description = description;
            return this;
        }
        public Builder price(double price) {
            this.price = price;
            return this;
        }
        public Builder size(String size) {
            this.size = size;
            return this;
        }

        public Clothing build() {
            return new Clothing(this);
        }
    }

    private Clothing(Builder builder) {
        description = builder.description;
        price = builder.price;
        size = builder.size;
    }

    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }  

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

}
