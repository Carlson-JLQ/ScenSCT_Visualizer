// An abstract class that implements Iterable and declares an abstract method named "iterator" should not be flagged.
package scensct.core.neg;

import java.util.Iterator;

public abstract class NegCase3 implements Iterable<Integer> {
    // Abstract class implements Iterable and declares abstract iterator() method.
    // No method body, so the checker should not report.
    public abstract Iterator<Integer> iterator();
}