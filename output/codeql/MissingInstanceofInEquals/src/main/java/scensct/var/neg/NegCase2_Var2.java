// equals method using instanceof on parameter should not be flagged as missing type test
package scensct.var.neg;

public class NegCase2_Var2 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        Object param = obj; // alias
        if (!(param instanceof NegCase2_Var2)) {
            return false;
        }
        NegCase2_Var2 other = (NegCase2_Var2) param;
        return true;
    }
}