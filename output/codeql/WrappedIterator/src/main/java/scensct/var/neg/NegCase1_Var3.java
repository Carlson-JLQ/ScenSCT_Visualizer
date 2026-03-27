// A class that does not implement java.lang.Iterable should not be flagged as non-multiple-iteration iterable.
package scensct.var.neg;

import java.util.Random;

public class NegCase1_Var3 {
    // Added a second field and more complex initialization
    private final int value;
    private final String tag;
    
    public NegCase1_Var3(int value) {
        this.value = value;
        this.tag = "ID-" + new Random().nextInt(100);
    }
    
    public int getValue() {
        return value;
    }
    
    public String getTag() {
        return tag;
    }
    
    // Helper method that does iteration-like logic but returns nothing
    private void repeatPrint(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(value);
        }
    }
}