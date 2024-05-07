package com.ArbitrationCostComparator.model;

import com.ArbitrationCostComparator.domain.Fees;
import java.util.Map;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public abstract class Cbma {
    public static Map<String, Double> fees(double value, String typeOfArbitration, Integer numberOfArbitrators) {

        Double registrationFee = value;
        Double administrationFee;

        if (Objects.equals(typeOfArbitration, "exp")) {
            administrationFee = value * 2;
        } else {
            administrationFee = value * 3;
        }

        Double arbitratorsFee = value * numberOfArbitrators;

        return Fees.getFees(registrationFee, administrationFee, arbitratorsFee);
    }
}
