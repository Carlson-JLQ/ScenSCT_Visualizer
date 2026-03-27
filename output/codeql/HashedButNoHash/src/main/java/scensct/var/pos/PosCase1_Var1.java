// A class defines an equals method but no hashCode method and an instance is added to a HashSet should be flagged as positive.
package scensct.var.pos;

import java.util.HashSet;

public class PosCase1_Var1 {
    static class MyClass {
        private final int val;
        
        MyClass(int v) {
            this.val = v;
        }
        
        @Override
        public boolean equals(Object o) {
            return o instanceof MyClass && this.val == ((MyClass) o).val;
        }
        // No hashCode
    }
    
    public static void main(String[] args) {
        HashSet<MyClass> items = new HashSet<>(); // [REPORTED LINE]
        MyClass instance = new MyClass(5);
        items.add(instance); // [REPORTED LINE]
    }
}