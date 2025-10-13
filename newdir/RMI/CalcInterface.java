package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalcInterface extends Remote{
    public int add(int a, int b) throws RemoteException;
    public int sub(int a, int b) throws RemoteException;
   public int mult(int a, int b) throws RemoteException;
    public int divide(int a, int b) throws RemoteException;
}