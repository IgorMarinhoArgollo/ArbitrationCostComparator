package com.ArbitrationCostComparator.categories;


import java.util.Objects;

public class CamarbCategory {
    private String arbitrationType;
    private int numberOfArbitrators;
    private int min;
    private int max;
    private double registrationFee;
    private double arbitratorsFee;
    private double percentageOfArbitratorFee;
    private double administrationFee;
    private double percentageOfAdm;

    public CamarbCategory(String arbitrationType, int numberOfArbitrators, int min, int max, double registrationFee, double arbitratorsFee, double percentageOfArbitratorFee, double administrationFee, double percentageOfAdm) {
        this.arbitrationType = arbitrationType;
        this.numberOfArbitrators = numberOfArbitrators;
        this.min = min;
        this.max = max;
        this.registrationFee = registrationFee;
        this.arbitratorsFee = arbitratorsFee;
        this.percentageOfArbitratorFee = percentageOfArbitratorFee;
        this.administrationFee = administrationFee;
        this.percentageOfAdm = percentageOfAdm;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getRegistrationFee() {
        return registrationFee;
    }

    public double getArbitratorsFee() {
        return arbitratorsFee;
    }

    public double getAdministrationFee() { return administrationFee; }

    public double getPercentageOfAdm() { return percentageOfAdm; }

    public double getPercentageOfArbitratorFee() { return percentageOfArbitratorFee; }

    public static CamarbCategory findCategory(Double value, String arbitrationType, int numberOfArbitrators) {
        CamarbCategory[] categories = {
                // conv - 3 arbitrators
                new CamarbCategory("conv", 3, 0, 2000000, 5000, 296987.54, 0,131994.46, 0),
                new CamarbCategory("conv", 3, 2000000, 4000000, 5000, 296987.54, 4.949792268750,131994.46, 0),
                new CamarbCategory("conv", 3, 4000000, 10000000, 5000, 395983.38, 3.563850433500, 131994.46,0.2639889),
                new CamarbCategory("conv", 3, 10000000, 18000000, 5000, 609814.41, 1.187950144500, 147833.80,0.2375900),
                new CamarbCategory("conv", 3, 18000000, 50000000, 5000, 704850.42, 0.395983381500,166841.00,0.2111911),
                new CamarbCategory("conv", 3, 50000000, 100000000, 5000, 831565.10, 0.356385043350,234422.16,0.1847922),
                new CamarbCategory("conv", 3, 100000000, 150000000, 5000, 1009757.62, 0.237590028900,326818.28,0.1319945),
                new CamarbCategory("conv", 3, 150000000, 300000000, 5000, 1128552.64, 0.158393352600,392815.51,0.0131994),
                new CamarbCategory("conv", 3, 300000000, 500000000, 5000, 1366142.67, 0.118795014450,412614.68,0.0065997),
                new CamarbCategory("conv", 3, 500000000, 1000000000, 5000, 1603732.70, 0.098995845375,425814.13,0.0032999),
                new CamarbCategory("conv", 3, 1000000000, Integer.MAX_VALUE, 5000, 2098711.92, 0.079196676300,442313.44,0.0016499),

                // conv - 1 arbitrator
                new CamarbCategory("conv", 1, 0, 2000000, 5000, 118795.01, 0,131994.46, 0),
                new CamarbCategory("conv", 1, 2000000, 4000000, 5000, 118795.01, 1.97991690750,131994.46, 0),
                new CamarbCategory("conv", 1, 4000000, 10000000, 5000, 158393.35, 1.42554017340, 131994.46,0.2639889),
                new CamarbCategory("conv", 1, 10000000, 18000000, 5000, 243925.76, 0.47518005780, 147833.80,0.2375900),
                new CamarbCategory("conv", 1, 18000000, 50000000, 5000, 281940.17, 0.15839335260,166841.00,0.2111911),
                new CamarbCategory("conv", 1, 50000000, 100000000, 5000, 332626.04, 0.14255401734,234422.16,0.1847922),
                new CamarbCategory("conv", 1, 100000000, 150000000, 5000, 403903.05, 0.09503601156,326818.28,0.1319945),
                new CamarbCategory("conv", 1, 150000000, 300000000, 5000, 451421.05, 0.06335734104,392815.51,0.0131994),
                new CamarbCategory("conv", 1, 300000000, 500000000, 5000, 546457.07, 0.04751800578,412614.68,0.0065997),
                new CamarbCategory("conv", 1, 500000000, 1000000000, 5000, 641493.08, 0.03959833815,425814.13,0.0032999),
                new CamarbCategory("conv", 1, 1000000000, Integer.MAX_VALUE, 5000, 839484.77, 0.03167867052,442313.44,0.0016499),

                // exp - 3 arb
                new CamarbCategory("exp", 3, 0, 1000000, 5000, 119999.70, 0,30000, 0),
                new CamarbCategory("exp", 3, 1000000, 2000000, 5000, 119999.70, 3.733324,30000, 0.9),
                new CamarbCategory("exp", 3, 2000000, 3000000, 5000, 157332.94, 3.733324, 39000,0.9),

                // exp - 1 arb
                new CamarbCategory("exp", 1, 0, 1000000, 5000, 45000, 0,30000, 0),
                new CamarbCategory("exp", 1, 1000000, 2000000, 5000, 45000, 1.4,30000, 0.9),
                new CamarbCategory("exp", 1, 2000000, 3000000, 5000, 59000, 1.4, 39000,0.9),
        };

        for (CamarbCategory category : categories) {
            if (value > category.getMin() && value <= category.getMax() && Objects.equals(arbitrationType, category.arbitrationType) && numberOfArbitrators == category.numberOfArbitrators) {
                return category;
            }
        }

        return null;
    }
}
