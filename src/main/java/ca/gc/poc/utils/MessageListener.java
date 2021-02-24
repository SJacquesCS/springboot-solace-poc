package ca.gc.poc.utils;

import com.solacesystems.jcsmp.BytesXMLMessage;
import com.solacesystems.jcsmp.JCSMPException;
import com.solacesystems.jcsmp.TextMessage;
import com.solacesystems.jcsmp.XMLMessageListener;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class MessageListener implements XMLMessageListener {

    private static final Logger logger = LoggerFactory.getLogger(MessageListener.class);
    @Getter
    private CountDownLatch latch = new CountDownLatch(1);

    @Override
    public void onReceive(BytesXMLMessage msg) {
        if (msg instanceof TextMessage) {
            logger.info("Text message received : " + ((TextMessage) msg).getText());
        } else {
            logger.info("Message received.");
        }
        latch.countDown();
    }

    @Override
    public void onException(JCSMPException e) {
        logger.info("Consumer received exception : " + e);
        latch.countDown();
    }
}
