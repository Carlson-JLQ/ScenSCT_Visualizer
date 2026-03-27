// A class that does not override equals(Object) and does not override hashCode() should not be flagged as violating the equals-hashCode contract.
package scensct.var.neg;

public class NegCase1_Var3 {
    // Variant 3: Restructure with a builder pattern and an enum, still no equals/hashCode.
    private final int value;
    private final boolean flag;
    
    private NegCase1_Var3(int value, boolean flag) {
        this.value = value;
        this.flag = flag;
    }
    
    public int getValue() {
        return value;
    }
    
    public boolean isFlag() {
        return flag;
    }
    
    public static Builder builder(int value) {
        return new Builder(value);
    }
    
    public static class Builder {
        private final int value;
        private boolean flag = false;
        
        Builder(int value) {
            this.value = value;
        }
        
        public Builder withFlag(boolean flag) {
            this.flag = flag;
            return this;
        }
        
        public NegCase1_Var3 build() {
            return new NegCase1_Var3(value, flag);
        }
    }
    
    // Adding an enum inside the class
    public enum Status {
        ACTIVE, INACTIVE
    }
}