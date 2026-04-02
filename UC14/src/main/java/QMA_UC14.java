public class QMA_UC14 {
    public static <U extends IMeasurable> boolean
    demonstrateEquality(Quantity<U> quantity1, Quantity<U> quantity2) {
        if (quantity1 == null || quantity2 == null) {
            throw new IllegalArgumentException("Quantities cannot be null");
        }

        return quantity1.equals(quantity2);
    }

    public static <U extends IMeasurable> Quantity<U>
    demonstrateConversion(Quantity<U> quantity, U targetUnit){
        if (quantity == null || targetUnit == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        double convertedValue = quantity.convertTo(targetUnit);

        return new Quantity<>(convertedValue, targetUnit);
    }

    public static <U extends IMeasurable> Quantity<U>
    demonstrateAddition(Quantity<U> quantity1, Quantity<U> quantity2) {

        if (quantity1 == null || quantity2 == null) {
            throw new IllegalArgumentException("Quantities cannot be null");
        }

        return quantity1.add(quantity2);
    }

    public static <U extends IMeasurable> Quantity<U>
    demonstrateAddition(Quantity<U> quantity1, Quantity<U> quantity2, U targetUnit) {

        if (quantity1 == null || quantity2 == null || targetUnit == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        return quantity1.add(quantity2, targetUnit);
    }

    public static <U extends IMeasurable> Quantity<U>
    demonstrateSubtraction(Quantity<U> quantity1, Quantity<U> quantity2) {

        if (quantity1 == null || quantity2 == null) {
            throw new IllegalArgumentException("Quantities cannot be null");
        }

        return quantity1.subtract(quantity2);
    }

    public static <U extends IMeasurable> Quantity<U>
    demonstrateSubtraction(Quantity<U> quantity1, Quantity<U> quantity2, U targetUnit) {

        if (quantity1 == null || quantity2 == null || targetUnit == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        return quantity1.subtract(quantity2, targetUnit);
    }

    public static <U extends IMeasurable> double
    demonstrateDivision(Quantity<U> quantity1, Quantity<U> quantity2) {

        if (quantity1 == null || quantity2 == null) {
            throw new IllegalArgumentException("Quantities cannot be null");
        }

        return quantity1.divide(quantity2);
    }

    public static void main(String[] args) {
        Quantity<TemperatureUnit> temp1 = new Quantity<>(0.0,
                TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> temp2 = new Quantity<>(32.0,
                TemperatureUnit. FAHRENHEIT);
        System.out.println("0°C equals 32°F: " + temp1.equals(temp2));

        Quantity<TemperatureUnit> celsius = new Quantity<>(100.0,
                TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> fahrenheit = new Quantity<>(
                celsius.convertTo(TemperatureUnit.FAHRENHEIT), TemperatureUnit.FAHRENHEIT);
        System.out.println( " 100 deg C = " + fahrenheit.getValue() + "°F");

        try {
            celsius.add(new Quantity<>(50.0, TemperatureUnit.CELSIUS));
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot add absolute temperatures: " + e.getMessage());
        }
    }
}
