// A class that overrides both equals(Object) and hashCode() should not be flagged as violating the equals-hashCode contract.
package scensct.var.neg;

import java.util.Objects;

public class NegCase2_Var2 {
    private final int identifier;
    private final String label;
    
    public NegCase2_Var2(int identifier, String label) {
        this.identifier = identifier;
        this.label = label;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof NegCase2_Var2) {
            NegCase2_Var2 that = (NegCase2_Var2) o;
            return this.identifier == that.identifier 
                && Objects.equals(this.label, that.label);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(identifier, label);
    }
}