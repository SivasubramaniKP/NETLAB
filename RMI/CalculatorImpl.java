package RMI;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements CalculatorInterface {
    
    protected CalculatorImpl() throws RemoteException {
        super();
    }
    
    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
    
    @Override
    public int subtract(int a, int b) throws RemoteException {
        return a - b;
    }
    
    @Override
    public int multiply(int a, int b) throws RemoteException {
        return a * b;
    }
    
    @Override
    public double divide(int a, int b) throws RemoteException {
        if (b == 0) throw new RemoteException("Cannot divide by zero");
        return (double) a / b;
    }
}
