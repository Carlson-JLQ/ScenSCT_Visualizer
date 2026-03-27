// Equality test where field access is to a non-float/double type should not be flagged as static NaN comparison.
package scensct.var.neg;

public class NegCase2_Var3 {
    static final int MAX_VALUE = 100;
    static final String CONST = "NaN";

    public static void main(String[] args) {
        // Variant 3: Control-flow restructuring with branching
        boolean test1, test2;
        if (MAX_VALUE >= 0) {
            test1 = (MAX_VALUE == 100); // Inside branch, same int static field
        } else {
            test1 = false;
        }
        test2 = (CONST != "test") ? true : false; // Ternary instead of direct assignment
        System.out.println(test1 + " " + test2);
    }
}