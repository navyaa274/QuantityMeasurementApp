package QMA_UC4;

public class Length {
    private final double value;
    private final LengthUnit unit;

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.00),
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
        this.value = value;
        this.unit = unit;
    }

    public double convertToBaseUnit() {
        return value*unit.getConversionFactor();
    }

    public boolean compare(Length thatLength) {
        return this.convertToBaseUnit() == thatLength.convertToBaseUnit();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Length thatLength = (Length) obj;

        return this.compare(thatLength);
    }

    public static void main(String[] args) {
        Length l1 = new Length(1.0, LengthUnit.YARDS);
        Length l2 = new Length(3.0, LengthUnit.FEET);
        Length l3 = new Length(91.44, LengthUnit.CENTIMETERS);

        System.out.println("Yards vs Feet: " + l1.compare(l2));
        System.out.println("Feet vs Centimeter: " + l2.compare(l3));
    }
}

