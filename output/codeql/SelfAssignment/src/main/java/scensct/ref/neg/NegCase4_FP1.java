// Static field assignment with same field name but no common qualifier should not be flagged as self-assignment.
package scensct.ref.neg;

public class NegCase4_FP1 {
    static int count = 0;
    public static void main(String[] args) {
        count = count; // Direct assignment var = var, but 'count' is a static field with no qualifier variable // [REPORTED LINE]
    }
}