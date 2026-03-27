// A class that does not override equals(Object) and does not override hashCode() should not be flagged as violating the equals-hashCode contract.
package scensct.var.neg;

import java.util.function.Supplier;

public class NegCase1_Var4 {
    // Variant 4: Add a lambda, a method reference, and a try-with-resources, but no equals/hashCode.
    private int value;
    private transient String cachedString; // transient field
    
    public NegCase1_Var4(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
        cachedString = null;
    }
    
    public String computeString(Supplier<String> supplier) {
        if (cachedString == null) {
            cachedString = supplier.get();
        }
        return cachedString;
    }
    
    // Method using try-with-resources (simulated)
    public String loadResource() {
        try (java.io.StringReader reader = new java.io.StringReader("dummy")) {
            char[] buf = new char[10];
            int read = reader.read(buf);
            return new String(buf, 0, read);
        } catch (java.io.IOException e) {
            return "";
        }
    }
}