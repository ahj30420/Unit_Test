package project.unitTesting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertSame;

public class Example3_04 {

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

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(-1, false),
                Arguments.of(0, false),
                Arguments.of(1, false),
                Arguments.of(2, true)
        );
    }
}
