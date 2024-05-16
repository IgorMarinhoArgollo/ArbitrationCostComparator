package com.ArbitrationCostComparator.controller;

import com.ArbitrationCostComparator.model.Acb;
import com.ArbitrationCostComparator.model.Camarb;
import com.ArbitrationCostComparator.model.Ccbc;
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
    private final Acb acb;
    private final Ccbc ccbc;
    private final Camarb camarb;

    @Autowired
    public ComparatorController(ComparatorService service, Acb acb, Ccbc ccbc, Camarb camarb) {
        this.service = service;
        this.acb = acb;
        this.ccbc = ccbc;
        this.camarb = camarb;
    }

    @GetMapping
    public ResponseEntity<Object> getResults() {
        double value = 3000;
        String typeOfArbitration = "exp";
        int numberOfArbitrators = 3;
        int estimatedTime = 12;

        if (numberOfArbitrators == 1 || numberOfArbitrators == 3) {
            Object response = service.getCosts(value, typeOfArbitration, numberOfArbitrators, estimatedTime);
            return ResponseEntity.ok().body(response);
        } else {
            return ResponseEntity.badRequest().body("Number of Arbitrators must be 1 or 3");
        }
    }
}
