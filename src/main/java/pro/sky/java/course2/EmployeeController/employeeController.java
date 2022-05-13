package pro.sky.java.course2.EmployeeController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.EmployeeException.EmployeeNotFoundException;
import pro.sky.java.course2.employeelist.Employee;
import pro.sky.java.course2.employeelist.EmployeeService;

import java.util.List;

@RestController
@RequestMapping(path="/employee")

public class employeeController {

    private final EmployeeService employeeService;
    public employeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path="/add")
    public Object addEmployee (@RequestParam("firstName")String firstName,
                               @RequestParam("lastName") String lastName) {
        try {
            return employeeService.addEmployee(firstName, lastName);
        } catch (Exception a) {
            return "500 Internal Server Error";
        }
    }
    @GetMapping (path="/delete")
    public Employee deleteEmployee (@RequestParam ("firstName")String firstName,
                                    @RequestParam("lastName") String lastName) {
        return employeeService.deleteEmployee(firstName, lastName);
    }
    @GetMapping (path="/search")
    public Object SearchEmployee (@RequestParam ("firstName")String firstName,
                                  @RequestParam("lastName") String lastName) {
        try {
            return employeeService.searchEmployee(firstName, lastName);
        } catch (ArrayIndexOutOfBoundsException | EmployeeNotFoundException a) {
            return "404 Not Found";
        }
    }
    @GetMapping("/list")
    public List<Employee> showListOfEmployee() {
        return employeeService.showListOfEmployee();
    }
}
