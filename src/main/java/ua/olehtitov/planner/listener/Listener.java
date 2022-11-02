package ua.olehtitov.planner.listener;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ua.olehtitov.planner.controller.Dispatcher;

@Slf4j
@Setter
@Component
@ConfigurationProperties("bot")
public class Listener extends TelegramLongPollingBot {
    private String username;
    private String token;

    private Dispatcher dispatcher;

    public Listener(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (hasMessageWithText(update)) {
            logMessage(update.getMessage());
            dispatcher.dispatch(update.getMessage().getText());
        } else {
            log.warn("Unexpected update from user");
        }
    }

    private boolean hasMessageWithText(Update update) {
        return update.hasMessage() && update.getMessage().hasText();
    }

    private void logMessage(Message message) {
        Long chatId = message.getChatId();
        String userFirstName = message.getFrom().getFirstName();
        String text = message.getText();

        log.info("[{}, {}] : {}", chatId, userFirstName, text);
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
