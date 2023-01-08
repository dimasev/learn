package main;

import entity.Carriage;
import entity.Loco;
import entity.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.OrderService;
import service.impl.OrderServiceImpl;

import java.util.List;

import static entity.Carriage.GENERAL_CARRIAGE;

public class OrderMain {
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        List<Carriage> carriage;
        Order order1 = new Order("Minsk railway station", "regional 23", Loco.LOCO_WITH_1LOCO, carriage = List.of(GENERAL_CARRIAGE, GENERAL_CARRIAGE, GENERAL_CARRIAGE, GENERAL_CARRIAGE));

        Order order2 = new Order("Minsk railway station", "regional 23", Loco.LOCO_WITH_1LOCO, carriage = List.of(GENERAL_CARRIAGE, GENERAL_CARRIAGE, GENERAL_CARRIAGE, GENERAL_CARRIAGE));
        int price = orderService.calculateTotalPrice(order1);
        String s = orderService.printBill(order1);
        System.out.println(order1.toString());
        System.out.println(s);
    }
}