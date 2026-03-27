// Variable dereferenced with provably non-null value should not be flagged as potential null pointer dereference.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        String s = "definitely non-null"; // Source definition: non-null literal
        System.out.println(s.length());   // Dereference: s is provably non-null
    }
}