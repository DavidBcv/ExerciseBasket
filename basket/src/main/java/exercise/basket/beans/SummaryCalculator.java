package exercise.basket.beans;

import exercise.basket.domain.ItemSelection;
import exercise.basket.domain.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SummaryCalculator {
    private final UsersClient usersClient;

    public SummaryCalculator(UsersClient usersClient) {
        this.usersClient = usersClient;
    }

    public double getDeliveryCost(ItemSelection itemSelection) {
        String email = itemSelection.getUserEmail();
        Optional<User> oUser = usersClient.getUser(email);
        double deliveryCost = 2.5;
        if (oUser.isPresent()) {
            User user = oUser.get();
            if (user.getAccountType().equals("premium account")) {
                deliveryCost = 0;
            }
        }

        return deliveryCost;

    }
}
