// Non-block body with successor on same column/line and indentation not increased should not be flagged.
package scensct.var.neg;

public class NegCase5_Var3 {
    // Variant 3: Inter-procedural refactoring - extract successor to helper, keep loop local
    public static void main(String[] args) {
        int count = 2;
        while (count > 0)
            count--; // body same column
        printDone(); // successor call on same column
    }

    private static void printDone() {
        System.out.println("Done");
    }
}