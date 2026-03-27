// equals method passing parameter to abstract method should not be flagged as missing type test
package scensct.var.neg;

public class NegCase6_Var1 {
    @Override
    public boolean equals(Object other) { // [REPORTED LINE]
        // Delegate to native validation, possibly checking type inside native code
        Object input = other;
        validateInput(input);
        return false;
    }
    
    private native void validateInput(Object o);
}