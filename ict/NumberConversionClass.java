package ict.22.NumberConversionClass;

public class NumberConversionClass {
    public static final NumberConversionClass INSTANCE = new NumberConversionClass();
    private NumberConversionClass() {}

    public String decimalToBinary(int n) { return Integer.toBinaryString(n); }
    public String decimalToHex(int n) { return Integer.toHexString(n).toUpperCase(); }
    public String decimalToOctal(int n) { return Integer.toOctalString(n); }
    
    public int binaryToDecimal(String s) { return Integer.parseInt(s, 2); }
}
