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

    public static String generateOrderId() {
        OrderList orders = OrderFileHandler.loadOrders();
        if (orders.isEmpty()) {
            return "O001";
        } else {
            Order lastOrder = orders.get(orders.size() - 1);
            int num = Integer.parseInt(lastOrder.getId().substring(1, 4));
            return String.format("O%03d", num + 1);
        }
    }

    public static Order serachOrder(String orderId) {
        Order[] orders = getOrdersAsArray();
        for (Order order : orders) {
            if (order.getId().equalsIgnoreCase(orderId)) {
                return order;
            }
        }
        return null;
    }

    public static OrderList getOrdersByStatus(String orderStatus) {
        OrderList orderList = OrderFileHandler.loadOrders();
        OrderList filteredList = new OrderList();

        for (Order order : orderList.toArray()) {
            if (order.getStatus().equals(orderStatus)) {
                filteredList.add(order);
            }
        }
        return filteredList;
    }

    public static OrderList getOrdersByCustomerId(String customerId) {
        OrderList orderList = OrderFileHandler.loadOrders();
        OrderList filteredList = new OrderList();

        for (Order order : orderList.toArray()) {
            if (order.getCustomerId().equals(customerId)) {
                filteredList.add(order);
            }
        }
        return filteredList;
    }

    public static OrderList getAllOrders() {
        return OrderFileHandler.loadOrders();
    }

    public static Order[] getOrdersAsArray() {
        return OrderFileHandler.loadOrders().toArray();
    }

    public static boolean addOrder(Order order) {
        return OrderFileHandler.saveOrder(order);
    }

    public static boolean updateOrder(Order order) {
        OrderList orderList = OrderFileHandler.loadOrders();
        if (!orderList.isEmpty()) {
            int index = orderList.indexOf(order);
            orderList.remove(index);
            orderList.add(index, order);
        }
        return OrderFileHandler.saveAll(orderList);
    }

    public static OrderList getUniqueCustomersByAmountDesc() {
        OrderList allOrders = OrderFileHandler.loadOrders();
        OrderList uniqueCustomers = new OrderList();

        for (int i = 0; i < allOrders.size(); i++) {
            Order order = allOrders.get(i);
            boolean found = false;

            for (int j = 0; j < uniqueCustomers.size(); j++) {
                Order existing = uniqueCustomers.get(j);
                if (existing.getCustomerId().equals(order.getCustomerId())) {
                    existing.setAmount(existing.getAmount() + order.getAmount());
                    found = true;
                    break;
                }
            }

            if (!found) {
                uniqueCustomers.addLast(new Order(
                        order.getId(),
                        order.getCustomerId(),
                        order.getCustomerName(),
                        order.getQuantity(),
                        order.getAmount(),
                        order.getStatus()
                ));
            }
        }

        uniqueCustomers.sortByAmountDesc();
        return uniqueCustomers;
    }
}
