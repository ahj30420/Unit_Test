package project.unitTesting;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class MessageRenderer implements IRenderer{

    private final List<IRenderer> subRenderers;

    public MessageRenderer() {
        this.subRenderers = List.of(
                new HeaderRenderer(),
                new BodyRenderer(),
                new FooterRenderer()
        );
    }

    @Override
    public String render(Message message) {
        return subRenderers.stream()
                .map(x -> x.render(message))
                .collect(Collectors.joining());
    }
}
