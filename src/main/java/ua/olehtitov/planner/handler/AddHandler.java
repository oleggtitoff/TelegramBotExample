package ua.olehtitov.planner.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import ua.olehtitov.planner.model.Notebook;
import ua.olehtitov.planner.sender.Sender;

@Slf4j
@Component
public class AddHandler implements Handler {
    private static final String COMMAND = "/add";
    private static final String WRITE_PLAN_PROMPT = "Додаємо новий план. Опиши його:";
    private static final String ADD_PLAN_DONE = "План додано.";

    private final Notebook notebook;
    private final Sender sender;

    private boolean isWaitingForText = false;

    public AddHandler(Notebook notebook, Sender sender) {
        this.notebook = notebook;
        this.sender = sender;
    }

    public boolean isApplicable(Message message) {
        return isCommand(message, COMMAND) || isWaitingForText;
    }

    public void handle(Message message) {
        log.info("/add command was triggered. Inside Add handler");

        if (isWaitingForText) {
            notebook.addPlan(message.getText());
            sender.buildAndSendMessage(message.getChatId(), ADD_PLAN_DONE);
            isWaitingForText = false;
        } else {
            sender.buildAndSendMessage(message.getChatId(), WRITE_PLAN_PROMPT);
            isWaitingForText = true;
        }
    }
}
