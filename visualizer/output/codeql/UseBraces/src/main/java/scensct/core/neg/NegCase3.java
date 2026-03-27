// Non-block body with no following statement in same block should not be flagged.
package scensct.core.neg;

public class NegCase3 {
    public static void main(String[] args) {
        boolean flag = true;
        // Scenario 3: if with non-block body, no successor in same block
        if (flag)
            System.out.println("Flag is true");
        // No statement after within same block; method ends
    }
}