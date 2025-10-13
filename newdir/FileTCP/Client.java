package FileTCP;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 42069);
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while ( true ) {
            System.out.println("Enter the file name ");
            String file = sc.nextLine();
            out.println(file);

            String resp = in.readLine();
            if ( resp.equals("FILE_NOT_FOUND") ) {
                System.out.println("FILE NOT FOUND");
                continue;
            } else {
                System.out.println(resp);
                while ( (resp = in.readLine()) != null && !resp.equals("EOF")) {
                    System.out.println(resp);
                }
            }
        }

    }
}
