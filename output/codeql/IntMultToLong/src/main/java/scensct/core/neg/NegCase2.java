// Multiplication implicitly converted to same-sized or non-integral type should not be flagged as overflow before widening to larger integral type.
package scensct.core.neg;

public class NegCase2 {
    public static void main(String[] args) {
        int x = 100;
        int y = 200;
        long sameSize = x * y; // Actually widening to long, but scenario example: same-sized conversion not possible for int to long? long is larger. Adjust to float.
        float toFloat = x * y; // Scenario 2: Implicit conversion to float (non-integral type)
        System.out.println(toFloat);
    }
}