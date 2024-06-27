package com.example.HR.Service;

import com.example.HR.Model.Employee;
import com.example.HR.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired //Spring bu alanı otomatik olarak inject/enjekte eder.
    private EmployeeRepository employeeRepository;

    public Employee hireEmployee(Employee employee) {
        //Yeni bir çalışanı veritabanına kaydeder.jpa'den gelen save methodu ile kaydeder
        return employeeRepository.save(employee);
        //CRUD'un C harfini temsil eder
    }

    public List<Employee> getAllEmployees() { //tüm çalışanları getir
        // Tüm çalışanları veritabanından "findAll" methodu ile getirir.
        // CRUD'un R harfini temsil eder(oluşturma)
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        //Belirtilen id deki çalışanı veritabanından getirir.
        // CRUD'un U harfini temsil eder(listeleme)
        return employeeRepository.findById(id);


    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {

        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Çalışan bulunamadı"));

        // orElse yani if döngüsünün else kısmı gibi düşünülebilir.Aranan çalışan bulunmadığındanda kullanıcıya bu metini döndürür.
        employee.setName(employeeDetails.getName());
        employee.setPosition(employeeDetails.getPosition());
        return employeeRepository.save(employee);
    }

    public void fireEmployee(Long id){

        //Belirtilen kimlikteki çalışanı silen metottur.
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Çalışan bulunamadı"));

        //silme işlemini yapan "delete" methodunu JPA repository içerisinden çağırarak kullandık.
        employeeRepository.delete(employee);
    }


}
