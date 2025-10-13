package RMIPractice;
import java.rmi.registry.*;
public class Server {
    public static void main(String[] args) throws Exception{
        Registry registry = LocateRegistry.createRegistry(1099);

        Management mgmt = new Management();
        registry.bind("mgmt", mgmt);

        System.out.println("SERVER STARTED");
    } 
}
