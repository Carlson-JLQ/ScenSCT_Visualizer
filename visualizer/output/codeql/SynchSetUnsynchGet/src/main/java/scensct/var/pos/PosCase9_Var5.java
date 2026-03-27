// A class with synchronized setter and getter with lock not this/class literal, getter accesses volatile field but no write to it exists should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase9_Var5 {
    private volatile int marker;
    private int score;
    private final Object diffLock = new Object();

    public synchronized void assignScore(int s) {
        score = s;
    }

    private int internalGetScore() {
        synchronized (diffLock) {
            return score;
        }
    }

    public int getScore() {
        return internalGetScore();
    }

    public int getMarker() {
        return marker;
    }
}