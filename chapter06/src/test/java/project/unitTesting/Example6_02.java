package project.unitTesting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Example6_02 {

    @Test
    void Adding_a_product_to_an_order() throws Exception {
        // given
        final Product product = new Product("Hand wash");
        final Order sut = new Order();

        // when
        sut.addProduct(product);

        // then
        assertThat(sut.products().size()).isEqualTo(1);
        assertThat(sut.products().get(0)).isEqualTo(product);
    }
}
