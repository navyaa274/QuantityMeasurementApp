package QMA_UC9;

public class Weight {
    private final double value;
    private final WeightUnit unit;
    public Weight(double value, WeightUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }
    public WeightUnit getUnit() {
        return unit;
    }

    private double convertToBaseUnit(){
        return unit.convertToBaseUnit(value);
    }

    public boolean compare(Weight thatWeight) {
        return Math.abs(this.convertToBaseUnit() - thatWeight.convertToBaseUnit()) < 0.0001;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Weight thatWeight = (Weight) obj;
        return this.compare(thatWeight);
    }

    public Weight convertTo(WeightUnit targetUnit) {
        double baseValue = this.convertToBaseUnit();
        double convertedValue = WeightUnit.convertFromBaseToTargetUnit(baseValue, targetUnit);
        return new Weight(convertedValue, targetUnit);
    }

    public static double convert(double value, WeightUnit sourceUnit, WeightUnit targetUnit) {

        double baseValue = sourceUnit.convertToBaseUnit(value);
        return WeightUnit.convertFromBaseToTargetUnit(baseValue, targetUnit);
    }

    public Weight add(Weight thatWeight) {

        double thisBase = this.convertToBaseUnit();
        double thatBase = thatWeight.convertToBaseUnit();

        double sumBase = thisBase + thatBase;

        double finalValue = WeightUnit.convertFromBaseToTargetUnit(sumBase, this.unit);

        return new Weight(finalValue, this.unit);
    }

    public Weight add (Weight thatWeight, WeightUnit targetUnit) {

        double thisBase = this.convertToBaseUnit();
        double thatBase = thatWeight.convertToBaseUnit();

        double sumBase = thisBase + thatBase;

        double finalValue = WeightUnit.convertFromBaseToTargetUnit(sumBase, targetUnit);

        return new Weight (finalValue, targetUnit);
    }

    @Override
    public String toString() {
        return String.format("%.3f %s", value, unit);
    }

    public static void main(String[] args) {
        Weight l1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight l2 = new Weight(1000.0, WeightUnit.GRAM);

        System.out.println("Equal: " + l1.equals(l2));

        Weight sum = l1.add(l2);
        System.out.println("Sum: " + sum);

        Weight converted = l1.convertTo(WeightUnit.GRAM);
        System.out.println("Converted: " + converted);
    }
}
