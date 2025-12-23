package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MessageConsumer {

    private final Map<String, WarehouseData> centralData = new ConcurrentHashMap<>();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = {"quickstart-events", "warehouse-1", "warehouse-2"})
    public void processMessage(ConsumerRecord<String, String> record) {
        String topic = record.topic();
        String content = record.value();

        if (topic.equals("quickstart-events")) {
            System.out.println("Read from quickstart-events: " + content);
        } else {
            try {
                WarehouseData data = objectMapper.readValue(content, WarehouseData.class);
                centralData.put(topic, data);
                System.out.println("Warehouse received from " + topic + ": " + data);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }
    public Map<String, WarehouseData> getCentralData() {
        return centralData;
    }

}