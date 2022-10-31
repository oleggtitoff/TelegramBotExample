package ua.olehtitov.planner.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AddHandler {
    public void handle() {
        log.info("/add command was triggered. Inside Add handler");
    }
}
