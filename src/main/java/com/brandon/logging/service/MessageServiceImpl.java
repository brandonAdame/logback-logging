package com.brandon.logging.service;

import com.brandon.logging.delegate.MessageProcessorDelegator;
import com.brandon.logging.pojo.Message;
import com.brandon.logging.pojo.MsgRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageServiceImpl implements MessageService {

    private final MessageProcessorDelegator messageProcessorDelegator;

    public MessageServiceImpl(MessageProcessorDelegator messageProcessorDelegator) {
        this.messageProcessorDelegator = messageProcessorDelegator;
    }

    @Override
    public Message processMessage(MsgRequest message) {
        // Do some other processing

        // Further message processing
        return messageProcessorDelegator.delegateProcessing(message);
    }
}
