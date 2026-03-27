// Compound assignment operator other than += or *= should not be flagged as implicit narrowing cast.
package scensct.var.neg;

public class NegCase1_Var3 {
    public static void main(String[] args) {
        int val = 10;
        val /= 2; // Changed operator to /=, still not += or *=
        System.out.println(val);
    }
}