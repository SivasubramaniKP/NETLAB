package FileUDP;

import java.net.*;

public class Client {
        public static void main(String[] args) throws Exception{
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");

            String hello = "Hello from Client";
            byte [] buffer = hello.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, 42069);
            socket.send(packet);

            buffer = new byte[1024];
            DatagramPacket packet2 = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet2);

            String serversResponse = new String(packet2.getData(), 0, packet2.getLength());
            System.out.println(serversResponse);

            socket.close();
        }
}
