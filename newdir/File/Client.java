package File;
import java.io.PrintWriter;
import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    private static int PORT = 42069;
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("localhost");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the filename to retrieve");
        String filename = sc.nextLine();

        byte[] buffer = filename.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, PORT); 
        socket.send(packet);

        buffer = new byte[1024];
        packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        String response = new String(packet.getData(), 0, packet.getLength());

        if ( response.equals("FILE_NOT_FOUND") ) {
            System.out.println("FILE NOT FOUND");
        } else {
            PrintWriter filOut = new PrintWriter(new File("./downloaded/" + filename));
            filOut.println(response);
            while ( !response.equals("EOF") ) {
                buffer = new byte[1024];
                packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                response = new String(packet.getData(), 0, packet.getLength());
                filOut.println(response);
            }
            filOut.close();
        }
    }
}
