package com.example.HR.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // bu anotasyon bu sınıfın bir veritabanı sınıfı tablosuna karşılık geldiğini gösterir
public class Employee {

    @Id //bu anotasyon id alanının birincil anahtar olduğunu belirtir
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //bu anotasyon id alanının otomatik olarak artırılacağını belirtir

    private long Id; //çalışanın benzersiz kimliği
    private String firstName; //çalışanın adı
    private String lastName;
    private String jobTitle;
    private String iban;


    /*Getter ve Setter metotları getter özel alanların değerini okumak için kullanılır
      setter özel alanların değerini ayarlamak için kullanılır
      */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

}
