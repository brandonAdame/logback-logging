package com.brandon.logging.pojo;

import lombok.*;

@Getter
@Setter
public class StringMessage extends Message {

    public String timestamp;

    public StringMessage(MsgRequest message) {
        super(message.getType(), message.getContent());
    }

    public StringMessage(Message message) {
        super(message.getType(), message.getContent());
    }
}
