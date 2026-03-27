// Multiplication explicitly cast to wider integral type should not be flagged as implicit conversion overflow.
package scensct.var.neg;

public class NegCase3_Var3 {
    private static int getM() {
        return 1000;
    }
    private static int getN() {
        return 2000;
    }
    public static void main(String[] args) {
        long val = (long) (getM() * getN());
        System.out.println(val);
    }
}