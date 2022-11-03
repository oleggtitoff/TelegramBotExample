package ua.olehtitov.planner.handler;

import org.telegram.telegrambots.meta.api.objects.Message;

public interface Handler {
    boolean isApplicable(Message message);
    void handle();

    default boolean isCommand(Message message, String command) {
        return message.isCommand() && message.getText().equals(command);
    }
}
