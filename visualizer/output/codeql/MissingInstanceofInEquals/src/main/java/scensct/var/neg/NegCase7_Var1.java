// equals method containing throw statement should not be flagged as missing type test
package scensct.var.neg;

public class NegCase7_Var1 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Throw with a different exception type and message format
        RuntimeException ex = new IllegalArgumentException("Operation equals is unsupported");
        throw ex;
    }
}