// Compound assignment operator other than += or *= should not be flagged as implicit narrowing cast.
package scensct.var.neg;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        int counter = 10;
        counter = counter - 5; // Equivalent to -= but written as assignment
        System.out.println(counter);
    }
}