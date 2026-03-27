// An abstract class that implements Iterable and declares an abstract method named "iterator" should not be flagged.
package scensct.var.neg;

import java.util.Iterator;

public abstract class NegCase3_Var1 implements Iterable<Integer> {
    // Abstract iterator method remains unchanged.
    @Override
    public abstract Iterator<Integer> iterator();

    // Adding a static helper method does not affect abstractness.
    public static void log(String msg) {
        System.out.println(msg);
    }

    // Adding a concrete non-iterator method is safe.
    public final int getVersion() {
        return 1;
    }
}