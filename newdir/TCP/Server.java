package TCP;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public static void main(String[] args) throws Exception{
        
        ServerSocket serverSocket = new ServerSocket(42069);

        while ( true ) {
            Socket socket = serverSocket.accept();

            System.out.println("Client Connected");
            new Thread(() -> {
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                    String client;
                    while ( (client = in.readLine()) != null ) {
                        if ( client.equals("TIME") ) {
                            System.out.println("CLIENT REQUESTED TIME");
                            Date date = new Date();
                            out.println(date.toString());
                        } else if ( client.equals("ECHO") ){
                            System.out.println("CLIENT REQUESTED ECHO");
                            String echo = in.readLine();
                            System.out.println("ECHO MSG IS "  + echo);
                            out.println(echo);
                        } else if ( client.equals("PING") ) {
                            System.out.println("CLIENT REQUESTED PING");
                            out.println("PONG");
                        }
                        else {
                            System.out.println("UNKNOWN REQUEST");
                        }
                    }
                } catch ( Exception e ) {
                    System.out.println("CLIENT DISCONNECTED");
                }
            }).start();;
        }
    } 
}
