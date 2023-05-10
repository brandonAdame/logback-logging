package com.brandon.logging.service;

import com.brandon.logging.pojo.Message;
import com.brandon.logging.pojo.MsgRequest;

@FunctionalInterface
public interface MessageService {
    Message processMessage(MsgRequest message);
}
