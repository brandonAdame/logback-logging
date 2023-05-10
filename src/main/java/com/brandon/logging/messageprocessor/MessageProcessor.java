package com.brandon.logging.messageprocessor;

import com.brandon.logging.pojo.Message;

@FunctionalInterface
public interface MessageProcessor {
    Message processMessage(Message message);
}
