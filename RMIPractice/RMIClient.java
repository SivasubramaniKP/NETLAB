package RMIPractice;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);

        CalculatorInterface calc = (CalculatorInterface) registry.lookup("CalcService");

        System.out.println(calc.add(10, 20));
    }
    
}
