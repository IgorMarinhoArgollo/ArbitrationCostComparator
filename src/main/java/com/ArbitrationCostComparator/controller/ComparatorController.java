package com.ArbitrationCostComparator.controller;

import com.ArbitrationCostComparator.service.ComparatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ComparatorController {

    private final ComparatorService service;

    @Autowired
    public ComparatorController(ComparatorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Object> getResults() {

        Double value = 2000.00;
        String typeOfArbitration = "conv";
        Integer numberOfArbitrators = 5;

        Object response = service.getCosts(value, typeOfArbitration, numberOfArbitrators);
        return ResponseEntity.ok().body(response);
    }
}
