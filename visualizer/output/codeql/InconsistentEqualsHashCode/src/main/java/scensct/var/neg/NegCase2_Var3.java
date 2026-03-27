// A class that overrides both equals(Object) and hashCode() should not be flagged as violating the equals-hashCode contract.
package scensct.var.neg;

import java.util.Objects;

public class NegCase2_Var3 {
    private int id;
    private String name;
    
    public NegCase2_Var3(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    private boolean fieldsMatch(NegCase2_Var3 other) {
        return id == other.id && Objects.equals(name, other.name);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (o == this) {
            return true;
        }
        return fieldsMatch((NegCase2_Var3) o);
    }
    
    private int computeHash() {
        int hash = 7;
        hash = 31 * hash + id;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        return hash;
    }
    
    @Override
    public int hashCode() {
        return computeHash();
    }
}