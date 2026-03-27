// Multiplication result used directly without implicit widening should not be flagged as overflow before widening.
package scensct.var.neg;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        int base = 10;
        int factor = 20;
        int temp = base;
        temp = temp * factor;
        int output = temp;
        System.out.println(output);
    }
}