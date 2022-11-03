package ua.olehtitov.planner.dispatcher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import ua.olehtitov.planner.handler.Handler;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class Dispatcher {
    private final List<Handler> handlers;

    public Dispatcher(List<Handler> handlers) {
        this.handlers = new ArrayList<>(handlers);
    }

    public void dispatch(Message message) {
        boolean handled = false;

        for (Handler handler : handlers) {
            if (handler.isApplicable(message)) {
                handler.handle();
                handled = true;
            }
        }

        if (!handled) {
            log.info("not a command");
        }
    }
}
