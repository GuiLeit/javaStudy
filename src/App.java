import java.util.Arrays;

import Models.Clothing;
import Models.Costumer;

public class App {
    public static void main(String[] args) throws Exception {
        Costumer costumer = new Costumer("Costumer", "M");

        try{
            costumer.addClothing(new Clothing.Builder()
                .description("Blue Jacket")
                .price(20.9)
                .size("M")
                .build()
            );

            costumer.addClothing(new Clothing.Builder()
                .description("A Orange T-shirt")
                .price(10.5)
                .size("S")
                .build()
            );
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }

        costumer.getClothes().sort((a,b) -> {return a.compareTo(b);});

        System.out.println("Clothes bought by " + costumer.getName() + ":");
        for (Clothing clothing : costumer.getClothes()) {
            if(!clothing.getSize().equals(costumer.getSize())){
                System.out.println("Warning: " + clothing.getDescription() + " is not your size!");
            }
            System.out.println(clothing.toString());
        }

        System.out.println(costumer.getName() + " gonna pay: " + costumer.getWardrobePrice() + " with fee included");

    }
}
