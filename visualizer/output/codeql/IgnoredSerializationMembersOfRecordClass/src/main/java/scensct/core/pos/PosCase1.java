// A record class declares a direct member with a name exactly matching one of the special serialization-related names should be flagged as a violation.
package scensct.core.pos;

import java.io.*;

public final class PosCase1 {
    // Helper record class with a direct member matching a special serialization-related name
    public record MyRecord(String data) {
        // Direct method member matching "writeObject" - should trigger the checker
        private void writeObject(ObjectOutputStream out) throws IOException { // [REPORTED LINE]
            out.defaultWriteObject();
        }
    }

    public static void main(String[] args) {
        MyRecord r = new MyRecord("test");
        System.out.println(r.data());
    }
}