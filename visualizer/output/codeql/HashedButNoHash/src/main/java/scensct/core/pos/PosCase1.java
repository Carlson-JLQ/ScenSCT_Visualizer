// A class defines an equals method but no hashCode method and an instance is added to a HashSet should be flagged as positive.
package scensct.core.pos;

import java.util.HashSet;

public class PosCase1 {
    static class MyClass {
        private int value;
        
        MyClass(int value) {
            this.value = value;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof MyClass) {
                return this.value == ((MyClass) obj).value;
            }
            return false;
        }
        // No hashCode method defined
    }
    
    public static void main(String[] args) {
        HashSet<MyClass> set = new HashSet<>(); // [REPORTED LINE]
        set.add(new MyClass(5)); // Using instance in HashSet triggers the checker // [REPORTED LINE]
    }
}