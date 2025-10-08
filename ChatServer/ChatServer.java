package ChatServer;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

        

public class ChatServer {
    
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(42069);

        Socket socket1 = serverSocket.accept();
        Socket socket2 = serverSocket.accept();

        BufferedReader in1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
        BufferedReader in2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
        PrintWriter out1 = new PrintWriter(socket1.getOutputStream(), true);
        PrintWriter out2 = new PrintWriter(socket2.getOutputStream(), true);

        new Thread(() -> forward(in1, out2, "CLIENT1")).start();;
        new Thread(() -> forward(in2, out1, "CLIENT2")).start();

    }

    static void forward(BufferedReader in, PrintWriter out, String name){ 
        try {

            String message;;
            while ( (message = in.readLine()) != null ) {
                out.println(name + ": " + message);
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}
