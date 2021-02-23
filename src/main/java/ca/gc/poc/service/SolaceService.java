package ca.gc.poc.service;

import ca.gc.poc.dto.SolaceMessage;
import ca.gc.poc.utils.PublishEventHandler;
import com.solacesystems.jcsmp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolaceService {

    @Autowired
    private SpringJCSMPFactory solaceFactory;
    @Autowired
    private JCSMPProperties properties;
    @Autowired
    private XMLMessageProducer producer;


    public String sendMessage(SolaceMessage solaceMessage) {

        try {
            final Topic topic = JCSMPFactory.onlyInstance().createTopic(solaceMessage.getTopic());
            final TextMessage message = JCSMPFactory.onlyInstance().createMessage(TextMessage.class);

            message.setDeliveryMode(DeliveryMode.PERSISTENT);
            message.setCorrelationKey(topic);
            message.setText(solaceMessage.getMessage());

            producer.send(message, topic);
        } catch (JCSMPException exception) {
            String message = exception.getMessage();
            return message;
        }

        return "Message sent successfully. :)";
    }
}
