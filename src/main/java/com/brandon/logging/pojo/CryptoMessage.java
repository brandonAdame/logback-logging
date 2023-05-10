package com.brandon.logging.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CryptoMessage extends Message {
    public String coin;
    public int price;

    public CryptoMessage(MsgRequest message) {
        super(message.getType(), message.getContent());
    }

    public CryptoMessage(Message message) {
        super(message.getType(), message.getContent());
    }
}
