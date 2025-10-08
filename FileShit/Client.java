package FileShit;

import java.util.Scanner;
import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        Socket socket = new Socket("localhost", 42069);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        System.out.println("Enter the file name to fetch");
        String filename = sc.nextLine();
        writer.println(filename);

        String serverResponse = br.readLine();
        if( serverResponse.equals("FILE_NOT_FOUND") ) {
            System.out.println("FILE NOT FOUND IN THE SERVER");
            return;
        }
        System.out.println("downloading...");
        PrintWriter filewriter = new PrintWriter("downloaded_" + filename);

        String line;
        while( !(line = br.readLine()).equals("EOF") ) {
            filewriter.println(line);
        }
        filewriter.close();

        
    }
    
}
