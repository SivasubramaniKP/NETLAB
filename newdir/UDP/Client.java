package UDP;
import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws Exception {
        InetAddress serverAddress = InetAddress.getByName("localhost");
        int PORT = 42069;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file name");
        String filename = sc.nextLine();

        DatagramSocket socket = new DatagramSocket();
        DatagramPacket packet = new DatagramPacket(filename.getBytes(), filename.getBytes().length, serverAddress, PORT);
        socket.send(packet);

        byte [] buffer = new byte[1024];
        packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        String resp = new String(packet.getData(), 0, packet.getLength());
        if ( resp.equals("FILE_NOT_FOUND") ) {
            System.out.println("FILE NOT FOUND");
        } else {
            PrintWriter out = new PrintWriter("download_");
            out.println(resp);

            System.out.println(resp);
            socket.send(new DatagramPacket("YES".getBytes(), "YES".getBytes().length, serverAddress, PORT));
            System.out.println("SENT ACK");
            while ( !resp.equals("EOF") ) {
                buffer = new byte[1024];
                packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                System.out.println("GOT PACKET");
                out.println(new String(packet.getData(), 0, packet.getLength()));
                socket.send(new DatagramPacket("YES".getBytes(), "YES".getBytes().length, serverAddress, PORT));
                System.out.println("SENT ACK");
                resp = new String(packet.getData(), 0, packet.getLength());
                System.out.println(resp);
            }
            out.close();
        }
    } 
}
