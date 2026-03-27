// equals method containing throw statement should not be flagged as missing type test
package scensct.var.neg;

public class NegCase7_Var4 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Extract exception creation to a helper method, but throw directly
        UnsupportedOperationException exception = createException();
        throw exception;
    }
    
    private UnsupportedOperationException createException() {
        return new UnsupportedOperationException("Equals not supported");
    }
}