package no.nav.kafkademo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> template;

    @Value("${app.topic.foo}")
    private String topic;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    public void send(String message) {
        log.info("Sending message: '{}' to topic: '{}'", message, topic);
        template.send(topic, message);
    }

}
