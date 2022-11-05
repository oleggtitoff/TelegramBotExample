package ua.olehtitov.planner.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import ua.olehtitov.planner.model.Notebook;
import ua.olehtitov.planner.sender.Sender;

@Slf4j
@Component
public class ShowHandler implements Handler {
    private static final String COMMAND = "/show";
    private static final String SHOW_PLANS_MESSAGE = "Ось усі твої плани:\n";

    private final Notebook notebook;
    private final Sender sender;

    public ShowHandler(Notebook notebook, Sender sender) {
        this.notebook = notebook;
        this.sender = sender;
    }

    public boolean isApplicable(Message message) {
        return isCommand(message, COMMAND);
    }

    public void handle(Message message) {
        log.info("/show command was triggered. Inside Show handler");
        String response = SHOW_PLANS_MESSAGE + String.join("\n", notebook.showPlans());
        sender.buildAndSendMessage(message.getChatId(), response);
    }
}
