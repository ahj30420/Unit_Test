package project.unitTesting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class Example04_1 {

    @Test
    void MeessageRenderer_uses_correct_sub_renderers() throws Exception {
        // given
        final MessageRenderer sut = new MessageRenderer();

        // when
        final List<IRenderer> renderers = sut.getSubRenderers();

        // then
        assertThat(renderers.size()).isEqualTo(3);
        assertThat(renderers.get(0)).isInstanceOf(HeaderRenderer.class);
        assertThat(renderers.get(1)).isInstanceOf(BodyRenderer.class);
        assertThat(renderers.get(2)).isInstanceOf(FooterRenderer.class);
    }
}
