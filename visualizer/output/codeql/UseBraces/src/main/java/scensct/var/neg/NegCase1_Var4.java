// Control structure body is a block statement should not be flagged as misleading indentation.
package scensct.var.neg;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        int x = 5;
        // if with braced body, but using a ternary in expression (outside body)
        String message = x > 0 ? "Positive" : "Non-positive";
        System.out.println(message);
        // Original if-else kept but commented to show alternative; actually removed.
        // for loop with braces, using enhanced for over a small array
        int[] vals = {0, 1, 2};
        for (int val : vals) {
            System.out.println(val);
        }
        // while loop with braces, using do-while equivalent
        if (x > 0) {
            do {
                x--;
            } while (x > 0);
        }
    }
}