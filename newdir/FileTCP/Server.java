package FileTCP;

import java.net.*;
import java.util.Scanner;
import java.io.*;
public class Server {
    
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(42069);
        
        while ( true ) {
            Socket socket = serverSocket.accept();
            
            new Thread(() -> {
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);


                    String client;
                    while ( (client = in.readLine()) != null ) {
                        if ( !new File(client).isFile() ) {
                            out.println("FILE_NOT_FOUND");
                        } else {
                            Scanner sc = new Scanner(new File(client));
                            while ( sc.hasNextLine() ) {
                                String s = sc.nextLine();
                                out.println(s);
                            }
                            out.println("EOF");
                        }
                    }

                } catch ( Exception e ) {
                    System.out.println("Client disconnected");
                }
            }).start();
        }
    }
}
