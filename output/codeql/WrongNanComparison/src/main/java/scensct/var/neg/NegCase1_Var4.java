// Equality test where neither operand is a field access expression should not be flagged as static NaN comparison.
package scensct.var.neg;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        // Variant 4: Use wrapper objects with auto-unboxing
        Double d1 = Double.NaN; // Autoboxing from field, but operand is variable
        Double d2 = 0.0 / 0.0;
        boolean out = (d1 == d2); // Compares unboxed values, still no field access in expression
        System.out.println(out);
    }
}