package ParseConnections;
import java.io.*;
import java.net.*;
import java.util.regex.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Process process = Runtime.getRuntime().exec("netstat -n");

        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String lines;
        in.readLine();
        in.readLine();
        in.readLine();
        in.readLine();
        while ( (lines = in.readLine()) != null  ) {
            String [] tokens = lines.split("\\s+");
            String protocol = tokens[0];
            String localIP = tokens[1];
            String foreignIP = tokens[2];
            String connStatus = tokens[3];
        }

    } 
}
