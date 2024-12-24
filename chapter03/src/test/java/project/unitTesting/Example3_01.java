package project.unitTesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example3_01 {

    @Test
    void Sum_of_two_numbers() throws Exception {
        // given
        double first = 10;
        double second = 20;
//        final Calculator calculator = new Calculator();
        final Calculator sut = new Calculator(); // sut를 의존성과 구별하라!

        // when
        final double result = sut.sum(first, second);

        // then
        assertEquals(30, result);
    }

}
