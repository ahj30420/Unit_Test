package project.unitTesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Example3_03 {

    @Test
    void Purchase_succeeds_when_enough_inventory() throws Exception {
        // given
        final Store store = createStoreWithInventory(Product.Shampoo, 10);
        final Customer sut = createCustomer();

        // when
        final boolean success = sut.purchase(store, Product.Shampoo, 5);

        // then
        assertTrue(success);
        assertSame(5, store.getInventory(Product.Shampoo));
    }

    @Test
    void Purchase_fails_when_not_enough_inventory() throws Exception {
        // given
        final Store store = createStoreWithInventory(Product.Shampoo, 10);
        final Customer sut = createCustomer();

        // when
        final boolean success = sut.purchase(store, Product.Shampoo, 15);

        // then
        assertFalse(success);
        assertSame(10, store.getInventory(Product.Shampoo));
    }

    private Store createStoreWithInventory(Product product, int quantity) {
        final Store store = new Store();
        store.addInventory(product, quantity);
        return store;
    }

    private static Customer createCustomer(){
        return new Customer();
    }
}
