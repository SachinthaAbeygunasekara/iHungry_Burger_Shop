/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Sachintha
 */
public class Order {

    private String id;
    private String customerId;
    private String customerName;
    private int quantity;
    private double amount;
    private String status;

    public static final double BURGERPRICE = 500;

    public Order(String id, String customerId, String customerName, int quantity, double amount, String status) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.quantity = quantity;
        this.amount = amount;
        this.status = status;
    }

    public Order(String customerId, String customerName, double amount) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
