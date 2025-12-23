package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CentralController {

    @Autowired
    private MessageConsumer messageConsumer;

    @GetMapping("/report")
    public Map<String, WarehouseData> getAllWarehouses() {
        // Returns the latest warehouse data collected by the consumer
        return messageConsumer.getCentralData();
    }
}
