// Loop condition changes at re-entry should not be flagged as constant condition.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        int j = 5;
        for (int i = 0; i < 10; ) {
            i++; // Update inside body
            j--;
        }
    }
}