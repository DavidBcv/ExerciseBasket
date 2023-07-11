package exercise.basket.beans;

import exercise.basket.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Controller
public class UsersClient {
    private final RestTemplate restTemplate;
    private final String url;

    public UsersClient(RestTemplate restTemplate,
                       @Value("${basket.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public UsersClient() {
    }

    public Optional<User> getUser(String email) {
        User user = restTemplate.getForObject(url + email, User.class);
        if (user == null) {
            return Optional.empty();
        }
        return Optional.of(user);
    }
}
