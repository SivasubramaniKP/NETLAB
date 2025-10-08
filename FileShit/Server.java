package FileShit;

import java.io.*;
import java.net.*;
import java.util.*;

class ClientHandler implements Runnable {
    Socket socket = null;

    ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override 
    public void run(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String filename = reader.readLine();
            File file = new File("FileShit/" + filename);

            if( !file.exists() ){
                System.out.println("FILE NOT EXISTS");
                writer.println("FILE_NOT_FOUND");
            } else {
                writer.println("FILE_FOUND");
                Scanner sc = new Scanner(file);
                while ( sc.hasNextLine() ) {
                    writer.println(sc.nextLine());
                }
                writer.println("EOF");
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

}

public class Server {
    public static void main(String[] args) throws Exception{
        
        ServerSocket server = new ServerSocket(42069);
        while ( true ) {
            Socket socket = server.accept();
            ClientHandler ch = new ClientHandler(socket);
            Thread thread = new Thread(ch);
            thread.start();
        }
    } 
}
