// Non-block body with successor on same column/line and indentation not increased should not be flagged.
package scensct.core.neg;

public class NegCase5 {
    public static void main(String[] args) {
        int count = 2;
        // Scenario 5: while with non-block body, successor T on same column, body column not less than control or successor
        while (count > 0)
            count--; // body column same as control column
        System.out.println("Done"); // successor T on same column as body and control
    }
}