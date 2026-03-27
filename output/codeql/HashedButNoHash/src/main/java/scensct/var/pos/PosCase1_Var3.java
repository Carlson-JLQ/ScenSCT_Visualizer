// A class defines an equals method but no hashCode method and an instance is added to a HashSet should be flagged as positive.
package scensct.var.pos;

import java.util.HashSet;
import java.util.Collections;

public class PosCase1_Var3 {
    static class MyClass {
        private int value;
        
        MyClass(int value) {
            this.value = value;
        }
        
        @Override
        public boolean equals(Object other) {
            if (other instanceof MyClass) {
                MyClass mc = (MyClass) other;
                return this.value == mc.value;
            }
            return false;
        }
        // No hashCode
    }
    
    public static void main(String[] args) {
        HashSet<MyClass> set = new HashSet<>(); // [REPORTED LINE]
        MyClass obj = new MyClass(5);
        boolean added = set.add(obj); // [REPORTED LINE]
        // Use the set to avoid dead code elimination illusions
        if (!set.isEmpty()) {
            System.out.println("Set has elements");
        }
    }
}