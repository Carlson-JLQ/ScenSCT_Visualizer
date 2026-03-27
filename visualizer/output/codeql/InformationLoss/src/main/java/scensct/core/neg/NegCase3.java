// += operator with source type not wider than destination type should not be flagged as implicit narrowing cast.
package scensct.core.neg;

public class NegCase3 {
    public static void main(String[] args) {
        int dest = 5;
        int src = 3;
        dest += src; // Scenario 3: Both int (same width, source not wider)
        System.out.println(dest);
        
        long destLong = 10L;
        int srcInt = 2;
        destLong += srcInt; // Also valid: destination long is wider than source int
    }
}