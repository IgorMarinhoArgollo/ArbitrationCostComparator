package com.ArbitrationCostComparator.model;

import com.ArbitrationCostComparator.domain.AcbCategory;
import com.ArbitrationCostComparator.domain.Fees;
import java.util.Map;

public abstract class Acb {
    public static Map<String, Double> fees(Double value, String disputeType, Integer numberOfArbitrators) {
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

    private static Double calculateAdminFee(Double value) {
        double adminFee = Math.min(0.02 * value, 180000);
        return Math.max(adminFee, 5000);
    }

    private static Double calculateArbitratorsFee(AcbCategory category, Integer numberOfArbitrators) {
        return (numberOfArbitrators == 1) ?
            category.getArbitratorsFee() * 1.15 :
            category.getArbitratorsFee() * numberOfArbitrators;
    }

}
