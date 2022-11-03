package ua.olehtitov.planner.handler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShowHandlerTests {
    private ShowHandler showHandler;
    private MessageEntity messageEntity;
    private Message message;

    @BeforeEach
    void init() {
        showHandler = new ShowHandler();
        messageEntity = new MessageEntity();
        messageEntity.setOffset(0);
        message = new Message();
    }

    @Test
    void isApplicableTrueTest() {
        messageEntity.setType("bot_command");
        message.setEntities(Collections.singletonList(messageEntity));
        message.setText("/show");
        assertTrue(showHandler.isApplicable(message));
    }

    @Test
    void isApplicableFalseNotACommandTest() {
        messageEntity.setType("not_a_command");
        message.setEntities(Collections.singletonList(messageEntity));
        message.setText("/show");
        assertFalse(showHandler.isApplicable(message));
    }

    @Test
    void isApplicableFalseWrongCommandTest() {
        messageEntity.setType("bot_command");
        message.setEntities(Collections.singletonList(messageEntity));
        message.setText("/wrong_command");
        assertFalse(showHandler.isApplicable(message));
    }
}
