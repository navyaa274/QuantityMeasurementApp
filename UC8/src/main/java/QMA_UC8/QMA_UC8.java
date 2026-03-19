package QMA_UC8;

public class QMA_UC8 {
    public static boolean demonstrateLengthEquality (Length length1, Length length2) {
        return length1.equals(length2);
    };

    public static boolean demonstrateLengthComparison(Length length1, Length length2) {
        return length1.compare(length2);
    }

    public static Length demonstrateConversion(double value, LengthUnit sourceUnit, LengthUnit targetUnit){
        double convertedValue = Length.convert(value, sourceUnit, targetUnit);

        return new Length(convertedValue, targetUnit);
    }

    public static Length demonstrateConversion(Length length, LengthUnit targetUnit){
        return length.convertTo(targetUnit);
    }

    public static Length demonstrateLengthAddition(Length length1, Length length2) {

        if (length1 == null || length2 == null) {
            throw new IllegalArgumentException("Lengths cannot be null");
        }

        return length1.add(length2);
    }

    public static Length demonstrateLengthAddition(Length length1, Length length2, LengthUnit targetUnit) {

        if (length1 == null || length2 == null) {
            throw new IllegalArgumentException("Lengths cannot be null");
        }

        return length1.add(length2, targetUnit);
    }

    public static void main(String[] args) {

        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        System.out.println("Are 1 foot and 12 inches equal? " +
                demonstrateLengthEquality(l1, l2));


        Length l3 = new Length(30.48, LengthUnit.CENTIMETERS);
        Length l4 = new Length(1.0, LengthUnit.FEET);

        System.out.println("Are 30.48 cm and 1 foot equal? " +
                demonstrateLengthComparison(l3, l4));


        Length result1 = demonstrateConversion(1.0,
                LengthUnit.FEET,
                LengthUnit.INCHES);

        System.out.println("1 Foot in Inches: " + result1);


        Length l5 = new Length(100.0, LengthUnit.CENTIMETERS);
        Length result2 = demonstrateConversion(l5, LengthUnit.INCHES);

        System.out.println("100 cm in Inches: " + result2);


        Length result3 = demonstrateConversion(30.48,
                LengthUnit.CENTIMETERS,
                LengthUnit.FEET);

        System.out.println("30.48 cm in Feet: " + result3);

        Length sum = demonstrateLengthAddition(l1, l2);
        System.out.println("1 foot + 12 inches = " + sum);

        Length yardsSum = demonstrateLengthAddition(l1, l2, LengthUnit.YARDS);
        System.out.println("1 foot + 12 inches = " + yardsSum);
    }
}
