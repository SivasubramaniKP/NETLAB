package SendShit;

import java.net.Socket;
import java.util.Scanner;
import java.io.*;

class ServerListener implements Runnable{
    Socket socket = null;
    BufferedReader br ;
    
    ServerListener(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg;
            while( (msg = br.readLine()) != null ) {
                System.out.println("SERVER" + msg);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

public class Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 42069);
        ServerListener listener = new ServerListener(socket);

        Thread thread = new Thread(listener);
        thread.start();


        Scanner sc = new Scanner(System.in);
        Integer userinput;
        
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        while( true ) {
            System.out.println("ENTER YOUR CHOICE");
            userinput = sc.nextInt();
            sc.nextLine();
            if ( userinput == 1 ) {
                writer.println("1");
            } else if ( userinput == 2 ) {
                writer.println("2");
                System.out.println("Enter a messge");
                String msg = sc.nextLine();
                writer.println(msg);
            } else 
            {
                writer.println("3");
            }
        }

    }
}
