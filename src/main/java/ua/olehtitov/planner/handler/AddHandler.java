package ua.olehtitov.planner.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

@Slf4j
@Component
public class AddHandler implements Handler {
    private static final String command = "/add";

    public boolean isApplicable(Message message) {
        return isCommand(message, command);
    }

    public void handle(Message message) {
        log.info("/add command was triggered. Inside Add handler");
    }
}
