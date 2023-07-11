package exercise.basket;

import exercise.basket.beans.Basket;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class SummaryEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    Basket basket;

    String url = "/summaries";

    @Test
    void getList() {
        restTemplate.getForObject(url, List.class);
        Mockito.verify(basket).getSummaries();
    }
}
