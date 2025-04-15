import java.util.ArrayList;

import Models.Clothing;
import Models.Costumer;

public class App {
    public static void main(String[] args) throws Exception {
        final double fee = 0.2;

        Costumer costumer = new Costumer("Costumer", "M");

        ArrayList<Clothing> clothes = new ArrayList<Clothing>();

        clothes.add(new Clothing.Builder()
            .description("Blue Jacket")
            .price(20.9)
            .size("M")
            .build()    
        );

        clothes.add(new Clothing.Builder()
            .description("Orange T-shirt")
            .price(15.5)
            .size("S")
            .build()
        );

        System.out.println("Clothes bought by " + costumer.getName() + ":");
        for (Clothing clothing : clothes) {
            if(!clothing.getSize().equals(costumer.getSize())){
                System.out.println("Warning: " + clothing.getDescription() + " is not your size!");
            } else {
                System.out.println(clothing.getDescription() + " is your size!");
            }
        }

        double total = clothes.stream().mapToDouble(Clothing::getPrice).sum() * (1 + fee);
        System.out.println(costumer.getName() + " gonna pay: " + total);

    }
}
