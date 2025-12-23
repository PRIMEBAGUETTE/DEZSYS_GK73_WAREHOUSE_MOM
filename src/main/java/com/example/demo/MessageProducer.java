package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private final WarehouseSimulation sim = new WarehouseSimulation();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/send")
    public String sendMessage(@RequestParam(value = "message", defaultValue = "") String message) {
        kafkaTemplate.send("quickstart-events", message);
        return "Message '" + message + "' sent.";
    }

    @Scheduled(fixedRate = 10000) //
    public void sendWarehouse1() {
        try {
            WarehouseData data = sim.getData("1");
            String json = objectMapper.writeValueAsString(data);
            kafkaTemplate.send("warehouse-1", json);
            System.out.println("Warehouse 1 sent: " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedRate = 60000)
    public void sendWarehouse2() {
        try {
            WarehouseData data = sim.getData("2");
            String json = objectMapper.writeValueAsString(data);
            kafkaTemplate.send("warehouse-2", json);
            System.out.println("Warehouse 2 sent: " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}