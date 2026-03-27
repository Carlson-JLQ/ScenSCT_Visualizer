// equals method using getClass() on parameter should not be flagged as missing type test
package scensct.var.neg;

public class NegCase1_Var5 {
    @Override
    public boolean equals(Object obj) {
        // Inverted logic with early continue style
        boolean typeOk = obj != null && this.getClass() == obj.getClass();
        if (!typeOk) return false;
        NegCase1_Var5 other = (NegCase1_Var5) obj;
        return true;
    }
}