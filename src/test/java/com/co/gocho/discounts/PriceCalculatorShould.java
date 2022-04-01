package com.co.gocho.discounts;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PriceCalculatorShould {


    @Test
    public void total_zero_when_there_are_prices(){

        PriceCalculator priceCalculator = new PriceCalculator();
        assertThat(priceCalculator.getTotal(),is(0.0));
    }

    @Test
    public void total_is_the_sum_of_prices() {
        PriceCalculator priceCalculator = new PriceCalculator();
        priceCalculator.addPrice(12.5);
        priceCalculator.addPrice(12.5);

        assertThat(priceCalculator.getTotal(),is(25.0));

    }

    @Test
    public void apply_discount_to_prices() {
        PriceCalculator priceCalculator = new PriceCalculator();
        priceCalculator.addPrice(15.5);
        priceCalculator.addPrice(15.5);

        priceCalculator.setDiscount(50);

        assertThat(priceCalculator.getTotal(),is(15.5));

    }
}