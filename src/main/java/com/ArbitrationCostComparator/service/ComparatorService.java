package com.ArbitrationCostComparator.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.ArbitrationCostComparator.model.Acb;


@Service
public class ComparatorService {

    private final Acb acb;

    public ComparatorService(Acb acb) {
        this.acb = acb;
    }

    public Map<String, Map<String, Double>> getCosts(Double value, String typeOfArbitration, Integer numberOfArbitrators, Integer timeEstimation) {
        Map<String, Map<String, Double>> result = new HashMap<>();

        result.put("ACB", acb.fees(value, typeOfArbitration, numberOfArbitrators));
//        result.put("ARBITAC", Arbitac.fees(value, typeOfArbitration, numberOfArbitrators));
//        result.put("CAMERS", Camers.fees(value, typeOfArbitration, numberOfArbitrators));
//        result.put("CAMFIEP", Camfiep.fees(value, typeOfArbitration, numberOfArbitrators));
//        result.put("CAMES", Cames.fees(value, typeOfArbitration, numberOfArbitrators));
//        result.put("CAMAGRO", Camagro.fees(value, typeOfArbitration, numberOfArbitrators));
//
//        result.put("CAMARB", Camarb.fees(value, typeOfArbitration, numberOfArbitrators));
//        result.put("ICCWBO", Iccwbo.fees(value, typeOfArbitration, numberOfArbitrators));

        return result;
    }
}
