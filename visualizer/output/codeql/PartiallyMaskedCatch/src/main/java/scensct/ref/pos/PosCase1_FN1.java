// A try statement with catch clauses where a general checked exception precedes a specific one should be flagged as unreachable.
package scensct.ref.pos;

import java.io.IOException;

public class PosCase1_FN1 {
    public static void main(String[] args) {
        try {
            // This can throw IOException, a subtype of Exception
            throw new IOException();
        } catch (IOException e) {
            // Specific catch clause for IOException
        } catch (Exception e) {
            // General catch clause for Exception, now reachable only if a supertype of IOException is thrown
        }
    }
}