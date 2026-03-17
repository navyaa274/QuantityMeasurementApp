import QMA_UC1.QMA_UC1.Feet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class QMA_UC1Test {

    @Test
    public void testEquality_SameValue() {

        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);

        assertEquals(feet1, feet2);
    }

    @Test
    public void testEquality_DifferentValue() {

        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(2.0);

        assertNotEquals(feet1, feet2);
    }

    @Test
    public void testEquality_NullComparison() {

        Feet feet = new Feet(1.0);

        assertNotEquals(null, feet);
    }

    @Test
    public void testEquality_DifferentClass() {

        Feet feet = new Feet(1.0);
        String otherObject = "Not a Feet object";

        assertNotEquals(feet, otherObject);
    }

    @Test
    public void testEquality_SameReference() {

        Feet feet = new Feet(1.0);

        assertEquals(feet, feet);
    }
}