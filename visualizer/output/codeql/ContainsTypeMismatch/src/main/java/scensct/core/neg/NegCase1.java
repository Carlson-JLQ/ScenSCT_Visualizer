// Calling contains on a raw collection should not be flagged as type incompatibility.
package scensct.core.neg;

import java.util.ArrayList;

public class NegCase1 {
    public static void main(String[] args) {
        // Raw collection: element type is Object, any argument is compatible.
        ArrayList rawList = new ArrayList();
        rawList.add("string");
        rawList.add(42);
        // Argument type Integer is compatible with raw collection element type Object.
        boolean result = rawList.contains(Integer.valueOf(42));
        System.out.println(result);
    }
}