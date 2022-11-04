package ua.olehtitov.planner.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

@Slf4j
@Component
public class ShowHandler implements Handler {
    private static final String command = "/show";

    public boolean isApplicable(Message message) {
        return isCommand(message, command);
    }

    public void handle(Message message) {
        log.info("/show command was triggered. Inside Show handler");
    }
}
