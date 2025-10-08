package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RMIClient {
    public static void main(String[] args) {
        try {
            // Connect to RMI registry on localhost:1099
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            
            // Lookup the remote object
            CalculatorInterface calculator = (CalculatorInterface) registry.lookup("CalculatorService");
            
            Scanner scanner = new Scanner(System.in);
            
            while (true) {
                System.out.println("\n=== RMI Calculator ===");
                System.out.println("1. Add");
                System.out.println("2. Subtract");
                System.out.println("3. Multiply");
                System.out.println("4. Divide");
                System.out.println("5. Exit");
                System.out.print("Choose operation: ");
                
                int choice = scanner.nextInt();
                
                if (choice == 5) break;
                
                System.out.print("Enter first number: ");
                int a = scanner.nextInt();
                System.out.print("Enter second number: ");
                int b = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        System.out.println("Result: " + calculator.add(a, b));
                        break;
                    case 2:
                        System.out.println("Result: " + calculator.subtract(a, b));
                        break;
                    case 3:
                        System.out.println("Result: " + calculator.multiply(a, b));
                        break;
                    case 4:
                        try {
                            System.out.println("Result: " + calculator.divide(a, b));
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
            
            scanner.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
