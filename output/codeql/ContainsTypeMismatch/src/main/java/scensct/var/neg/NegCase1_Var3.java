// Calling contains on a raw collection should not be flagged as type incompatibility.
package scensct.var.neg;

import java.util.ArrayList;

public class NegCase1_Var3 {
    // Variant 3: Helper method returns raw list, contains checked after try-finally.
    private static ArrayList getRawList() {
        ArrayList raw = new ArrayList();
        raw.add("item");
        raw.add(999);
        return raw;
    }

    public static void main(String[] args) {
        ArrayList data = getRawList();
        try {
            // do nothing
        } finally {
            boolean ok = data.contains(999);
            System.out.println(ok);
        }
    }
}