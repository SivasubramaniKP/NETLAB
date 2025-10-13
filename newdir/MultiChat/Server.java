package MultiChat;
import java.io.*;
import java.net.*;
import java.util.*;
public class Server {

    static HashMap<String, PrintWriter> writers = new HashMap<>();

    static synchronized void broadcast(String user, String message) {
        for ( Map.Entry<String, PrintWriter> entry: writers.entrySet() ) {
            String name = entry.getKey();
            PrintWriter out = entry.getValue();

            if ( !name.equals(user) ) {
                out.println(user + " : " + message);
            }

        }
    }

    static synchronized void addWriter(String username, PrintWriter out) {
        writers.put(username, out);
    }


    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(42069);
        while ( true ) {
            Socket socket = serverSocket.accept();
            System.out.println("client connected");

            new Thread(() -> {
                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String userName = in.readLine();
                    addWriter(userName, out);

                    String user;
                    while ( (user = in.readLine()) != null ) {
                        System.out.println(userName + " SAID : " + user);
                        broadcast(userName, user);
                    }
                } catch ( Exception e ) {
                    System.out.println("DISCONNECTED");
                }
            }).start();
        }

    }

}
