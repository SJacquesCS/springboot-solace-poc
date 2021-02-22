package ca.gc.poc.service;

import ca.gc.poc.dto.SolaceMessage;
import ca.gc.poc.utils.PublishEventHandler;
import com.solacesystems.jcsmp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolaceService {

    private final PublishEventHandler eventHandler = new PublishEventHandler();

    @Autowired
    private SpringJCSMPFactory solaceFactory;
    @Autowired
    private JCSMPProperties properties;


    public String sendMessage(SolaceMessage solaceMessage) {

        try {
            final JCSMPSession session = solaceFactory.createSession();

            XMLMessageProducer producer = session.getMessageProducer(eventHandler);

            final Topic topic = JCSMPFactory.onlyInstance().createTopic(solaceMessage.getTopic());

            TextMessage message = JCSMPFactory.onlyInstance().createMessage(TextMessage.class);

            message.setText(solaceMessage.getMessage());

            producer.send(message, topic);

        } catch (JCSMPException exception) {
            return exception.getMessage();
        }

        return "Message sent successfully. :)";
    }
}
