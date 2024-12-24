package project.unitTesting;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Delivery {

    private LocalDateTime date;

    public Delivery(LocalDateTime date) {
        this.date = date;
    }
}
