package com.jc;

import com.jc.model.Employee;
import com.jc.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

/*
 *  DB --> JDBC --> Hibernate --> Spring Data JPA
 * */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);

        var employeeRepo = context.getBean(EmployeeRepository.class);


        List<Employee> employees = List.of(
                new Employee(null, "employee1", LocalDate.now(), true),
                new Employee(null, "employee2", LocalDate.now(), false),
                new Employee(null, "employee3", LocalDate.now(), true),
                new Employee(null, "employee4", LocalDate.now(), false),
                new Employee(null, "employee5", LocalDate.now(), true)
        );

        employeeRepo.saveAll(employees);

        employeeRepo.findAllbyMarriedTrue().forEach(System.out::println);
    }
}
