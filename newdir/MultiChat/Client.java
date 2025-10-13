package MultiChat;

import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 42069);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        new Thread(() -> {
            try {
                String server;
                while ( (server = in.readLine()) != null ) {
                    System.out.println(server);
                }
            } catch ( Exception e ) {
                System.out.println("Disconnecte from the server");
            }
        }).start();


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username");
        String username = sc.nextLine();
        out.println(username);
        
        System.out.println("ENTER TO THE CHAT");
        String user;
        while ( !(user=sc.nextLine()).equals("EXIT") ) {
            out.println(user);
            System.out.print("YOU: ");
        }


        sc.close();
        socket.close();
    } 
}
