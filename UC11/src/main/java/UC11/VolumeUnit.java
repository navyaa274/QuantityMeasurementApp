package UC11;

public enum VolumeUnit implements IMeasurable{
    LITRE(1.0),
    MILLILITRE(0.001),
    GALLON(3.78541);

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {
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
        double litres = 2.0;

        double baseValue = VolumeUnit.LITRE.convertToBaseUnit(litres);
        System.out.println(litres + " litres is " + baseValue + " litres (base unit)");

        double milliLitres = VolumeUnit.MILLILITRE.convertFromBaseUnit(baseValue);
        System.out.println(litres + " litres is " + milliLitres + " millilitres");

        double gallons = VolumeUnit.GALLON.convertFromBaseUnit(baseValue);
        System.out.println(litres + " litres is " + gallons + " gallons");
    }
}
