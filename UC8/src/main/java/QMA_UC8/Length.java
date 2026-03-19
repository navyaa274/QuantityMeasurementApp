package QMA_UC8;

public class Length {
    private final double value;
    private final LengthUnit unit;

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

    private double convertToBaseUnit(){
        return unit.convertToBaseUnit(value);
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
        double convertedValue = LengthUnit.convertFromBaseToTargetUnit(baseValue, targetUnit);
        return new Length(convertedValue, targetUnit);
    }

    public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit) {

        double baseValue = sourceUnit.convertToBaseUnit(value);
        return LengthUnit.convertFromBaseToTargetUnit(baseValue, targetUnit);
    }

    public Length add(Length thatLength) {

        double thisBase = this.convertToBaseUnit();
        double thatBase = thatLength.convertToBaseUnit();

        double sumBase = thisBase + thatBase;

        double finalValue = LengthUnit.convertFromBaseToTargetUnit(sumBase, this.unit);

        return new Length(finalValue, this.unit);
    }

    public Length add (Length thatLength, LengthUnit targetUnit) {

        double thisBase = this.convertToBaseUnit();
        double thatBase = thatLength.convertToBaseUnit();

        double sumBase = thisBase + thatBase;

        double finalValue = LengthUnit.convertFromBaseToTargetUnit(sumBase, targetUnit);

        return new Length(finalValue, targetUnit);
    }

    @Override
    public String toString() {
        return String.format("%.3f %s", value, unit);
    }

    public static void main(String[] args) {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        System.out.println("Equal: " + l1.equals(l2));

        Length sum = l1.add(l2);
        System.out.println("Sum: " + sum);

        Length converted = l1.convertTo(LengthUnit.INCHES);
        System.out.println("Converted: " + converted);
    }
}
