import QMA_UC8.QMA_UC8;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import QMA_UC8.Length;
import QMA_UC8.LengthUnit;


public class QMA_UC8Test {
    @Test
    public void testFeetEquality() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(1.0, LengthUnit.FEET);

        assertEquals(l1, l2);
    }

    @Test
    public void testInchesEquality() {
        Length l1 = new Length(1.0, LengthUnit.INCHES);
        Length l2 = new Length(1.0, LengthUnit.INCHES);

        assertEquals(l1, l2);
    }

    @Test
    public void testFeetInchesComparison() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        assertEquals(l1, l2);
    }

    @Test
    public void testFeetInequality() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(2.0, LengthUnit.FEET);

        assertNotEquals(l1, l2);
    }

    @Test
    public void testInchesInequality() {
        Length l1 = new Length(1.0, LengthUnit.INCHES);
        Length l2 = new Length(2.0, LengthUnit.INCHES);

        assertNotEquals(l1, l2);
    }

    @Test
    public void testCrossUnitInequality() {
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
        Length lengthInInches = QMA_UC8.demonstrateConversion(
                3.0, LengthUnit.FEET, LengthUnit.INCHES);
        Length expectedLength = new Length(36.0, LengthUnit.INCHES);

        assertTrue(QMA_UC8.demonstrateLengthEquality(lengthInInches, expectedLength));
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod () {
        Length lengthInYards = new Length(2.0, LengthUnit.YARDS);
        Length lengthInInches = QMA_UC8.demonstrateConversion(
                lengthInYards, LengthUnit.INCHES);
        Length expectedLength = new Length(72.0, LengthUnit.INCHES);

        assertTrue(QMA_UC8.demonstrateLengthEquality(lengthInInches, expectedLength));
    }

    @Test
    public void addFeetAndInches() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        Length sumLength = QMA_UC8.demonstrateLengthAddition(l1, l2);
        Length expectedLength = new Length(2.0, LengthUnit.FEET);

        assertTrue(QMA_UC8.demonstrateLengthEquality(sumLength, expectedLength));
    }

    @Test
    public void addFeetAndInchesWithTargetUnitInches() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        Length sumLength = QMA_UC8.demonstrateLengthAddition(l1, l2, LengthUnit.INCHES);
        Length expectedLength = new Length(24.0, LengthUnit.INCHES);

        assertTrue(QMA_UC8.demonstrateLengthEquality(sumLength, expectedLength));
    }
}
