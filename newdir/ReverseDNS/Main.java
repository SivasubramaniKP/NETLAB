package ReverseDNS;

import java.net.InetAddress;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the domain to resolve");
        String domain =  sc.nextLine();
        System.out.println("IP of the domain : " + InetAddress.getByName(domain));
        System.out.println("Enter the IP to reverse DNS");

        String ip = sc.nextLine();

        System.out.println("Host name is " + InetAddress.getByName(ip).getHostName());
    } 
}
