// Compound assignment operator other than += or *= should not be flagged as implicit narrowing cast.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        int result = 10;
        int decrement = 5;
        result -= decrement; // Operator -= via variable
        System.out.println(result);
    }
}