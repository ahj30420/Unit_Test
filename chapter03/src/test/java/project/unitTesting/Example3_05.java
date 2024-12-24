package project.unitTesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Example3_05 {

    @ParameterizedTest
    @MethodSource("provideArguments")
    void Can_detect_an_invalid_delivery_date(
            int daysFromNow, boolean expected
    ) throws Exception {
        // given
         final DeliveryService sut = new DeliveryService();
        final LocalDateTime deliveryDate = LocalDateTime.now().plusDays(daysFromNow);
        final Delivery delivery = new Delivery(deliveryDate);

        // when
        final boolean isValid = sut.isDeliveryValid(delivery);

        // then
        assertSame(expected, isValid);
    }

    @Test
    void The_soonest_delivery_date_is_two_days_from_now() throws Exception {
        // given
        final DeliveryService sut = new DeliveryService();
        final LocalDateTime deliveryDate = LocalDateTime.now().plusDays(2);
        final Delivery delivery = new Delivery(deliveryDate);

        // when
        final boolean isValid = sut.isDeliveryValid(delivery);

        // then
        assertTrue(isValid);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(-1, false),
                Arguments.of(0, false),
                Arguments.of(1, false)
        );
    }
}
