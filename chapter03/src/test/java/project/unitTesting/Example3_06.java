package project.unitTesting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertSame;

public class Example3_06 {

    @ParameterizedTest
    @MethodSource("provideArguments")
    void Can_detect_an_invalid_delivery_date(
            LocalDateTime deliveryDate, boolean expected
    ) throws Exception {
        // given
        final DeliveryService sut = new DeliveryService();
        final Delivery delivery = new Delivery(deliveryDate);

        // when
        final boolean isValid = sut.isDeliveryValid(delivery);

        // then
        assertSame(expected, isValid);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(LocalDateTime.now().minusDays(1L), false),
                Arguments.of(LocalDateTime.now(), false),
                Arguments.of(LocalDateTime.now().plusDays(1L), false),
                Arguments.of(LocalDateTime.now().plusDays(2L), true)
        );
    }
}
