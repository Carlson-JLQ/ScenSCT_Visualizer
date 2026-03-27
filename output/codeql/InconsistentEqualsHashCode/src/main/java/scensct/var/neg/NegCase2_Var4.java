// A class that overrides both equals(Object) and hashCode() should not be flagged as violating the equals-hashCode contract.
package scensct.var.neg;

import java.util.Objects;

public class NegCase2_Var4 {
    private int id;
    private String name;
    
    public NegCase2_Var4(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    @Override
    public boolean equals(Object o) {
        return o != null 
            && o.getClass() == NegCase2_Var4.class 
            && (this == o || (id == ((NegCase2_Var4) o).id 
                && Objects.equals(name, ((NegCase2_Var4) o).name)));
    }
    
    @Override
    public int hashCode() {
        Object[] fields = {id, name};
        return Objects.hash(fields);
    }
}