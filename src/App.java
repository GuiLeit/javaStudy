import Models.Clothing;
import Models.Costumer;

public class App {
    public static void main(String[] args) throws Exception {
        final double tax = 0.2;

        Costumer costumer = new Costumer("Costumer");

        // Build Pattern
        Clothing item1 = new Clothing.Builder()
                .description("Blue Jacket")
                .price(20.9)
                .size("M")
                .build();
        Clothing item2 = new Clothing.Builder()
                .description("Orange T-shirt")
                .price(15.5)
                .size("S")
                .build();

        double total = (item1.getPrice() + item2.getPrice()) * (1 + tax);
        System.out.println(costumer.getName() + " gonna pay: " + total);

    }
}
