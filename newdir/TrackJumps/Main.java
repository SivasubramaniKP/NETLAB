package TrackJumps;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the domain to trace");
        String domain = sc.nextLine();
        String command = "tracert " + domain;
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String lines;
        in.readLine();
        in.readLine();
        in.readLine();
        in.readLine();
        while ( (lines = in.readLine()) != null ) {
            String [] tokens = lines.split("\\s\\s+");
            String hopNo = tokens[0];
            System.out.println(hopNo);
            String probe1 = tokens[1];
            System.out.println(probe1);
            String probe2 = tokens[2];
            System.out.println(probe2);
            String probe3 = tokens[3];
            System.out.println(probe3);
            String ip = tokens[4];
            System.out.println(ip);


            if ( probe1.equals("*") ) {
                continue;
            }
            System.out.println(lines);
        }
    } 
}
