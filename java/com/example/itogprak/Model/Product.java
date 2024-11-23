package com.example.itogprak.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int weight;
    private String type;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Shop shopproduct;
    @ManyToOne(optional = true)
    private Warehouse werehouseproduct;

    public Product() {

    }

    public Product(long id, String name, int weight, String type, Shop shopproduct, Warehouse werehouseproduct) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.shopproduct = shopproduct;
        this.werehouseproduct = werehouseproduct;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Shop getShopproduct() {
        return shopproduct;
    }

    public void setShopproduct(Shop shopproduct) {
        this.shopproduct = shopproduct;
    }

    public Warehouse getWerehouseproduct() {
        return werehouseproduct;
    }

    public void setWerehouseproduct(Warehouse werehouseproduct) {
        this.werehouseproduct = werehouseproduct;
    }
}