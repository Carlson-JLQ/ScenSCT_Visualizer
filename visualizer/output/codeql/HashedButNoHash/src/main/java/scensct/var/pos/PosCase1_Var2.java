// A class defines an equals method but no hashCode method and an instance is added to a HashSet should be flagged as positive.
package scensct.var.pos;

import java.util.HashSet;

public class PosCase1_Var2 {
    static class MyClass {
        private int data;
        
        MyClass(int d) {
            data = d;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof MyClass)) return false;
            MyClass that = (MyClass) obj;
            return this.data == that.data;
        }
        // No hashCode
    }
    
    static void populateSet() {
        HashSet<MyClass> set = new HashSet<>(); // [REPORTED LINE]
        set.add(new MyClass(5)); // [REPORTED LINE]
    }
    
    public static void main(String[] args) {
        populateSet();
    }
}