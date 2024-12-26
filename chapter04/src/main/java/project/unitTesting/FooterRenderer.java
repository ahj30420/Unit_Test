package project.unitTesting;

public class FooterRenderer implements IRenderer {

    @Override
    public String render(Message message) {
        return String.format("<i>%s</i>", message.getFooter());
    }
}
