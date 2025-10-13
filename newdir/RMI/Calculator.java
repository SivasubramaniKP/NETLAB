package RMI;
import java.rmi.server.*;
import java.rmi.*;
public class Calculator extends UnicastRemoteObject implements CalcInterface {
    protected Calculator() throws RemoteException {
        super();
    }
    public int add( int a, int b ) throws RemoteException {
        return a + b;
    } 
    public int sub( int a, int b ) throws RemoteException {
        return a - b;
    } 
    public int mult( int a, int b ) throws RemoteException {
        return a * b;
    } 
    public int divide( int a, int b ) throws RemoteException {
        return a / b;
    } 
}
