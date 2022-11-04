package ua.olehtitov.planner.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import ua.olehtitov.planner.sender.Sender;

@Slf4j
@Component
public class StartHandler implements Handler {
    private static final String COMMAND = "/start";
    private static final String START_MESSAGE = "Привіт! Цей бот дозволяє додавати та " +
            "переглядати ваші плани.";

    Sender sender;

    public StartHandler(Sender sender) {
        this.sender = sender;
    }

    public boolean isApplicable(Message message) {
        return isCommand(message, COMMAND);
    }

    public void handle(Message message) {
        log.info("/start command was triggered. Inside Start handler");
        sender.buildAndSendMessage(message.getChatId(), START_MESSAGE);
    }
}
