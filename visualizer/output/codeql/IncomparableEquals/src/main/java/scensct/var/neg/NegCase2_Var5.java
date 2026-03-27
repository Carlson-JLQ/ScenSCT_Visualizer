// A Java source file containing a call to equals(Object) where the compile-time types share a common subtype other than Object should not be flagged as incomparable equals.
package scensct.var.neg;

import java.util.List;

public class NegCase2_Var5 {
    public static void main(String[] args) {
        List<String> list = List.of("a");
        Object obj = list.get(0); // obj is String
        String str = "b";
        boolean same = str.equals(obj); // Common subtype String
        System.out.println(same);
    }
}