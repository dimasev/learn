package entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static util.GenerateId.generateNextId;

public class Order {
    static Logger logger = LogManager.getLogger();
    public static final int PRICE_FOR_REGISTRATION = 800;
    public static final int MAX_LENGTH_TRAIN_NAME = 20;
    public static final int MIN_LENGTH_TRAIN_NAME = 4;
    public static final String CLIENT = "Client";
    public static final int MAX_AMOUNT_CARRIAGES = 20;
    public static final int MIN_AMOUNT_CARRIAGES = 1;
    private int orderId;
    private String customerId;
    private String trainName;
    private Loco loco;
    private List<Carriage> carriages;

    public Order(String customerId, String trainName, Loco loco, List<Carriage> carriages) {
        this.customerId = customerId;
        if (loco != null) {
            this.loco = loco;
        } else {
            this.loco = Loco.LOCO_WITH_1LOCO;
            logger.log(Level.ERROR, "Need at least one loco");
        }
        this.carriages = carriages;
        this.orderId = generateNextId();
        if (trainName.length() <= MAX_LENGTH_TRAIN_NAME && trainName.length() >= MIN_LENGTH_TRAIN_NAME) {
            this.trainName = trainName;
        } else {
            this.trainName = CLIENT + orderId;
        }
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public Loco getLoco() {
        return loco;
    }

    public void setLoco(Loco loco) {
        this.loco = loco;
    }

    public List<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(List<Carriage> carriages) {
        this.carriages = carriages;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order[");
        sb.append(orderId).append(':');
        sb.append(customerId).append(':');
        sb.append(trainName).append(':');
        sb.append(carriages.size());
        sb.append(']');
        return sb.toString();
    }
}
