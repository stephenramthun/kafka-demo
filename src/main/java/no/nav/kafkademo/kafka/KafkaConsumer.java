package no.nav.kafkademo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "${app.topic.test}")
    public void listen(@Payload String message) {
        log.info("Received message: {}", message);
    }

}
