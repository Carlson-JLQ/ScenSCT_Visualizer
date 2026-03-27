// equals method using instanceof on parameter should not be flagged as missing type test
package scensct.var.neg;

public class NegCase2_Var4 {
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != NegCase2_Var4.class) {
            return false;
        }
        NegCase2_Var4 other = (NegCase2_Var4) obj;
        return true;
    }
}