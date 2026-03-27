// An abstract class that implements Iterable and declares an abstract method named "iterator" should not be flagged.
package scensct.var.neg;

import java.util.Iterator;

public abstract class NegCase3_Var5 implements Iterable<Integer> {
    // Keep the abstract iterator.
    @Override
    public abstract Iterator<Integer> iterator();

    // Introduce a private field and a concrete getter.
    private int id = 0;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    // Override toString (concrete) but unrelated.
    @Override
    public String toString() {
        return "NegCase3_Var5[id=" + id + "]";
    }
}