package project.unitTesting;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


public class Example6_05 {

    @Test
    void Adding_a_comment_to_an_article() throws Exception {
        // given
        final Article sut = new Article();
        final Comment comment = new Comment(
                "Comment text",
                "John Doe",
                LocalDateTime.now()
        );

        // when
        sut.addComment(comment.text, comment.author, comment.dateCreated);

        // then
        assertThat(sut.comments()).containsExactly(comment);
    }
}
