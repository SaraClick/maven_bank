package com.qa.practice;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    // counter is to set customer ids
    private static int counter = 1;

    // List storing all customers from bank
    private List<Customer> customers = new ArrayList<>();

    private String name;
    private String surname;
    private LocalDate dob;
    private int customerID;

    // Constructors
    public Customer(String name, String surname, String dob) {
        this.name = name;
        this.surname = surname;
        this.dob = LocalDate.parse(dob);
        this.customerID = counter;
        counter++;  // add +1 to counter to ensure all customers have unique identifiers
    }

    // Getter and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    // Specific methods
    public int getAge() {
        LocalDate today = LocalDate.now();
        return Period.between(this.getDob(), today).getYears();
    }

    public boolean over18() {
        if (this.getAge() >= 18) {
            return true;
        }
        return false;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dob=" + dob +
                ", customerID=" + customerID +
                '}';
    }
}
