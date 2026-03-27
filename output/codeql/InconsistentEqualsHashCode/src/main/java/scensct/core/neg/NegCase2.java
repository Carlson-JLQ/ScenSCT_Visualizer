// A class that overrides both equals(Object) and hashCode() should not be flagged as violating the equals-hashCode contract.
package scensct.core.neg;

import java.util.Objects;

public class NegCase2 {
    private int id;
    private String name;
    
    public NegCase2(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    @Override
    public boolean equals(Object o) {
        // Proper equals override with type check and field comparison
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NegCase2 negCase2 = (NegCase2) o;
        return id == negCase2.id && Objects.equals(name, negCase2.name);
    }
    
    @Override
    public int hashCode() {
        // Consistent hashCode override using same fields as equals
        return Objects.hash(id, name);
    }
}