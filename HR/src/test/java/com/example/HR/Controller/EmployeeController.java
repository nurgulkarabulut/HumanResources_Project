package com.example.HR.Controller;

import com.example.HR.Model.Employee;
import com.example.HR.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//bu anotasyon bu sınıfın bir control sınıfı/RESTful web servisi olduğunu gösterir.
@RequestMapping("/api/employees")
//Temel URL'ini belirtir.
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/hire")
    //Bu anotasyon ile işaretlenen bu metot, bir çalışanı işe almak için kullanılır.
    public Employee hireEmployee(@RequestBody Employee employee) {
        return employeeService.hireEmployee(employee);
    }

    @GetMapping
    /*çalışanları getirmek için servis sınıfımızdan oluşturduğumuz "getAllEmployees"
    methodunu çağırarak döndürüyoruz. */
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }


}
