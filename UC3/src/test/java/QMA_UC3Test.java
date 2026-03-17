import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import QMA_UC3.Length;

public class QMA_UC3Test {
    // Feet to Feet - same value
    @Test
    public void testEquality_FeetToFeet_SameValue() {

        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);

        assertEquals(length1, length2);
    }

    // Inch to Inch - same value
    @Test
    public void testEquality_InchToInch_SameValue() {

        Length length1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(1.0, Length.LengthUnit.INCHES);

        assertEquals(length1, length2);
    }

    // Feet to Inch equivalent value
    @Test
    public void testEquality_FeetToInch_EquivalentValue() {

        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);

        assertEquals(length1, length2);
    }

    // Inch to Feet equivalent value
    @Test
    public void testEquality_InchToFeet_EquivalentValue() {

        Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);

        assertEquals(length1, length2);
    }

    // Feet to Feet different value
    @Test
    public void testEquality_FeetToFeet_DifferentValue() {

        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(2.0, Length.LengthUnit.FEET);

        assertNotEquals(length1, length2);
    }

    // Inch to Inch different value
    @Test
    public void testEquality_InchToInch_DifferentValue() {

        Length length1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(2.0, Length.LengthUnit.INCHES);

        assertNotEquals(length1, length2);
    }

    // Same reference
    @Test
    public void testEquality_SameReference() {

        Length length = new Length(1.0, Length.LengthUnit.FEET);

        assertEquals(length, length);
    }

    // Null comparison
    @Test
    public void testEquality_NullComparison() {

        Length length = new Length(1.0, Length.LengthUnit.FEET);

        assertNotEquals(null, length);
    }

    // Invalid class comparison
    @Test
    public void testEquality_DifferentClass() {

        Length length = new Length(1.0, Length.LengthUnit.FEET);
        String testString = "Length";

        assertNotEquals(length, testString);
    }
}
