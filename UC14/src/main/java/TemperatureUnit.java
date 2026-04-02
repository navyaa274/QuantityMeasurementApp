import java.util.function.Function;

public enum TemperatureUnit implements IMeasurable {
    CELSIUS(false),
    FAHRENHEIT(true);

    final Function<Double, Double> FAHRENHEIT_TO_CELSIUS = (fahrenheit) -> (fahrenheit - 32) * 5 / 9;

    final Function<Double, Double> CELSIUS_TO_CELSIUS = (celsius) -> (celsius);

    Function<Double, Double> conversionValue;

    SupportsArithmetic supportsArithmetic = () -> false;

    TemperatureUnit(boolean isFahrenheit) {
        if(isFahrenheit) conversionValue = x -> (x - 32) * 5 / 9;
        else conversionValue = x -> x;
    }

    public double getConversionFactor() {
        return 1.0;
    }

    public double convertToBaseUnit(double value) {
        return conversionValue.apply(value);
    }

    public double convertFromBaseUnit(double baseValue) {
        if(this == CELSIUS) return baseValue;

        return baseValue * 9/5 + 32;
    }

    public String getUnitName() {
        return this.name().toLowerCase();
    }

    public double convertTo(double value, TemperatureUnit targetUnit) {
        double baseValue = convertToBaseUnit(value);

        return targetUnit.convertFromBaseUnit(baseValue);
    }

    @Override
    public boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    @Override
    public void validateOperationSupport(String operation) {

        if (!supportsArithmetic.isSupported()) {
            String message = this.name() + " does not support " + operation + " operations.";
            throw new UnsupportedOperationException(message);
        }
    }

    public static void main(String[] args) {
        System.out.println("TemperatureUnit Enum");
        for(TemperatureUnit tempUnit: TemperatureUnit.values()){
            System.out.println(tempUnit + " has conversion function to base unit: " + tempUnit.conversionValue);
        }

        System.out.println("Does TemperatureUnit support arithmetic operations?" +
                TemperatureUnit.CELSIUS.supportsArithmetic() + " for Celsius, " +
                TemperatureUnit.FAHRENHEIT.supportsArithmetic() +  " for Fahrenheit");
    }
}
