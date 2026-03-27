// Equality test where neither operand is a field access expression should not be flagged as static NaN comparison.
package scensct.var.neg;

public class NegCase1_Var3 {
    public static void main(String[] args) {
        // Variant 3: Introduce control flow and temporaries
        double a = 0.0;
        double b = 0.0;
        for (int i = 0; i < 1; i++) {
            a = a / b; // Produces NaN
            b = Double.NaN; // Assignment from field, but comparison uses variable
        }
        boolean flag = (b == a); // b is variable, a is variable
        System.out.println(flag);
    }
}