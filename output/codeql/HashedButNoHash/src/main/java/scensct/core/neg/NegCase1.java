// A class with equals but no hashCode whose instance is never stored in a hashing data structure should not be flagged as a violation.
package scensct.core.neg;

import java.util.HashSet;
import java.util.Map;

public class NegCase1 {
    // Class defines equals but no hashCode, satisfying scenario condition
    static class MyClass {
        private int id;
        MyClass(int id) { this.id = id; }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyClass myClass = (MyClass) o;
            return id == myClass.id;
        }
        // No hashCode method defined
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass(1); // Instance created
        // No storage in any hashing data structure (HashSet, HashMap, etc.)
        // Only simple assignment or method calls allowed
        System.out.println(obj.equals(new MyClass(1)));
    }
}