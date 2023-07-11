package exercise.basket.beans;

import exercise.basket.domain.ItemSelection;
import exercise.basket.domain.Summary;

import java.util.List;

public class Basket {
    private final SummaryCalculator calculator;
    private final List<Summary> summaries;

    public Basket(SummaryCalculator calculator, List<Summary> summaries) {
        this.calculator = calculator;
        this.summaries = summaries;
    }


    public Summary transferToSummary(ItemSelection itemSelection) {
        double deliveryPrice = calculator.getDeliveryCost(itemSelection);
        String userEmail = itemSelection.getUserEmail();
        String itemName = itemSelection.getItemName();
        double itemPrice = itemSelection.getItemPrice();
        double totalPrice = itemPrice + deliveryPrice;
        return new Summary(userEmail,
                itemName,
                itemPrice,
                totalPrice);
    }

    public void addSummary(ItemSelection itemSelection) {
        summaries.add(transferToSummary(itemSelection));
    }

    public List<Summary> getSummaries() {
        return summaries;
    }


}
