package main;

import entity.Carriage;
import entity.Loco;
import entity.Order;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.OrderService;
import service.impl.OrderServiceImpl;

import java.util.List;

import static entity.Carriage.*;

public class OrderMain {
    static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {

        OrderService orderService = new OrderServiceImpl();
        List<Carriage> carriage;
        Order order1 = new Order("Minsk railway station", "regional 2", Loco.LOCO_WITH_1LOCO, carriage = List.of(GENERAL_CARRIAGE, GENERAL_CARRIAGE, GENERAL_CARRIAGE, GENERAL_CARRIAGE));
        System.out.println(order1.toString());
        System.out.println(orderService.printBill(order1));
        Order order2 = new Order("Gomel railway station", "passengers 23", Loco.LOCO_WITH_2LOCO, carriage = List.of(RESTAURANT, COUPE, COUPE, COUPE, COUPE, RESERVED_SEAT, RESERVED_SEAT, RESERVED_SEAT, RESERVED_SEAT));
        System.out.println(order2.toString());
        System.out.println(orderService.printBill(order2));



    }
}