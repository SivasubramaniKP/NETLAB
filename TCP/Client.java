package TCP;

import java.net.*;
import java.util.Scanner;
import java.io.*;

class ServerListener implements Runnable {
    Socket socket = null;
    private BufferedReader bufferedReader;
    ServerListener(Socket socket) {
       this.socket = socket;
    }

    @Override
    public void run(){
        String message = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while ( (message = bufferedReader.readLine()) != null)  
            {
                System.out.println(message);
            }
            bufferedReader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
}

class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 42069);

        ServerListener listener = new ServerListener(socket);
        Thread listenerThread = new Thread(listener);
        listenerThread.start();

        Scanner sc = new Scanner(System.in);
        int userinput;
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        System.out.println("Enter 1 for time");
        System.out.println("Enter 2 for Echo");
        System.out.println("Enter 3 for Exit");
        while (true)  {
            userinput = sc.nextInt();
            if ( userinput == 1 ){
                bufferedWriter.write("1\n");
                bufferedWriter.flush();
            } else if ( userinput == 2 ){
                bufferedWriter.write("2\n");
                bufferedWriter.flush();
                String echoMessage = sc.nextLine();
                bufferedWriter.write(echoMessage);;
                bufferedWriter.flush();
            } else {
                break;
            }
        }
        sc.close();
    } 
}