package com.example.HR.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // bu anotasyon bu sınıfın bir veritabanı sınıfı tablosuna karşılık geldiğini gösterir
public class Employee {

    @Id //bu anotasyon id alanının birincil anahtar olduğunu belirtir
    @GeneratedValue(strategy = GenerationType.IDENTITY) //bu anotasyon id alanının otomatik olarak artırılacağını belirtir

    private long Id; //çalışanın benzersiz kimliği
    private String name; //çalışanın adı
    private String position; //çalışanın pozisyonu

    /*Getter ve Setter metotları
    getter özel alanların değerini okumak için kullanılır
    setter özel alanların değerini ayarlamak için kullanılır
     */

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
