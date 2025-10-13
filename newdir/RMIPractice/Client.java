package RMIPractice;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws Exception{
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        SMS sms = (SMS) registry.lookup("mgmt");

        sms.addStudent(null);
        sms.removeStudent(null);
        ArrayList<Student> recs = sms.DB;
    } 
}
