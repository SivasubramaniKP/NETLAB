package TCP;
import java.net.*;
import java.util.Date;
import java.io.*;


class ClientHandler implements Runnable{
    private Socket socket = null;
    
    ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String clientMessage = null;

            while( (clientMessage = bufferedReader.readLine()) != null){
                int message = Integer.parseInt(clientMessage);
                switch (message) {
                    case 1:
                        System.out.println("CLIENT REQUESTED TIME");
                        Date date = new Date();
                        System.out.println("DATE NOW IS " + date.toString());
                        bufferedWriter.write(date.toString() + "\n");
                        bufferedWriter.flush();
                        break;
                    case 2:
                        String echoMessage = bufferedReader.readLine();
                        bufferedWriter.write(echoMessage + "\n");
                        bufferedWriter.flush();
                        break;
                    case 3:
                        break;
                    default:
                        break;
                }
            }

            bufferedReader.close();
            bufferedWriter.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

class Server {
    static private int PORT = 42069;
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            
            while ( true ){
                Socket socket = serverSocket.accept();
                System.out.println("CLIENT CONNECTED :  " + socket.getInetAddress().toString());
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread clientThread = new Thread(clientHandler);
                clientThread.start();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}