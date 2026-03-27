// A class with both equals and hashCode whose instance is stored in a hashing data structure should not be flagged as a violation.
package scensct.var.neg;

import java.util.HashSet;
import java.util.Set;

public class NegCase2_Var3 {
    // hashCode cached, equals uses getClass check, usage inside a static helper
    static class DataNode {
        private final int val;
        private int hashCache = 0;
        DataNode(int v) { val = v; }
        
        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            DataNode dn = (DataNode) obj;
            return val == dn.val;
        }
        
        @Override
        public int hashCode() {
            if (hashCache == 0) {
                hashCache = Integer.hashCode(val);
            }
            return hashCache;
        }
    }
    
    private static void populateAndCheck() {
        DataNode node = new DataNode(7);
        Set<DataNode> nodes = new HashSet<>();
        nodes.add(node);
        System.out.println(nodes.contains(node));
    }

    public static void main(String[] args) {
        populateAndCheck();
    }
}