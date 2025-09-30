/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Order;

/**
 *
 * @author Sachintha
 */
public class OrderController {

    private Order[] orderArray = new Order[0];

    private void extendOrderArray() {
        Order[] tempOrderArray = new Order[orderArray.length + 1];
        for (int i = 0; i < orderArray.length; i++) {
            tempOrderArray[i] = orderArray[i];
        }
        orderArray = tempOrderArray;
    }

    public Order[] getAllOrders() {
        return orderArray;
    }

    public boolean addOrder(Order Order) {
        extendOrderArray();
        orderArray[orderArray.length - 1] = Order;
        return true;
    }

    public Order searchOrder(String id) {
        if (id == null) {
            return null;
        }
        for (Order order : orderArray) {
            if (order.getId().equalsIgnoreCase(id)) {
                return order;
            }
        }
        return null;
    }

    public boolean updateOrder(Order order) {
        int index = indexOf(order);
        if (index != -1) {
            orderArray[index] = order;
            return true;
        }
        return false;
    }

    public boolean deleteOrder(String id) {
        int index = -1;
        for (int i = 0; i < orderArray.length; i++) {
            if (orderArray[i].getId().equalsIgnoreCase(id)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }

        Order[] temp = new Order[orderArray.length - 1];
        for (int i = 0, j = 0; i < orderArray.length; i++) {
            if (i != index) {
                temp[j++] = orderArray[i];
            }
        }
        orderArray = temp;
        return true;
    }

    public int indexOf(Order order) {
        for (int i = 0; i < orderArray.length; i++) {
            if (orderArray[i].getId().equalsIgnoreCase(order.getId())) {
                return i;
            }
        }
        return -1;
    }

    public int searchIndex(String searchKey, String field) {
        for (int i = 0; i < orderArray.length; i++) {
            switch (field.toLowerCase()) {
                case "id":
                    if (orderArray[i].getId().equalsIgnoreCase(searchKey)) {
                        return i;
                    }
                    break;
                case "customerid":
                    if (orderArray[i].getCustomerId().equalsIgnoreCase(searchKey)) {
                        return i;
                    }
                    break;
            }
        }
        return -1;
    }

    public String getOrderStatus(int orderStatus) {
        String status = "";
        switch (orderStatus) {
            case 0:
                status = "Pending";
                break;
            case 1:
                status = "Delivered";
                break;
            case 2:
                status = "Cancelled";
                break;
        }
        return status;
    }

    public String generateOrderId() {
        if (orderArray.length <= 0) {
            return "O001";
        }
        String lastOrderId = orderArray[orderArray.length - 1].getId();
        int lastOrderIdNumber = Integer.parseInt(lastOrderId.substring(1));
        return String.format("O%03d", lastOrderIdNumber + 1);
    }

    public String generateCustomerId() {
        if (orderArray.length <= 0) {
            return "C001";
        }
        String lastCustomerId = orderArray[orderArray.length - 1].getCustomerId();
        int lastCustomerNumber = Integer.parseInt(lastCustomerId.substring(1));
        return String.format("C%03d", lastCustomerNumber + 1);
    }
}
