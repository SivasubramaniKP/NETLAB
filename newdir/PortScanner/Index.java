package PortScanner;

import java.io.*;
import java.net.*;
import java.util.*;

class Index {

    public static void main(String[] args) {
        int start = 1, end = 1024;
        for ( int i = start; i <= end; i++ ) {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress("localhost", i), 500);
                System.out.println("PORT " + i +" is open");
            } catch ( Exception e ) {
                System.out.println("PORT" + i +" is OCCUPIED");
            }
        }        
    }
}