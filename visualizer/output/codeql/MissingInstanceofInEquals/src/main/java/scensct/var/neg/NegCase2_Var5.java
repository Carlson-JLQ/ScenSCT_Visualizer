// equals method using instanceof on parameter should not be flagged as missing type test
package scensct.var.neg;

public class NegCase2_Var5 {
    @Override
    public boolean equals(Object obj) {
        try {
            NegCase2_Var5 other = (NegCase2_Var5) obj;
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }
}