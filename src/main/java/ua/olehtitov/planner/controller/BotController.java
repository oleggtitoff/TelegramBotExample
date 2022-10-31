package ua.olehtitov.planner.controller;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ua.olehtitov.planner.handler.AddHandler;
import ua.olehtitov.planner.handler.ShowHandler;
import ua.olehtitov.planner.handler.StartHandler;

@Slf4j
@Setter
@Component
@ConfigurationProperties("bot")
public class BotController extends TelegramLongPollingBot {
    private String username;
    private String token;

    private StartHandler startHandler;
    private AddHandler addHandler;
    private ShowHandler showHandler;

    public BotController(StartHandler startHandler, AddHandler addHandler,
                         ShowHandler showHandler) {
        this.startHandler = startHandler;
        this.addHandler = addHandler;
        this.showHandler = showHandler;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (hasMessageWithText(update)) {
            logMessage(update.getMessage());
            dispatch(update.getMessage().getText());
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

    private void dispatch(String string) {
        switch (string) {
            case "/start" -> startHandler.handle();
            case "/add" -> addHandler.handle();
            case "/show" -> showHandler.handle();
            default -> log.info("not a command");
        }
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
