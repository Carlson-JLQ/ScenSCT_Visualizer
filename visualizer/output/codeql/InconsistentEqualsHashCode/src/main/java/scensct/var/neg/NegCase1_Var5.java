// A class that does not override equals(Object) and does not override hashCode() should not be flagged as violating the equals-hashCode contract.
package scensct.var.neg;

public class NegCase1_Var5 {
    // Variant 5: Use an abstract base class that does not override equals/hashCode,
    // and add an annotation.
    private final int value;
    
    @Deprecated
    private String oldField; // annotated field
    
    public NegCase1_Var5(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    @SuppressWarnings("deprecation")
    public String getOldField() {
        return oldField;
    }
    
    // Static nested abstract class
    public static abstract class Base {
        public abstract void doSomething();
    }
    
    // Concrete nested class extending Base, still no equals/hashCode
    public static class Concrete extends Base {
        private int data;
        
        public Concrete(int data) {
            this.data = data;
        }
        
        @Override
        public void doSomething() {
            System.out.println(data);
        }
    }
}