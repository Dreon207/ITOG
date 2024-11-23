package com.example.itogprak.Model;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
@Table(name = "Shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is required")

    private String name;

    @NotBlank(message = "sizeSM is required")
    private String address;

    @NotBlank(message = "weightKG is required")
    private int rating;
    @OneToMany (mappedBy = "shopemployees", fetch = FetchType.EAGER)
    private Collection<Employees> employeesid;
    @OneToMany (mappedBy = "shopproduct", fetch = FetchType.EAGER)
    private Collection<Product> productid;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name="warehouse_id")
    private Warehouse warehouse;

    public Shop(){

    }

    public Shop(long id, String name, String address, int rating, Collection<Employees> employeesid, Collection<Product> productid, Warehouse warehouse){
        this.id = id;
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.employeesid = employeesid;
        this.productid = productid;
        this.warehouse = warehouse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank(message = "Name is required") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is required") String name) {
        this.name = name;
    }

    public @NotBlank(message = "sizeSM is required") String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank(message = "sizeSM is required") String address) {
        this.address = address;
    }

    @NotBlank(message = "weightKG is required")
    public int getRating() {
        return rating;
    }

    public void setRating(@NotBlank(message = "weightKG is required") int rating) {
        this.rating = rating;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Collection<Product> getProductid() {
        return productid;
    }

    public void setProductid(Collection<Product> productid) {
        this.productid = productid;
    }

    public Collection<Employees> getEmployeesid() {
        return employeesid;
    }

    public void setEmployeesid(Collection<Employees> employeesid) {
        this.employeesid = employeesid;
    }
}

