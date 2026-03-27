// A record class declares a direct member with a name exactly matching one of the special serialization-related names should be flagged as a violation.
package scensct.var.pos;

import java.io.*;

public final class PosCase1_Var2 {
    // Variant 2: Intra-procedural refactoring - split logic into temporary variables, add conditional that always executes
    public record MyRecord(String data) {
        private void writeObject(ObjectOutputStream out) throws IOException { // [REPORTED LINE]
            boolean shouldWrite = true;
            if (shouldWrite) {
                ObjectOutputStream temp = out;
                temp.defaultWriteObject();
            }
        }
    }

    public static void main(String[] args) {
        MyRecord r = new MyRecord("test");
        System.out.println(r.data());
    }
}