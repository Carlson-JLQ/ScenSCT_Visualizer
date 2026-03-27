// Multiplication explicitly cast to wider integral type should not be flagged as implicit conversion overflow.
package scensct.var.neg;

public class NegCase3_Var4 {
    public static void main(String[] args) {
        int m = 1000;
        int n = 2000;
        long widened;
        if (args.length >= 0) { // always true
            widened = (long) (m * n);
        } else {
            widened = 0L;
        }
        System.out.println(widened);
    }
}