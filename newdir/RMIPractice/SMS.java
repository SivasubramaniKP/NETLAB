package RMIPractice;
import java.rmi.*;
import java.util.*;
class Student {
    String name;
    String regno;
    int age;
    double GPA;

    Student(String name, String regno, int age, double GPA) {
        this.name = name;
        this.regno = regno;
        this.age = age;
        this.GPA = GPA;
    }
}
public interface SMS extends Remote {
    public ArrayList<Student> DB = null;
    public void addStudent(Student s) throws RemoteException;
    public void removeStudent(String regno) throws RemoteException;
    public void generateReport() throws RemoteException;
}
