package QMA_UC6;

public class Length {

    private final double value;
    private final LengthUnit unit;

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        this.value = value;
        this.unit = unit;
    }

    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    public boolean compare(Length thatLength) {
        return Math.abs(this.convertToBaseUnit() - thatLength.convertToBaseUnit()) < 0.0001;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Length thatLength = (Length) obj;
        return this.compare(thatLength);
    }

    public Length convertTo(LengthUnit targetUnit) {
        double baseValue = this.convertToBaseUnit();
        double convertedValue = baseValue / targetUnit.getConversionFactor();
        return new Length(convertedValue, targetUnit);
    }

    public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit) {

        Length temp = new Length(value, sourceUnit);
        return temp.convertTo(targetUnit).value;
    }

    private double convertFromBaseToTargetUnit(double baseValue, LengthUnit targetUnit) {
        return baseValue / targetUnit.getConversionFactor();
    }

    public Length add(Length thatLength) {

        if (thatLength == null) {
            throw new IllegalArgumentException("Length cannot be null");
        }

        double thisBase = this.convertToBaseUnit();
        double thatBase = thatLength.convertToBaseUnit();


        double sumBase = thisBase + thatBase;

        double finalValue = convertFromBaseToTargetUnit(sumBase, this.unit);

        return new Length(finalValue, this.unit);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }

    public static void main(String[] args) {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        Length result = l1.add(l2);

        System.out.println("\n1 foot + 12 inches = " + result);
    }
}