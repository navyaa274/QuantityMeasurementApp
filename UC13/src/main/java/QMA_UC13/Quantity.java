package QMA_UC13;

import java.util.function.DoubleBinaryOperator;

public class Quantity <U extends IMeasurable> {
    private double value;
    private U unit;

    public Quantity(double value, U unit) {
        if (unit == null) throw new IllegalArgumentException();
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    public <U extends IMeasurable> double convertTo(U targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
        double baseValue = unit.convertToBaseUnit(value);
        return targetUnit.convertFromBaseUnit(baseValue);
    }

    public Quantity<U> add(Quantity<U> other) {
        validateArithmeticOperands(other, this.unit, false);

        double result = performArithmetic(other, this.unit, ArithmeticOperation.ADD);

        double addedValue = this.unit.convertFromBaseUnit(result);

        return new Quantity<U>(addedValue, this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        validateArithmeticOperands(other, targetUnit, true);

        double result = performArithmetic(other, targetUnit, ArithmeticOperation.ADD);

        double addedValue = targetUnit.convertFromBaseUnit(result);

        return new Quantity<U>(addedValue, targetUnit);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        validateArithmeticOperands(other, this.unit, false);

        double result = performArithmetic(other, this.unit, ArithmeticOperation.SUBTRACT);

        double subValue = this.unit.convertFromBaseUnit(result);

        return new Quantity<U>(subValue, this.unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        validateArithmeticOperands(other, targetUnit, true);

        double result = performArithmetic(other, targetUnit, ArithmeticOperation.SUBTRACT);

        double subValue = targetUnit.convertFromBaseUnit(result);

        return new Quantity<U>(subValue, targetUnit);
    }

    public double divide(Quantity<U> other) {
        validateArithmeticOperands(other, null, false);

        return (performArithmetic(other, null, ArithmeticOperation.DIVIDE));
    }

    private void validateArithmeticOperands(Quantity<U> other, U targetUnit, boolean targetUnitRequired) {
        if (other == null) {
            throw new IllegalArgumentException("Other quantity cannot be null");
        }
        if (this.unit.getClass() != other.unit.getClass()) {
            throw new IllegalArgumentException("Both units must be of same type");
        }
        if (!Double.isFinite(this.value) || !Double.isFinite(other.value)) {
            throw new IllegalArgumentException("Quantities must be finite");
        }
        if (targetUnitRequired)
            if (targetUnit == null) {
                throw new IllegalArgumentException("Target unit cannot be null");
            }
    }

    private enum ArithmeticOperation {
        ADD((a, b) -> a + b),
        SUBTRACT((a, b) -> a - b),
        DIVIDE((a, b) -> {
            if (b == 0.0) throw new ArithmeticException("Divide by zero");
            return a / b;
        });

        private final DoubleBinaryOperator operation;

        ArithmeticOperation(DoubleBinaryOperator operation) {
            this.operation = operation;
        }

        public double compute(double a, double b) {
            return this.operation.applyAsDouble(a, b);
        }
    }

    private double performArithmetic(Quantity<U> other, U targetUnit, ArithmeticOperation operation) {
        double baseValue1 = this.unit.convertToBaseUnit(this.value);
        double baseValue2 = other.unit.convertToBaseUnit(other.value);

        return operation.compute(baseValue1, baseValue2);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Quantity<?> other)) return false;

        double baseValue1 = this.unit.convertToBaseUnit(this.value);
        double baseValue2 = other.unit.convertToBaseUnit(other.value);

        return Double.compare(baseValue1, baseValue2) == 0;
    }

    @Override
    public int hashCode() {
        double baseValue = unit.convertToBaseUnit(value);
        return Double.hashCode(baseValue);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }

    public static void main(String[] args) {

        // ----- LENGTH -----
        Quantity<LengthUnit> lengthInFeet = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> lengthInInches = new Quantity<>(120.0, LengthUnit.INCHES);

        boolean isEqual = lengthInFeet.equals(lengthInInches);
        System.out.println("Are lengths equal? " + isEqual);

        double convertedLength = lengthInFeet.convertTo(LengthUnit.INCHES);
        System.out.println("10 feet in inches: " + convertedLength);

        Quantity<LengthUnit> totalLength = lengthInFeet.add(lengthInInches, LengthUnit.FEET);
        System.out.println("Total Length in feet: " + totalLength.getValue() + " " + totalLength.getUnit());


        // ----- WEIGHT -----
        Quantity<WeightUnit> weightInKilograms = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weightInGrams = new Quantity<>(1000.0, WeightUnit.GRAM);

        isEqual = weightInKilograms.equals(weightInGrams);
        System.out.println("Are weights equal? " + isEqual);

        Quantity<WeightUnit> weightInPounds = new Quantity<>(2.0, WeightUnit.POUND);
        Quantity<WeightUnit> totalWeight = weightInKilograms.add(weightInPounds, WeightUnit.KILOGRAM);
        System.out.println("Total Weight in kilograms: " + totalWeight.getValue() + " " + totalWeight.getUnit());


        // ----- VOLUME (NEW ADDED) -----
        Quantity<VolumeUnit> volumeInLitres = new Quantity<>(2.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volumeInMillilitres = new Quantity<>(2000.0, VolumeUnit.MILLILITRE);

        // Equality check
        isEqual = volumeInLitres.equals(volumeInMillilitres);
        System.out.println("Are volumes equal? " + isEqual);

        // Conversion
        double convertedVolume = volumeInLitres.convertTo(VolumeUnit.MILLILITRE);
        System.out.println("2 litres in millilitres: " + convertedVolume);

        // Addition (same as length/weight pattern)
        Quantity<VolumeUnit> volumeInGallons = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> totalVolume = volumeInLitres.add(volumeInGallons, VolumeUnit.LITRE);
        System.out.println("Total Volume in litres: " + totalVolume.getValue() + " " + totalVolume.getUnit());
    }
}