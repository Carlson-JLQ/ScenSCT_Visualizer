// An abstract class that implements Iterable and declares an abstract method named "iterator" should not be flagged.
package scensct.var.neg;

import java.util.Iterator;

public abstract class NegCase3_Var4 implements Iterable<Integer> {
    // Abstract iterator declared, but also adding another abstract method.
    public abstract Iterator<Integer> iterator();
    public abstract String getName();

    // Adding a concrete nested abstract class.
    public abstract static class Builder {
        public abstract NegCase3_Var4 build();
        public void preBuild() {
            System.out.println("Building...");
        }
    }
}