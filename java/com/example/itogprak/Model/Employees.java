package com.example.itogprak.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fio;
    private String phone;
    private int experience;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Shop shopemployees;
    @ManyToOne(optional = true)
    private Warehouse werehouseemployees;

    public Employees(){

    }

    public Employees(long id, String fio, String phone, int experience, Shop shopemployees, Warehouse werehouseemployees){
        this.id = id;
        this.fio = fio;
        this.phone = phone;
        this.experience = experience;
        this.shopemployees = shopemployees;
        this.werehouseemployees = werehouseemployees;
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

    public Shop getShopemployees() {
        return shopemployees;
    }

    public void setShopemployees(Shop shopemployees) {
        this.shopemployees = shopemployees;
    }

    public Warehouse getWerehouseemployees() {
        return werehouseemployees;
    }

    public void setWerehouseemployees(Warehouse werehouseemployees) {
        this.werehouseemployees = werehouseemployees;
    }
}
