package QMA_UC9;

public enum WeightUnit {
    MILLIGRAM(0.001),
    GRAM(1.0),
    KILOGRAM(1000.0),
    POUND(453.592),
    TONNE(1_000_000.0);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    double convertToBaseUnit(double value) {
        return value * this.conversionFactor;
    }

    static double convertFromBaseToTargetUnit(double baseValue, WeightUnit targetUnit) {
        return baseValue / targetUnit.conversionFactor;
    }

    public static void main(String[] args) {
        double kilograms = 10.0;
        double grams = WeightUnit.KILOGRAM.convertToBaseUnit(kilograms);

        System.out.println(kilograms + " kilograms is " + grams + " grams");

        double milligrams = WeightUnit.convertFromBaseToTargetUnit(grams, WeightUnit.MILLIGRAM);
        System.out.println(grams + " grams is " + milligrams + " milligrams");
    }

}
