package project.unitTesting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Example6_01 {

    @Test
    void Discount_of_two_products() throws Exception {
        // given
        final Product product1 = new Product("Hand wash");
        final Product product2 = new Product("Shampoo");
        final PriceEngine sut = new PriceEngine();

        // when
        final double discount = sut.calculateDiscount(product1, product2);

        // then
        assertThat(discount).isEqualTo(0.02d);
    }

}
