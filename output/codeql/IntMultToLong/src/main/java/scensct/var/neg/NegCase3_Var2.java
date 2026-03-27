// Multiplication explicitly cast to wider integral type should not be flagged as implicit conversion overflow.
package scensct.var.neg;

public class NegCase3_Var2 {
    public static void main(String[] args) {
        int x = 1000;
        int y = 2000;
        int product = x * y;
        long widened = (long) product;
        System.out.println(widened);
    }
}