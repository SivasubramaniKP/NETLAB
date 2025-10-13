package File;

import java.net.*;
import java.util.Scanner;
import java.io.*;
public class Server {
    
    public static void main(String[] args) throws Exception{
        DatagramSocket serversocket = new DatagramSocket(42069);

        byte[] fileNameBuffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(fileNameBuffer, fileNameBuffer.length);
        serversocket.receive(packet);
        String filename = new String(packet.getData(), 0, packet.getLength());

        InetAddress clientAddres = packet.getAddress();
        int PORT = packet.getPort();

        if ( !new File(filename).isFile() ) {
            byte[] buffer = "FILE_NOT_FOUND".getBytes();
            packet = new DatagramPacket(buffer, buffer.length, clientAddres, PORT);
            serversocket.send(packet);
        } else {
            Scanner sc = new Scanner(new File(filename));
            while ( sc.hasNextLine() ) {
                String nextline = sc.nextLine();
                System.out.println(nextline);
                byte [] buffer = nextline.getBytes();
                packet = new DatagramPacket(buffer, buffer.length, clientAddres, PORT);
                serversocket.send(packet);
            }
            byte[] buffer = "EOF".getBytes();
            packet = new DatagramPacket(buffer, buffer.length, clientAddres, PORT);
            serversocket.send(packet);
            sc.close();
        }
    }
}
