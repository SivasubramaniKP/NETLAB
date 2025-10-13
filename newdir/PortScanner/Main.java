package PortScanner;

import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) {
        for ( int i = 1; i <= 1024; i++ ) {
            try {
                ServerSocket socket = new ServerSocket(i);
                System.out.println(i + " PORT IS FREE");
            } catch ( Exception e ) {
                System.out.println(i + " PORT IS NOT FREE");
            }
        }
    } 
}
