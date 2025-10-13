package Chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 42069);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream() , true);

        new Thread(() -> {
            try {
                String incoming;
                while( (incoming = in.readLine()) != null )  {
                    System.out.println(incoming);
                }
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        }).start();

        Scanner sc = new Scanner(System.in);
        String userinput = "";

        while ( !userinput.equals("EXIT") ) {
            userinput = sc.nextLine();
            out.println(userinput);
        }
    }    
}
