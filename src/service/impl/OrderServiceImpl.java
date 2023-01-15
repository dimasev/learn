package service.impl;

import entity.Carriage;
import entity.Order;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.OrderService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class OrderServiceImpl implements OrderService {

    static Logger logger = LogManager.getLogger();

    String dateTime = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a")
            .format(LocalDateTime.now());

    @Override
    public int calculateTotalPrice(Order order) {
        List<Carriage> list = order.getCarriages();
        int totalPrice = 0;
        for (int i = 0; i < list.size(); i++) {
            totalPrice = totalPrice + list.get(i).getPriceCarriage();
        }
        totalPrice += order.PRICE_FOR_REGISTRATION;
        totalPrice += order.getLoco().getLocoPrice();
        return totalPrice;
    }

    @Override
    public void addCarriage(Carriage carriage, Order order) {
        if (order.getCarriages().size() < order.MAX_AMOUNT_CARRIAGES) {
            order.getCarriages().add(carriage);
        } else {
            logger.log(Level.ERROR, "Excess number of carriage");
        }
    }

    @Override
    public void deleteCarriage(Carriage carriage, Order order) {
        int i = 0;
        if (order.getCarriages().size() > order.MIN_AMOUNT_CARRIAGES) {
            while (i < order.getCarriages().size()) {
                if (carriage.getNameCarriage().equals(order.getCarriages().get(i))) {
                    order.getCarriages().remove(i);
                    break;
                } else {
                    i++;
                }
            }
            logger.log(Level.ERROR, "Carriage absent");
        } else {
            logger.log(Level.ERROR, "Minimum value exceeded");
        }

    }

    @Override
    public String generateBill(Order order) {
        String dateTime = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a")
                .format(LocalDateTime.now());
        StringBuilder bill = new StringBuilder();
        bill.append("*".repeat(30) + "\n");
        bill.append(dateTime + "\n");
        bill.append("*".repeat(30) + "\n");
        bill.append("Order: " + order.getOrderId() + "\n");
        bill.append("client: " + order.getCustomerId() + "\n");
        bill.append("title: " + order.getTrainName() + "\n");
        bill.append("-".repeat(30) + "\n");
        bill.append(String.format("%-19s %-3s %s %n", "General fee ", "1", order.PRICE_FOR_REGISTRATION + "€"));
        bill.append(String.format("%-19s %-3s %s %n", "Amount locomotive ", order.getLoco().getAmountLoco(), order.getLoco().getLocoPrice() + "€"));

        int amountCarriages;
        Set<Carriage> carriageSet = new HashSet<>(order.getCarriages());
        List<Carriage> carriages1 = new ArrayList<>(carriageSet);
        for (int i = 0; i < carriages1.size(); i++) {
            amountCarriages = 0;
            for (int j = 0; j < order.getCarriages().size(); j++) {
                if (carriages1.get(i).equals(order.getCarriages().get(j))) {
                    amountCarriages++;
                }
            }

            bill.append(String.format("%-19s %-3s %s %n", carriages1.get(i).getNameCarriage(), amountCarriages, carriages1.get(i).getPriceCarriage() * amountCarriages + "€"));
        }
        bill.append("-".repeat(30) + "\n");
        bill.append(String.format("%-23s %s %n", "Total:", calculateTotalPrice(order) + "€"));
        bill.append(String.format("%-23s %s %n", "Amount: ", "1"));
        bill.append("-".repeat(30) + "\n");
        bill.append(String.format("%-23s %s %n", "Total:", calculateTotalPrice(order) + "€"));
        bill.append("*".repeat(30) + "\n");
        return bill.toString();
    }


}
