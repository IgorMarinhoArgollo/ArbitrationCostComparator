package com.ArbitrationCostComparator.domain;

import java.util.HashMap;
import java.util.Map;

public abstract class Fees {
    public static Map<String, Double> getFees( Double registrationFee,
        Double administrationFee, Double arbitratorsFee) {
        Map<String, Double> results = new HashMap<>();
        results.put("registrationFee", registrationFee);
        results.put("administrationFee", administrationFee);
        results.put("arbitratorsFee", arbitratorsFee);

        return results;
    }
}
