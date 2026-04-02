package UC12;

public class Quantity <U extends IMeasurable> {
    private double value;
    private U unit;

    public Quantity(double value, U unit) {
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
        if (other == null) {
            throw new IllegalArgumentException("Other quantity cannot be null");
        }

        double baseValue1 = this.unit.convertToBaseUnit(this.value);
        double baseValue2 = other.unit.convertToBaseUnit(other.value);

        double sumBase = baseValue1 + baseValue2;

        double finalValue = this.unit.convertFromBaseUnit(sumBase);

        return new Quantity<>(finalValue, this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        double baseValue1 = this.unit.convertToBaseUnit(this.value);
        double baseValue2 = other.unit.convertToBaseUnit(other.value);

        double sumBase = baseValue1 + baseValue2;

        double finalValue = targetUnit.convertFromBaseUnit(sumBase);

        return new Quantity<>(finalValue, targetUnit);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        if (other == null) {
            throw new IllegalArgumentException("Other quantity cannot be null");
        }

        double baseValue1 = this.unit.convertToBaseUnit(this.value);
        double baseValue2 = other.unit.convertToBaseUnit(other.value);

        double diffBase = baseValue1 - baseValue2;

        double finalValue = this.unit.convertFromBaseUnit(diffBase);

        return new Quantity<>(finalValue, this.unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        double baseValue1 = this.unit.convertToBaseUnit(this.value);
        double baseValue2 = other.unit.convertToBaseUnit(other.value);

        double diffBase = baseValue1 - baseValue2;

        double finalValue = targetUnit.convertFromBaseUnit(diffBase);

        return new Quantity<>(finalValue, targetUnit);
    }

    public double divide(Quantity<U> other) {
        if (other == null) {
            throw new IllegalArgumentException("Other quantity cannot be null");
        }
        if (!other.unit.equals(this.unit)) {
            throw new IllegalArgumentException("Both units must be same");
        }
        if (other.value == 0){
            throw new ArithmeticException("Cannot divide by zero");
        }

        double baseValue1 = this.unit.convertToBaseUnit(this.value);
        double baseValue2 = other.unit.convertToBaseUnit(other.value);

        double quotientBase = baseValue1 / baseValue2;

        double finalValue = this.unit.convertFromBaseUnit(quotientBase);

        return finalValue;
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
