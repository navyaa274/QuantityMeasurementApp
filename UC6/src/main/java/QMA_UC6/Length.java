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

    @Override
    public String toString() {
        return value + " " + unit;
    }

    public static void main(String[] args) {
        System.out.println("1 Foot = " +
                Length.convert(1.0, LengthUnit.FEET, LengthUnit.INCHES) + " Inches");

        System.out.println("100 cm = " +
                Length.convert(100.0, LengthUnit.CENTIMETERS, LengthUnit.INCHES) + " Inches");

        System.out.println("30.48 cm = " +
                Length.convert(30.48, LengthUnit.CENTIMETERS, LengthUnit.FEET) + " Feet");

        // Equality check
        Length a = new Length(1.0, LengthUnit.FEET);
        Length b = new Length(12.0, LengthUnit.INCHES);

        System.out.println("\nAre 1 foot and 12 inches equal? " + a.equals(b));
    }
}