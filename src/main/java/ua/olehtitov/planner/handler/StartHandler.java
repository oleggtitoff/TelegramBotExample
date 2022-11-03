package ua.olehtitov.planner.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

@Slf4j
@Component
public class StartHandler implements Handler {
    private static final String command = "/start";

    public boolean isApplicable(Message message) {
        return isCommand(message, command);
    }

    public void handle() {
        log.info("/start command was triggered. Inside Start handler");
    }
}
