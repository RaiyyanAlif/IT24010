package ict.22.CustomPrintClass;

public class CustomPrintClass {
    public static final CustomPrintClass INSTANCE = new CustomPrintClass();
    private CustomPrintClass() {}

    public void pr(Object msg) {
        System.out.println(msg);
    }
}
