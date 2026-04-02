package QMA_UC10;

public class QMA_UC10 {
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

    public static void main(String[] args) {
        Quantity<WeightUnit> weightInGrams = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> weightInKilograms = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        boolean areEqual = demonstrateEquality(weightInGrams, weightInKilograms);
        System.out.println("Are weights equal? " + areEqual);

        Quantity<WeightUnit> convertedWeight = demonstrateConversion(weightInGrams, WeightUnit.KILOGRAM);
        System.out.println("Converted weight: " + convertedWeight.getValue() +  " " +  convertedWeight.getUnit());

        Quantity<WeightUnit> weightInPounds = new Quantity<>(2.20462, WeightUnit.POUND);
        Quantity<WeightUnit> sumWeight = demonstrateAddition(weightInKilograms, weightInPounds);
        System.out.println("Sum Weight: " + sumWeight.getValue() +  " " +  sumWeight.getUnit());

        Quantity<WeightUnit> sumWeightInGrams = demonstrateAddition(weightInKilograms, weightInPounds, WeightUnit.GRAM);
        System.out.println("Sum Weight in grams: " +  sumWeightInGrams.getValue() +  " " +  sumWeightInGrams.getUnit());
    }
}
