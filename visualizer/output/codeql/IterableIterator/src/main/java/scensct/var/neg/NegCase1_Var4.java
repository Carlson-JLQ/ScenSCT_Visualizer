// A class that does not implement Iterable should not be flagged as lacking a guard for multiple concurrent iterations.
package scensct.var.neg;

public class NegCase1_Var4 {
    private final int value;
    
    public NegCase1_Var4(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return "NegCase1_Var4[value=" + value + "]";
    }
    
    // Method that uses an iterator from a collection but does not make this class Iterable
    public void iterateOverList() {
        java.util.List<String> list = java.util.List.of("a", "b");
        for (String s : list) {
            System.out.println(s);
        }
    }
}