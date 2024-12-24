package project.unitTesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Example3_02 {

    private final Store store;
    private final Customer sut;

    public Example3_02() {
        this.store = new Store();
        this.store.addInventory(Product.Shampoo, 10);
        this.sut = new Customer();
    }

    @Test
    void Purchase_succeeds_when_enough_inventory() throws Exception {
        // when
        final boolean success = sut.purchase(store, Product.Shampoo, 5);

        // then
        assertTrue(success);
        assertSame(5, store.getInventory(Product.Shampoo));
    }

    @Test
    void Purchase_fails_when_not_enough_inventory() throws Exception {
        // when
        final boolean success = sut.purchase(store, Product.Shampoo, 15);

        // then
        assertFalse(success);
        assertSame(10, store.getInventory(Product.Shampoo));
    }
}
