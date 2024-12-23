package project.unitTesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class Example2_2 {

    /**
     * 런던파 방식
     * SUT에서 협력자를 테스트 대역으로 대체 하여 테스트하는 방법
     */

    @Mock
    Store storeMock;

    @Test
    void Purchase_succeeds_when_enough_inventory() throws Exception {
        // given
        given(storeMock.hasEnoughInventory(Product.Shampoo, 5)).willReturn(true);
        final Customer customer = new Customer();

        // when
        final boolean success = customer.purchase(storeMock, Product.Shampoo, 5);

        // then
        assertTrue(success);
        verify(storeMock).removeInventory(Product.Shampoo, 5);
    }

    @Test
    void purchase_fails_when_not_enough_inventory() throws Exception {
        // given
        given(storeMock.hasEnoughInventory(Product.Shampoo, 5)).willReturn(false);
        final Customer customer = new Customer();

        // when
        final boolean success = customer.purchase(storeMock, Product.Shampoo, 5);

        // then
        assertFalse(success);
        then(storeMock).should(never()).removeInventory(Product.Shampoo, 5);
    }
}
