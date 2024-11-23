package com.example.itogprak.Model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "Warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int capacity;
    private String Address;
    @OneToOne(optional = true, mappedBy = "warehouse")
    private Shop shop;
    @OneToMany (mappedBy = "werehouseemployees", fetch = FetchType.EAGER)
    private Collection<Employees> employeesid;
    @OneToMany (mappedBy = "werehouseproduct", fetch = FetchType.EAGER)
    private Collection<Product> productid;
    @OneToOne(optional = true)


    @JoinColumn(name="provider_id")
    private Provider provider;


    public Warehouse(){

    }

    public Warehouse(long id, int capacity, String Address, Shop storage, Shop shop, Collection<Employees> employeesid, Collection<Product> productid, Provider provider){
        this.id = id;
        this.capacity = capacity;
        this.Address = Address;
        this.shop = shop;

        this.employeesid = employeesid;
        this.productid = productid;
        this.provider = provider;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }



    public Collection<Employees> getEmployeesid() {
        return employeesid;
    }

    public void setEmployeesid(Collection<Employees> employeesid) {
        this.employeesid = employeesid;
    }

    public Collection<Product> getProductid() {
        return productid;
    }

    public void setProductid(Collection<Product> productid) {
        this.productid = productid;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
