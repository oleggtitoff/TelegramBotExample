package ua.olehtitov.planner.sender;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Setter
@Component
@ConfigurationProperties("bot")
public class Sender extends DefaultAbsSender {
    private String token;

    public Sender() {
        super(new DefaultBotOptions());
    }

    @Override
    public String getBotToken() {
        return token;
    }

    public void buildAndSendMessage(Long chatId, String text) {
        sendMessage(buildMessage(chatId, text));
    }

    private SendMessage buildMessage(Long chatId, String text) {
        return SendMessage
                .builder()
                .chatId(chatId)
                .text(text)
                .build();
    }

    private void sendMessage(SendMessage sendMessage) {
        try {
            this.sendApiMethod(sendMessage);
        } catch (TelegramApiException e) {
            log.error("Exception when sending message: ", e);
        }
    }
}