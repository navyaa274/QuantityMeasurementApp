import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import QMA_UC2.QMA_UC2.Feet;
import QMA_UC2.QMA_UC2.Inch;


public class QMA_UC2Test {

    @Test
    public void testFeetEquality_SameValue() {

        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);

        assertEquals(feet1, feet2);
    }

    @Test
    public void testFeetEquality_DifferentValue() {

        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(2.0);

        assertNotEquals(feet1, feet2);
    }

    @Test
    public void testFeetEquality_NullComparison() {

        Feet feet = new Feet(1.0);

        assertNotEquals(null, feet);
    }

    @Test
    public void testFeetEquality_DifferentClass() {

        Feet feet = new Feet(1.0);
        String otherObject = "Not a Feet object";

        assertNotEquals(feet, otherObject);
    }

    @Test
    public void testFeetEquality_SameReference() {

        Feet feet = new Feet(1.0);

        assertEquals(feet, feet);
    }

    ///////////// Inch ///////////////

    @Test
    public void testInchEquality_SameValue() {

        Inch inch1 = new Inch(1.0);
        Inch inch2 = new Inch(1.0);

        assertEquals(inch1, inch2);
    }

    @Test
    public void testInchEquality_DifferentValue() {

        Inch inch1 = new Inch(1.0);
        Inch inch2 = new Inch(2.0);

        assertNotEquals(inch1, inch2);
    }

    @Test
    public void testInchEquality_NullComparison() {

        Inch inch = new Inch(1.0);

        assertNotEquals(null, inch);
    }

    @Test
    public void testInchEquality_DifferentClass() {

        Inch inch = new Inch(1.0);
        String otherObject = "Not an Inch object";

        assertNotEquals(inch, otherObject);
    }

    @Test
    public void testInchEquality_SameReference() {

        Inch inch = new Inch(1.0);

        assertEquals(inch, inch);
    }
}