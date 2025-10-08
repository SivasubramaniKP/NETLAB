package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.io.*;

public class Server {
   public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(42069);
        byte buffer[] = new byte[1024];

        System.out.println("WAITING FOR CLIENT");

        DatagramPacket request = new DatagramPacket(buffer, buffer.length);
        socket.receive(request);
        
        InetAddress clientAddress = request.getAddress();
        int port = request.getPort();;

        Scanner fileScanner = new Scanner(new File("UDP/purity.txt"));
        while ( fileScanner.hasNextLine() ) {
            String line = fileScanner.nextLine();
            byte[] lineData = line.getBytes();
            DatagramPacket packet = new DatagramPacket(lineData, lineData.length, clientAddress, port);
            socket.send(packet);
            Thread.sleep(1);
        }

        String eof = "EOF";

        byte[] eofData = eof.getBytes();
        DatagramPacket packet = new DatagramPacket(eofData, eofData.length, clientAddress, port);
        socket.send(packet);

        System.out.println("FILE SENT");
        fileScanner.close();
        socket.close();
       } 
}
