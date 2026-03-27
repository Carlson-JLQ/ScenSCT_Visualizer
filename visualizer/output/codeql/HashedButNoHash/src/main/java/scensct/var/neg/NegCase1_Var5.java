// A class with equals but no hashCode whose instance is never stored in a hashing data structure should not be flagged as a violation.
package scensct.var.neg;

import java.util.HashSet;
import java.util.Map;
import java.util.LinkedList;

public class NegCase1_Var5 {
    static class Record {
        final int tag;
        Record(int tag) { this.tag = tag; }
        
        @Override
        public boolean equals(Object o) {
            if (o instanceof Record) {
                return this.tag == ((Record) o).tag;
            }
            return false;
        }
        // No hashCode
    }

    public static void main(String[] args) {
        Record r1 = new Record(100);
        Record r2 = new Record(100);
        // Using LinkedList (non-hashing) to store instances
        LinkedList<Record> records = new LinkedList<>();
        records.add(r1);
        records.add(r2);
        // Access and compare
        boolean eq = records.getFirst().equals(records.getLast());
        System.out.println(eq);
        // HashSet/HashMap never touched
    }
}