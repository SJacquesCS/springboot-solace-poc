package ca.gc.poc.Runner;

import ca.gc.poc.utils.MessageListener;
import com.solacesystems.jcsmp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SolaceRunner implements CommandLineRunner {

    private final Topic topic = JCSMPFactory.onlyInstance().createTopic("try-me");

    private final MessageListener messageListener = new MessageListener();

    @Autowired
    SpringJCSMPFactory solaceFactory;

    @Override
    public void run(String... args) throws Exception {
        final JCSMPSession session = solaceFactory.createSession();

        final XMLMessageConsumer xmlMessageConsumer = session.getMessageConsumer(messageListener);

        session.addSubscription(topic);

        xmlMessageConsumer.start();

    }
}
