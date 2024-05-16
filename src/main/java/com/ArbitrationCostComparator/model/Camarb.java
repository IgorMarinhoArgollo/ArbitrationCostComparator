package com.ArbitrationCostComparator.model;

import com.ArbitrationCostComparator.categories.AcbCategory;
import com.ArbitrationCostComparator.categories.Fees;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Camarb {
    public Map<String, Double> fees(Double value, String disputeType, Integer numberOfArbitrators) {
        AcbCategory category = AcbCategory.findCategory(value);

        if (category != null) {
            double registrationFee = category.getRegistrationFee();
            double adminFee = calculateAdminFee(value);
            double arbitratorsFee = calculateArbitratorsFee(category, numberOfArbitrators);

            if (disputeType.equals("exp")) {
                adminFee *= 0.7;
                arbitratorsFee *= 0.7;
            }

            return Fees.getFees(registrationFee, adminFee, arbitratorsFee);
        }

        return null;
    }

    private Double calculateAdminFee(Double value) {
        double adminFee = Math.min(0.02 * value, 180000);
        return Math.max(adminFee, 5000);
    }

    private Double calculateArbitratorsFee(AcbCategory category, Integer numberOfArbitrators) {
        return (numberOfArbitrators == 1) ?
            category.getArbitratorsFee() * 1.15 :
            category.getArbitratorsFee() * numberOfArbitrators;
    }

}
