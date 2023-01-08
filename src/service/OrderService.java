package service;

import entity.Carriage;
import entity.Order;

public interface OrderService {
    String generateBill(Order order);

    int calculateTotalPrice(Order order);

    void addCarriage(Carriage carriage, Order order);

    void deleteCarriage(Carriage carriage, Order order);
}
