// Unbraced if-then with misleading indentation where body is not terminal and successor is not empty should be flagged as positive.
package scensct.ref.pos;

public class PosCase1_FN1 {
    public static void main(String[] args) {
        boolean condition = true;
        boolean anotherCondition = false;
        if (condition)
            System.out.println("Then branch"); // Unbraced body, not terminal
        System.out.println("Misleading successor"); // Same line start, indented further, not empty
    }
}