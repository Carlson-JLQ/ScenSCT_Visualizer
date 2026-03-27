// equals method using instanceof on parameter should not be flagged as missing type test
package scensct.var.neg;

public class NegCase2_Var3 {
    @Override
    public boolean equals(Object obj) {
        NegCase2_Var3 other = castToMe(obj);
        if (other == null) {
            return false;
        }
        return true;
    }

    private NegCase2_Var3 castToMe(Object o) {
        return (o instanceof NegCase2_Var3) ? (NegCase2_Var3) o : null;
    }
}