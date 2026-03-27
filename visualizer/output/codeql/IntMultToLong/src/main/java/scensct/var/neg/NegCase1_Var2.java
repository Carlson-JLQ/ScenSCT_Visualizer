// Multiplication result used directly without implicit widening should not be flagged as overflow before widening.
package scensct.var.neg;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        int val1 = 10;
        int val2 = 20;
        int result = multiply(val1, val2);
        System.out.println(result);
    }

    private static int multiply(int p, int q) {
        return p * q;
    }
}