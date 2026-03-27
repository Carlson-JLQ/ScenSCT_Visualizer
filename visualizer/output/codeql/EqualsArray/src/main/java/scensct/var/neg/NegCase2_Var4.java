// Calling non-Object.equals/hashCode methods or equals with incompatible array types should not be flagged.
package scensct.var.neg;

import java.util.Random;

public class NegCase2_Var4 {
    static class Custom {
        public boolean equals(Custom other) {
            return other != null;
        }
        public int hashCode(String input) {
            return new Random().nextInt();
        }
    }
    
    public static void main(String[] args) {
        int[] arr = null;
        if (args.length == 0) {
            arr = new int[5];
        } else {
            arr = new int[10];
        }
        Custom custom = new Custom();
        boolean eqCustom = custom.equals(custom);
        int hashCustom = custom.hashCode("test");
        String str = arr.toString();
        
        String[] strArr = { null, null };
        int[] intArr = new int[2];
        boolean incompatible;
        if (strArr.length == intArr.length) {
            incompatible = strArr.equals(intArr);
        } else {
            incompatible = false;
        }
        
        // Another unrelated array type
        double[] dArr = new double[3];
        Object o = dArr;
        String ts = o.toString();
    }
}