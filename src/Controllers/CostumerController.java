package Controllers;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import Models.Clothing;
import Models.Costumer;

public class CostumerController implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) {
        try {
            if(!"GET".equals(exchange.getRequestMethod())) exchange.sendResponseHeaders(405, -1); // Method not allowed

            Costumer costumer = new Costumer("Costumer", "M");

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
        
            // Ordering by price
            costumer.getClothes().sort((a,b) -> {return a.compareTo(b);});

            StringBuilder clothesDescriptionBuilder = new StringBuilder();
            clothesDescriptionBuilder.append("[");
            clothesDescriptionBuilder.append(" \"Clothes bought by " + costumer.getName() + ":" + "\",");
            for (Clothing clothing : costumer.getClothes()) {
                clothesDescriptionBuilder.append("\"" + clothing.toString() + "\"" + ",");
            }
            clothesDescriptionBuilder.append("]");

            String response = clothesDescriptionBuilder.toString();

            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, 0);
            exchange.getResponseBody().write(response.getBytes());
            exchange.getResponseBody().close();

            // System.out.println("Clothes bought by " + costumer.getName() + ":");
            // for (Clothing clothing : costumer.getClothes()) {
            //     if(!clothing.getSize().equals(costumer.getSize())){
            //         System.out.println("Warning: " + clothing.getDescription() + " is not your size!");
            //     }
            //     System.out.println(clothing.toString());
            // }
            // System.out.println(costumer.getName() + " gonna pay: " + costumer.getWardrobePrice() + " with fee included");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
