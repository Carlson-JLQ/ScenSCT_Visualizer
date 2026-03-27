// Multiplication result used directly without implicit widening should not be flagged as overflow before widening.
package scensct.var.neg;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        int m = 10;
        int n = 20;
        int result;
        try {
            result = m * n;
        } catch (Exception e) {
            result = -1;
        }
        System.out.println(result);
    }
}