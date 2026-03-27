// A class with both equals and hashCode whose instance is stored in a hashing data structure should not be flagged as a violation.
package scensct.core.neg;

import java.util.HashSet;

public class NegCase2 {
    // Class defines both equals and hashCode, satisfying scenario condition
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
        
        @Override
        public int hashCode() {
            return id;
        }
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass(1);
        HashSet<MyClass> set = new HashSet<>(); // Hashing data structure
        set.add(obj); // Instance stored in hashing data structure
        System.out.println(set.contains(obj));
    }
}