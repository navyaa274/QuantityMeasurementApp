package QMA_UC1;
import java.util.Scanner;

public class QMA_UC1 {

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

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        Feet f1 = new Feet(scn.nextDouble());
        Feet f2 = new Feet(scn.nextDouble());

        System.out.println("Equal: (" + f1.equals(f2) + ")");
    }
}