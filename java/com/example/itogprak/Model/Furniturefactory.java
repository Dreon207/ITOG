package com.example.itogprak.Model;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Furniturefactory")
public class Furniturefactory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is required")

    private String name;

    @NotBlank(message = "sizeSM is required")
    private String address;

    @NotBlank(message = "weightKG is required")
    private int yearsofwork ;
    @OneToOne(optional = true, mappedBy = "furniturefactory")
    private Provider provider;

    public Furniturefactory(){

    }

    public Furniturefactory(long id, String name, String address, int yearsofwork, Provider provider){
        this.id = id;
        this.name = name;
        this.address = address;
        this.yearsofwork = yearsofwork;
        this.provider = provider;
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
    public int getYearsofwork() {
        return yearsofwork;
    }

    public void setYearsofwork(@NotBlank(message = "weightKG is required") int yearsofwork) {
        this.yearsofwork = yearsofwork;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}

