package ua.olehtitov.planner.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StartHandler {
    public void handle() {
        log.info("/start command was triggered. Inside Start handler");
    }
}
