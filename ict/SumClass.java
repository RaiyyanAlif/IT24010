package ict.22.SumClass;

public class SumClass {
    public static final SumClass INSTANCE = new SumClass();
    private SumClass() {}

    public double calculateSeries() {
        double sum = 0;
        for (double i = 1.0; i >= 0.1; i -= 0.1) {
            sum += i;
        }
        return sum;
    }
}
