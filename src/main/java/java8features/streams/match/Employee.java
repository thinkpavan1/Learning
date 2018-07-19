package java8features.streams.match;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private int sal;

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
        List<Employee> list = new ArrayList<> (  );
        list.add ( new Employee ( 1,"A",1000 ) );
        list.add ( new Employee ( 2,"B",2000 ) );
        list.add ( new Employee ( 3,"C",3000 ) );
        list.add ( new Employee ( 4,"D",4000 ) );
        list.add ( new Employee ( 5,"E",5000 ) );
        return list;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sal=" + sal +
                '}';
    }
}
