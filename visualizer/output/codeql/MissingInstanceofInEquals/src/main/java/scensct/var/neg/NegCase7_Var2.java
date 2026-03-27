// equals method containing throw statement should not be flagged as missing type test
package scensct.var.neg;

public class NegCase7_Var2 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Wrap throw in a try-catch block that rethrows, preserving direct throw semantics
        try {
            failOnEquals();
        } catch (RuntimeException e) {
            throw e;
        }
        return false; // Unreachable, but syntactically present
    }
    
    private void failOnEquals() {
        throw new UnsupportedOperationException("Equals not supported");
    }
}