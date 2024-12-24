package project.unitTesting;

import java.time.LocalDateTime;

public class DeliveryService {

    public boolean isDeliveryValid(Delivery delivery) {
        final LocalDateTime deliveryDate = delivery.getDate();
        final LocalDateTime maxValidDate = LocalDateTime.now().plusMinutes(2 * 24 * 60 - 1);
        return deliveryDate.isEqual(maxValidDate) || deliveryDate.isAfter(maxValidDate);
    }
}
