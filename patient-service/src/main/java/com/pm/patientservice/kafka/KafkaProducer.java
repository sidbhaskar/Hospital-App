package com.pm.patientservice.kafka;

import com.pm.patientservice.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;


@Service
public class KafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String,byte[]> kafkaTemplate;

    public  KafkaProducer(KafkaTemplate<String,byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvents(Patient patient){
        PatientEvent event = PatientEvent.newBuilder()
                .setId(patient.getId().toString())
                .setName(patient.getName())
                .setEmail(patient.getEmail())
                .setEventType("PATIENT_CREATED")
                .build();

        try{
            kafkaTemplate.send("patient", event.toByteArray());
        }
        catch (Exception e){
            log.error("Error sending event {}",event);
        }

    }
}
