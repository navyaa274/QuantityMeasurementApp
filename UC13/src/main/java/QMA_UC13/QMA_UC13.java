package QMA_UC13;

public class QMA_UC13 {
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

        Quantity<VolumeUnit> volumeInMillilitres = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> volumeInLitres = new Quantity<>(1.0, VolumeUnit.LITRE);

        boolean areEqual = demonstrateEquality(volumeInMillilitres, volumeInLitres);
        System.out.println("Are volumes equal? " + areEqual);

        Quantity<VolumeUnit> convertedVolume = demonstrateConversion(volumeInMillilitres, VolumeUnit.LITRE);
        System.out.println("Converted volume: " + convertedVolume.getValue() + " " + convertedVolume.getUnit());

        Quantity<VolumeUnit> volumeInGallons = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> sumVolume = demonstrateAddition(volumeInLitres, volumeInGallons);
        System.out.println("Sum Volume: " + sumVolume.getValue() + " " + sumVolume.getUnit());

        Quantity<VolumeUnit> sumVolumeInMillilitres =
                demonstrateAddition(volumeInLitres, volumeInGallons, VolumeUnit.MILLILITRE);
        System.out.println("Sum Volume in millilitres: " +
                sumVolumeInMillilitres.getValue() + " " + sumVolumeInMillilitres.getUnit());

        Quantity<VolumeUnit> v1 = new Quantity<>(4.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(2.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> diff = demonstrateSubtraction(v1, v2);
        System.out.println("Difference in Volumes: " + diff.getValue() + " " + diff.getUnit());

        Quantity<VolumeUnit> diffml = demonstrateSubtraction(v1, v2, VolumeUnit.MILLILITRE);
        System.out.println("Difference in Volumes in ml: " + diffml.getValue() + " " + diffml.getUnit());

        double prod = demonstrateDivision(v1, v2);
        System.out.println("Division of Volumes: " + prod);


    }
}
