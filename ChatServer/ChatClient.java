package ChatServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ChatClient {
    
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 42069);
        Scanner sc = new Scanner(System.in);

        new Thread(() -> {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String msg;
                while ( (msg = in.readLine()) != null ) {
                    System.out.println(msg);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }).start();

        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        String user;
        while (true) {
            user = sc.nextLine();
            writer.println(user);
        }


    }
}
