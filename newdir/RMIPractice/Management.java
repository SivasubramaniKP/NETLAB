package RMIPractice;
import java.io.*;
import java.rmi.*;
import java.util.*;
import java.rmi.server.*;
public class Management extends UnicastRemoteObject implements SMS {
    ArrayList<Student> DB = new ArrayList<>();
    
    protected Management() throws RemoteException {
        super();
    }
    public void addStudent(Student s) throws RemoteException {
        System.out.println("Add student is called");
    }
    
    public void removeStudent(String regno)throws RemoteException  {
        System.out.println("Student is removed");
    }

    public void generateReport() throws RemoteException {
        System.out.println("REPORT IS GENERATED");
    }

}
