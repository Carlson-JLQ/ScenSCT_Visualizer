// Loop condition changes at re-entry should not be flagged as constant condition.
package scensct.var.neg;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        int[] a = new int[1];
        a[0] = 0;
        int j = 5;
        while (a[0] < 10) {
            a[0]++; // Update via array alias
            j--;
        }
    }
}