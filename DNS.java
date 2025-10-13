import java.io.*;
import java.net.*;
import java.util.Scanner;
public class DNS {
    
        public static void main(String[] args) throws Exception{
            Process process = Runtime.getRuntime().exec("ipconfig /all");

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String msg;


            while( (msg = reader.readLine()) != null ) {
                if ( msg.contains("DNS Server") ) {
                    System.out.println(msg);
                }
            }

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a domain name");
            String domain  = sc.nextLine();

            InetAddress addr = InetAddress.getByName(domain);
            String hostname = addr.getHostName();
            String address = addr.getHostAddress();

            System.out.println(hostname);
            System.out.println(address);
        }
}
