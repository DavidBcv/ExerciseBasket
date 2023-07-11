package exercise.basket;

import exercise.basket.beans.SummaryCalculator;
import exercise.basket.beans.UsersClient;
import exercise.basket.domain.ItemSelection;
import exercise.basket.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class SummaryCalculatorTest {

    @Autowired
    SummaryCalculator calculator;

    @MockBean
    UsersClient client;


    @Test
    void getDeliveryCostPremium() {
        String premium = "premium account";
        String emailPremium = "premium@gmail.com";
        ItemSelection itemSelection = new ItemSelection(emailPremium, "test", 1.0);

        User userPremium = new User(emailPremium, premium);
        Mockito.when(client.getUser(emailPremium)).thenReturn(Optional.of(userPremium));

        double expected = 0.0;
        double result = calculator.getDeliveryCost(itemSelection);

        Assertions.assertEquals(expected, result);
        Mockito.verify(client).getUser(emailPremium);


    }

    @Test
    void getDeliveryCostStandard() {
        String standard = "standard account";
        String testEmail = "test@gmail.com";
        ItemSelection itemSelection = new ItemSelection(testEmail, "test", 1.0);

        User userPremium = new User(testEmail, standard);
        Mockito.when(client.getUser(testEmail)).thenReturn(Optional.of(userPremium));

        double expected = 2.5;
        double result = calculator.getDeliveryCost(itemSelection);

        Assertions.assertEquals(expected, result);
        Mockito.verify(client).getUser(testEmail);
    }

    @Test
    void getDeliveryCostNonRegistered() {
        String standard = "standard account";
        String testEmail = "test@gmail.com";
        ItemSelection itemSelection = new ItemSelection(testEmail, "test", 1.0);

        User userPremium = new User(testEmail, standard);
        Mockito.when(client.getUser(testEmail)).thenReturn(Optional.empty());

        double expected = 2.5;
        double result = calculator.getDeliveryCost(itemSelection);

        Assertions.assertEquals(expected, result);
        Mockito.verify(client).getUser(testEmail);
    }


}
