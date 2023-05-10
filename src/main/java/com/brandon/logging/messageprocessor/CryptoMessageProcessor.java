package com.brandon.logging.messageprocessor;

import com.brandon.logging.pojo.CryptoMessage;
import com.brandon.logging.pojo.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CryptoMessageProcessor implements MessageProcessor {
    @Override
    public Message processMessage(Message message) {
        CryptoMessage cryptoMessage = new CryptoMessage(message);
        cryptoMessage.setCoin("BTC");
        cryptoMessage.setPrice(100);

        return cryptoMessage;
    }
}
