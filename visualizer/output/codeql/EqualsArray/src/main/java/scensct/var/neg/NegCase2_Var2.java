// Calling non-Object.equals/hashCode methods or equals with incompatible array types should not be flagged.
package scensct.var.neg;

public class NegCase2_Var2 {
    static class Custom {
        public boolean equals(Custom other) {
            return this == other || other != null;
        }
        public int hashCode(String input) {
            return input.length() * 31;
        }
        public String toString() {
            return "Custom";
        }
    }
    
    public static void main(String[] args) {
        final int[] arr = new int[] { 0, 1, 2, 3, 4 };
        Custom c1 = new Custom();
        Custom c2 = c1;
        boolean eq = c1.equals(c2);
        int hash = c1.hashCode("test");
        String s = arr.toString();
        
        String[] strArr = new String[2];
        int[] intArr = new int[2];
        boolean b;
        try {
            b = strArr.equals(intArr);
        } finally {
            // ensure no exception changes reachability
        }
        
        // Use a ternary to obscure the call
        Object o1 = strArr;
        Object o2 = intArr;
        boolean ignored = (args.length > 0) ? o1.equals(o2) : false;
    }
}