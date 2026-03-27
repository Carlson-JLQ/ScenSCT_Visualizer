// A program with no method calls should not be flagged as exposing stack traces.
package scensct.var.neg;

public class NegCase1_Var5 {
    // Variant 5: Minimal class with an enum and a ternary operator.
    enum Status { ACTIVE, INACTIVE }
    public static void main(String[] args) {
        Status s = Status.ACTIVE;
        int value = (s == Status.ACTIVE) ? 1 : 0;
    }
}