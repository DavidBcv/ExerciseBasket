package exercise.basket.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

public class RestTemplateConfiguration {

    @Bean
    RestTemplate restTemplate (){
        return new RestTemplate();
    }
}
