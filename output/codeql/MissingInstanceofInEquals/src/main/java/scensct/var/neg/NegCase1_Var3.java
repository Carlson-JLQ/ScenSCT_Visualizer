// equals method using getClass() on parameter should not be flagged as missing type test
package scensct.var.neg;

public class NegCase1_Var3 {
    private boolean isSameType(Object o) {
        return o != null && this.getClass() == o.getClass();
    }

    @Override
    public boolean equals(Object obj) {
        // Type check extracted to helper method
        if (!isSameType(obj)) {
            return false;
        }
        NegCase1_Var3 other = (NegCase1_Var3) obj;
        return true;
    }
}