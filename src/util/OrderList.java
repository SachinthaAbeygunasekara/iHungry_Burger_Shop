/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import model.Order;

/**
 *
 * @author Sachintha
 */
public class OrderList {

    private Order[] orderArray;
    private int nextIndex;
    private double loadFact;
    private int initSize;

    public OrderList() {
        nextIndex = 0;
        loadFact = 0.5;
        initSize = 100;
        orderArray = new Order[initSize];
    }

    public OrderList(int initSize, double loadFact) {
        orderArray = new Order[initSize];
        this.loadFact = loadFact;
        nextIndex = 0;
        this.initSize = initSize;
    }

    public boolean add(Order order) {
        if (order == null) {
            return false;
        }

        if (nextIndex >= orderArray.length) {
            extendsArray();
        }
        orderArray[nextIndex++] = order;
        return true;
    }

    public boolean addLast(Order order) {
        return add(order);
    }

    public boolean addFirst(Order order) {
        return add(0, order);
    }

    public boolean add(int index, Order order) {
        if (order == null || index < 0 || index > nextIndex) {
            return false;
        }

        for (int i = nextIndex; i > index; i--) {
            orderArray[i] = orderArray[i - 1];
        }
        orderArray[index] = order;
        nextIndex++;
        return true;
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(nextIndex - 1);
    }

    public boolean remove(int index) {

        if (index < 0 || index > nextIndex) {
            return false;
        }
        for (int i = index; i < nextIndex; i++) {
            orderArray[i] = orderArray[i + 1];
        }
        nextIndex--;
        return true;
    }

    public Order get(int index) {
        return index >= 0 && index < nextIndex ? orderArray[index] : null;
    }

    public void printList() {
        System.out.print("[");
        for (int i = 0; i < nextIndex; i++) {
            System.out.print(orderArray[i] + ", ");
        }
        System.out.println(isEmpty() ? "empty]" : "\b\b]");
    }

    private void extendsArray() {
        Order[] tempDataArray = new Order[(int) (orderArray.length * (loadFact + 1))];
        for (int i = 0; i < orderArray.length; i++) {
            tempDataArray[i] = orderArray[i];
        }
        orderArray = tempDataArray;
    }

    public boolean isEmpty() {
        return nextIndex <= 0;
    }

    public int size() {
        return nextIndex;
    }

    public boolean contains(Order order) {
        return indexOf(order) != -1;
    }

    public int indexOf(Order order) {
        for (int i = 0; i < nextIndex; i++) {
            if (orderArray[i] == order) {
                return i;
            }
        }
        return -1;
    }

    public Order[] toArray() {
        Order[] tempDataArray = new Order[nextIndex];
        for (int i = 0; i < nextIndex; i++) {
            tempDataArray[i] = orderArray[i];
        }
        return tempDataArray;
    }

    public Order getLast() {
        if (isEmpty()) {
            return null;
        }
        return orderArray[nextIndex - 1];
    }

    public void clear() {
        nextIndex = 0;
        orderArray = new Order[initSize];
    }

}
