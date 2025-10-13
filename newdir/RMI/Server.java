package RMI;
import java.rmi.registry.*;
public class Server {
   public static void main(String[] args) throws Exception{
        Calculator calc = new Calculator();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("calc", calc);

        System.out.println("SERVER STARTED");

   } 
}
