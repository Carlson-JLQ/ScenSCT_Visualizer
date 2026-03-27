// Compound assignment operator other than += or *= should not be flagged as implicit narrowing cast.
package scensct.var.neg;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        // Using ternary to choose operator? Not directly, but we can simulate:
        a -= (args.length > 0 ? b : 0); // -= with conditional RHS, still int
        System.out.println(a);
    }
}