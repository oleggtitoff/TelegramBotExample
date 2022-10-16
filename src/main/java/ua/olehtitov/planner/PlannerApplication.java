package ua.olehtitov.planner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.RequiredArgsConstructor;
import jakarta.annotation.PostConstruct;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
@RequiredArgsConstructor
public class PlannerApplication {
    private static final Logger log = LoggerFactory.getLogger(PlannerApplication.class);
    private final SimpleEchoBot simpleEchoBot;

    public static void main(String[] args) {
        SpringApplication.run(PlannerApplication.class, args);
    }

    @PostConstruct
    public void init() throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        simpleEchoBot.setLog(log);
        try {
            log.info("Registering bot...");
            telegramBotsApi.registerBot(simpleEchoBot);
        } catch (TelegramApiRequestException e) {
            log.error("Failed to register bot(check internet connection / bot token or make sure " +
                    "only one instance of bot is running).", e);
        }
        log.info("Telegram bot is ready to accept updates from user......");
    }
}
