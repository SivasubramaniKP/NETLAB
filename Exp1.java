import java.net.*;

public class Exp1 {
    
    public static void main(String[] args) throws Exception{
        String addr = InetAddress.getLocalHost().getHostAddress();
        String name = InetAddress.getLocalHost().getHostName();

        System.out.println(addr);
        System.out.println(name);


    }
}
