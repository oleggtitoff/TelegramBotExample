package ua.olehtitov.planner.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.olehtitov.planner.handler.AddHandler;
import ua.olehtitov.planner.handler.ShowHandler;
import ua.olehtitov.planner.handler.StartHandler;

@Slf4j
@Component
public class Dispatcher {
    private final StartHandler startHandler;
    private final AddHandler addHandler;
    private final ShowHandler showHandler;

    public Dispatcher(StartHandler startHandler, AddHandler addHandler,
                      ShowHandler showHandler) {
        this.startHandler = startHandler;
        this.addHandler = addHandler;
        this.showHandler = showHandler;
    }

    public void dispatch(String string) {
        switch (string) {
            case "/start" -> startHandler.handle();
            case "/add" -> addHandler.handle();
            case "/show" -> showHandler.handle();
            default -> log.info("not a command");
        }
    }
}
