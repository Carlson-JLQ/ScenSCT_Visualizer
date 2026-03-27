// Calling contains on a raw collection should not be flagged as type incompatibility.
package scensct.var.neg;

import java.util.ArrayList;

public class NegCase1_Var5 {
    // Variant 5: Raw collection stored in Object variable, cast back before contains.
    public static void main(String[] args) {
        Object objList = new ArrayList();
        ((ArrayList) objList).add("test");
        ((ArrayList) objList).add(777);
        ArrayList rawList = (ArrayList) objList;
        boolean r = rawList.contains(777);
        System.out.println(r);
    }
}