// equals method passing parameter to abstract method should not be flagged as missing type test
package scensct.var.neg;

public class NegCase6_Var2 {
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            // Still passes null to abstract method; no instanceof here
            performAbstractCheck(obj);
        } else {
            performAbstractCheck(obj);
        }
        return false;
    }
    
    protected native void performAbstractCheck(Object param);
}