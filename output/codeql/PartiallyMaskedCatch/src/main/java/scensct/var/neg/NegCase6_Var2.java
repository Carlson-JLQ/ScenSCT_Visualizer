// A try statement with at least one catch clause, where a given exception type (masking) is not the type caught by the catch clause at a specified index (first) should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase6_Var2 {
    // Variant 2: Extract throwing logic to a helper method
    static void ioOperation() throws java.io.IOException {
        throw new java.io.IOException();
    }
    
    public static void main(String[] args) {
        try {
            ioOperation();
        } catch (java.io.IOException e) {
            System.out.println("IOException caught");
        }
    }
}