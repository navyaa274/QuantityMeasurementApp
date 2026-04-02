package UC11;

public class QMA_UC11 {
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
    }
}
