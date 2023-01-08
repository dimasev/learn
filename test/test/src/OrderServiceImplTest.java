package test.src;

import entity.Carriage;
import entity.Loco;
import entity.Order;
import service.OrderService;
import service.impl.OrderServiceImpl;

import java.util.List;

import static entity.Carriage.GENERAL_CARRIAGE;
import static org.testng.Assert.*;

public class OrderServiceImplTest {

    @org.testng.annotations.Test
    public void testCalculateTotalPrice() {
        List<Carriage> carriage;
        OrderService orderService = new OrderServiceImpl();
        Order order1 = new Order("Minsk railway station", "regional 2", Loco.LOCO_WITH_1LOCO, carriage = List.of(GENERAL_CARRIAGE, GENERAL_CARRIAGE, GENERAL_CARRIAGE, GENERAL_CARRIAGE));
        int actual = orderService.calculateTotalPrice(order1);
        int expected = 18800;
        assertEquals(actual, expected, 0);
    }
}