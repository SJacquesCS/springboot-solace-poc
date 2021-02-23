package ca.gc.poc.utils;

import com.solacesystems.jcsmp.JCSMPException;
import com.solacesystems.jcsmp.JCSMPStreamingPublishEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PublishEventHandler implements JCSMPStreamingPublishEventHandler {

    private static final Logger logger = LoggerFactory.getLogger(PublishEventHandler.class);

    @Override
    public void handleError(String s, JCSMPException e, long l) {
        logger.info("Producer received error : " + e);
    }

    @Override
    public void responseReceived(String s) {
        logger.info("Producer received message : " + s);
    }
}
