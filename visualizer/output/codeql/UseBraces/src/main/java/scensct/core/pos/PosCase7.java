// Unbraced if-then with misleading indentation where body is not terminal and successor is non-empty non-local-type should be flagged as positive.
package scensct.core.pos;

public class PosCase7 {
    public static void main(String[] args) {
        boolean condition = true;
        if (condition)
            System.out.println("Then branch"); // Unbraced body, not terminal
System.out.println("Non-empty successor"); // Same column as if keyword, indented further, not a local type declaration
    }
}