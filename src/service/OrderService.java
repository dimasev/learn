package service;

import entity.Carriage;
import entity.Order;

import java.util.List;

public interface OrderService {
    String printBill(Order order);
    int calculateTotalPrice(Order order);
    void addCarriage (Carriage carriage, Order order);
    void deleteCarriage (Carriage carriage, Order order);
}
