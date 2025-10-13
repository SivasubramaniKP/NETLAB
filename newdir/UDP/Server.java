package UDP;

import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Server {
    
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(42069);

        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);

        String filename = new String(packet.getData(), 0, packet.getLength());
        System.out.println("REQUESTED FILE " + filename);
        InetAddress addr = packet.getAddress();
        int PORT = packet.getPort();
        
        if ( !new File(filename).isFile() ) {
           buffer = "FILE_NOT_FOUND".getBytes();
           System.out.println("FILE NOT FOUND");
           packet = new DatagramPacket(buffer, buffer.length, addr, PORT);
           socket.send(packet);
        } else {
            Scanner sc = new Scanner(new File(filename));
            System.out.println("FILE FOUND");
            ArrayList<DatagramPacket> packets = new ArrayList<>();
            String content = "";
            while ( sc.hasNextLine() ) {
                String line = sc.nextLine();
                System.out.println(line);
                content = content + line;
                packet = new DatagramPacket(line.getBytes(), line.getBytes().length, addr, PORT);
                packets.add(packet);
            }
            for ( DatagramPacket p: packets ) {
                while ( true ) {
                    socket.send(p);
                    System.out.println("SENDING PACKET");
                    byte[] ackBuf = new byte[1024];
                    DatagramPacket ack = new DatagramPacket(ackBuf, ackBuf.length);
                    socket.receive(ack);
                    String response = new String(ack.getData(), 0, ack.getLength());

                    if ( response.equals("YES") ) {
                        break; 
                    }
                    System.out.println(
                        "RECEIVED ACK"
                    );
                }
            }
            socket.send(new DatagramPacket("EOF".getBytes(), "EOF".getBytes().length, addr, PORT));
        }
    }
}
