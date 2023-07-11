package exercise.basket.domain;

import java.util.Objects;

public class Summary {
    private String userEmail;
    private String itemName;
    private double itemPrice;
    private double totalPrice;

    public Summary() {
    }

    public Summary(String userEmail, String itemName, double itemPrice, double totalPrice) {
        this.userEmail = userEmail;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.totalPrice = totalPrice;
    }

    void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    void setItemName(String itemName) {
        this.itemName = itemName;
    }

    void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Summary)) return false;
        Summary summary = (Summary) o;
        return Double.compare(summary.getItemPrice(), getItemPrice()) == 0 &&
                Double.compare(summary.getTotalPrice(), getTotalPrice()) == 0 &&
                getUserEmail().equals(summary.getUserEmail()) &&
                getItemName().equals(summary.getItemName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserEmail(), getItemName(), getItemPrice(), getTotalPrice());
    }
}
