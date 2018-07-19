package java8features.streams.match;

import java.util.List;
import java.util.function.Predicate;

public class MatchDemo {
    public static void main(String[] args) {
        Predicate<Employee> p1 = employee -> employee.getId ( ) < 10 && employee.getName ( ).startsWith ( "A" );
        Predicate<Employee> p2 = employee -> employee.getSal ( ) < 10000;

        List<Employee> employeeList = Employee.getEmployeeList ();

        boolean flag = employeeList.stream ().allMatch ( p1 );
        System.out.println ( "All match employee.getId ( ) < 10 && employee.getName ( ).startsWith ( \"A\" ) : "+ flag );

        flag = employeeList.stream ().allMatch ( p2 );
        System.out.println ( "All match employee -> employee.getSal ( ) < 10000 : "+ flag );


        flag = employeeList.stream ().anyMatch ( p1 );
        System.out.println ( "Any match employee.getId ( ) < 10 && employee.getName ( ).startsWith ( \"A\" )  : "+ flag );

        flag = employeeList.stream ().anyMatch ( p2 );
        System.out.println ( "Any match employee -> employee.getSal ( ) < 10000 : "+ flag );

        flag = employeeList.stream ().noneMatch ( p1 );
        System.out.println ( "None match employee.getId ( ) < 10 && employee.getName ( ).startsWith ( \"A\" )  : "+ flag );

    }
}
