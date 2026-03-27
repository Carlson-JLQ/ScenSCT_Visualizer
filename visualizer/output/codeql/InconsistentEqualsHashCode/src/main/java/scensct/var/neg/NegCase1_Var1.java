// A class that does not override equals(Object) and does not override hashCode() should not be flagged as violating the equals-hashCode contract.
package scensct.var.neg;

public class NegCase1_Var1 {
    // Variant 1: Add a toString and a static factory method, but still no equals/hashCode.
    private final int value;
    private String label; // Additional field
    
    public NegCase1_Var1(int value) {
        this(value, "default");
    }
    
    private NegCase1_Var1(int value, String label) {
        this.value = value;
        this.label = label;
    }
    
    public static NegCase1_Var1 createWithLabel(int value, String label) {
        return new NegCase1_Var1(value, label);
    }
    
    public int getValue() {
        return value;
    }
    
    public String getLabel() {
        return label;
    }
    
    @Override
    public String toString() {
        return "NegCase1_Var1{value=" + value + ", label='" + label + "'}";
    }
}