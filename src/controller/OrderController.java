/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Order;
import util.OrderFileHandler;
import util.OrderList;

/**
 *
 * @author Sachintha
 */
public class OrderController {

    public Order[] getOrdersAsArray() {
        return OrderFileHandler.loadOrders().toArray();
    }

    public OrderList getAllOrders() {
        return OrderFileHandler.loadOrders();
    }

    public boolean addOrder(Order order) {
        return OrderFileHandler.saveOrder(order);
    }

    public boolean updateOrder(int index, Order order, OrderList orderList) {
        orderList.remove(index);
        orderList.add(index, order);
        return OrderFileHandler.saveAll(orderList);
    }
}
