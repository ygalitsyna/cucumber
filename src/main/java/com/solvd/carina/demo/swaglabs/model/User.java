package com.solvd.carina.demo.swaglabs.model;

import java.util.List;

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private Integer zipcode;

    private List<Order>orders;

    public User() {
    }

    public User(Integer id, String firstName, String lastName, String login, String password, Integer zipcode, List<Order> orders) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.zipcode = zipcode;
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return String.format("User{id = %d, , firstName = %s,  lastName = %s, login = %s, " +
                        "password = %s, zipcode = %d, orders:}",
                id, firstName, lastName, login, password, zipcode, orders);
    }
}
