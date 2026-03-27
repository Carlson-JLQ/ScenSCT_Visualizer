// equals method using getClass() on parameter should not be flagged as missing type test
package scensct.var.neg;

public class NegCase1_Var1 {
    @Override
    public boolean equals(Object o) {
        // Use temporary variable for getClass()
        Class<?> thisClass = this.getClass();
        Class<?> thatClass = o == null ? null : o.getClass();
        if (thisClass != thatClass) {
            return false;
        }
        NegCase1_Var1 that = (NegCase1_Var1) o;
        return true;
    }
}