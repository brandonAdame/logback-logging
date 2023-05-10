package com.brandon.logging.delegate;

import com.brandon.logging.factory.MessageFactory;
import com.brandon.logging.messageprocessor.MessageProcessor;
import com.brandon.logging.pojo.Message;
import com.brandon.logging.pojo.MsgRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Component
public class MessageProcessorDelegator {
    private final Map<String, MessageProcessor> processorMap;
    private final MessageFactory messageFactory;

    public MessageProcessorDelegator(List<MessageProcessor> messageProcessors, MessageFactory messageFactory) {
        processorMap = messageProcessors.stream().collect(Collectors.toMap(messageProcessor -> messageProcessor.getClass().getSimpleName(), Function.identity()));
        this.messageFactory = messageFactory;
    }

    public Message delegateProcessing(MsgRequest message) {
        MessageProcessor messageProcessor = processorMap.get(message.getType());
        Message msg = messageFactory.createMessage(message);

        if (messageProcessor != null) {
            return messageProcessor.processMessage(msg);
        } else {
            log.info("Returning Empty.");
            return null;
        }
    }
}
