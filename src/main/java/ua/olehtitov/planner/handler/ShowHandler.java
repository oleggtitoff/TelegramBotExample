package ua.olehtitov.planner.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ShowHandler implements Handler{
    public void handle() {
        log.info("/show command was triggered. Inside Show handler");
    }
}
