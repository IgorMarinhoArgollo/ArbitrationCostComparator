package com.ArbitrationCostComparator.controller;

import com.ArbitrationCostComparator.service.ComparatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ComparatorController {

    private ComparatorService service;

    @Autowired
    public ComparatorController(ComparatorService service) {
        this.service = service;
    }

    @GetMapping
    public String getResults() {
        return service.getScrap();
    }

}
