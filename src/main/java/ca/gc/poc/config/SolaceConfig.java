package ca.gc.poc.config;

import ca.gc.poc.utils.PublishEventHandler;
import com.solacesystems.jcsmp.JCSMPException;
import com.solacesystems.jcsmp.JCSMPSession;
import com.solacesystems.jcsmp.SpringJCSMPFactory;
import com.solacesystems.jcsmp.XMLMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SolaceConfig {

    @Autowired
    private SpringJCSMPFactory solaceFactory;

    @Bean
    protected JCSMPSession jcsmpSession() throws JCSMPException {
        JCSMPSession session = solaceFactory.createSession();
        session.connect();
        return session;
    }

    @Bean
    public XMLMessageProducer xmlMessageProducer(JCSMPSession session) throws JCSMPException {
        PublishEventHandler publishEventHandler = new PublishEventHandler();
        return session.getMessageProducer(publishEventHandler);
    }


}
