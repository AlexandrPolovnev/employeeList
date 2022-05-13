package pro.sky.java.course2.EmployeeException;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeIndexOutOfBoundsException extends RuntimeException{
}
