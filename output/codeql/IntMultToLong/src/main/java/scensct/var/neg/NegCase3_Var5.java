// Multiplication explicitly cast to wider integral type should not be flagged as implicit conversion overflow.
package scensct.var.neg;

public class NegCase3_Var5 {
    public static void main(String[] args) {
        final int coefficient = 1000;
        int factor = 2000;
        try {
            long converted = (long) (coefficient * factor);
            System.out.println(converted);
        } catch (Exception e) {
            // ignore
        }
    }
}