package QMA_UC2;

public class QMA_UC2 {

    public static class Feet {

        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            Feet feet = (Feet) obj;

            return Double.compare(feet.value, value) == 0;
        }
    }

    public static class Inch {

        private final double value;

        public Inch(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            Inch inch = (Inch) obj;

            return Double.compare(inch.value, value) == 0;
        }
    }

    public static void demonstrateFeetEquality() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        System.out.println("Equal: (" + f1.equals(f2) + ")");

    }

    public static void demonstrateInchEquality() {
        Inch i1 = new Inch(1.0);
        Inch i2 = new Inch(1.0);

        System.out.println("Equal: (" + i1.equals(i2) + ")");
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchEquality();
    }
}