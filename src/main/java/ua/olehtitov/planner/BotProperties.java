package ua.olehtitov.planner;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Configuration
@ConfigurationProperties("bot")
public class BotProperties {
    private String username;
    private String token;
}
