@FunctionalInterface
interface SupportsArithmetic {
    boolean isSupported();
}

public interface IMeasurable {
    SupportsArithmetic supportsArithmetic = () -> true;

    public double getConversionFactor();
    public double convertToBaseUnit(double value);
    public double convertFromBaseUnit(double baseValue);
    public String getUnitName();

    default boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    default void validateOperationSupport(String operation){}

    public static void main(String[] args) {
        System.out.println("QMA_UC13.IMeasurable Interface");
    }
}
