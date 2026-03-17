package QMA_UC3;

public class Length {
    private double value;
    private LengthUnit unit;

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0);

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
        Length length = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        System.out.println("Are lengths equal? " + length.compare(length2));
    }
}

