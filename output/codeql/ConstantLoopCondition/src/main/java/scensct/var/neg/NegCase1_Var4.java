// Loop condition changes at re-entry should not be flagged as constant condition.
package scensct.var.neg;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        int i = 0;
        int j = 5;
        while (i < 10) { // [REPORTED LINE]
            incrementI();
            j--;
        }
    }
    private static int counter = 0;
    private static void incrementI() {
        counter++; // counter acts as loop variable
    }
}