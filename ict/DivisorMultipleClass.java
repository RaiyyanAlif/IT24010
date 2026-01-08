package ict.22.DivisorMultipleClass;

public class DivisorMultipleClass {
    public static final DivisorMultipleClass INSTANCE = new DivisorMultipleClass();
    private DivisorMultipleClass() {}

    public int getGCD(int a, int b) {
        return b == 0 ? a : getGCD(b, a % b);
    }

    public int getLCM(int a, int b) {
        return (a * b) / getGCD(a, b);
    }
}
