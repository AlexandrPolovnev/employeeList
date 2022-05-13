package pro.sky.java.course2.employeelist;


import org.springframework.stereotype.Service;
import pro.sky.java.course2.EmployeeException.EmployeeExistsException;
import pro.sky.java.course2.EmployeeException.EmployeeIndexOutOfBoundsException;
import pro.sky.java.course2.EmployeeException.EmployeeNotFoundException;

import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = List.of(


            new Employee("Sergey", "Petrov"),
            new Employee("Mikhail", "Antonov"),
            new Employee("Alexey", "Sorokin"),
            new Employee("Maxim", "Diveev"),
            new Employee("Arthur", "Kim"),
            new Employee("Oleg", "Vasin"),
            new Employee("Svetlana", "Frolova"),
            new Employee("Dmitriy", "Chertov"),
            new Employee("Natasha", "Krylova"),
            new Employee("Petr", "Denisov")
    );


    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        int index = -1;
        boolean take = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) == null && !take) {
                index = i;
                take = true;
            }
            if (employees.get(i).equals(employee)) {
                throw new EmployeeExistsException();
            }
        }
        if (index != -1) {
            employees.set(index, employee);
        } else {
            throw new EmployeeIndexOutOfBoundsException();
        }
        return employee;
    }

    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).equals(employee)) {
                employees.set(i, null);
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }


    public Employee searchEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).equals(employee)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }
    public List<Employee> showListOfEmployee() {
        return employees;
    }
}