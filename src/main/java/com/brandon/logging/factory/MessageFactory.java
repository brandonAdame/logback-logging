package com.brandon.logging.factory;

import com.brandon.logging.pojo.CryptoMessage;
import com.brandon.logging.pojo.Message;
import com.brandon.logging.pojo.MsgRequest;
import com.brandon.logging.pojo.StringMessage;
import org.springframework.stereotype.Component;

@Component
public class MessageFactory {
    public Message createMessage(MsgRequest msgRequest) {
        if (msgRequest.getType().equals("StringMessageProcessor")) {
            return new StringMessage(msgRequest);
        } else if (msgRequest.getType().equals("CryptoMessageProcessor")) {
            return new CryptoMessage(msgRequest);
        }

        return null;
    }
}
