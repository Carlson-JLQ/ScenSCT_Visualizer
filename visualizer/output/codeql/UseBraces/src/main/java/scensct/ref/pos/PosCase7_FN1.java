// Unbraced if-then with misleading indentation where body is not terminal and successor is non-empty non-local-type should be flagged as positive.
package scensct.ref.pos;

public class PosCase7_FN1 {
    public static void main(String[] args) {
        boolean condition = true;
        if (condition)
            System.out.println("Then branch"); // Unbraced body, not terminal
        System.out.println("Non-empty successor"); // Same line start, indented further, not a local type declaration
    }
}