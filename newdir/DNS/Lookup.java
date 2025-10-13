package DNS;

import java.util.*;
import java.io.*;
import java.net.*;
public class Lookup {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the domain to resolve");
        String domain = sc.nextLine();

        try {
            InetAddress addr = InetAddress.getByName(domain);
            System.out.println(InetAddress.getLocalHost());
        } catch ( Exception e ) {
            System.out.println("DOMAIN NOT FOUND");
        }

    }
}
