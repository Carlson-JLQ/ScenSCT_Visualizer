// equals method using getClass() on parameter should not be flagged as missing type test
package scensct.var.neg;

import java.util.Objects;

public class NegCase1_Var4 {
    @Override
    public boolean equals(Object obj) {
        // Use Objects.equals for null-aware class comparison
        if (!Objects.equals(this.getClass(), obj == null ? null : obj.getClass())) {
            return false;
        }
        NegCase1_Var4 that = (NegCase1_Var4) obj;
        return true;
    }
}