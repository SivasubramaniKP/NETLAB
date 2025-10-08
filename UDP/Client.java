package UDP;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("localhost");
        byte[] buffer = new byte[1024];

        String trigger = "SEND_FILE";
        byte[] triggerData = trigger.getBytes();
        DatagramPacket packet = new DatagramPacket(triggerData, triggerData.length, addr, 42069);
        socket.send(packet);

        System.out.println("RECEIVING FILE");

        PrintWriter writer = new PrintWriter("download_");
        while ( true ) {
            DatagramPacket packet2 = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet2);
            String line = new String(packet2.getData(), 0, packet2.getLength());
            if ( "EOF".equals(line) ) {
                break;
            }
            writer.println(line);
        }

        System.out.println("FILE RECEIVED");
        writer.close();;
        socket.close();

    }
}
