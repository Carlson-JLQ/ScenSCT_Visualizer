// Loop condition changes at re-entry should not be flagged as constant condition.
package scensct.var.neg;

public class NegCase1_Var6 {
    public static void main(String[] args) {
        int i = 0;
        int j = 5;
        do {
            i++;
            j--;
        } while (i < 10);
    }
}