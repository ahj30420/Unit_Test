package project.unitTesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Example2_1 {

    /**
     * 고전적 방식
     * 협력자를 대체하지 않고 운영용 인스턴스를 사용하여 테스트 하는 방법
     */


    @Test
    void Purchase_succeeds_when_enough_inventory() {
        // Given(준비)
        final Store store = new Store();
        store.addInventory(Product.Shampoo, 10);
        final Customer customer = new Customer();

        // When(실행)
        final boolean success = customer.purchase(store, Product.Shampoo, 5);

        // Then(검증)
        assertTrue(success);
        assertSame(5, store.getInventory(Product.Shampoo));
    }

    @Test
    void Purchase_fails_when_not_enough_inventory() throws Exception {
        // given
        final Store store = new Store();
        store.addInventory(Product.Shampoo, 10);
        final Customer customer = new Customer();

        // when
        boolean success = customer.purchase(store, Product.Shampoo, 15);

        // then
        assertFalse(success);
        assertSame(10, store.getInventory(Product.Shampoo));
    }
}
