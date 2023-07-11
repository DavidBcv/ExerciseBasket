package exercise.basket;

import exercise.basket.beans.UsersClient;
import exercise.basket.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class UsersClientTest {

    @Autowired
    UsersClient usersClient;

    @MockBean
    RestTemplate restTemplate;

    String email = "test@email";


    @Value("${basket.url}")
    String url;


    @Test
    void getEmptyOptionalOfUser() {
        Mockito.when(restTemplate.getForObject(url + email, User.class)).thenReturn(null);
        Optional<User> oUser = usersClient.getUser(email);

        Assertions.assertTrue(oUser.isEmpty());

        Mockito.verify(restTemplate).getForObject(url + email, User.class);

    }

    @Test
    void getPresentOptionalOfUser() {
        User expected = new User(email, "test");
        Mockito.when(restTemplate.getForObject(url + email, User.class)).thenReturn(expected);

        Optional<User> oUser = usersClient.getUser(email);
        Assertions.assertTrue(oUser.isPresent());
        User result = oUser.get();

        Assertions.assertEquals(expected, result);

        Mockito.verify(restTemplate).getForObject(url + email, User.class);

    }
}
