package com.example.HR.Controller;

import com.example.HR.Model.Employee;
import com.example.HR.Service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Yeni personel kaydı yapar.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Personel başarıyla kaydedildi"),
            @ApiResponse(responseCode = "400", description = "Hatalı istek")
    })

    //Bu anotasyon ile işaretlenen bu metot, bir çalışanı işe almak için kullanılır.
    public Employee hireEmployee(@RequestBody Employee employee) {
        return employeeService.hireEmployee(employee);
    }

    @GetMapping
    @Operation(summary = "Tüm personelleri getirip listeler")
    /*çalışanları getirmek için servis sınıfımızdan oluşturduğumuz "getAllEmployees"
    methodunu çağırarak döndürüyoruz. */
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Belirli bir personeli id numarasına göre getirip listeler.")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Bir personelin bilgilerini günceller.")
    //Belirtilen kimlikteki çalışan bilgilerini bu metod ile güncelliyoruz.
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        return employeeService.updateEmployee(id, employeeDetails);
    }

    @DeleteMapping("/fire/{id}")
    @Operation(summary = "Bir personeli siler")
    public void fireEmployees(@PathVariable Long id) {
        employeeService.fireEmployee(id);
    }


}
