package exercise.basket.domain;

import java.util.Objects;

public class ItemSelection {

    private String userEmail;
    private String itemName;
    private double itemPrice;

    public ItemSelection() {
    }

    public ItemSelection(String userEmail, String itemName, double itemPrice) {
        this.userEmail = userEmail;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
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

    public String getUserEmail() {
        return userEmail;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemSelection)) return false;
        ItemSelection that = (ItemSelection) o;
        return Double.compare(that.getItemPrice(), getItemPrice()) == 0 &&
                getUserEmail().equals(that.getUserEmail()) &&
                getItemName().equals(that.getItemName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserEmail(), getItemName(), getItemPrice());
    }
}
