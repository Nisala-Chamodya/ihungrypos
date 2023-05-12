package lk.blacky.ihungrypos.model;

public class Order {
    private String orderId;
    private int burgerQTY;
    private  double price;

    public Order(String orderId, int burgerQTY, double price) {
        this.orderId = orderId;
        this.burgerQTY = burgerQTY;
        this.price = price;
    }

    public Order() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getBurgerQTY() {
        return burgerQTY;
    }

    public void setBurgerQTY(int burgerQTY) {
        this.burgerQTY = burgerQTY;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", burgerQTY=" + burgerQTY +
                ", price=" + price +
                '}';
    }
}

