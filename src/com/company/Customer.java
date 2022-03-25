package com.company;

import java.util.ArrayList;

public class Customer {
    private static int customerCount=0;
    private int customerId;
    private String customerEmail;
    private String customerName;
    private String customerPassword;
    private boolean isBusy = false;

    public Customer(String customerName, String customerEmail, String customerPassword, ArrayList<Customer> customers){
        for(int i=0; i<customers.size(); i++){
            Customer c = customers.get(i);
            if(c.customerEmail.equals(customerEmail)){
                System.out.println("Customer with that email already exists. Please log in.");
                return;
            }
        }
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        customerCount++;
        this.customerId = customerCount;
    }

    private static Customer findCustomer(String customerEmail, ArrayList<Customer> customers){
//        System.out.println(customers.size());
        for(int i=0; i<customers.size(); i++){
            Customer c = customers.get(i);
//            System.out.println(c.customerEmail + " " + customerEmail);
            if(c.customerEmail.equals(customerEmail)){
                return c;
            }
        }
        return null;
    }

    public static Customer Login(String customerEmail, String customerPassword, ArrayList<Customer> customers){
        Customer existingCustomer = findCustomer(customerEmail, customers);
        if(existingCustomer != null){
            if(existingCustomer.customerPassword.equals(customerPassword) == false){
                System.out.println("Incorrect password. Please try again");
                return null;
            }
            System.out.println("Welcome " + existingCustomer.customerName);
            return existingCustomer;
        }else{
            System.out.println("No such customer exists. Please signup.");
            return null;
        }
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }
}
