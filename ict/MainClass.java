package ict.22.MainClass;

import ict.22.SumClass.SumClass;
import ict.22.DivisorMultipleClass.DivisorMultipleClass;
import ict.22.NumberConversionClass.NumberConversionClass;
import ict.22.CustomPrintClass.CustomPrintClass;

public class MainClass {
    public static void main(String[] args) {
        // Accessing via static instances
        CustomPrintClass p = CustomPrintClass.INSTANCE;
        
        // 1. Sum
        double total = SumClass.INSTANCE.calculateSeries();
        p.pr("Sum of Series: " + total);

        // 2. GCD & LCM
        int gcd = DivisorMultipleClass.INSTANCE.getGCD(12, 18);
        int lcm = DivisorMultipleClass.INSTANCE.getLCM(12, 18);
        p.pr("GCD of 12,18: " + gcd);
        p.pr("LCM of 12,18: " + lcm);

        // 3. Conversions
        String bin = NumberConversionClass.INSTANCE.decimalToBinary(10);
        p.pr("Decimal 10 to Binary: " + bin);
        p.pr("Binary 1010 to Decimal: " + NumberConversionClass.INSTANCE.binaryToDecimal("1010"));
    }
}
