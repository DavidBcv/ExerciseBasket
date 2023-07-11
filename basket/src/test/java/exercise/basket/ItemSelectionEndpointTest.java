package exercise.basket;

import exercise.basket.beans.Basket;
import exercise.basket.domain.ItemSelection;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ItemSelectionEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    Basket basket;

    String email = "test@gmail.com";

    ItemSelection itemTest = new ItemSelection(email, "Test", 0.0);

    String url = "/itemselections";

    @Test
    void post() {
        restTemplate.postForObject(url, itemTest, ItemSelection.class);
        Mockito.verify(basket).addSummary(itemTest);

    }
}
