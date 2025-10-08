package RMIPractice;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(1099);

        Calculator calc = new Calculator();

        registry.bind("CalcService", calc);

        System.out.println("RMI IS RUNNING ON PORT 1099");;
    }
    
}
