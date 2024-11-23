package com.example.itogprak.Model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "Provider")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int rating;
    private int yearsofwork ;
    @OneToOne(optional = true, mappedBy = "provider")
    private Warehouse werehouse;


    @OneToMany (mappedBy = "providertransport", fetch = FetchType.EAGER)
    private Collection<Transport> transportid;
    @OneToOne(optional = true)
    @JoinColumn(name="furniturefactory_id")
    private Furniturefactory furniturefactory;

    public Provider(){

    }

    public Provider(long id, String name, int rating, int yearsofwork, Warehouse werehouse, Collection<Transport> transportid, Furniturefactory furniturefactory){
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.yearsofwork = yearsofwork;
        this.werehouse = werehouse;
        this.transportid = transportid;
        this.furniturefactory = furniturefactory;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getYearsofwork() {
        return yearsofwork;
    }

    public void setYearsofwork(int yearsofwork) {
        this.yearsofwork = yearsofwork;
    }

    public Warehouse getWerehouse() {
        return werehouse;
    }

    public void setWerehouse(Warehouse werehouse) {
        this.werehouse = werehouse;
    }

    public Collection<Transport> getTransportid() {
        return transportid;
    }

    public void setTransportid(Collection<Transport> transportid) {
        this.transportid = transportid;
    }

    public Furniturefactory getFurniturefactory() {
        return furniturefactory;
    }

    public void setFurniturefactory(Furniturefactory furniturefactory) {
        this.furniturefactory = furniturefactory;
    }
}
