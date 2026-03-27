// Calling non-Object.equals/hashCode methods or equals with incompatible array types should not be flagged.
package scensct.var.neg;

public class NegCase2_Var1 {
    static class Custom {
        public boolean equals(Custom other) {
            return other != null;
        }
        public int hashCode(String input) {
            return input == null ? 0 : input.hashCode();
        }
        public String toString() {
            return super.toString();
        }
    }
    
    private static boolean compareCustom(Custom a, Custom b) {
        return a.equals(b);
    }
    
    private static int hashInput(Custom c, String s) {
        return c.hashCode(s);
    }
    
    public static void main(String[] args) {
        int[] numbers = new int[5];
        Custom obj = new Custom();
        boolean eqResult = compareCustom(obj, obj);
        int hashResult = hashInput(obj, "test");
        String desc = numbers.toString();
        
        String[] texts = { "a", "b" };
        int[] values = { 1, 2 };
        boolean mismatch = texts.equals(values);
        
        // Additional no-op loop to vary control flow
        for (int i = 0; i < numbers.length; i++) {
            // do nothing relevant
        }
    }
}