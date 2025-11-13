/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JOptionPane;
import model.Order;

/**
 *
 * @author Sachintha
 */
public class OrderFileHandler {

    private static final String FILE_NAME = "iHungry_db.txt";
    private static OrderList orderList;

    public static boolean saveOrder(Order order) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(order.getId() + ","
                    + order.getCustomerId() + ","
                    + order.getCustomerName() + ","
                    + order.getQuantity() + ","
                    + order.getAmount() + ","
                    + order.getStatus() + "\n");
            fw.close();
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public static OrderList loadOrders() {
        orderList = new OrderList();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Order order = new Order(data[0], data[1], data[2], Integer.parseInt(data[3]), Double.parseDouble(data[4]), data[5]);
                orderList.add(order);
            }
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return orderList;
    }

    public static boolean saveAll(OrderList orderList) {
        try (FileWriter fw = new FileWriter(FILE_NAME, false)) {
            for (Order o : orderList.toArray()) {
                fw.write(o.getId() + ","
                        + o.getCustomerId() + ","
                        + o.getCustomerName() + ","
                        + o.getQuantity() + ","
                        + o.getAmount() + ","
                        + o.getStatus() + "\n");
            }
            fw.close();
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

}
