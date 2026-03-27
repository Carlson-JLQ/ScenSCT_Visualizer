// A program with no method calls should not be flagged as exposing stack traces.
package scensct.var.neg;

public class NegCase1_Var3 {
    // Variant 3: Static initializer block and instance variable, no methods.
    static {
        int staticVar = 42;
    }
    private int instanceVar = 100;
    public static void main(String[] args) {
        byte b = 127;
    }
}