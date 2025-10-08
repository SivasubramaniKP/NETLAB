package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            // Create RMI registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            
            // Create remote object
            CalculatorImpl calculator = new CalculatorImpl();
            
            // Bind the remote object to registry
            registry.rebind("CalculatorService", calculator);
            
            System.out.println("RMI Server is running on port 1099...");
            System.out.println("CalculatorService is ready!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}