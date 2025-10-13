package Chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.tree.ExpandVetoException;

import java.io.PrintWriter;

public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket socket = new ServerSocket(42069);

        Socket client1 = socket.accept();
        Socket client2 = socket.accept();

        BufferedReader in1 = new BufferedReader(new InputStreamReader(client1.getInputStream()));
        PrintWriter out1 = new PrintWriter(client1.getOutputStream(), true);
        BufferedReader in2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));
        PrintWriter out2 = new PrintWriter(client2.getOutputStream(), true);

        new Thread(() -> forward(in1, out2, "User 1")).start();
        new Thread(() -> forward(in2, out1, "User 1")).start();
    }

    public static void forward(BufferedReader in, PrintWriter out, String outname) {

        String msg;
        try {
            while ( (msg = in.readLine()) != null ) {
                out.println(outname + ": "+ msg);
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}
