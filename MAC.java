import java.io.*;
import java.net.*;
public class MAC {

    public static void main(String[] args) throws Exception{
        Process process = Runtime.getRuntime().exec("route print");
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String msg;

        while ( (msg = br.readLine()) != null ) {
            if ( msg.equals("Active Routes:") ) {
                msg = br.readLine();
                msg = br.readLine();
                System.out.println(msg);
                break;
            };
        }

        Process p2 = Runtime.getRuntime().exec("arp -a");
        BufferedReader in = new BufferedReader(new InputStreamReader(p2.getInputStream()));
        
    
        

    }
    
}
