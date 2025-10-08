package PortScanner;

import java.net.InetSocketAddress;
import java.net.Socket;

public class index {
    public static void main(String[] args) {
        int start = 1;
        int end = 1024;

        for ( int i = start; i <= end; i++ ) {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress("localhost", i), 200);
                System.out.println("PORT" + i + " is open");

            } catch ( Exception e ) {
            }
        }
    }
    
}
