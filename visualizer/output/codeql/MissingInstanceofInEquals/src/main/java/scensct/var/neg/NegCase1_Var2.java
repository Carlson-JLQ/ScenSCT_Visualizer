// equals method using getClass() on parameter should not be flagged as missing type test
package scensct.var.neg;

public class NegCase1_Var2 {
    @Override
    public boolean equals(Object obj) {
        // Reorder condition: null check separate, then getClass
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        NegCase1_Var2 rhs = (NegCase1_Var2) obj;
        return true;
    }
}