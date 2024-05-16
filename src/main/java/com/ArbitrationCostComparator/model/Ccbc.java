package com.ArbitrationCostComparator.model;

import com.ArbitrationCostComparator.categories.CcbcCategory;
import com.ArbitrationCostComparator.categories.Fees;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

@Component
public class Ccbc {
    public Map<String, Double> fees(Double value, String disputeType, int numberOfArbitrators) {
        CcbcCategory category = CcbcCategory.findCategory(value, disputeType, numberOfArbitrators);

        if (category != null) {
            double registrationFee = category.getRegistrationFee();
            double adminFee = calculateAdminFee(category, value);
            double arbitratorsFee = calculateArbitratorsFee(category, value);


            return Fees.getFees(registrationFee, adminFee, arbitratorsFee);
        }

        if(Objects.equals(disputeType, "exp") && value >= 3000000) { return null; }

        return null;
    }

    private Double calculateAdminFee(CcbcCategory category, Double value) {
        return category.getAdministrationFee() + (value - category.getMin())*category.getPercentageOfAdm();
    }

    private Double calculateArbitratorsFee(CcbcCategory category, Double value) {
        return category.getArbitratorsFee() + (value - category.getMin())*category.getPercentageOfArbitratorFee();

    }

}
