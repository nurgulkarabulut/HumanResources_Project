package com.example.HR.Repository;

import com.example.HR.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Bu anotasyon bu sınıfın bir Spring veritabanı deposu olduğunu gösterir
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
//Jpa---> Crud(oluşturma, okuma, güncelleme ve silme) işlerimleri için gerekli methodları sağlar.
//CRUD---> Create, Read, Update, Delete
