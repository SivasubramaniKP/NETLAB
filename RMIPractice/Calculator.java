package RMIPractice;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class Calculator extends UnicastRemoteObject implements CalculatorInterface {
    protected Calculator() throws RemoteException {
        super();
    }

    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
    public int sub(int a, int b) throws RemoteException {
        return a - b;
    }
    public int multi(int a, int b) throws RemoteException {
        return a * b;
    }
    public int divide(int a, int b) throws RemoteException {
        return a / b;
    }
}