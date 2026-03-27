// A class with both equals and hashCode whose instance is stored in a hashing data structure should not be flagged as a violation.
package scensct.var.neg;

import java.util.HashSet;
import java.util.Objects;

public class NegCase2_Var1 {
    // Renamed class, added a field, used Objects.hash in hashCode
    static class Item {
        private final int identifier;
        private String tag; // extra field not used in equals/hashCode
        Item(int id) { this.identifier = id; this.tag = ""; }
        
        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (!(other instanceof Item)) return false;
            Item that = (Item) other;
            return this.identifier == that.identifier;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(identifier);
        }
    }

    public static void main(String[] args) {
        Item thing = new Item(42);
        HashSet<Item> collection = new HashSet<>();
        collection.add(thing);
        System.out.println(collection.contains(thing));
    }
}