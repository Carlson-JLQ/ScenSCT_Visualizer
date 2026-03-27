// A class defines an equals method but no hashCode method and an instance is added to a HashSet should be flagged as positive.
package scensct.var.pos;

import java.util.HashSet;

public class PosCase1_Var5 {
    static class MyClass {
        private int value;
        
        MyClass(int value) {
            this.value = value;
        }
        
        @Override
        public boolean equals(Object obj) {
            boolean result = false;
            if (obj instanceof MyClass) {
                MyClass other = (MyClass) obj;
                result = (this.value == other.value);
            }
            return result;
        }
        // No hashCode
    }
    
    public static void main(String[] args) {
        HashSet<MyClass> set;
        set = new HashSet<>(); // [REPORTED LINE]
        for (int i = 0; i < 1; i++) {
            set.add(new MyClass(5)); // [REPORTED LINE]
        }
    }
}