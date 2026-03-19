package QMA_UC9;

public class QMA_UC9 {
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

    ////////////// WEIGHT //////////////

    public static boolean demonstrateWeightEquality (Weight weight1, Weight weight2) {
        return weight1.equals(weight2);
    };

    public static boolean demonstrateWeightComparison(Weight weight1, Weight weight2) {
        return weight1.compare(weight2);
    }

    public static Weight demonstrateConversion(double value, WeightUnit sourceUnit, WeightUnit targetUnit){
        double convertedValue = Weight.convert(value, sourceUnit, targetUnit);

        return new Weight(convertedValue, targetUnit);
    }

    public static Weight demonstrateConversion(Weight weight, WeightUnit targetUnit){
        return weight.convertTo(targetUnit);
    }

    public static Weight demonstrateWeightAddition(Weight weight1, Weight weight2) {

        if (weight1 == null || weight2 == null) {
            throw new IllegalArgumentException("Weights cannot be null");
        }

        return weight1.add(weight2);
    }

    public static Weight demonstrateWeightAddition(Weight weight1, Weight weight2, WeightUnit targetUnit) {

        if (weight1 == null || weight2 == null) {
            throw new IllegalArgumentException("Weights cannot be null");
        }

        return weight1.add(weight2, targetUnit);
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

        ////////////// WEIGHT //////////////

        Weight w1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000.0, WeightUnit.GRAM);

        System.out.println("Are 1 kg and 1000 gms equal? " +
                demonstrateWeightEquality(w1, w2));


        Weight w3 = new Weight(0.001, WeightUnit.GRAM);
        Weight w4 = new Weight(1.0, WeightUnit.MILLIGRAM);

        System.out.println("Are 0.001 gm and 1 mg equal? " +
                demonstrateWeightComparison(w3, w4));


        Weight wResult1 = demonstrateConversion(1.0,
                WeightUnit.POUND,
                WeightUnit.GRAM);

        System.out.println("1 pound in gm: " + wResult1);


        Weight w5 = new Weight(1000.0, WeightUnit.GRAM);
        Weight wResult2 = demonstrateConversion(w5, WeightUnit.KILOGRAM);

        System.out.println("1000 gms in kg: " + wResult2);


        Weight wResult3 = demonstrateConversion(1.0,
                WeightUnit.KILOGRAM,
                WeightUnit.POUND);

        System.out.println("1 kg in pounds: " + wResult3);

        Weight wSum = demonstrateWeightAddition(w1, w2);
        System.out.println("1 kg + 1000 gms = " + wSum);

        Weight poundSum = demonstrateWeightAddition(w1, w2, WeightUnit.POUND);
        System.out.println("1 kg + 1000 gms = " + poundSum);
    }
}
