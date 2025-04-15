import Models.Clothing;
import Models.Costumer;

public class App {
    public static void main(String[] args) throws Exception {
        Costumer costumer = new Costumer("Costumer", "M");

        costumer.addClothing(new Clothing.Builder()
            .description("Blue Jacket")
            .price(20.9)
            .size("M")
            .build()
        );
        costumer.addClothing(new Clothing.Builder()
            .description("Orange T-shirt")
            .price(15.5)
            .size("S")
            .build());


        System.out.println("Clothes bought by " + costumer.getName() + ":");
        for (Clothing clothing : costumer.getClothes()) {
            if(!clothing.getSize().equals(costumer.getSize())){
                System.out.println("Warning: " + clothing.getDescription() + " is not your size!");
            } else {
                System.out.println(clothing.getDescription() + " is your size!");
            }
        }

        System.out.println(costumer.getName() + " gonna pay: " + costumer.getWardrobePrice() + " with fee included");

    }
}
