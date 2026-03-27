// Multiplication explicitly cast to wider integral type should not be flagged as implicit conversion overflow.
package scensct.var.neg;

public class NegCase3_Var1 {
    public static void main(String[] args) {
        int a = 1000;
        int b = 2000;
        long result = (long) (a * b);
        System.out.println(result);
    }
}