// equals method using safe cast (pattern variable) on parameter should not be flagged as missing type test
package scensct.var.neg;

public class NegCase4_Var5 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Variant 5: pattern variable inside a switch expression (Java 17+)
        return switch (obj) {
            case NegCase4_Var5 other -> true;
            default -> false;
        };
    }
}