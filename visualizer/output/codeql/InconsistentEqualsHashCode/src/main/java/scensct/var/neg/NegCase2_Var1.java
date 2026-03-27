// A class that overrides both equals(Object) and hashCode() should not be flagged as violating the equals-hashCode contract.
package scensct.var.neg;

import java.util.Objects;

public class NegCase2_Var1 {
    private int id;
    private String name;
    
    public NegCase2_Var1(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NegCase2_Var1)) {
            return false;
        }
        NegCase2_Var1 other = (NegCase2_Var1) obj;
        boolean sameId = this.id == other.id;
        boolean sameName = Objects.equals(this.name, other.name);
        return sameId && sameName;
    }
    
    @Override
    public int hashCode() {
        int result = Integer.hashCode(id);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}