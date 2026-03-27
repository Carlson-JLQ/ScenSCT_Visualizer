// Loop condition changes at re-entry should not be flagged as constant condition.
package scensct.var.neg;

public class NegCase1_Var5 {
    private static int i = 0;
    public static void main(String[] args) {
        int j = 5;
        while (i < 10) {
            incrementI();
            j--;
        }
    }
    private static void incrementI() {
        i++; // static field update
    }
}