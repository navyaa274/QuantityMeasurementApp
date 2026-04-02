package UC11;

public enum LengthUnit implements IMeasurable{
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

    public double convertToBaseUnit(double value) {
        return value * this.conversionFactor;
    }

    public double convertFromBaseUnit(double baseValue) { return baseValue / this.conversionFactor;
    }

    public String getUnitName() {
        return this.name().toLowerCase();
    }

    public static void main(String[] args) {
        double feet = 12.0;
        double inches = LengthUnit.FEET.convertToBaseUnit(feet);

        System.out.println(feet + " feet is " + inches + " inches");

        double yard = LengthUnit.YARDS.convertFromBaseUnit(inches);
        System.out.println(inches + " inches is " + yard + " yards");
    }
}
