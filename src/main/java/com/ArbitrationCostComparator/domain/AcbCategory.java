package com.ArbitrationCostComparator.domain;


public class AcbCategory {
    private double min;
    private double max;
    private double registrationFee;
    private double arbitratorsFee;

    public AcbCategory(double min, double max, double registrationFee, double arbitratorsFee) {
        this.min = min;
        this.max = max;
        this.registrationFee = registrationFee;
        this.arbitratorsFee = arbitratorsFee;
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

    public static AcbCategory findCategory(Double value) {
        AcbCategory[] categories = {
            new AcbCategory(0, 100000, 1500, 6000),
            new AcbCategory(100000, 250000, 2000, 10000),
            new AcbCategory(250000, 500000, 2500, 15000),
            new AcbCategory(500000, 750000, 3000, 19000),
            new AcbCategory(750000, 1000000, 3500, 23000),
            new AcbCategory(1000000, 2000000, 6500, 30000),
            new AcbCategory(2000000, 5000000, 4500, 32000),
            new AcbCategory(5000000, 10000000, 5000, 38000),
            new AcbCategory(10000000, 20000000, 6000, 45000),
            new AcbCategory(20000000, 50000000, 7000, 52000),
            new AcbCategory(50000000, Double.POSITIVE_INFINITY, 20000, 130000)
        };

        for (AcbCategory category : categories) {
            if (value > category.getMin() && value <= category.getMax()) {
                return category;
            }
        }

        return null;
    }
}
