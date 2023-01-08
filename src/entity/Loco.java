package entity;

public enum Loco {
    LOCO_WITH_1LOCO(10000,1),
    LOCO_WITH_2LOCO(20000,2);
    private int locoPrice;
    private int amountLoco;

    Loco(int locoPrice, int amountLoco) {
        this.locoPrice = locoPrice;
        this.amountLoco = amountLoco;
    }

    public int getLocoPrice() {
        return locoPrice;
    }

    public int getAmountLoco() {
        return amountLoco;
    }
}
