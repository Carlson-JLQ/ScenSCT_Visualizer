// equals method passing parameter to abstract method should not be flagged as missing type test
package scensct.var.neg;

public class NegCase6_Var5 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Store in array then pass to abstract method (still no instanceof)
        Object[] arr = new Object[] { obj };
        for (Object o : arr) {
            performAbstractCheck(o);
            break;
        }
        return false;
    }
    
    private native void performAbstractCheck(Object obj);
}