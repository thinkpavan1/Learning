package java8features.streams;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private int sal;
    private Address address;

    public Employee(int id, String name, int sal, Address address) {
        this.id = id;
        this.name = name;
        this.sal = sal;
        this.address = address;
    }

    public Employee(int id, String name, int sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSal() {
        return sal;
    }

    public static List<Employee> getEmployeeList(){
        Address a1 = new Address(1314,"Olof");
        Address a2 = new Address(1315,"Almere");

        List<Employee> list = new ArrayList<> (  );
        list.add ( new Employee ( 1,"A",1000 ,a1) );
        list.add ( new Employee ( 2,"B",2000 ,a1) );
        list.add ( new Employee ( 3,"C",3000 ,a1) );
        list.add ( new Employee ( 4,"D",4000 ,a1) );
        list.add ( new Employee ( 5,"E",5000 ,a2) );
        return list;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sal=" + sal +
                ", address=" + address +
                '}';
    }
}
