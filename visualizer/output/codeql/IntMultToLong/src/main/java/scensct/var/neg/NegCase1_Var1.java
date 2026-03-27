// Multiplication result used directly without implicit widening should not be flagged as overflow before widening.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        int product;
        if (x > 0) {
            product = x * y;
        } else {
            product = 0;
        }
        int finalResult = product;
        System.out.println(finalResult);
    }
}