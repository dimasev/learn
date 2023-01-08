package entity;

public enum Carriage {
    SW(7000,"SW"),
    RESTAURANT(5000,"Carriage restaurant"),
    COUPE(7000, "Coupe"),
    RESERVED_SEAT(4000,"Reserved seat"),
    GENERAL_CARRIAGE(2000,"General carriage"),
    LUGGAGE_CARRIAGE(1000, "Luggage carriage");
    private int priceCarriage;
    private String nameCarriage;

    Carriage(int price, String name) {
        this.priceCarriage = price;
        this.nameCarriage = name;
    }

    public int getPriceCarriage() {
        return priceCarriage;
    }


    public String getNameCarriage() {
        return nameCarriage;
    }

}
