// A class that does not override equals(Object) and does not override hashCode() should not be flagged as violating the equals-hashCode contract.
package scensct.var.neg;

import java.util.Objects;

public class NegCase1_Var2 {
    // Variant 2: Use a generic type parameter and implement an unrelated interface.
    private final int value;
    private final Object metadata;
    
    public NegCase1_Var2(int value) {
        this.value = value;
        this.metadata = null;
    }
    
    public NegCase1_Var2(int value, Object metadata) {
        this.value = value;
        this.metadata = Objects.requireNonNull(metadata);
    }
    
    public int getValue() {
        return value;
    }
    
    public Object getMetadata() {
        return metadata;
    }
    
    // Inner class that does override equals/hashCode, but outer class does not.
    public static class Inner {
        private int id;
        
        public Inner(int id) {
            this.id = id;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Inner inner = (Inner) o;
            return id == inner.id;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}