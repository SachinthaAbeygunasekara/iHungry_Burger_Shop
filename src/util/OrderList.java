package util;

import model.Order;

public class OrderList {

    private Node first;

    public boolean add(int index, Order order) {
        if (index >= 0 && index <= size()) {
            Node node = new Node(order);

            if (index == 0) {
                node.next = first;
                first = node;
            } else {
                Node temp = first;
                int count = 0;
                while (count < index - 1) {
                    temp = temp.next;
                    count++;
                }
                node.next = temp.next;
                temp.next = node;
            }
            return true;
        }
        return false;
    }

    public boolean addFirst(Order order) {
        return add(0, order);
    }

    public boolean addLast(Order order) {
        return add(size(), order);
    }

    public boolean add(Order order) {
        return addLast(order);
    }

    public boolean remove(int index) {
        if (index >= 0 && index < size()) {
            if (index == 0) {
                first = first.next;
            } else {
                Node temp = first;
                int count = 0;
                while (count < index - 1) {
                    temp = temp.next;
                    count++;
                }
                temp.next = temp.next.next;
                return true;
            }
        }
        return false;
    }

    public boolean removeFirst() {
        return remove(0);
    }

    public boolean removeLast() {
        return remove(size() - 1);
    }

    public Order get(int index) {
        if (index >= 0 && index < size()) {
            Node temp = first;
            int count = 0;
            while (count < index) {
                temp = temp.next;
                count++;
            }
            return temp.order;
        }
        return null;
    }

    public Order getFirst() {
        return get(0);
    }

    public Order getLast() {
        return get(size() - 1);
    }

    public int indexOf(Order order) {
        int index = 0;
        Node temp = first;
        while (temp != null) {
            if (order.equals(temp.order)) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    public boolean contains(Order order) {
        return indexOf(order) != -1;
    }

    public boolean remove(Order order) {
        int index = indexOf(order);
        return remove(index);
    }

    public int size() {
        Node temp = first;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public void printOrders() {
        System.out.println("{");
        Node temp = first;
        while (temp != null) {
            Order order = temp.order;
            System.out.println(order.toString() + ", ");
            temp = temp.next;
        }
        System.out.println(isEmpty() ? "{empty}" : "\b\b}");
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Order[] toArray() {
        Order[] array = new Order[size()];
        Node temp = first;
        int index = 0;

        while (temp != null) {
            array[index++] = temp.order;
            temp = temp.next;
        }
        return array;
    }

    public void sortByAmountDesc() {
        if (first == null || first.next == null) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Node current = first;

            while (current.next != null) {
                if (current.order.getAmount() < current.next.order.getAmount()) {
                    // Swap the orders (not nodes)
                    Order temp = current.order;
                    current.order = current.next.order;
                    current.next.order = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    class Node {

        private Order order;
        private Node next;

        public Node(Order order) {
            this.order = order;
            this.next = null;
        }
    }
}
