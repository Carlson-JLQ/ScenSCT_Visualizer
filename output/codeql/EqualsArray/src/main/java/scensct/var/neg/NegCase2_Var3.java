// Calling non-Object.equals/hashCode methods or equals with incompatible array types should not be flagged.
package scensct.var.neg;

public class NegCase2_Var3 {
    static class Custom {
        public boolean equals(Custom other) {
            return true;
        }
        public int hashCode(String input) {
            return input == null ? 0 : input.length();
        }
    }
    
    static String[] makeStringArray() {
        return new String[2];
    }
    
    static int[] makeIntArray() {
        return new int[2];
    }
    
    static void consume(boolean b) {
        // dummy
    }
    
    public static void main(String[] args) {
        int[] a = new int[5];
        Custom custom = new Custom();
        boolean e = custom.equals(custom);
        int h = custom.hashCode("test");
        String t = a.toString();
        
        String[] sArr = makeStringArray();
        int[] iArr = makeIntArray();
        consume(sArr.equals(iArr));
        
        // Aliasing through Object variables
        Object obj1 = sArr;
        Object obj2 = iArr;
        boolean same = obj1.equals(obj2);
    }
}