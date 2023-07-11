package exercise.basket;

import exercise.basket.beans.Basket;
import exercise.basket.beans.SummaryCalculator;
import exercise.basket.domain.ItemSelection;
import exercise.basket.domain.Summary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;
@SpringBootTest(webEnvironment = NONE)
public class BasketTest {




        @Autowired
        Basket basket;

        @MockBean
        SummaryCalculator calculator;

        String testEmail = "test@gmail.com";
        ItemSelection itemSelection = new ItemSelection(testEmail, "test", 1.0);

        Summary summaryExpected = new Summary(testEmail, "test", 1.0, 3.5);


        @Test
        void addSummary() {
            Mockito.when(calculator.getDeliveryCost(itemSelection)).thenReturn(2.5);
            basket.addSummary(itemSelection);

            List<Summary> expected = List.of(summaryExpected);
            List<Summary> result = basket.getSummaries();

            Assertions.assertEquals(expected, result);

            Mockito.verify(calculator).getDeliveryCost(itemSelection);


        }

        @Test
        void transferToSummary() {
            Mockito.when(calculator.getDeliveryCost(itemSelection)).thenReturn(2.5);
            Summary result = basket.transferToSummary(itemSelection);

            Assertions.assertEquals(summaryExpected, result);

            Mockito.verify(calculator).getDeliveryCost(itemSelection);


        }
}
