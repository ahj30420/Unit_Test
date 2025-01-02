package project.unitTesting;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ArticleExtensions {

    public static void shouldContainNumberOfComments(Article article, int commentCount){
        assertThat(article.comments().size()).isEqualTo(commentCount);
    }

    public static void withComment(Article article, String text, String author, LocalDateTime dateCreated) {
        final List<Comment> comments = article.comments();
        final Comment comment = getSingleOrDefault(comments, text, author, dateCreated);
        assertThat(comment).isNotNull();
    }

    private static Comment getSingleOrDefault(List<Comment> comments, String text, String author, LocalDateTime dateCreated) {
        if(comments.size() > 1) {
            throw new IllegalArgumentException();
        }
        if(comments.isEmpty()) {
            return new Comment(text, author, dateCreated);
        }
        return comments.get(0);
    }
}
