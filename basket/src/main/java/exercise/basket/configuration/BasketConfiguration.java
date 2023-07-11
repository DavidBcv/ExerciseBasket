package exercise.basket.configuration;

import exercise.basket.beans.Basket;
import exercise.basket.beans.SummaryCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration

public class BasketConfiguration {
    private  final SummaryCalculator calculator;

    public BasketConfiguration(SummaryCalculator calculator) {
        this.calculator = calculator;
    }

    @Bean
    Basket basket() {
        return new Basket(calculator, new ArrayList<>());
    }
}
