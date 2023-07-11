package exercise.basket.beans;

import exercise.basket.domain.ItemSelection;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itemselections")
public class ItemSelectionEndpoint {
    private final Basket basket;

    public ItemSelectionEndpoint(Basket basket) {
        this.basket = basket;
    }

    @PostMapping
    ItemSelection post(@RequestBody ItemSelection itemSelection) {
        basket.addSummary(itemSelection);
        return itemSelection;
    }
}
