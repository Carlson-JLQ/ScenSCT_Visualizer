// Calling non-Object.equals/hashCode methods or equals with incompatible array types should not be flagged.
package scensct.var.neg;

public class NegCase2_Var5 {
    static class Custom {
        public boolean equals(Custom other) {
            return this == other;
        }
        public int hashCode(String input) {
            return input.hashCode();
        }
    }
    
    static class Container {
        Custom custom = new Custom();
        int[] array = new int[5];
    }
    
    public static void main(String[] args) {
        Container cont = new Container();
        boolean eq = cont.custom.equals(cont.custom);
        int hash = cont.custom.hashCode("test");
        String ts = cont.array.toString();
        
        String[] strArr = new String[2];
        int[] intArr = new int[2];
        boolean noMatch = false;
        for (int i = 0; i < 1; i++) {
            noMatch = strArr.equals(intArr);
        }
        
        // Switch with default that does nothing
        switch (args.length) {
            case 0:
                eq = !eq;
                break;
            default:
                // fall through
        }
    }
}