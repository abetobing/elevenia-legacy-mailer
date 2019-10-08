package id.co.elevenia.legacy.mailer.web.rest;

import id.co.elevenia.legacy.mailer.EleveniaLegacyMailerApp;
import id.co.elevenia.legacy.mailer.config.SecurityBeanOverrideConfiguration;
import id.co.elevenia.legacy.mailer.service.EleveniaLegacyMailerKafkaProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EmbeddedKafka
@SpringBootTest(classes = {SecurityBeanOverrideConfiguration.class, EleveniaLegacyMailerApp.class})
public class EleveniaLegacyMailerKafkaResourceIT {

    @Autowired
    private EleveniaLegacyMailerKafkaProducer kafkaProducer;

    private MockMvc restMockMvc;

    @BeforeEach
    public void setup() {
        EleveniaLegacyMailerKafkaResource kafkaResource = new EleveniaLegacyMailerKafkaResource(kafkaProducer);

        this.restMockMvc = MockMvcBuilders.standaloneSetup(kafkaResource)
            .build();
    }

    @Test
    public void sendMessageToKafkaTopic() throws Exception {
        restMockMvc.perform(post("/api/elevenia-legacy-mailer-kafka/publish?message=yolo"))
            .andExpect(status().isOk());
    }
}
