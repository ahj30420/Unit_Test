package project.unitTesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;

@ExtendWith(MockitoExtension.class)
public class Example5_01 {

    @Mock
    IEmailGateway mock;

    @Test
    void Sending_a_greetings_email() throws Exception {
        // given
        final String email = "user@email.com";
        final Controller sut = new Controller(mock);

        // when
        sut.greetUser(email);

        // then
        then(mock).should(only()).sendGreetingsEmail(email);
    }
}
