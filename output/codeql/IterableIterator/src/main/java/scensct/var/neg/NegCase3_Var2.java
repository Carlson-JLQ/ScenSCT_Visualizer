// An abstract class that implements Iterable and declares an abstract method named "iterator" should not be flagged.
package scensct.var.neg;

import java.util.Iterator;

public abstract class NegCase3_Var2<T extends Number> implements Iterable<T> {
    // Generic abstract class; iterator remains abstract.
    public abstract Iterator<T> iterator();

    // Adding a default method via a private interface.
    private interface Debuggable {
        default void debug() {
            System.out.println("Debugging");
        }
    }

    // Concrete method using generic type.
    public T defaultValue() {
        return null;
    }
}