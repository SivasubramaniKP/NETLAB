package SendShit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

class ClientHandler implements Runnable {
    private Socket socket = null;
    ClientHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

            String clientMessage = null;

            while( (clientMessage = bufferedReader.readLine()) != null ) {
                int message = Integer.parseInt(clientMessage);
                switch (message) {
                    case 1:
                        Date date = new Date();
                        printWriter.println(date.toString()); 
                        break;
                    case 2:
                        clientMessage = bufferedReader.readLine();
                        System.out.println("CLIENT MESSAGE IS " + clientMessage);
                        printWriter.println(clientMessage);
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Server {
    
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(42069);

        while( true ) {
            Socket socket = serverSocket.accept();
            Thread clienThread = new Thread(new ClientHandler(socket));
            clienThread.start();
        }
    }
}
