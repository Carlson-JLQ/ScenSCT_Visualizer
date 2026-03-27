// An abstract class that implements Iterable and declares an abstract method named "iterator" should not be flagged.
package scensct.var.neg;

import java.util.Iterator;

public abstract class NegCase3_Var3 implements Iterable<Integer> {
    // Abstract iterator with protected visibility? No, must be public for interface contract.
    // Keep it public abstract but add a throws clause (still abstract).
    public abstract Iterator<Integer> iterator() throws UnsupportedOperationException;

    // Add an inner static class unrelated to iteration.
    public static class Config {
        private final String name;
        public Config(String name) { this.name = name; }
        public String getName() { return name; }
    }

    // Static initializer block.
    static {
        System.out.println("Class loaded");
    }
}