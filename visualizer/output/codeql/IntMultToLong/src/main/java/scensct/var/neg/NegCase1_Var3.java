// Multiplication result used directly without implicit widening should not be flagged as overflow before widening.
package scensct.var.neg;

public class NegCase1_Var3 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int sum = 0;
        for (int i = 0; i < b; i++) {
            sum += a; // same as a * b for positive b
        }
        int result = sum;
        System.out.println(result);
    }
}