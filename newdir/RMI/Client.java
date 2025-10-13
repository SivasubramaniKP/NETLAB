package RMI;
import java.rmi.registry.*;
public class Client {
   public static void main(String[] args)throws Exception{
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        CalcInterface calc = (CalcInterface) registry.lookup("calc");

        System.out.println(calc.add(10, 20));
   } 
}
