package FileUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(42069);
        byte [] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        InetAddress clientAddress = packet.getAddress();
        int port = packet.getPort();
        System.out.println("Received Packet from client " + packet.getAddress() + " DATA : " + packet.getData());
        String responseMessage = "Hello from the other side";
        buffer = responseMessage.getBytes();
        packet = new DatagramPacket(buffer, buffer.length, clientAddress, port);
        socket.send(packet);

    }
}
