// A class defines an equals method but no hashCode method and an instance is added to a HashSet should be flagged as positive.
package scensct.var.pos;

import java.util.HashSet;
import java.util.Set;

public class PosCase1_Var4 {
    static class MyClass {
        private int val;
        
        MyClass(int val) {
            this.val = val;
        }
        
        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (o.getClass() != MyClass.class) return false;
            return this.val == ((MyClass) o).val;
        }
        // No hashCode
    }
    
    public static void main(String[] args) {
        Set<MyClass> collection = new HashSet<MyClass>(); // [REPORTED LINE]
        collection.add(new MyClass(5));
    }
}