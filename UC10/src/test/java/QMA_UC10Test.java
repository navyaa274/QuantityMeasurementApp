import QMA_UC10.*;
import QMA_UC10.QMA_UC10.*;

import org.junit.jupiter.api.Test;

import static QMA_UC10.QMA_UC10.demonstrateConversion;
import static org.junit.jupiter.api.Assertions.*;

public class QMA_UC10Test {
    @Test
    public void lengthFeetEqualsInches() {
        Quantity<LengthUnit> l1 = new Quantity<LengthUnit>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<LengthUnit>(12.0, LengthUnit.INCHES);

        assertEquals(l1, l2);
    }

    @Test
    public void lengthYardsEqualsFeet() {
        Quantity<LengthUnit> l1 = new Quantity<LengthUnit>(1.0, LengthUnit.YARDS);
        Quantity<LengthUnit> l2 = new Quantity<LengthUnit>(3.0, LengthUnit.FEET);

        assertEquals(l1, l2);
    }

    @Test
    public void weightKilogramsEqualsGrams() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(1000.0, WeightUnit.GRAM);

        assertEquals(w1, w2);
    }

    @Test
    public void weightPoundsEqualsGrams() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(1.0, WeightUnit.POUND);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(453.592, WeightUnit.GRAM);

        assertEquals(w1, w2);
    }

    @Test
    public void convertLengthFeetToInches() {
        Quantity<LengthUnit> l1 = new Quantity<LengthUnit>(3.0, LengthUnit.FEET);

        Quantity<LengthUnit> converted = demonstrateConversion(l1, LengthUnit.INCHES);
        Quantity<LengthUnit> expected = new Quantity<LengthUnit>(36.0, LengthUnit.INCHES);

        assertEquals(converted, expected);
    }

    @Test
    public void addLengthFeetAndInches() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(10.0, LengthUnit.INCHES);

        assertNotEquals(l1, l2);
    }

    @Test
    public void testMultipleFeetComparison() {
        Length l1 = new Length(2.0, LengthUnit.FEET);
        Length l2 = new Length(24.0, LengthUnit.INCHES);

        assertEquals(l1, l2);
    }

    @Test
    public void yardEquals36Inches() {
        Length l1 = new Length(1.0, LengthUnit.YARDS);
        Length l2 = new Length(36.0, LengthUnit.INCHES);

        assertEquals(l1, l2);
    }

    @Test
    public void centimeterEquals39point3701Inches() {
        Length l1 = new Length(100.0, LengthUnit.CENTIMETERS);
        Length l2 = new Length(39.3701, LengthUnit.INCHES);

        assertEquals(l1, l2);
    }

    @Test
    public void threeFeetEqualsOneYard() {
        Length l1 = new Length(1.0, LengthUnit.YARDS);
        Length l2 = new Length(3.0, LengthUnit.FEET);

        assertEquals(l1, l2);
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(30.48, LengthUnit.CENTIMETERS);

        assertEquals(l1, l2);
    }

    @Test
    public void yardNotEqualToInches() {
        Length l1 = new Length(1.0, LengthUnit.YARDS);
        Length l2 = new Length(1.0, LengthUnit.INCHES);

        assertNotEquals(l1, l2);
    }

    @Test
    public void referenceEqualitySameObject() {
        Length l1 = new Length(1.0, LengthUnit.YARDS);

        assertEquals(l1, l1);
    }

    @Test
    public void equalsReturnsFalseForNull() {
        Length l1 = new Length(1.0, LengthUnit.YARDS);

        assertNotEquals(null, l1);
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {
        Length l1 = new Length(1.0, LengthUnit.YARDS);
        Length l2 = new Length(3.0, LengthUnit.FEET);
        Length l3 = new Length(36.0, LengthUnit.INCHES);

        boolean b1 = l1.equals(l2);
        boolean b2 = l2.equals(l3);

        assertEquals(b1, b2);

    }

    @Test
    public void differentValuesSameUnitNotEqual() {
        Length l1 = new Length(1.0, LengthUnit.YARDS);
        Length l2 = new Length(2.0, LengthUnit.YARDS);

        assertNotEquals(l1, l2);
    }

    @Test
    public void crossUnitEqualityDemonstrateMethod() {
        Length l1 = new Length(1.0, LengthUnit.YARDS);
        Length l2 = new Length(3.0, LengthUnit.FEET);

        assertEquals(l1, l2);
    }

    @Test
    public void convertFeetToInches() {
        Length lengthInInches = QMA_UC9.demonstrateConversion(
                3.0, LengthUnit.FEET, LengthUnit.INCHES);
        Length expectedLength = new Length(36.0, LengthUnit.INCHES);

        assertTrue(QMA_UC9.demonstrateLengthEquality(lengthInInches, expectedLength));
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod () {
        Length lengthInYards = new Length(2.0, LengthUnit.YARDS);
        Length lengthInInches = QMA_UC9.demonstrateConversion(
                lengthInYards, LengthUnit.INCHES);
        Length expectedLength = new Length(72.0, LengthUnit.INCHES);

        assertTrue(QMA_UC9.demonstrateLengthEquality(lengthInInches, expectedLength));
    }

    @Test
    public void addFeetAndInches() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        Length sumLength = QMA_UC9.demonstrateLengthAddition(l1, l2);
        Length expectedLength = new Length(2.0, LengthUnit.FEET);

        assertTrue(QMA_UC9.demonstrateLengthEquality(sumLength, expectedLength));
    }

    @Test
    public void addFeetAndInchesWithTargetUnitInches() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        Length sumLength = QMA_UC9.demonstrateLengthAddition(l1, l2, LengthUnit.INCHES);
        Length expectedLength = new Length(24.0, LengthUnit.INCHES);

        assertTrue(QMA_UC9.demonstrateLengthEquality(sumLength, expectedLength));
    }

    ////////////// WEIGHT //////////////

    @Test
    public void kilogramEquals1000Gram() {
        Weight w1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000.0, WeightUnit.GRAM);

        assertEquals(w1, w2);
    }

    @Test
    public void poundEquals453Point592Grams() {
        Weight w1 = new Weight(1.0, WeightUnit.POUND);
        Weight w2 = new Weight(453.592, WeightUnit.GRAM);

        assertEquals(w1, w2);
    }

    @Test
    public void tonneEquals1000000Grams() {
        Weight w1 = new Weight(1.0, WeightUnit.TONNE);
        Weight w2 = new Weight(1000000.0, WeightUnit.GRAM);

        assertEquals(w1, w2);
    }

    @Test
    public void kilogramNotEqualToPound() {
        Weight w1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1.0, WeightUnit.POUND);

        assertNotEquals(w1, w2);

    }

    @Test
    public void additionOfWeightEqualsExpected() {
        Weight w1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000.0, WeightUnit.GRAM);

        Weight sumWeight = QMA_UC9.demonstrateWeightAddition(w1, w2);
        Weight expectedWeight = new Weight(2.0, WeightUnit.KILOGRAM);

        assertTrue(QMA_UC9.demonstrateWeightEquality(sumWeight, expectedWeight));
    }
}
