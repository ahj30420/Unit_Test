package project.unitTesting;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Example6_03 {

    @Test
    void Adding_a_comment_to_an_article() throws Exception {
        // given
        final Article sut = new Article();
        final String text = "Comment text";
        final String author = "John Doe";
        final LocalDateTime now = LocalDateTime.now();

        // when
        sut.addComment(text, author, now);

        // then
        assertThat(sut.comments().size()).isEqualTo(1);
        assertThat(sut.comments().get(0).text).isEqualTo(text);
        assertThat(sut.comments().get(0).author).isEqualTo(author);
        assertThat(sut.comments().get(0).dateCreated).isEqualTo(now);
    }
}
