package id.co.elevenia.legacy.mailer.web.rest;

import id.co.elevenia.legacy.mailer.service.EleveniaLegacyMailerKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/elevenia-legacy-mailer-kafka")
public class EleveniaLegacyMailerKafkaResource {

    private final Logger log = LoggerFactory.getLogger(EleveniaLegacyMailerKafkaResource.class);

    private EleveniaLegacyMailerKafkaProducer kafkaProducer;

    public EleveniaLegacyMailerKafkaResource(EleveniaLegacyMailerKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
