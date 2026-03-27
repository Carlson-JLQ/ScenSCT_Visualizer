// A class with equals but no hashCode whose instance is never stored in a hashing data structure should not be flagged as a violation.
package scensct.var.neg;

import java.util.HashSet;
import java.util.Map;
import java.util.ArrayList;

public class NegCase1_Var2 {
    static class Data {
        int code;
        Data(int code) { this.code = code; }
        
        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (!(obj instanceof Data)) return false;
            Data d = (Data) obj;
            return this.code == d.code;
        }
        // No hashCode
    }

    public static void main(String[] args) {
        Data d1 = new Data(10);
        Data d2 = new Data(10);
        // Use a non-hashing collection to show it's still safe
        ArrayList<Data> list = new ArrayList<>();
        list.add(d1);
        list.add(d2);
        System.out.println("List size: " + list.size());
        // Equals call
        System.out.println(d1.equals(d2));
    }
}