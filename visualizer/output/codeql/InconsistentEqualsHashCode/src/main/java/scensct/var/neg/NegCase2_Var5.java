// A class that overrides both equals(Object) and hashCode() should not be flagged as violating the equals-hashCode contract.
package scensct.var.neg;

import java.util.Objects;

public class NegCase2_Var5 {
    private int id;
    private String name;
    
    public NegCase2_Var5(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        NegCase2_Var5 other = null;
        try {
            other = (NegCase2_Var5) o;
        } catch (ClassCastException e) {
            return false;
        }
        return id == other.id 
            && (name == null ? other.name == null : name.equals(other.name));
    }
    
    @Override
    public int hashCode() {
        int h = 1;
        h = h * 59 + id;
        h = h * 59 + (name == null ? 0 : name.hashCode());
        return h;
    }
}