package RMIPractice;

import java.rmi.*;


public interface CalculatorInterface extends Remote {
    int add(int a, int b) throws RemoteException;
    int sub(int a, int b) throws RemoteException;
    int multi(int a, int b) throws RemoteException;
    int divide(int a, int b) throws RemoteException;
}