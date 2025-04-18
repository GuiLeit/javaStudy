import com.sun.net.httpserver.HttpServer;

import Controllers.CostumerController;

import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        
        server.createContext("/", (exchange -> {
            String response = "Hello, World!";
            exchange.sendResponseHeaders(200, 0);
            exchange.getResponseHeaders().add("Content-Type", "text/plain");
            exchange.getResponseBody().write(response.getBytes());
            exchange.getResponseBody().close(); 
        }));
        server.createContext("/costumer", new CostumerController());
        
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on port 8080");
    }    
}
