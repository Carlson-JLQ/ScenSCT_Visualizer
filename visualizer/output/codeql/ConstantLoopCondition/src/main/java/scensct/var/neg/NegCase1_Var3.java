// Loop condition changes at re-entry should not be flagged as constant condition.
package scensct.var.neg;

public class NegCase1_Var3 {
    public static void main(String[] args) {
        int i = 0;
        int j = 5;
        while (i < 10) {
            if (j >= 0) { // always true initially, but not trivially constant
                i++;
            }
            j--;
        }
    }
}