package com.example.itogprak.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fio;
    private String phone;
    private int experience;
    @OneToOne(optional = true, mappedBy = "driver")
    private Transport transport;

    public Driver(){

    }

    public Driver(long id, String fio, String phone, int experience, Transport transport){
        this.id = id;
        this.fio = fio;
        this.phone = phone;
        this.experience = experience;
        this.transport = transport;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }
}
