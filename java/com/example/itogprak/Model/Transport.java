package com.example.itogprak.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Transport")
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String brand;
    private String model;
    private String statenumber;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Provider providertransport;
    @OneToOne(optional = true)
    @JoinColumn(name="driver_id")
    private Driver driver;


    public Transport(){

    }

    public Transport(long id, String brand, String model, String statenumber, Provider providertransport, Driver driver){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.statenumber = statenumber;
        this.providertransport = providertransport;
        this.driver = driver;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatenumber() {
        return statenumber;
    }

    public void setStatenumber(String statenumber) {
        this.statenumber = statenumber;
    }

    public Provider getProvidertransport() {
        return providertransport;
    }

    public void setProvidertransport(Provider providertransport) {
        this.providertransport = providertransport;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
