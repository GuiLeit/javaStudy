package Models;

public class Clothing implements Comparable<Clothing>{
    private String description;
    private double price;
    private String size = "M";

    private static final double fee = 0.2;
    private static final double mininumPrice = 10.0;

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
            if(price < Clothing.mininumPrice) throw new IllegalArgumentException("Price must be at least " + Clothing.mininumPrice);
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
        return price * (1 + fee);
    }
    public double getPriceWithoutFee() {
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

    @Override
    public String toString() {
        return "Clothing [description= " + description + ", price= " + price + ", size= " + size + "]";
    }

    @Override
    public int compareTo(Clothing o) {
        return this.description.compareTo(o.description);
    }
}
