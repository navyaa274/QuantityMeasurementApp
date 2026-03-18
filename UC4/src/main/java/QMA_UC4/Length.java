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
        return Math.abs(this.convertToBaseUnit() - thatLength.convertToBaseUnit()) < 0.0001;
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
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);
        System.out.println("Are lengths equal? " + l1.equals(l2));

        Length l3 = new Length(1.0, LengthUnit.YARDS);
        Length l4 = new Length(36.0, LengthUnit.INCHES);
        System.out.println("Are lengths equal? " + l3.equals(l4));

        Length l5 = new Length(100.0, LengthUnit.CENTIMETERS);
        Length l6 = new Length(39.3701, LengthUnit.INCHES);
        System.out.println("Are lengths equal? " + l5.equals(l6));
    }
}

