package project.unitTesting;

import org.junit.jupiter.api.Test;

import static project.unitTesting.ArticleExtensions.shouldContainNumberOfComments;
import static project.unitTesting.ArticleExtensions.withComment;

import java.time.LocalDateTime;

public class Example6_04 {

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
        shouldContainNumberOfComments(sut, 1);
        withComment(sut,text,author,now);
    }
}
