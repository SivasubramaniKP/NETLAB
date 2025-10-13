package IPValidator;

import java.util.Scanner;
import java.util.regex.*;

public class Index {
    public static void main(String[] args) {
        String ipregex = "^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$";

        Scanner sc = new Scanner(System.in);
        while ( true ) {
            String ip = sc.nextLine();
            if ( Pattern.matches(ipregex, ip) ) {
                System.out.println("VALID IP");
            } else {
                System.out.println("NOT A VALID IP");
            }
        }
    } 
}
