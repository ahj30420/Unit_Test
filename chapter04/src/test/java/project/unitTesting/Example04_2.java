package project.unitTesting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Example04_2 {

    @Test
    void Rendering_a_message() throws Exception {
        // given
        final MessageRenderer sut = new MessageRenderer();
        final Message message = new Message();
        message.setHeader("h");
        message.setBody("b");
        message.setFooter("f");

        // when
        final String html = sut.render(message);

        // then
        assertThat(html).isEqualTo("<h1>h</h1><b>b</b><i>f</i>");
    }

}
