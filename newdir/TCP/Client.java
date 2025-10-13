package TCP;
import java.net.*;
import java.util.Scanner;
import java.io.*;


public class Client {
    private static volatile long pingtime = 0;
    public static void main(String [] args) throws Exception{

        Socket socket = new Socket("localhost", 42069);

        new Thread(() -> {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String msg;
                while ( (msg = in.readLine()) != null ) {
                    System.out.println(msg);
                    if ( msg.equals("PONG") ) {
                        long interval = System.currentTimeMillis() - pingtime;
                        System.out.println("LATENCY : " + interval);
                    }
                }
            } catch ( Exception e ) {
                System.out.println("DISCONNECTED FROM SERVER");
            }
        }).start();

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);


        String user;
        while ( (user = sc.nextLine()) != null ) {
            if ( user.equalsIgnoreCase("TIME") ) {
                out.println("TIME");
            } else if ( user.equalsIgnoreCase("ECHO") ) {
                out.println("ECHO");
                String echomsg = sc.nextLine();
                out.println(echomsg);
            } else if ( user.equalsIgnoreCase("EXIT") ) {
                System.out.println("DISCONNECTING");
                socket.close();
                break;
            } else if ( user.equalsIgnoreCase("PING") ) {
                pingtime = System.currentTimeMillis();
                out.println("PING");
            }
        }

        
    }
    
}
