package HTTP;

import java.io.*;
import java.net.*;

import com.sun.net.httpserver.*;
public class Server {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(42069), 0);
        System.out.println("SERVER STARTED");

        server.createContext("/", exchange -> {
            String response = "hello from Java HTTP server";
            exchange.sendResponseHeaders(200, (long)response.getBytes().length);
            try ( OutputStream os = exchange.getResponseBody() ) {
                os.write(response.getBytes()); 
            } catch( Exception e ) {

            }
        });

        server.setExecutor(null);
        server.start();
    }    
}
