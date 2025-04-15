package Models;

import java.util.ArrayList;

public class Costumer {
    private String name;
    private String size;
    private ArrayList<Clothing> clothes = new ArrayList<Clothing>();

    public Costumer(String name, String size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    public ArrayList<Clothing> getClothes() {
        return clothes;
    }
    public void addClothing(Clothing clothing) {
        this.clothes.add(clothing);
    }

    public double getWardrobePrice() {
        return this.clothes.stream().mapToDouble(Clothing::getPrice).sum();
    }
}
