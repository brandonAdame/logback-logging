package com.brandon.logging.messageprocessor;

import com.brandon.logging.pojo.Message;
import com.brandon.logging.pojo.StringMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StringMessageProcessor implements MessageProcessor {
    @Override
    public Message processMessage(Message message) {
        StringMessage stringMessage = new StringMessage(message);
        stringMessage.setTimestamp("Afternoon");

        return stringMessage;
    }
}
