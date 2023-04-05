package com.kofa.kofa.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String telNumber;
    private String address;
    private String products;

//    @OneToMany(mappedBy = "orders")
//    private Set<Product> orders;

    public Orders() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

//    public Set<Product> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(Set<Product> orders) {
//        this.orders = orders;
//    }

    public Orders(String firstName, String telNumber, String address, String products) {
        this.firstName = firstName;
        this.telNumber = telNumber;
        this.address = address;
        this.products = products;
    }

//    public Orders(String firstName, String telNumber, String address, Set<Product> orders) {
//        this.firstName = firstName;
//        this.telNumber = telNumber;
//        this.address = address;
//        this.orders = orders;
//    }
}
