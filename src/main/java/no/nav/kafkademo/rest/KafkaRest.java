package no.nav.kafkademo.rest;

import no.nav.kafkademo.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaRest {

    private final KafkaProducer producer;

    @Autowired
    public KafkaRest(KafkaProducer producer) {
        this.producer = producer;
    }

    @GetMapping("/send/{message}")
    public String sendMessage(@PathVariable String message) {
        producer.send(message);
        return "Sent message: " + message;
    }

}
