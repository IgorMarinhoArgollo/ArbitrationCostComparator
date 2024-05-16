package com.ArbitrationCostComparator.service;

import java.util.HashMap;
import java.util.Map;

import com.ArbitrationCostComparator.model.Camarb;
import com.ArbitrationCostComparator.model.Ccbc;
import org.springframework.stereotype.Service;

import com.ArbitrationCostComparator.model.Acb;


@Service
public class ComparatorService {

    private final Acb acb;
    private final Ccbc ccbc;
    private final Camarb camarb;

    public ComparatorService(Acb acb, Ccbc ccbc, Camarb camarb) {
        this.acb = acb;
        this.ccbc = ccbc;
        this.camarb = camarb;
    }

    public Map<String, Object> getCosts(Double value, String typeOfArbitration, int numberOfArbitrators, Integer estimatedTime) {
        Map<String, Object> result = new HashMap<>();


        Map<String, Object> inputObject = new HashMap<>();
        inputObject.put("value", value);
        inputObject.put("arbitrationType", typeOfArbitration);
        inputObject.put("numberOfArbitrators", numberOfArbitrators);
        inputObject.put("estimatedTime", estimatedTime);
        result.put("Input", inputObject);


        result.put("CCBC", ccbc.fees(value, typeOfArbitration, numberOfArbitrators));
        result.put("CAMARB", ccbc.fees(value, typeOfArbitration, numberOfArbitrators));
        result.put("ACB", acb.fees(value, typeOfArbitration, numberOfArbitrators));

        return result;
    }
}
